<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">

	<div id="zkbzj-toolbar">
		<div class="wu-toolbar-button">
<!-- 			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="sendzkbzj()" plain="true">同步</a> -->
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-arrow-up'" onclick="addzkbzjExcel()" plain="true">上传数据</a>
<!-- 			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-arrow-down'" onclick="wyfee.exportExcel()" plain="true">导出数据</a> -->
<!-- 			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="zkbzjRemove()" plain="true">删除</a> -->
		</div>
		<div class="wu-toolbar-search">
			<label>同步状态：</label>
			<select class="easyui-combobox" id="zkbzjStatus" panelHeight="auto" style="width:100px">
            	<option value="">全部</option>
                <option value="y">已同步</option>
                <option value="n">未同步</option>
            </select>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doFindzkbzjList()">查询</a>
        </div>
	</div>
    <div id="center" data-options="region:'center'">
		<table class="easyui-datagrid" id="zkbzj" toolbar="#zkbzj-toolbar"
		data-options="rownumbers:true,singleSelect:false,multiSort:true,pagination:true,fit:true,fitColumns:false,url:'${pageContext.request.contextPath}/zkbzj/getSAPPostList',method:'get',pageSize:50,pageList: [50, 100, 500]">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'pzbm',width:85, styler: function(value,row,index){
					if(value !=''){
						return 'color:green;';
					}
				}">凭证编号</th>
					<th data-options="field:'zz',width:60">组织</th>
					<th data-options="field:'km',width:140">科目</th>
					<th data-options="field:'je',width:70">金额</th>
					<th data-options="field:'status',width:60,formatter:ReportForm.formattbjdyStatus, styler: function(value,row,index){
					if(value =='n'){
						return 'color:red;';
					}else if(value=='y'){
						return 'color:green;';
					}
				}">同步状态</th>
					<th data-options="field:'msg',width:320,formatter:formatCellTooltip, styler: function(value,row,index){
					if(value !=''){
						return 'color:red;';
					}
				}">失败原因</th>
					<th data-options="field:'pzrq',width:80,formatter:ReportForm.formatDate">凭证日期</th>
					<th data-options="field:'gzrq',width:80,formatter:ReportForm.formatDate">过账日期</th>
					<th data-options="field:'cjr',width:80">创建人</th>
					<th data-options="field:'date',width:80,formatter:ReportForm.formatDate">创建日期</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<!-- Excel导入 -->
<div id="zkbzjExcelDlg" class="easyui-dialog" data-options="closed:true,modal:true,iconCls:'icon-save'" style="width:400px; height:150px; padding:10px;" 
	buttons="#zkbzjExcelDlg-buttons" >
	<form id="zkbzjExcelForm"  method="post" enctype="multipart/form-data">
	   选择文件：　<input id="zkbzjExcelFile" name="zkbzjExcelFile" class="easyui-filebox" buttonText="选择文件" style="width:260px" data-options="prompt:'请选择文件...'">
	</form> 
</div>
<div id="zkbzjExcelDlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="uploadzkbzjExcel()">导入数据</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#zkbzjExcelDlg').dialog('close')">取消</a>
</div>
<script>

function getzkbzjSelectionsIds() {
	var zkbzj = $("#zkbzj");
	var sels = zkbzj.datagrid("getSelections");
	var ids = [];
	for ( var i in sels) {
		ids.push(sels[i].id);
	}
	ids = ids.join(",");
	return ids;
}

function formatCellTooltip(value){  
    return "<span title='" + value + "'>" + value + "</span>";  
} 



//同步
function sendzkbzj() {
	var zkbzj = $("#zkbzj");
	var sels = zkbzj.datagrid("getSelections");
	for ( var i in sels) {
		if(sels[i].status=='y'){
			$.messager.alert('提示', '已同步的数据不能重复同步!','info');
			return;
		}
	}
	
	var ids = getzkbzjSelectionsIds();
	if (ids.length == 0) {
		$.messager.alert('提示', '至少选择一条数据同步!','info');
		return;
	}
	$.ajax({  
		 contentType:"application/json;charset=utf-8",
		 type: 'GET',  
		 data: {ids:ids},
	     url: "${pageContext.request.contextPath}"+"/zkbzj/sendzkbzj",   
		 beforeSend: function () {
		    $.messager.progress({ 
		       title: '提示', 
		       msg: '同步中，请稍候……', 
		       text: '' 
		    });
		 },
		 complete: function () {
		       $.messager.progress('close');
		 },
	     success: function(data){   
	     	if(data.status ==200){
	     		$.messager.alert('提示',data.msg,'info',function(){
                	$("#zkbzj").datagrid("load");
                });
			}else{
				$.messager.alert('提示',data.msg,'info');
			}
	     }  
	  });

}


//上传Excel数据
function addzkbzjExcel() {
	$('#zkbzjExcelDlg').dialog('open').dialog('setTitle', '导入Excel');
	$('#zkbzjExcelForm').form('clear');
}

function uploadzkbzjExcel(){   
	 //得到上传文件的全路径
	 var fileName= $('#zkbzjExcelFile').filebox('getValue');
	//进行基本校验
	 if(fileName==""){   
		$.messager.alert('提示','请选择上传文件！','info'); 
	 }else{
		 //对文件格式进行校验
		 var d1=/\.[^\.]+$/.exec(fileName); 
		 if(d1==".xlsx" || d1==".xls"){
			 var formData=new FormData(document.getElementById("zkbzjExcelForm"));
			 $.ajax({  
		      	url: "${pageContext.request.contextPath}/zkbzj/uploadPostExcel",  
		      	type:"post",
				data:formData,
				//告诉jQuery不要去处理发送的数据
				processData:false,
				//告诉jQuery不要去设置Content-Type请求头,因为表单已经设置了multipart/form-data
				contentType:false,
				beforeSend: function () {
					    $.messager.progress({ 
					       title: '提示', 
					       msg: '数据上传同步中，请稍候……', 
					       text: '' 
					    });
					 },
					 complete: function () {
					       $.messager.progress('close');
				},
				success:function(data) {
					if(data.status ==200){
						$("#zkbzjExcelDlg").dialog("close");
						$.messager.alert('提示',data.msg,'info',function(){
	                    	$("#zkbzj").datagrid("load");
	                    });
					}else{
						$.messager.alert("警告", data.msg, 'warning');
						return;
					}
				}
			    });
	    }else{
	        $.messager.alert('提示','请选择xlsx或xls格式文件！','info'); 
	    	$('#zkbzjExcelFile').filebox('setValue',''); 
	    }
	 } 

 }
	
	function doFindzkbzjList(){
		var zkbzjStatus= $('#zkbzjStatus').combobox('getValue');
		$('#zkbzj').datagrid('load',{
			zkbzjStatus: zkbzjStatus
		});
	}
	
	
	//删除
	function zkbzjRemove() {
		var ids = getzkbzjSelectionsIds();
		if (ids.length == 0) {
			$.messager.alert('提示', '至少选择一条数据进行删除!','info');
			return;
		}
		$.messager.confirm('确认', '确定删除选中的数据吗？', function(r) {
			if (r) {
				var params = {
					"ids" : ids
				};
				$.post("${pageContext.request.contextPath}/zkbzj/delzkbzj", params,
						function(data) {
							if (data.status == 200) {
			                    $.messager.alert("提示", data.msg,'info',function(){
			                    	$("#zkbzj").datagrid("load");
			                    });
							} else {
								$.messager.alert('提示', data.msg,'info');
							}
						});
			}
		});

	}
	
	
	   var ctx = "${pageContext.request.contextPath}";
		var wyfee = (function(){
			return{
			exportExcel:function(){
				var url =  ctx + "/zkbzj/export";
				window.location.href = url;  
		}
		}
	})();
	

</script>
