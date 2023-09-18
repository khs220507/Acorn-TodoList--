package todolistPRJ;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchTerm = request.getParameter("searchTerm");

		List<String> searchResults;

		SearchDAO dao = new SearchDAO();

		searchResults = dao.searchMemo(searchTerm);

		request.setAttribute("searchResults", searchResults);
		request.getRequestDispatcher("WEB-INF/views/search.jsp").forward(request, response);
	}
}
