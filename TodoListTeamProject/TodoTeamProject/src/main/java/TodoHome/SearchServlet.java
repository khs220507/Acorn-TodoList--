package TodoHome;
  
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchtest")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchTerm = request.getParameter("searchTerm");

		List<String> searchResults;

		SearchDAO dao = new SearchDAO();

		searchResults = dao.searchMemo(searchTerm);
		if (searchTerm == null || searchTerm.trim().isEmpty()) {
			String alertScript = "<script>alert('검색어를 입력하지 않았습니다.'); window.location.href='searchtest';</script>";
			response.getWriter().println(alertScript);
			return; //
		}

		request.setAttribute("searchResults", searchResults);
		request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
	}

}
