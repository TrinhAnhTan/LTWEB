package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/readcookie" })
public class ReadCookie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5808054729796482808L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = req.getCookies();
		// Set response content type
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		if (cookies != null) {
			out.println("<h2> Found Cookies Name and Value</h2>");
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.print("Name : " + cookie.getName() + ", ");
				out.print("Value: " + cookie.getValue() + " <br/>");
			}
		} else {
			out.println("<h2>No cookies founds</h2>");
		}
		out.close();

	}

}
