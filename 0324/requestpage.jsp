<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/MyStyle.css">
<script src="../js/jquery-3.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('#lprod').on('click', function(){
			$.ajax({
				url : "http://localhost/jqPro/0324/lprodController.jsp",
				type : 'get',
				success : function(res){
					//alert("성공");
					code = "<table border = '1'>";
					code += "<tr><td>no.</td><td>상품번호</td><td>상품분류</td></tr>"
					
					$.each(res, function(i, v){
						code += "<tr><td>"+v.id +"</td><td>"+ v.gu +"</td><td>"+ v.nm+ "</td></tr>"
					})
					code += "</table>"

					$('#r1').html(code);
				},
				error : function(xhr){
					alert("상태: " + xhr.status);
				},
				dataType : 'json'
			})
		})
	})
</script>
<style>
	table{
		border: 2px solid rgb(19, 135, 155);
	}
	td{
		width: 150px;
		height: 30px;
		text-align: center;
		color: rgba(9, 103, 9, 0.734);
	}

</style>
</head>
<body>
	<div class="box">
		<p></p>
		
		<input type="button" value="lprod리스트" id="lprod">
		<br>
		<br>
		<div class="result" id="r1"></div>
	</div>
	
</body>
</html>