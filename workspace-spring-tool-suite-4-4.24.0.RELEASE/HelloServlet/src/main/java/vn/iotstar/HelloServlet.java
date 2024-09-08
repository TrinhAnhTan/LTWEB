package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371967339859964305L;

	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("Phuong thuc su dung la:" + req.getMethod());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter wr = resp.getWriter();
		wr.println("<h1> Xin chao ban</h1>");
		wr.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Ket thuc Servlet");
	}

}
