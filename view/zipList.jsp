<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.ZipVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//controller에서 저장된 값 꺼내기
	List<ZipVo> list = (List<ZipVo>)request.getAttribute("listvalue");
	Gson gs = new Gson();
	String result = gs.toJson(list);
	
	out.print(result);
	out.flush();
%>