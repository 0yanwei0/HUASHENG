 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div id="xxdddjys-toolbar">
		<div class="wu-toolbar-search">
            <label>日期 : </label><input id="ny" class="easyui-datebox" style="width: 150px"> 
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-arrow-refresh'" onclick="updateData()" plain="true">更新</a>
        </div>
	</div>

	<table class="easyui-datagrid" id="xxdddjysList" toolbar="#xxdddjys-toolbar"
		data-options="rownumbers:true,singleSelect:false,multiSort:true,pagination:true,fit:true,fitColumns:false,url:'${pageContext.request.contextPath}/getXsdddjys',method:'get',pageSize:30">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'id',width:120">编号</th>
				<th data-options="field:'xspz',width:80">销售凭证</th>
				<th data-options="field:'xspzxm',width:80">销售凭证行</th>
				<th data-options="field:'cpbm',width:180">产品编码</th>
				<th data-options="field:'cpms',width:260">产品描述</th>
				<th data-options="field:'wlz',width:60">物料组</th>
				<th data-options="field:'ddsl',width:60">订单数量</th>
				<th data-options="field:'gcgd',width:80">工厂跟单</th>
				<th data-options="field:'jxskhmc',width:180">经销商名称</th>
				<th data-options="field:'jjzt',width:60">拒绝状态</th>
				<th data-options="field:'cjny',width:80">创建年月</th>
			</tr>
		</thead>
	</table>
</div>
<script>
	
	function updateData() {
		var ny= $('#ny').datebox('getValue');
		if(ny==''){
			$.messager.alert('提示', '请选择年月!','info');
			return;
		}
		$.ajax({  
			 contentType:"application/json;charset=utf-8",
			 type: 'GET',  
			 url: "${pageContext.request.contextPath}/updateXsdddjys",   
			 data: {ny:ny},
			 beforeSend: function () {
			    $.messager.progress({ 
			       title: '提示', 
			       msg: '正在更新数据，请稍候……', 
			       text: '' 
			    });
			 },
			 complete: function () {
			       $.messager.progress('close');
			 },
		     success: function(data){   
		    	if (data.status == 200) {
                    $.messager.alert("提示", data.msg,'info',function(){
                    	$("#xxdddjysList").datagrid("load");
                    });
				} else {
					$.messager.alert('提示', data.msg,'info');
				}
		     }  
		  });
	}
	
	
	$(function() {
		   $('#ny').datebox({
		       //显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
		       onShowPanel: function () {
		          //触发click事件弹出月份层
		          span.trigger('click'); 
		          if (!tds)
		            //延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
		            setTimeout(function() { 
		                tds = p.find('div.calendar-menu-month-inner td');
		                tds.click(function(e) {
		                   //禁止冒泡执行easyui给月份绑定的事件
		                   e.stopPropagation(); 
		                   //得到年份
		                   var year = /\d{4}/.exec(span.html())[0] ,
		                   //月份
		                   //之前是这样的month = parseInt($(this).attr('abbr'), 10) + 1; 
		                   month = parseInt($(this).attr('abbr'), 10);  

		         //隐藏日期对象                     
		         $('#ny').datebox('hidePanel') 
		           //设置日期的值
		           .datebox('setValue', year + '-' + month); 
		                        });
		                    }, 0);
		            },
		            //配置parser，返回选择的日期
		            parser: function (s) {
		                if (!s) return new Date();
		                var arr = s.split('-');
		                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
		            },
		            //配置formatter，只返回年月 之前是这样的d.getFullYear() + '-' +(d.getMonth()); 
		            formatter: function (d) { 
		                var currentMonth = (d.getMonth()+1);
		                var currentMonthStr = currentMonth < 10 ? ('0' + currentMonth) : (currentMonth + '');
		                return d.getFullYear() + '-' + currentMonthStr; 
		            }
		        });

		        //日期选择对象
		        var p = $('#ny').datebox('panel'), 
		        //日期选择对象中月份
		        tds = false, 
		        //显示月份层的触发控件
		        span = p.find('span.calendar-text'); 
		        var curr_time = new Date();

		        //设置前当月
		        $("#ny").datebox("setValue", myformatter(curr_time));
		});
	//格式化日期
	function myformatter(date) {
	    //获取年份
	    var y = date.getFullYear();
	    //获取月份
	    var m = date.getMonth() + 1;
	    return y + '-' + m;
	}
</script>