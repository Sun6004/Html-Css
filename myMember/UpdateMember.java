package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/updateMember.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*100)
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(request.getParameter("memId"));
		vo.setMem_name(request.getParameter("memName"));
		vo.setMem_pass(request.getParameter("memPass"));
		vo.setMem_tel(request.getParameter("memTel"));
		vo.setMem_addr(request.getParameter("memAddr"));
		
		String uploadPath = "d:/d_other/uploadFiles";
		
		File f = new File(uploadPath);
		if(!f.exists()) {
			 f.mkdirs();
		}
		
		Part part = request.getPart("memPhoto");
		
		String fileName = "";
		String headerValue = part.getHeader("content-disposition");
		
		String[] items = headerValue.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		vo.setMem_photo(fileName);
		
		part.write(uploadPath + File.separator + fileName);
		
		MemberServiceImpl.getInstance().updateMember(vo);
		
		response.sendRedirect(request.getContextPath() + "/main.do");
	}

}
