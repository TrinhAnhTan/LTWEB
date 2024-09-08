package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/helloform" })
public class HelloForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2299366696072746328L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set response content type
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Nhập dữ liệu từ request URL
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");

		// Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
		PrintWriter out = resp.getWriter();
		out.println("<b>First Name</b>: " + ten + "<br/><b>Last Nmae</b>: " + holot);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set response content type
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Nhận dữ liệu từ request URL
		String ten = req.getParameter("ten");
		String holot = req.getParameter("holot");
		// Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
		PrintWriter out = resp.getWriter();
		out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: " + holot);

	}

}
