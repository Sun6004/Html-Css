/**
 * 
 */
$.listPageServer = function(cpage){
	
	vtype = "";
	 vword = "";
	  
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
				  
				code +=`<div class="card">
			      <div class="card-header">
			        <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
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
			              <input type="button"  name="delete" class="action" value="삭제">
			              <input type="button"  name="modify" class="action" value="수정">
			           </p>
			           <p class="p3">
			            ${v.content}
			           </p>
			           <p class="p4">
			              <textarea rows="" cols="50"></textarea>
			              <input type="button" name="reply" class="action" value="등록">
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
