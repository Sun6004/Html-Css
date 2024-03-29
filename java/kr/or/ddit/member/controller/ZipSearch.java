package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemverService;
import kr.or.ddit.member.vo.ZipVo;


@WebServlet("/zipSearch.do")
public class ZipSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//전송데이터 dong값 가져오기
		String dong = request.getParameter("dong");
		
		//service객체 얻기
		MemverService service = MemberServiceImpl.getService();
		
		//service메소드 호출 - 결과값 받기
		List<ZipVo> list = service.selectByDong(dong);
		
		//결과값을 request에 저장
		request.setAttribute("listvalue", list);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/zipList.jsp").forward(request, response);
	}

}
