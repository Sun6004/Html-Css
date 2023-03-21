<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="../css/MyStyle.css" />

<script src="../js/jquery-3.6.4.min.js" type="text/javaScript"></script>

<script></script>
<style>
p {
	font-size : 2.0em
}

h1 {
	color: red;
}
</style>
</head>
<body>
	<h1>JSP : Java Script Page</h1>

	<%
	String stxt = request.getParameter("txt");
	%>

	<p><%=stxt%></p>
</body>
</html>
