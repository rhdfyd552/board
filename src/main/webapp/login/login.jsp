<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">
    <%@ include file="../include/jQuery.jsp" %>
    <%@ include file="../include/jscookie.jsp" %>
    <script>
    
    	function setCookie(cookieName, cookieValue,expires){
    		var toDay = new Date();
    		toDay.setDate(toDay.getDate()+expires);
    		document.cookie = cookieName+"="+encodeURIComponent(cookieValue)+"; "+
    						"path=/;"+"expires="+toDay.toGMTString();
    	}
    //쿠키값
    //리턴:쿠키
    	function getCookie(cookieName){
    		cookieName = cookieName+"=";
    		
    		var cookies = document.cookie.split(';');
    		
    		for(var i = 0;i<cookies.length; i++){
    			var cookie = cookies[i];
    			if(cookie.indexOf(cookieName)>=0){
    				cookie = cookie.substring(cookieName.length);
    				return cookie;
    				
    			}
    		}   		
    	}
    	
    	function deleteCookie(cookieName){
    		setCookie(cookieName, "",-1);
    		console.log("deleteCookie");
    	}
    	//화면 로딩시 쿠키에 설정된 사용자 값을 확인하여 설정해준다
    	function initUserId(){
    		var userId = getCookie("userId");
    		var remember = getCookie("remember");
    		//저장된 쿠키가 있는 경우
    		if(userId != ""){
    			$('#userId').val(userId);//사용자 아이디를 설정해 준다
    			$('#password').focus();//비밀번호 입력창으로 focus
    			//$('#remember').prop("checked",true);//remember me checkbox check
    			console.log(userId)
    		}
    	}
    	
    	function initEvent(){
    		//remember me checkbox change 이벤트
    		$('#singinbtn').click(function(){
    			console.log("singinbtn");
    			var checked = $('#remember').prop("checked");
    			if(checked){
    				
    				$('#remember').val("true");
    			}
    			$('#frm').submit();
    		})
    		
    	}
    	
    	//문서 로딩
    	$(function(){
    		initUserId();
    		
    		initEvent();
    	})
    
    </script>
  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="<%=request.getContextPath()%>/LoginServlet" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
       
        <label for="userId" class="sr-only">userId</label> 
        <input type="text" id="userId" name="mem_id" class="form-control" placeholder="아이디를 입력해주세요" required autofocus>
       
       
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="mem_pass" class="form-control" placeholder="비밀번호를 입력해주세요" required>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="" id="remember" name="remember"> Remember me
          </label>
        </div>
        
        <button id="singinbtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  </body>
</html>
