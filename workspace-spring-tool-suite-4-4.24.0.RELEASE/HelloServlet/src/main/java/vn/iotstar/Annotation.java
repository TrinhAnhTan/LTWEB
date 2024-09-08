package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/annotation","/XML"})
public class Annotation extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699811296408851693L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		PrintWriter wr =resp.getWriter();
		
		wr.println("<h1> Xin chào các bạn, Tôi là Trịnh Anh Tân</h1>");
		
		wr.close();
	}

}
