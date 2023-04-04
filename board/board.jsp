<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  
   <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
  
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="../js/board.js"  type="text/javascript"></script>

<style>
*{
   box-sizing: border-box;
}
p{
 
 margin : 1px;
 padding : 3px;
 height : auto;
}
.p1{
  float : left;
  width : 70%;
}
.p2{
  float : right;
  width : 28%;
}
.p3{
  clear: both;
}
input[name=reply]{
  height : 50px;
  vertical-align: top; 
}
#pagelist{
  margin-left : 20%;
}

</style>


<script type="text/javascript">

currentPage = 1;

mypath = '<%= request.getContextPath()%>';

console.log(mypath);

  $(function(){
	  $.listPageServer(1);
	  
	  
	  //이벤트 
	  //페이지번호 클릭 
	  
	  //다음 클릭 
	  $(document).on('click', '#next', function(){
		 
		  currentPage =  parseInt($('.pageno').last().text().trim()) + 1;
		  $.listPageServer(currentPage);
		  
	  })
	  
	  //이전클릭
	$(document).on('click', '#prev', function(){
		
		  currentPage =  parseInt($('.pageno').first().text().trim()) - 1;
		  $.listPageServer(currentPage);
		  
	  })
  })
</script>

</head>
<body>


  <div id="result"></div>
  <br><br>
  <div id="pagelist"></div>
</body>
</html>










