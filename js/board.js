/**
 * 
 */
$.boardDeleteService = function(){
	$.ajax({
		url : `${mypath}/BoardDelete.do`,
		type : 'get',
		data : {"bonum" : vidx},
		success : function(res){
			alert(res.flag)
			//성공했으면
			$.listPageServer(1);
		},
		error : function(xhr){
			alert("상태: " + xhr.status)
		},
		dataType : 'json'
	})

}

$.replyUpdateServer = function(){
	$.ajax({
		url : `${mypath}/ReplyUpdate.do`,
		type : 'post',
		data : reply, //reply객체 - cont, renum
		success : function(res){
			alert(res.flag);
			$(vp3).html(modiout);
		},
		error : function(xhr){
			alert("상태: " + xhr.status);
		},
		dataType : 'json'
	})
}

$.deleteReplyServer = function(target){ //target: 클릭한 댓글 삭제 버튼
	$.ajax({
		url : `${mypath}/ReplyDelete.do`,
		type : 'get',
		data : {"renum" : vidx},
		success : function(res){
			//alert(res.flag);
			if(res.flag == "ok"){
				$(target).parents('.reply-body').remove();
			}
		},
		error : function(xhr){
			alert(xhr.status);
		},
		dataType : 'json'
	})
	
	
}

$.boardWriteServer = function(){
	$.ajax({
		  url : `${mypath}/BoardWrite.do`,
		  type : 'post',
		  data : fdata,
		  success : function(res){
			  //alert(res.flag);
			  if(res.flag == "ok"){
				  currentPage = 1;
				  $.listPageServer(1);
			  }
		  },
		  error: function(xhr){
			  
			  alert("실패");
		  },
		  dataType : "json"
	})
}
$.replyListServer = function(target){ //target : 클릭한 등록 버튼 or 클릭한 제목
	$.ajax({
		url : `${mypath}/ReplyList.do`,
		type : 'get', //
		data : {"bonum" : vidx}, //{"bonum" : reply.bonum},
		success : function(res){
			//target: 클릭한 등록 기준으로 출력한다.
			rcode = "" 
			$.each(res, function(i, v){
				content = v.cont;
				content2 = content.replaceAll(/\n/g, "<br>");
				
				rcode += `<div class="reply-body">
					           <p class="p1">
					             작성자<span id="rwr">${v.name}</span>&nbsp;&nbsp;&nbsp; 
					             날짜<span id="rda">${v.redate}</span>&nbsp;&nbsp;&nbsp;
					           </p>
					           <p class="p2">
					              <input type="button" idx="${v.renum}" name="r_delete" class="action" value="댓글삭제">
					              <input type="button" idx="${v.renum}" name="r_modify" class="action" value="댓글수정">
					           </p>
					           <p class="p3">
					            ${content2}
					           </p>
					       </div>`
			})// $.each
			
			$(target).parents('.card-body').find('.reply-body').remove();
			$(target).parents('.card').find('.card-body').append(rcode);
		},
		error : function(xhr){
			alert("상태: " + xhr.status);
		},
		dataType: 'json'
	})// $.ajax
}//$.replyListServer

$.replyWriteServer = function(re){
	$.ajax({
		  url : `${mypath}/ReplyWrite.do`,
		  type : 'post',
		  data : reply,
		  success : function(res){
			 // 저장성공
			 alert(res.flag);
			 if(res.flag == "ok"){
			 // 댓글내용을 출력 - 등록버튼 (re)를 기준으로 출력
			 //$(re)
				 $.replyListServer(re);
			 }
		  },
		  error: function(xhr){
			  
			  alert("실패");
		  },
		  dataType : "json"
	})
}

$.listPageServer = function(cpage){
	
	vtype = $('#stype option:selected').val().trim();
	vword = $('#sword').val().trim();
	  
	  $.ajax({
		  url : `${mypath}/BoardList.do`,
		  type : 'post',
		  data :  {
			    "page" : cpage,
			    "stype" : vtype,
			    "sword" :vword
		  },
		  success : function(res){
			  code =   `<div class="container mt-3">
			            <div id="accordion">`;
			  $.each(res.datas, function(i, v){
				  
				  content = v.content; // \r\n
				  console.log("--------"+content);
				  
				  content = content.replaceAll(/\n/g,"<br>");
				  
				code +=`<div class="card">
			      <div class="card-header">
			        <a class="btn action" idx="${v.num}" name="list" data-bs-toggle="collapse" href="#collapse${v.num}">
			          ${v.subject}
			        </a>
			      </div>
			      <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
			        <div class="card-body">
			           <p class="p1">
			             작성자<span id="wr">${v.writer}</span>&nbsp;&nbsp;&nbsp; 
			             이메일<span id="em">${v.mail}</span>&nbsp;&nbsp;&nbsp;  
			             날짜<span id="da">${v.wdate}</span>&nbsp;&nbsp;&nbsp;
			             조회수<span id="hit">${v.hit}</span>&nbsp;&nbsp;&nbsp;
			           </p>
			           <p class="p2">
			              <input type="button" idx="${v.num}" name="delete" class="action" value="삭제">
			              <input type="button" idx="${v.num}" name="modify" class="action" value="수정">
			           </p>
			           <p class="p3">
			            ${v.content}
			           </p>
			           <p class="p4">
			              <textarea rows="" cols="50"></textarea>
			              <input type="button" name="reply" idx="${v.num}" class="action" value="등록">
			           </p>
			        </div>
			      </div>
			    </div>`
				  
			  })//$.each
			  code += `</div>
			          </div>`
			  
			    //리스트 출력
			  $('#result').html(code);
			    
			   //페이지 처리
			   //이전
			   pager = "";
			   pager += `<ul class="pagination">`;
			   if(res.sp > 1){
				     pager +=`  <li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
			   }
			   //페이지번호 
			   for(i=res.sp; i<= res.ep; i++){
				   if(i == currentPage){
					  pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>` 
				   }else{
					  pager += `<li class="page-item"><a  class="page-link pageno" href="#">${i}</a></li>`
				   }
			   }
			   //다음 
			   if(res.ep < res.tp){
				   pager +=`<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
			   }
			   pager += `</ul>` ;
			   
			   $('#pagelist').html(pager);
				          
		  },//success
		  error : function(xhr){
			  alert("상태 : " + xhr.status)
		  },
		  dataType : 'json'
		  
	  })
	
}
