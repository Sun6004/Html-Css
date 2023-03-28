
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	//파라미터 받아오기
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int result = 0;

	Connection conn = null;
	String sql="SELECT COUNT(MEM_ID) AS result FROM MEMBER WHERE MEM_ID = ? AND MEM_PW=?"; //쿼리문	

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mydb");
		conn = ds.getConnection("LSI", "java");
		ds.getConnection("LSI", "java");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			result = rs.getInt(1);
		}
		
		if(result != 0){
		    // 로그인 성공
		    if(id.equals("admin")){
		        // 어드민 로그인
				out.println("<script>alert('관리자 로그인 입니다.');</script>");
				out.println("<script>location.href='Main.jsp'</script>");
		    } else {
		        // 일반 유저 로그인
				out.println("<script>alert('로그인 되었습니다.');</script>");
				out.println("<script>location.href='Main.jsp'</script>");
		    }
// 		    session.setAttribute("login", result);
// 		    session.setAttribute("id", id);
		}else{
			out.println("<script>alert('아이디와 비밀번호를 확인하세요.');</script>");
			out.println("<script>location.href='../groupWare/로그인.html'</script>");
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>
