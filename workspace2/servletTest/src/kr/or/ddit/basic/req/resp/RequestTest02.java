package kr.or.ddit.basic.req.resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestTest02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String strNum1 = request.getParameter("number1");
		String strNum2 = request.getParameter("number2");
		String op = request.getParameter("op");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Request 객체 연습 2</title></head>");
		out.println("<body>");
		
		out.println("<hr>");
		out.println("<h2>계산결과</h2>");
		out.println("<hr>");
		
		double result = 0;
		boolean calOk = true; //계산 성공 여부 저장하는 변수
		
		switch (op) {
		case "+":
			result = num1 + num2;
			out.println("<p>"+ num1 + op + num2 + " = "+ result + "</p>");
			break;
		case "-":
			result = num1 - num2;
			out.println("<p>"+ num1 + op + num2 + " = "+ result + "</p>");
			break;
		case "/":
				result = (double)num1 / num2;
				out.println("<p>"+ num1 + op + num2 + " = "+ result + "</p>");
			break;
		case "*":
			result = num1 * num2;
			out.println("<p>"+ num1 + op + num2 + " = "+ result + "</p>");
			break;
		case "%":

				result = num1 % num2;
				out.println("<p>"+ num1 + op + num2 + " = "+ result + "</p>");
			break;
		
		default:
			break;
		}
		 
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
