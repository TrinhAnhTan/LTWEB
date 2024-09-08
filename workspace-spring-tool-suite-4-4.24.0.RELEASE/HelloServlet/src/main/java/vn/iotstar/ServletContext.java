package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/check-config" }, initParams = { @WebInitParam(name = "name", value = "Trịnh Anh Tân"),
		@WebInitParam(name = "email", value = "anhtan") })
public class ServletContext extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4145353208025482651L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset-UTF-8");
		PrintWriter out = resp.getWriter();

		jakarta.servlet.ServletConfig sc = getServletConfig();

		out.println(sc.getInitParameter("email"));
		out.println(sc.getInitParameter("name"));

		// Thiết lập chỉ số chung cho web
		getServletContext().setAttribute("truong", "Trường đại học Sư Phạm Kỹ Thuật HCM");;
		// Gọi tham số cho web
		String truong = (String) getServletContext().getAttribute("truong");
		out.println(truong);

		String scon = getServletContext().getInitParameter("sdt");
		out.println(scon);

		out.close();
	}

}
