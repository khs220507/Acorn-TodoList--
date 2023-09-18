package todolistPRJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		LoginDAO dao = new LoginDAO();
		int result = dao.login(id, pw);

		if (result == 1) {

			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			response.sendRedirect("main.do");
		} else if (result == 0) {

			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
