<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% RequestDispatcher rd = request.getRequestDispatcher("header.jsp?userId=brown");
	rd.include(request, response);
%>
<div id="left">left side</div>

<div id="content">main content</div>

<div id="footer">footer</div>
</body>
</html>