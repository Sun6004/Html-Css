<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int result = 0; //로그인 결과를 저장할 변수
	
	Connection conn = null;
	String sql = "SELECT COUNT(MEM_ID) AS result FROM MEMBER WHERE MEM_ID ="+ id  + "AND MEM_PW =" + pw +"'";
%>