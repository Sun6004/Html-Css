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
import board.vo.ReplyVO;

@WebServlet("/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String cont = request.getParameter("cont");
		int renum = Integer.parseInt(request.getParameter("renum"));
		// 요청시 전송 데이터 받기 - cont, renum - vo에 저장
		ReplyVO vo = new ReplyVO();
		vo.setCont(cont);
		vo.setRenum(renum);
		
		// service 객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		// service 메서드 호출 - 결과값 받기
		int res = service.updateReply(vo);
		
		// request에 결과값 저장
		request.setAttribute("result", res);
		
		// view페이지로 이동 - result.jsp
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}

}