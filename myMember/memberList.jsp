<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
 	$(document).on('click', '.memId', function(){
		value = this.text();
		uri = 'getMember.do?memId=' + value;
		location.href='<%=request.getContextPath() %>/' + uri;
	})
})
</script>
</head>
<body>
<h3>회원 목록 보기</h3>
<table border="1">
	<thead>
		<tr>
			<td colspan="5"><button type="button">회원추가</button> </td>
		</tr>
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody>
		<%
			List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
		
			for(MemberVO vo : list){
		%>
			<tr>
				<td>
					<a class="memId" href="<%=request.getContextPath() %>/getMember.do?memId=<%=vo.getMem_id() %>">
						<%=vo.getMem_id() %>
					</a>
				</td>
				<td><%=vo.getMem_pass() %></td>
				<td><%=vo.getMem_name() %></td>
				<td><%=vo.getMem_tel() %></td>
				<td><%=vo.getMem_addr() %></td>
			</tr>
		<%
			}
		%>
	</tbody>
</table>
</body>
</html>