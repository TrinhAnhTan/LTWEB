package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/creatession"})
public class CreateSession extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2736668372529065640L;

	@SuppressWarnings("removal")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Khởi tạo Session
		HttpSession s = req.getSession();
		// Gán dữ liệu vào session
		s.setAttribute("ten", "Trịnh Anh Tân");
		s.setAttribute("tuoi", new Integer(22));
		// Thoeets lập thời gian tồn tại session
		s.setMaxInactiveInterval(30);
		// Hiển thị lên trang web
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("Xin chào bạn session đã được tạo");
		out.close();
	}

}
