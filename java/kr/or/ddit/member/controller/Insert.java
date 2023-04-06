package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.MemverService;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 요청시 전송 데이터 받기 - 9개 - id, name
		// () 안에 join.jsp의 fdata 값과 일치해야함
		String memId = request.getParameter("mem_id");
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
		String memBir = request.getParameter("mem_bir");
		String memZip = request.getParameter("mem_zip");
		String memAddl = request.getParameter("mem_add1");
		String memAdd2 = request.getParameter("mem_add2");
		String memHp = request.getParameter("mem_hp");
		String memMail = request.getParameter("mem_mail");
		
		// vo 클래스에 저장
		MemberVO vo = new MemberVO();
		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		vo.setMem_name(memName);
		vo.setMem_bir(memBir);
		vo.setMem_zip(memZip);
		vo.setMem_add1(memAddl);
		vo.setMem_add2(memAdd2);
		vo.setMem_hp(memHp);
		vo.setMem_mail(memMail);
		
		// service 객체 얻어오기
		MemverService service = MemberServiceImpl.getService();
		
		// service메서드 호출하기 - 결과값 받기
		int res = service.insertMember(vo);
		
		// 결과값을 request에 저장하기
		request.setAttribute("resvalue", res);
		
		// view페이지로 이동
		request.getRequestDispatcher("/view/insert.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
