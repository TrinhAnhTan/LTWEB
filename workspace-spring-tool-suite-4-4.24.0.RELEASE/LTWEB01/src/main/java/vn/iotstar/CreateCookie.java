package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/createcookie" })
public class CreateCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257282568472603953L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set response content type
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Nhận dữ liệu từ FORM
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		// Create cookies for first and last names.
		Cookie firstName = new Cookie("ten", ten);
		Cookie lastName = new Cookie("holot", holot);

		// Set expiry date after 24 Hrs for both the cookies.
		firstName.setMaxAge(60 * 60 * 24);
		lastName.setMaxAge(60 * 60 * 24);
		// Add both the cookies in the response header.
		resp.addCookie(firstName);
		resp.addCookie(lastName);

		PrintWriter out = resp.getWriter();
		out.println("<b>First Name</b>: " + firstName.getValue() + " - <b>Last Name</b>: " + lastName.getValue());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
