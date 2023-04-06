<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//controller 에서 저장한 데이터 꺼내기
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("listvalue");
	int sp = (Integer)request.getAttribute("startPage");	
	int ep = (Integer)request.getAttribute("endPage");	
	int tp = (Integer)request.getAttribute("totalPage");	

	JsonObject obj = new JsonObject();
	obj.addProperty("sp", sp);
	obj.addProperty("ep", ep);
	obj.addProperty("tp", tp);

	Gson gson = new Gson();
	
	JsonElement result = gson.toJsonTree(list);
	
	obj.add("datas", result);
	out.print(obj);
	out.flush();
%>