package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/showsession"})
public class ShowSession extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8928875438580524587L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Hiển thị sesion lên web
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String ten ="";
		// khởi tạo session
		HttpSession s = req.getSession();
		//truy xuất dữ liệu từ session
		Object obj = s.getAttribute("ten");
		
		// Kiểm tra đối tượng Objective có null hay không
		if(obj != null) {
			ten = String.valueOf(obj); //ép kiểu về String
		}else {
			// nếu null thì chuyển về trang tạo session
			resp.sendRedirect("/LTWEB01/createsession");
		}
		int tuoi = (Integer)s.getAttribute("tuoi");//ép kiểu
		//Hiển thị session lê web
		out.println("Xin chào bạn:" + ten + "tuổi:" + tuoi);
		out.close();
	}

}
