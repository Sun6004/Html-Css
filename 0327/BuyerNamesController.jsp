<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buyer.service.BuyerService"%>
<%@page import="kr.or.ddit.buyer.dao.BuyerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//요청시 데이터 받기

//service 객체 얻기
BuyerService service = BuyerServiceImpl.getService();

//service메서드 호출 = 결과값 받기
List<BuyerVO> list = service.selectIdName();

//결과값을 저장
request.setAttribute("asd", list);

//view 페이지로 이동 - 응답 데이터를 생성 - json
RequestDispatcher disp = request.getRequestDispatcher("BuyerName.jsp");
disp.forward(request, response);
%>
</body>
</html>