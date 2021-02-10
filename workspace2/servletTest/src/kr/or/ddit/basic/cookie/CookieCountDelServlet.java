package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		//count라는 쿠키변수가 있는지 검사한다.
        Cookie[] cookieArr = request.getCookies();
        int count = 0;
        
        for(Cookie cookie : cookieArr) {
           String name = cookie.getName();
           if("count".equals(name)) {
              //쿠키의 수명을 0으로 셋팅
              cookie.setMaxAge(0);
              response.addCookie(cookie);
           }
        }
        
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DPCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'>");
        out.println("<title>Cookie count 연습</title></head>");
        out.println("<body>");      
        out.println("<h2>count가 초기화 되었습니다.</h2><hr>");
        
        out.println("<a href='" + request.getContextPath() + "/basic/02/cookieCount.jsp'>시작문서로 이동하기</a>");
        
        out.println("</body> </html>");   
		
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
