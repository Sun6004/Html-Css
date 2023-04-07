package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;


@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 전송데이터 받기 - renum
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		// service 객체 얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		// service메서드 호출하기 - 결과값 받기
		int res = service.deleteReply(renum);
		
		// request에 결과값 저장
		request.setAttribute("result", res);
		
		// view 페이지로 이동하기
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}


}
