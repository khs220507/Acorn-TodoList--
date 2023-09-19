package TodoHome;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		//
		HttpServletRequest h_request = (HttpServletRequest) request;
		HttpServletResponse h_response = (HttpServletResponse) response;
		HttpSession session = h_request.getSession();

		if (session.getAttribute("userId") != null) {
			// 요청한 서블릿으로 넘어감
			chain.doFilter(request, response);
		} else {
			String path = h_request.getContextPath();
			h_response.sendRedirect(path + "/login");
		}
	}
}
