<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장된 처리결과값을 꺼낸다.
List<MemberVO> varlist = (List<MemberVO>)request.getAttribute("listvalue");

Gson gson = new Gson();
	String result = gson.toJson(varlist);
	out.print(result);
	out.flush();
%>



