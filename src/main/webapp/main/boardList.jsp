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
    <%@ include file="/include/commonCss.jsp" %>
    <%@ include file="/include/jQuery.jsp" %>
    <script>
    	$(function(){
    		
    		
    		$('#boardList tr').click(function(){
    			var board_seq = $(this).find("td:eq(1)").text();
    			var category_seq = $(this).find("td:eq(0)").text();
    			var del_yn = $(this).find("td:eq(2)").attr('class');
    			
    			if(del_yn == 'Y'){
    				return false;
    			}
    			
    			$('#board_seq').val(board_seq);
    			$('#category_seq').val(category_seq);
				if($(this).find('td').attr('class')=="Y"){
    				return false;
    			}
    			$('#frm').submit();
    			 	

    				
    		})
    		$('#boardReg').click(function(){
    			document.location = "${pageContext.request.contextPath }/board/boardForm.jsp";
    		})
    	})
    </script>
    <style>
    	.Y{
    		color: #c91010;
    	}
    
    </style>
  </head>

  <body>

    <%@ include file="/layout/header.jsp" %>
  <form id="frm" action="${pageContext.request.contextPath }/getBoard" method="get">
  	<input type="hidden" name="board_seq" id="board_seq">
  	<input type="hidden" name="category_seq" id="category_seq">
  </form>
    <div class="container-fluid">
      <div class="row">
        <%@ include file="/layout/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">게시글 목록</h1>

				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>게시글 이름</th>
								<th>작성자</th>
								<th>등록 일시</th>
							</tr>
						</thead>
						<tbody id="boardList">
							<c:forEach items="${boardList }" var="vo">
								<tr>
									<td hidden>${vo.category_seq}</td>
									<td>${vo.board_seq }</td>
									<c:choose>
										<c:when test="${vo.del_yn == 'Y'}">
											<td class="Y" >삭제된 게시글 입니다</td>
										</c:when>
										<c:otherwise>
											<td class="N">${vo.title }</td>
										</c:otherwise>

									</c:choose>
									<td>${vo.reg_id }</td>
									<td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd" /></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<button id="boardReg" type="submit" class="btn btn-default">게시글 쓰기</button>
				${pageNav }
				
			</div>
		</div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
