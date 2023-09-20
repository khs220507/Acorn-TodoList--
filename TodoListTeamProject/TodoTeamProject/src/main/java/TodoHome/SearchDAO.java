package TodoHome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {
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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(AutoCloseable... a) {

		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> searchMemo(String searchTerm) {
		List<String> searchResults = new ArrayList<>();
		Connection con = dbcon();
		String sql = "select b_memo from board_tbl where b_memo like ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, "%" + searchTerm + "%");
				rs = pst.executeQuery();
				while (rs.next()) {
					String memo = rs.getString("b_memo");
					searchResults.add(memo);
				}
				close(rs, pst);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(con);
			}
		}
		return searchResults;
	}
}
