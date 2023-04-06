package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemverService;


@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전송데이터 받기 -id
		String userId = request.getParameter("id");
		
		//service객체얻기
		MemverService service = MemberServiceImpl.getService();
		
		//service메소드 호출 - 결과값 받기
		String res = service.idCheck(userId);
		
		//결과값을 requese에 저장
		request.setAttribute("zzz", res);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/idCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
