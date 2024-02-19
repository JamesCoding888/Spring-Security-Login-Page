package owasp03;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
@WebServlet("/owasp03/XSSTest")
public class XssServlet extends HttpServlet {
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie c1 = new Cookie("user", "james");
		c1.setHttpOnly(true);
		c1.setHttpOnly(false);
		resp.addCookie(c1);
		Cookie c2 = new Cookie("pwd", "123456");
//		c2.setHttpOnly(true);
		c2.setHttpOnly(false);
		resp.addCookie(c2);
		String javaScript = req.getParameter("javaScript");
		String badUrl = req.getParameter("badUrl");
		String normal = req.getParameter("normal");
		try {
			out.print("<h2> Safe: </h2>");
			out.print("<br>");
			out.print("normal: " + normal);
			out.print("</br>");
//			out.print("javaScript: " + ESAPI.encoder().encodeForHTML(javaScript));
			out.print("javaScript: " + javaScript);
			out.print("<br>");
//			out.print("badUrl: " + ESAPI.encoder().encodeForCSS(badUrl));
			out.print("badUrl: " + badUrl);
			// not safe
			out.print("<h2> Not Safe: </h2>");
			out.print("normal: " + normal);
			out.print("<br>");
			out.print("javaScript: " + javaScript);
			out.print("<br>");
			out.print("badUrl: " + badUrl);
			// back to home
//			out.print("<h3><a href='index.jsp'>Back to Home</a></h3>");
		} catch(Exception e) {
			e.getMessage();
		}
		
	}
}
