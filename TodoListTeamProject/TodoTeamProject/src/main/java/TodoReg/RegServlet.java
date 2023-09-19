package TodoReg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/views/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String tel = req.getParameter("tel");

		RegService s = new RegService();
		int result  = s.regUser(new User(id, pw, name, birth, tel));

		if (result == 1) {
			req.setAttribute("message", "다시 입력해주세요");
			req.getRequestDispatcher("WEB-INF/views/reg.jsp").forward(req, resp);
		} else if (result == 0) {
			System.out.print("ok");
			req.setAttribute("message", "회원가입 완료");
			req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
		}

	}

}
