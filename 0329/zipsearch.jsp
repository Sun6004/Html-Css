<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../css/MyStyle.css">

<script type="text/javascript">
 $(function(){
	 $('#zip').on('click', function(){
		 dongvalue = $('#dong').val().trim();

		 $.ajax({
			url : '<%=request.getContextPath()%>/zipSearch.do',
			data : {"dong" : dongvalue},
			type : 'post',
			dataType : 'json',
			success : function(res){
				//alert("성공");			
				code = "<table>"
					code += "<tr><td>우편번호</td><td>주소</td><td>번지</td></tr>"
					$.each(res, function(i, v) {
						code += "<tr><td>" + v.zipcode + "</td>";
						code += `<td> ${v.sido} ${v.gugun} ${v.dong} </td>`;
						code += `<td> ${v.bunji}</td></tr>`;
					})
					code+="</table>";
                    $("#r1").html(code);
			},
			error : function(xhr){
				alert("상태: " +xhr.status);
			}
		 })
	 })
	 
	 //결과에서 한줄을 선택하면 (click이벤트) - 실행중 동적으로 생성된 요소
	 $(document).on('click', '#r1 tr', function(){
		zip =  $('td:eq(0)', this).text();
		addr =  $('td:eq(1)', this).text();
		
		$('#uzip', opener.document).val(zip);
		$('#uadd1', opener.document).val(addr);
		
		window.close();
	 })
 })
</script>

<style>
	#r1 tr:hover{
		background: skyblue;
	}
</style>
</head>
<body>
	<div class="box">
	<p>찾는 동을 입력하세요</p>
	<input type="text" id="dong">
	<input type="button" value="검색" id="zip">
	<br>
	<br>
	<div class="result" id="r1"></div>
</div>
</body>
</html>