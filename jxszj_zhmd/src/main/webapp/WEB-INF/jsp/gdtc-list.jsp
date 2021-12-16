 <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
	<div id="gdtc-toolbar">
		<div class="wu-toolbar-search">
            <label>日期 : </label><input id="gdtcrq" class="easyui-datebox" style="width: 150px"> 
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doFindgdtc()">查询</a>
        </div>
	</div>

	<table class="easyui-datagrid" id="gdtcList" toolbar="#gdtc-toolbar"
		data-options="rownumbers:true,singleSelect:false,multiSort:true,pagination:true,fit:true,fitColumns:false,url:'${pageContext.request.contextPath}/getGdtc',method:'get',pageSize:30">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'jxs',width:120">经销商</th>
				<th data-options="field:'gd',width:80">跟单</th>
				<th data-options="field:'mds',width:80">门店数</th>
				<th data-options="field:'xdje',width:80">下单金额</th>
				<th data-options="field:'yskje',width:80">预收款金额</th>
				<th data-options="field:'xsskje',width:80">销售收款金额</th>
				<th data-options="field:'xsje',width:80">销售金额</th>
				<th data-options="field:'tcxs',width:80">提成系数</th>
				<th data-options="field:'xstc',width:80">提成</th>
				<th data-options="field:'ny',width:80">年月</th>
			</tr>
		</thead>
	</table>
</div>
<script>
	
	function doFindgdtc(){
		$('#gdtcList').datagrid('load',{
			gdtcrq: $('#gdtcrq').datebox('getValue'),
		});
	}
	
	$(function() {
	   $('#gdtcrq').datebox({
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
	         $('#gdtcrq').datebox('hidePanel') 
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
	        var p = $('#gdtcrq').datebox('panel'), 
	        //日期选择对象中月份
	        tds = false, 
	        //显示月份层的触发控件
	        span = p.find('span.calendar-text'); 
	        var curr_time = new Date();

	        //设置前当月
	        $("#gdtcrq").datebox("setValue", myformatter(curr_time));
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