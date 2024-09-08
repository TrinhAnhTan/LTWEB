package vn.iotstar;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2503688571332761207L;
	private String emailSupport1;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		// Lấy ra giá trị của tham số khởi tạo (initialization parameter) của Servlet.
		// (Theo Cấu hình của Servlet này trong web.xml).
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = resp.getOutputStream();
		out.println("<html>");
		out.println("<head><title>InitParam</title></head>");
		out.println("<body>");
		out.println("<h3>Init Param</h3>");
		out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
		out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
		out.println("</body>");
		out.println("<html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
