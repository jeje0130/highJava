package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		// Form에서 넘어오는 Parameter값들을 구한다.
		String userId = request.getParameter("userid"); //userid값 받기
		String pass = request.getParameter("pass");		//pass값 받기
		
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();

		
		//로그인 성공 여부 검사하기 (성공 id : admin, password : 1234)
		if(userId != null && pass != null) {	//해당 변수의 null값 여부 검사
			if(userId.equals("admin") && pass.equals("1234")) {
				session.setAttribute("userId", userId);
			}
		}
		//sessionLogin.js문서로 이동하기
		//방법 1) sendRedirect()이용하기
//		response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
		
		//방법 2) forward방식 이용하기
		RequestDispatcher rd = request.getRequestDispatcher("/basic/03/sessionLogin.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
