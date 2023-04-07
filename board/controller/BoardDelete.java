package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;

@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		IBoardService service = BoardServiceImpl.getService();
		
		int res = service.deleteBoard(bonum);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
	}

}
