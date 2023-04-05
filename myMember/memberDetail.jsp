<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<style type="text/css">
*{
	box-sizing: border-box;
}
table{
	border-collapse : collapse;
	border: 1px solid blue;
	width: 500px;
}
td{
	padding: 3px;
	align-items: center;
}

</style>
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO)request.getAttribute("memVo");
%>
<h3>회원 정보 상세보기</h3>
<table border="1">
	<tr>
		<td>
			<img src="<%=request.getContextPath() %>/images/imageSrcView.do?filename=<%=vo.getMem_photo()%>" width="150px">
		</td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=vo.getMem_id() %></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=vo.getMem_pass() %></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><%=vo.getMem_name() %></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=vo.getMem_tel() %></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><%=vo.getMem_addr() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<span>
				<a href="<%=request.getContextPath() %>/memberModifyForm.jsp?memId=<%=vo.getMem_id() %>&memPhoto=<%=vo.getMem_photo()%>">
					<button type="button" id="update">수정</button>
				</a>
				<a href="<%=request.getContextPath() %>/deleteMember.do?memId=<%=vo.getMem_id() %>">
					<button type="button" id="delete">삭제</button>
				</a>
				<a href="<%=request.getContextPath() %>/main.do">
					<button type="button">회원목록</button>
				</a>
			</span>
		</td>
	</tr>
</table>
</body>
</html>