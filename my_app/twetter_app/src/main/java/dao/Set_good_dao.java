package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Set_good_dao extends Connect_database{
	public void main_void (int tweet_id, int like_data) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "UPDATE tweet_data SET like_data = ?  WHERE id = ?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,like_data+1);
			pStmt.setInt(2, tweet_id);
			pStmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("teteteett");
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(rs);
			this.close(pStmt);
		}
	}
}
