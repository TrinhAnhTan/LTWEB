package vn.iotstar;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/annotationExample", "/annExample" }, initParams = {
		@WebInitParam(name = "emailSupport1", value = "abc@example.com"), @WebInitParam(name = "emailSupport2", value = "tom@example.com")
})


public class AnnotationExampleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8321877980437658682L;
	private String emailSupport1;

	public AnnotationExampleServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = resp.getOutputStream();
		out.println("<html>");
		out.println("<head><title>InitParam</title></head>");
		out.println("<body>");
		out.println("<h3>Servlet with Annotation configuration</h3>");
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
