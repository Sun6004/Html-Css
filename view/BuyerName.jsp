<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기
List<BuyerVO> list = (List<BuyerVO>)request.getAttribute("asd");

Gson gson = new Gson();
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>


<%-- 
[
<%
	for(int i=0; i<list.size(); i++){
	BuyerVO vo = list.get(i);
	if(i>0)out.print(",");
	
%>

	{
		"id" : "<%= vo.getBUYER_ID() %>",
		"name" : "<%= vo.getBUYER_NAME() %>"
	}

<%
	}

%>
]
--%>
