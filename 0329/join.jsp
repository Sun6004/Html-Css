<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('#idCheck').on('click', function(){

      //입력한 값을 가져온다.
      idvalue = $('#uid').val().trim();
      console.log(idvalue);

      if(idvalue.length < 1){
        alert("아이디를 입력하세요");
        return false;
      }
     	 
      $.ajax({
        url:'<%=request.getContextPath()%>/IdCheck.do',
        type : 'get',
        data : {"id" : idvalue},
        success : function(res){

        },
        error : function(xhr){
          alert("상태: " +xhr.status);
        },
        dataType : 'json'
      })
    })
	})
</script>
</head>
<body>
<div class="container">
  <h2>회원가입</h2>
  <form class="needs-validation" novalidate>
    <div class="form-group">
      <label for="uid">아이디:</label>
      <button type="button" id="idCheck" class="btn btn-outline-info btn-sm">중복검사</button>
      <span id="idspan">1234</span>
      <input type="text" class="form-control" id="uid" placeholder="Enter username" name="mem_id" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="uname">이름:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter username" name="mem_name" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
   
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="mem_pass" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="ubir">생년월일:</label>
      <input type="date" class="form-control" id="ubir" placeholder="Enter username" name="mem_bir" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="uph">전화번호:</label>
      <input type="text" class="form-control" id="uph" placeholder="Enter username" name="mem_hp" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="umail">mail:</label>
      <input type="text" class="form-control" id="umail" placeholder="Enter username" name="mem_mail" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="uzip">우편번호:</label>
      <button type="button" id="zipsearch" class="btn btn-outline-info btn-sm">번호검색</button>
      <input type="text" class="form-control" id="uzip" placeholder="Enter username" name="mem_zip" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="uadd1">주소:</label>
      <input type="text" class="form-control" id="uadd1" placeholder="Enter username" name="mem_add1" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="uadd2">상세주소:</label>
      <input type="text" class="form-control" id="uadd2" placeholder="Enter username" name="mem_add2" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <button type="button" class="btn btn-outline-success btn-lg">Submit</button>
    <span id="joinspan">zzz</span>
  </form>
</div>
</body>
</html>