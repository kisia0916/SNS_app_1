package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect_database {
	private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/twetter_data";
	private static final String DB_USER = "digskill";
	private static final String DB_PASS = "secret";
	protected static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			return conn;
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println("nulllll");
			e.printStackTrace();	
			return null;
		}
	}
	protected void close(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	protected void close(PreparedStatement pStmt){
		if (pStmt != null) {
			try {
				pStmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	protected void close(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
