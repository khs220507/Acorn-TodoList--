package TodoBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register") 
public class BoardRegisterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json;charset=UTF-8");
		req.getRequestDispatcher("WEB-INF/views/testMain.jsp").forward(req, resp);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardService s = new BoardService();
		
		String contents = req.getParameter("contents");
		
		String regTodo = s.registerTodo(new Board(contents));
		
		req.setAttribute("regTodo", regTodo);
		req.getRequestDispatcher("WEB-INF/views/testMain.jsp").forward(req, resp);
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.getWriter().write(regTodo);

	}
	
}
