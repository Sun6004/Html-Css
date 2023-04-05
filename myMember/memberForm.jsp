<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<h3>회원 정보 입력 폼</h3>
<form action="insertMember.do" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td>회원ID</td>
			<td><input type="text" name="memId"><button type="button">중복확인</button></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="memPass"></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="text" name="confirmPass"></td>
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
					<input type="submit" value="저장">
					<input type="reset" value="취소">
					<a href="./memberList.jsp">
						<button type="button" onclick="">회원목록</button>
					</a>
				</span>
			</td>
		</tr>
	</table>
</form>
</body>
</html>