<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
//controller에서 저장된 데이터 꺼내기
BuyerVO vo = (BuyerVO)request.getAttribute("zzz");

Gson gson = new Gson();
	String result = gson.toJson(vo);
	
	out.print(result);
	out.flush();
%>
<%--
{
	"id" : <%= vo.getBUYER_ID() %>,
	"lgu" : <%= vo.getBUYER_LGU() %>,
	"name" : <%= vo.getBUYER_NAME() %>,
	"mail" : <%= vo.getBUYER_MAIL() %>,
	"bank" : <%= vo.getBUYER_BANK() %>,
	"bName" : <%= vo.getBUYER_BANKNAME() %>,
	"bNo" : <%= vo.getBUYER_BANKNO() %>,
	"zip" : <%= vo.getBUYER_ZIP() %>,
	"add1" : <%= vo.getBUYER_ADD1() %>,
	"add2" : <%= vo.getBUYER_ADD2() %>,

}
 --%>