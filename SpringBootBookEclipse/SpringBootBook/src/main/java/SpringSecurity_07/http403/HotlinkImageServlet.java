package SpringSecurity_07.http403;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayimage")
public class HotlinkImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");		

		// Check if referer is null or not matching your domain
		if (referer == null || !referer.startsWith("http://localhost:8081")) {
			// Return HTTP 403 Forbidden if the referer is not allowed
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		// Serve the image
		// You can load the image from a file, database, etc.
		// For simplicity, we're just sending a dummy response with a plain text
		response.setContentType("text/plain");
//		response.getWriter().println("Your protected image content here");
		response.sendRedirect("image/whatishotlinking.png");
	}
}
