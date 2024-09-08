package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class HttpSession extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4612590836938686063L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		jakarta.servlet.http.HttpSession session =req.getSession();
		session.setAttribute("uname", "Trịnh Anh Tân");
		session.setMaxInactiveInterval(10); // Thiết lập thời gian tồn tại session
		
		// Lấy thông tin Session
		String uname = "";
		Object obj = session.getAttribute("uname");
		if (obj != null) {
			uname = String.valueOf(obj);
			// Tạo đối tượng PrintWriter và hiển thị thông tin
		    PrintWriter printWriter = resp.getWriter();
		    printWriter.println(uname);
			}else {
			//chuyển sang trang LoginServlet
			resp.sendRedirect("/LTWEB01/HttpSession");
			}
		
		
			
	}
}
