package vn.iotstar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/"})
public class MydefaultServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980540897657786132L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletOutputStream out = resp.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Page not found</title></head>");
		out.println("<body>");
		out.println("<h3>Sorry! Page not found</h3>");
		out.println("<h1>404</h1>");
		out.println("Message from servlet: " + this.getClass().getName());
		out.println("</body>");
		out.println("<html>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
