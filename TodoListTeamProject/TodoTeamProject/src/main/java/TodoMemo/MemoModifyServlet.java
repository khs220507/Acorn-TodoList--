
package TodoMemo;  

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modify")
public class MemoModifyServlet extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BoardMemoService m=new BoardMemoService();
	ArrayList<BoardMemo> list=m.getSelectAll();
	//수정
	req.setAttribute("list", list);
	req.getRequestDispatcher("WEB-INF/views/memo.jsp").forward(req, resp);
}
}
