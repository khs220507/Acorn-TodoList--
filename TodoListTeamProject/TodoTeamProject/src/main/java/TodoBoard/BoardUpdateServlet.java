package TodoBoard;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/update")
public class BoardUpdateServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		BoardService s = new BoardService();
		
		
		Board b = s.getBoardOne(code);
		
		System.out.println(b);
		System.out.println(code);
		
		req.setAttribute("board", b);
		req.getRequestDispatcher("WEB-INF/views/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); 
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
		
		String code = req.getParameter("code");
		String newContents = req.getParameter("newContents");
		System.out.println(code);
		System.out.println(newContents);
		
		BoardService s = new BoardService();
		Board b = new Board(code, newContents);
		s.changeBoardData(b);
		
		
		resp.sendRedirect("/TodoTeamProject/main.do");
	}
}
