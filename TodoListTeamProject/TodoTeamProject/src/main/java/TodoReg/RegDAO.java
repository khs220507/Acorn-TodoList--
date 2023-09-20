package TodoReg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public Connection dbcon() {

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
	public User selectUser(String id) {
		con=dbcon();
		String sql = "select * from usertbl where id = ?";
		User u = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,id);
			rs = pst.executeQuery();
			if(rs.next()) {
				String u_id = rs.getString(1);
				String u_pw = rs.getString(2);
				String u_name = rs.getString(3);
				String u_birth = rs.getString(4);
				String u_tel = rs.getString(5);
				u = new User(u_id,u_pw,u_name,u_birth,u_tel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs,pst,con);
		return u;
	}
	
	public void updateUser(User u) {
		con = dbcon();
		String sql = "update usertbl set pw = ? , tel =? where id = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getPw());
			pst.setString(2, u.getTel());
			pst.setString(3, u.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst,con);
		
	}
	
	public void insertUser(User u) {
		con = dbcon();
		
		String sql = "insert into usertbl values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,u.getId());
			pst.setString(2,u.getPw());
			pst.setString(3,u.getName());
			pst.setString(4,u.getBirth());
			pst.setString(5,u.getTel());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst,con);
		
	}
	public void deleteUser(String id) {
		con = dbcon();
		String sql="delete from usertbl where id = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
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
}
