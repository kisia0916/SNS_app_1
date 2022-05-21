package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Set_like_dao extends Connect_database{
	public void like_set(int tweet_id,int user_id) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO like_data (user_id,tweet_id) VALUES (?,?);";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			pStmt.setInt(2, tweet_id);
			pStmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(pStmt);
			this.close(rs);
		}
	}
}
