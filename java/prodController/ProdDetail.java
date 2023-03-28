package prodController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prodService.ProdService;
import prodService.ProdServiceImpl;
import prodVo.ProdVO;

/**
 * Servlet implementation class ProdDetail
 */
@WebServlet("/ProdDetail.do")
public class ProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청시 전송데이터 받기
		String prodId = request.getParameter("prodId");
		
		//service객체얻기
		ProdService service = ProdServiceImpl.getService();
		
		//service메소드 호출 - 결과값 받기
		ProdVO vo = service.prodByDetail(prodId);
		
		// 결과값 저장
		request.setAttribute("ppp", vo);
		
		//view페이지로 이동
		request.getRequestDispatcher("/view/prodDtail.jsp").forward(request, response);
	}

}
