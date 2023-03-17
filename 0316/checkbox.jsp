<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취미</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");	

	String[] hobbies = request.getParameterValues("hobby");
	String str = "";
	if(hobbies != null) {
		for(int i=0; i<hobbies.length; i++){
			str += hobbies[i] + " ";
		}
	}
%>
취미 : <%= str %>
</body>
</html>