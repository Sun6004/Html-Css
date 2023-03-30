<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String res = (String)request.getAttribute("zzz"); //controller에서 저장한 이름
	if(res !=null){
%>
	{
		"flag" : "사용 불가능한 id"
	}	
	
<%	}else{ %>
	
	{
		"flag" : "사용 가능한 id"
	}
		
<% 
	}
%>		