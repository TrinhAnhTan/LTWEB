package vn.iotstar;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestResponse extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6590908648770958204L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Phuong thuc su dung Request: " + req.getMethod());
		req.getContentType();
		req.getContextPath();
		
		System.out.println(req.getServerName());
		System.out.println(req.getServletPath());
		
		Enumeration<String> k = req.getHeaderNames();
		while (k.hasMoreElements()) {
			String key = k.nextElement();
			System.out.println(key + ":" + req.getHeader(key));
		}
		
	}

}
