package TodoBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {

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

	// 전체조회 - 현수

	public ArrayList<Board> showAllTodo() {

		Board board = null;
		Connection con = dbcon();
		String sql = "select * from board_tbl";
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<Board> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String code_tmp = rs.getString(1);
				int no_tmp = rs.getInt(2);
				String id_tmp = rs.getString(3);
				String contents_tmp = rs.getString(4);
				String date_tmp = rs.getString(5);
				String star_tmp = rs.getString(6);
				String finished_tmp = rs.getString(7);
				board = new Board(code_tmp, no_tmp, id_tmp, contents_tmp, date_tmp, star_tmp, finished_tmp);
				list.add(board);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 해제
		close(rs, pst, con);
		return list;
	}
	
	/*
	// 할일등록 - 민지
		public void registerTodo(Board b) {
			
			Connection con = dbcon();
			String sql = "insert into board_tbl values(?,?,?,?,?,?,?)";
			PreparedStatement pst = null;
			
			try {
				pst=con.prepareStatement(sql);
				pst.setString(1,b.getCode());
				pst.setInt(2,b.getNo());
				pst.setString(3,b.getId());
				pst.setString(4,b.getContents());
				pst.setString(5,b.getDate());
				pst.setString(6,b.getStar());
				pst.setString(7,b.getFinished());
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(pst,con);
		
			
		}*/
	
	//할일등록 - 민지
	/*public void registerTodo(Board b) {
		
		Connection con = dbcon();
		
		//String insertQuery = "INSERT INTO your_table (column_name) VALUES (?)"
		
		String sql = "insert into board_tbl (b_code, b_no, b_contents, b_date) values (seq_code.nextval, seq_no.nextval, ?, sysdate)";
		PreparedStatement pst = null;
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, b.contents);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst,con);
	}*/
	
	
	//할일등록 return - 민지
	public String registerTodo(Board b) {
		
		Connection con = dbcon();
		
		//String insertQuery = "INSERT INTO your_table (column_name) VALUES (?)"
		
		String sql = "insert into board_tbl (b_code, b_no, b_contents, b_date) values (seq_code.nextval, seq_no.nextval, ?, sysdate)";
		PreparedStatement pst = null;
		
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, b.contents);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst,con);
		return b.contents;
	}
	
	
	
	
	
	// 할일수정 - 현수
	public void changeTodo(Board b) {
	}
	
	// 할일삭제 - 민지
		public void deleteTodo(String code) {
			
			Connection con = dbcon();
			
			String sql = "delete from board_tbl where b_code=?";
			PreparedStatement pst = null;
			
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1,code);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(pst,con);
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
	
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		//dao.registerTodo(new Board("A06",6,"abc@naver.com","테스트하기","2023-09-15","F","F"));
		//dao.deleteTodo("1008");
		
		//dao.registerTodo(new Board("할일 테스트 2222"));
		//dao.registerTodo(new Board("테스트"));
		
	}
	

}
