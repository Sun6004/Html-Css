<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 3px solid red;
	margin: auto;
	border-collapse: collapse;
}
tr{
border: 1px solid yellow;

}
td{
width: 260px;
height: 60px;
text-align: center;
}

td:nth-child(1) {
	background-color: pink;
}
div{
border: 3px solid red;

	width: 500px;
	margin: auto;
	padding: 10px;
	height: 500px;
}
p{
	border: 1px solid green;
}
p:nth-child() {
	background-color: yellow;	
}
</style>
</head>
<body>
<%
String name = request.getParameter("name");
String id = request.getParameter("id");
String tel = request.getParameter("tel");
String txt = request.getParameter("txt");

String rep= txt.replaceAll("\n", "<br>").replaceAll("\r", "");

%>
</body>
<table border="1">
	<tr>
 <td>이름</td>
 <td><%=name  %> </td>
</tr>

	<tr>
 <td>아이디</td>
 <td><%=id  %> </td>
</tr>

	<tr>
 <td>전화번호</td>
 <td><%=tel  %> </td>
</tr>

	<tr>
 <td>자기소개</td>
 <td><%=txt  %> </td>
</tr>
</table>
<br>
<br>
<br>

<div>
	<p><span>자기소개</span></p>
	<p><span><%=rep %></span></p>
</div>
</html>