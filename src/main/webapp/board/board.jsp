<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
        <%@ include file="/include/jQuery.jsp" %>
    <script>
    	$(function(){
    		var mem_id = $("#mem_id").val();
    		/* if(mem_id==null || mem_id==''){
    			if(mem_id != $("board tr").find("td:eq(2)").text()){
    				$('#modifyBoard').hide();
    				$('#deleteBoard').hide();
    			}else{
    				$('#replyBoard').hide();
    			}
    		} */
    		$('#modifyBoard').click(function(){
    			//method : get-조회할 때 , post-서버상의 변경이 일어날 때
    			$('#frm').attr('action','${pageContext.request.contextPath}/modifyBoard');
    			$('#frm').attr('method','get');
    			$('#frm').submit();
    		})
    		
    		$('#deleteBoard').click(function(){
    			$('#frm').attr('action','${pageContext.request.contextPath}/deleteBoard');
    			$('#frm').attr('method','get');
    			$('#frm').submit();
    		})
    		$('#replyBoard').click(function(){
    			$('#frm').attr('action','${pageContext.request.contextPath}/replyBoard');
    			$('#frm').attr('method','get');
    			$('#frm').submit();
    		})
    	})
    
    </script>
    
    <style>
    	td{
    		width: 200px;
    		height:50px;
    		border-top: 1px black solid;
    		border-bottom: 1px gray solid;
    		font-weight: bold;
    	}
    
    </style>
  </head>

  <body>

    <%@ include file="/layout/header.jsp" %>
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
			<div class="container-fluid">
		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<table id="board">
					<tr>
						<td>${category_seq }</td>
						<td>${boardVO.title}</td>
						<td>${boardVO.reg_id}</td>
						<td><fmt:formatDate value="${boardVO.reg_dt}" pattern="yyyy-MM-dd hh:mm"/></td>
					</tr>
				</table>
				<form id="frm"class="form-horizontal" role="form" method="get">
				<div>
					<input type="hidden" id="board_seq" name="board_seq" value="${boardVO.board_seq }">
				</div>
					
					<div class="content">
					
						<p>
							${boardVO.content }
						</p>
						
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="modifyBoard" class="btn btn-default">게시글 수정</button>
							<button type="button" id="deleteBoard" class="btn btn-default">게시글 삭제</button>
							<button type="button" id="replyBoard" class="btn btn-default">답글 달기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
				
		</div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
  <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
