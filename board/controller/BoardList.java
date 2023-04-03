package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;


@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//요청시 전송 데이터 가져오기 
		int page = Integer.parseInt(request.getParameter("page")); // 최초 실행시 값이 1
		String stype = request.getParameter("stype"); //최초 실행시 없다.
		String sword = request.getParameter("sword"); //최초 실행시 값이 없다
		
		// service객체 얻기
		IBoardService service = BoardServiceImpl.getService();
		
		// service 메서드 호출하기 - 페이지 처리에 필요한 값들을 계산 
		
		
		// service 메서드 - list를 select 한 결과값 받기
		
		
		// 결과값을 request에 저장
		
		
		// view 페이지로 이동
		
		
	}

}
