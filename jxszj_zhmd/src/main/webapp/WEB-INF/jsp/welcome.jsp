<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=" <%=basePath%>">
  <meta name="viewport" content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no,minimal-ui" />
  <title>日志评论</title>
  <link rel="stylesheet" type="text/css" href="css/style1.css" />
  <link rel="stylesheet" type="text/css" href="css/theme.default.css" />
  <link rel="stylesheet" type="text/css" href="css/andrew.mobile.plugin.min.css" />
  <script src="js/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="js/data.js"></script>
  <script src="https://g.alicdn.com/dingding/dingtalk-jsapi/2.10.3/dingtalk.open.js"></script>
  <script src="js/message.js"></script>
</head>
<body>
<main>
<!-- type="hidden"  -->
<input  type="hidden" type="text" id="tid" value="${tid }" />
<input  type="hidden" type="text" id="code" value="" />
<input  type="hidden" type="text" id="userid1" value="" />
<input  type="hidden" type="text" id="userName1" value="" />
  <!----------Andrew_Ratyli---------->
  <div class="module list press mt_5">
    <ul class="list_h_36em">
      <li class="bor_bottom bor_gray_ddd bg_white">
        <dl class="ovh h_in">
          <dt class="fl ovh ml_3 mr_03em">运营姓名：</dt>
          <dd class="fl ovh">
            <div class="line_h_in ovh" id="name">
              	${yyyg }
            </div>
          </dd>
        </dl>
      </li>
      <li class="bor_bottom bor_gray_ddd bg_white">
        <dl class="ovh h_in">
          <dt class="fl ovh ml_3 mr_03em">点赞记录：</dt>
          <dd class="fl ovh">
            <div class="line_h_in ovh" id="dzlb">
            	${dzlb }
            </div>
          </dd>
        </dl>
      </li>
      <li class="bor_bottom bor_gray_ddd bg_white">
        <dl class="ovh h_in">
          <dt class="fl ovh ml_3 mr_03em">范本记录：</dt>
          <dd class="fl ovh">
            <div class="line_h_in ovh" id="fbdz">
            	${fbdz }
            </div>
          </dd>
        </dl>
      </li>
      <li class="bor_bottom bor_gray_ddd bg_white">
        <dl class="ovh h_in">
          <dt class="fl ovh ml_3 mr_03em">点赞积分：</dt>
          <dd class="fl ovh">
            <div class="line_h_in ovh" id="dzjf">
            	${dzjf }
            </div>
          </dd>
        </dl>
      </li>
      <li class="bor_bottom bor_gray_ddd bg_white">
        <dl class="ovh h_in">
          <dt class="fl ovh ml_3 mr_03em">范本积分：</dt>
          <dd class="fl ovh">
            <div class="line_h_in ovh" id="fbjf">
            	${fbjf }
            </div>
          </dd>
        </dl>
      </li>
    </ul>
  </div>
  <div class="module mt_5 plug_validate"> 
     <dl class="ovh bg_white" >
       <dt class="press c_title bg_white pl_3 h_3em line_h_3em">评论<label style="color:red;font-size:2px">(注:对领导评论回复时,可使用@领导名字@,一次回复只能使用一次)</label></dt>
       <dd class="rel minus_mt_05em">
         <textarea class="plug_textarea ml_3 mr_3 w_94 h_12_em c_gray_777" placeholder="请输入评论..." required id="pl"></textarea>
       </dd>
     </dl>
  </div>

  <!----------Andrew_Dialog & Andrew_PopupWin---------->
  <div class="module press bg_white mt_5 pb_5">
  	<button type="button" class="mt_6 btn_h_au  wm_95 bg_title c_white h_32em" id="pinglun">发表评论</button>
    <button type="button" class="mt_6 btn_h_au  wm_95 bg_title c_white h_32em" id="plug_alert">内容点赞👍</button>
    <button type="button" class="mt_6 btn_h_au  wm_95 bg_title c_white h_32em" id="plug_prompt_textarea">范本点赞👍</button>
  </div>

  <div class="module list press mt_5">
    <h3 class="bg_white c_title pl_3 line_h_36em bor_bottom bor_gray_ddd">历史评论</h3>
    <ul class="plug_dropbutton">
    
    	<c:forEach var="pljl" items="${pljl}">
			<li class="bg_white ovh bor_bottom bor_gray_ddd">
	        	<dl class="rel pl_3 ovh touchstart list_h_36em">
	          		<dt class="fl ovh">
	            		${pljl.plr}
	          		</dt>
	          	<dd class="abs wm_94 left_0 c_gray_999 text_al_r">
	            	${pljl.plsj}
	          	</dd>
	        	</dl>
	        	<article class="ma_3 c_gray_777 line_h_18em">
	         		${pljl.plnr}
	        	</article>
	    	</li>
	  	</c:forEach>
    </ul>
  </div>
</main>
</body>
<script type="text/javascript">

dd.ready(function() {
	dd.runtime.permission.requestAuthCode({
		corpId: "dingf75558d96e00291135c2f4657eb6378f",
		onSuccess : function(res) {
			// 调用成功时回调
// 			console.log(res);
// 			alert(res.code);
			$("#code").attr("value",res.code);
		},
		onFail : function(err) {
			// 调用失败时回调
			console.log(err)
		}
	});
});

$(function(){
    $("#plug_alert").click(function(){
    	var code=$("#code").val();
    	var tid=$("#tid").val();
    	var userid1=$("#userid1").val();
    	var userName1=$("#userName1").val();
    	$.ajax({  
   		 contentType:"application/json;charset=utf-8",
   		 type: 'GET',  
   		 url: "${pageContext.request.contextPath}/dianzan", 
   	     data: {code:code,tid:tid,userid1:userid1,userName1:userName1},
   	     success: function(data){  
   	    	 if(data.status ==200){
   	    		 $("#userid1").val(data.data.userid);
   	    		 $("#userName1").val(data.data.userName);
   	    		 $('#dzlb').html(data.data.dzlb);
   	    		 $('#dzjf').html(data.data.dzjf);
   	    		 alert(data.msg);
   	    	 }else {
   	    		 $("#userid1").val(data.data.userid);
   	    		 $("#userName1").val(data.data.userName);
   	    		 alert(data.msg);
   	    	 }
   	     }  
   	  });
    });
});

$(function(){
    $("#plug_prompt_textarea").click(function(){
    	var code=$("#code").val();
    	var tid=$("#tid").val();
    	var userid1=$("#userid1").val();
    	var userName1=$("#userName1").val();
    	$.ajax({  
   		 contentType:"application/json;charset=utf-8",
   		 type: 'GET',  
   		 url: "${pageContext.request.contextPath}/dianzan1", 
   	     data: {code:code,tid:tid,userid1:userid1,userName1:userName1},
   	     success: function(data){  
   	    	 if(data.status ==200){
   	    		 $("#userid1").val(data.data.userid);
   	    		 $("#userName1").val(data.data.userName);
   	    		 $('#fbdz').html(data.data.fbdz);
   	    		 $('#fbjf').html(data.data.fbjf);
   	    		 alert(data.msg);
   	    	 }else {
   	    		 $("#userid1").val(data.data.userid);
   	    		 $("#userName1").val(data.data.userName);
   	    		 alert(data.msg);
   	    	 }
   	     }  
   	  });
    });
});


$(function(){
    $("#pinglun").click(function(){
    	var pl=$("#pl").val();
    	if(pl==""){
    		alert("请填写评论内容！");
    		return;
    	}else if(pl.indexOf("#") >= 0){
    		alert("评论内容不能包含'#'符号！");
    		return;
    	}else if(pl.indexOf("@") >= 0 && pl.split("@").length != 3){
    		alert("请按规定使用'@'符号！");
    		return;
    	}
    	
    	var code=$("#code").val();
    	var tid=$("#tid").val();
    	var userid1=$("#userid1").val();
    	var userName1=$("#userName1").val();
    	toast({time: 1000, content: '评论已发表！'});
    	$.ajax({  
   		 contentType:"application/json;charset=utf-8",
   		 type: 'GET',  
   		 url: "${pageContext.request.contextPath}/pinglun", 
   	     data: {code:code,tid:tid,userid1:userid1,pl:pl,userName1:userName1},
   	     success: function(data){  
   	    	 if(data.status ==200 || data.status ==201){
   	    		 $("#userid1").val(data.data.userid);s
   	    		 $("#userName1").val(data.data.userName);
   	    		 $("#pl").val("");
	    	
   	    		setTimeout(
   	    			  function() 
   	    			  {
   	    				window.location.reload();
   	    			  }, 1500);
   	    		 
   	    	 }else {
   	    		 alert(data.msg);
   	    	 }
   	     }  
   	  });
    });
});

</script>
</html>
