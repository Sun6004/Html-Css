<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.lprod.service.IlprodService"%>
<%@page import="kr.or.ddit.lprod.service.LprodServiceImpl"%>
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
//요청데이터

//service객체를 얻어오기
	IlprodService service = LprodServiceImpl.getService();

//service메서드 호출 - 결과값 받기
	List<LprodVO> list = service.selectAll();	

//결과값을 request에 저장
	request.setAttribute("lprodList", list);

//view페이지로 이동
	RequestDispatcher rd = request.getRequestDispatcher("/view/lprodList.jsp");
	rd.forward(request, response);
	
%>
</body>
</html>