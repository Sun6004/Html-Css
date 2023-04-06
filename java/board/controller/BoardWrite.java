package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/BoardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//요청시 전송데이터 받기 - writer, subject, mail, content, password
		BoardVO vo = new BoardVO();
		vo.setWriter(request.getParameter("writer"));
		vo.setSubject(request.getParameter("subject"));
		vo.setMail(request.getParameter("mail"));
		vo.setContent(request.getParameter("content"));
		vo.setPassword(request.getParameter("password"));
		vo.setWip(request.getRemoteAddr());
		
		// Service객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		// service 메서드로 호출하기 - 결과값 받기
		int res = service.insertBoard(vo);
		
		// 결과값을 erequest에 저장
		request.setAttribute("result", res);
		
		// View페이지로 이동
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}

}
