package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prodService.ProdService;
import prodService.ProdServiceImpl;
import prodVo.ProdVO;

@WebServlet("/ProdNames.do")
public class ProdNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdNames() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전송 데이터 받기 - lprod_gu
		String lgu = request.getParameter("guvalue");
		
		//service객체 얻어오기
		ProdService service = ProdServiceImpl.getService();
		
		//service메소드 호출-결과값 받기
		List<ProdVO> list = service.getClass(lgu);
		
		//결과값을 저장
		request.setAttribute("select", list);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/prodList.jsp").forward(request, response);
	}

}
