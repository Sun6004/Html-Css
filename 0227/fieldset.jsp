<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
color: blue;
}
</style>
</head>
<body>
<h1>JSP: Java Server Page</h1>
<%
request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("id");

%>
<p>당신의 아이디는<%=userId %>입니다ㅋ </p>
</body>
</html>