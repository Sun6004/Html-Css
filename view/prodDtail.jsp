<%@page import="com.google.gson.Gson"%>
<%@page import="prodVo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- --%>
<%
 //controller에서 저장한 데이터 꺼내기
 ProdVO pvo = (ProdVO)request.getAttribute("ppp");

	Gson gson = new Gson();
	String result = gson.toJson(pvo);
	
	out.print(result);
	out.flush();
%>

<%-- 
{
	"id" : "<%= pvo.getProd_id() %>" ,
	"buyer" : "<%= pvo.getProd_buyer() %>" ,
	"cost" : "<%= pvo.getProd_cost() %>" ,
	"detail" : "<%= pvo.getProd_detail() %>" ,
	"name" : "<%= pvo.getProd_name() %>" ,
	"sale" : "<%= pvo.getProd_sale() %>" ,
	"prive" : "<%= pvo.getProd_price() %>" ,
	"cost" : "<%= pvo.getProd_cost() %>" 
}
--%>