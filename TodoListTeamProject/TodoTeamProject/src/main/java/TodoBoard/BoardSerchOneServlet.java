package TodoBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/search")
public class BoardSerchOneServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		BoardService s = new BoardService();
		Board b = s.getBoardOne(code);
		req.setAttribute("board", b);
		req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
		
	}
}
