package vn.iotstar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/any/*"})
public class AsteriskServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2583562137600232601L;

	public AsteriskServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = resp.getOutputStream();
		out.println("<html>");
		out.println("<head><title>Asterisk</title></head>");
		out.println("<body>");
		out.println("<h3>Hi, your URL match /any/*</h3>");
		out.println("</body>");
		out.println("<html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
