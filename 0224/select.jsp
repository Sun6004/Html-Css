<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
	border: 1px solid blue;
	width: 300px;
	height: 400px;
	margin: auto;
	text-align: center;
}
	
</style>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String id= request.getParameter("id");
	String name= request.getParameter("name");
	String food = request.getParameter("food");
	
	String foods[] = request.getParameterValues("foods");
	String str = "";
	for(String ss : foods){
		str += ss+"<br>";
	}
	%>
	<table border="1">
<tr>
 <td>아이디</td>
 <td><%=id  %> </td>
</tr>

<tr>
 <td>name</td>
 <td><%=name %></td>
</tr>

<tr>
 <td>가장좋아하는 음식</td>
 <td><%= food %></td>
</tr>

<tr>
 <td>좋아하는 음식들</td>
 <td><%= str %></td>
</tr>

</table>
</body>
</html>