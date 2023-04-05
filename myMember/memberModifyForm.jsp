<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<style type="text/css">
*{
	box-sizing: border-box;
}
table{
	border-collapse : collapse;
	border: 1px solid blue;
}
td{
	padding: 3px;
	align-items: center;
}
span{
	margin-left: 20%;
}
</style>
</head>
<body>
<h3>회원 정보 수정 폼</h3>
<form action="updateMember.do" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td colspan="2">
				<img src="<%=request.getContextPath() %>/images/imageSrcView.do?filename=<%=request.getParameter("memPhoto")%>" width="150px">
			</td>
		</tr>
		<tr>
			<td>회원ID</td>
			<td>
				<%=request.getParameter("memId") %>
				<input type="hidden" name="memId" value="<%=request.getParameter("memId") %>">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="memPass"></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="memName"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="memTel"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="memAddr"></td>
		</tr>
		<tr>
			<td>프로필 사진</td>
			<td><input type="file" name="memPhoto"></td>
		</tr>
		<tr>
			<td colspan="2">
				<span>
					<input type="submit" value="저장"></input>
					<input type="reset" value="취소">
					<a href="<%=request.getContextPath() %>/main.do">
						<button type="button">회원목록</button>
					</a>
				</span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>