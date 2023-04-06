package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.ReplyVO;

@WebServlet("/ReplyWrite.do")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 요청시 전송데이터 받기 - name, bonum, cont
		String repName = request.getParameter("name");
		int repBonum = Integer.parseInt(request.getParameter("bonum"));
		String repCont = request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		vo.setBonum(repBonum);
		vo.setCont(repCont);
		vo.setName(repName);
		
		// service객체 얻기 = 결과값을 받기
		IBoardService service = BoardServiceImpl.getService();
		
		int res = service.insertReply(vo);		
		
		// 결과값을 request에 저장
		request.setAttribute("result", res);

		
		// view페이지로 이동
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}

}
