package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

	public class TheaterDAO {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";

		public Connection dbcon() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				if (con != null)
					System.out.println("ok");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		
		
		
		// 전체조회 - 윤
		public ArrayList<Board> showAllTodo() {
			return null;
		}
		
		// 할일등록 - 민지
		public void registerTodo(Board b) {
			
		}
		
		// 할일수정 - 현수
		public void changeTodo(Board b) {
			
		}
		
		// 할일삭제 - 윤 *보류
		
		public void deleteTodo(int No) {
			
		}
		
		

		public void close(AutoCloseable... a) {
			for (AutoCloseable item : a) {
				try {
					item.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
