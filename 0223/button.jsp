<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border: 1px solid blue;
}
td{
	width: 200px;
	height: 50px;
}

</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String userId = request.getParameter("id");
	String userPw = request.getParameter("pw");
	String userGender = request.getParameter("gender");
	String userfile = request.getParameter("file");
	
	String foods[] = request.getParameterValues("foods");
	
	String str = "";
	for(String ss : foods){
		str += ss+"<br>";
	}
	//db연결 - crud처리 - 결과값 생성
%>

<table border="1">
<tr>
 <td>아이디</td>
 <td><%=userId  %> </td>
</tr>

<tr>
 <td>비밀번호</td>
 <td><%=userPw %></td>
</tr>

<tr>
 <td>성별</td>
 <td><%= userGender %></td>
</tr>

<tr>
 <td>좋아하는 음식</td>
 <td><%= str %></td>
</tr>

<tr>
 <td>첨부파일</td>
 <td><%= userfile %></td>
</tr>

</table>
</body>
</html>