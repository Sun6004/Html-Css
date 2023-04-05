package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/getMember.do")
public class GetMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memId");
		System.out.println(memId);
		
		MemberVO vo = MemberServiceImpl.getInstance().getMember(memId);
		
		request.setAttribute("memVo", vo);
		
		request.getRequestDispatcher("/memberDetail.jsp").forward(request, response);
	}

}
