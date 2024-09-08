package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Refresh extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7810762444713880236L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set refresh, autoload time as 5 seconds
		resp.setIntHeader("Refresh", 5);
		// Set response content type
		resp.setContentType("text/html");

		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		PrintWriter out = resp.getWriter();
		 String title = "Auto Refresh Header Setting";
		 String docType = "<!doctype html>\n";
		 out.println(docType + "<html>\n" +
		 "<head><title>" + title + "</title></head>\n"+
		 "<body bgcolor = \"#f0f0f0\">\n" +
		"<h1 align = \"center\">" + title + "</h1>\n" +
		 "<p>Current Time is: " + CT + "</p>\n");
	}

}
