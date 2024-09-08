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
public class ServletConfig extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7550367938359857797L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset-UTF-8");
		PrintWriter out = resp.getWriter();

		jakarta.servlet.ServletConfig sc = getServletConfig();

		out.println(sc.getInitParameter("email"));
		out.println(sc.getInitParameter("name"));
		out.close();

	}

}
