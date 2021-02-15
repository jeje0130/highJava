package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// Form에서 넘어오는 Parameter값들을 구한다.
		String userId = request.getParameter("userid"); //userid값 받기
		String pass = request.getParameter("pass");		//pass값 받기
		
		HttpSession session = request.getSession();

		session.setAttribute("id", userId);
		session.setAttribute("pw", pass);
		
		//로그인 성공 여부 검사하기 (성공 id : admin, password : 1234)
		if(userId != null && pass != null) {	//해당 변수의 null값 여부 검사
			if(userId.equals("admin") && pass.equals("1234")) {
				//로그인 성공시
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head><meta charset='utf-8'>");
				out.println("<title>Session 연습</title></head>");
				out.println("<body>");
				
				out.println("<h2>" + userId +" 님 반갑습니다</h2>");
				
				out.println("<hr><br>");
				
				out.println("<a href='"
						+ request.getContextPath() + "/sessionLogout.do'>로그아웃</a>");
				
				
				out.println("</body></html>");
				
			}else {
				//로그인 실패시
				response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
				}
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
