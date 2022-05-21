package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_like_dao extends Connect_database{
	public boolean check_like(int user_id,int tweet_id) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		boolean sql_data = false;
		String sql = "SELECT * FROM like_data WHERE user_id = ? AND tweet_id = ? LIMIT 1;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			pStmt.setInt(2, tweet_id);
			rs = pStmt.executeQuery();
			//System.out.println(rs);
			if (!rs.next()) {
				System.out.println("testetetete");//////取得したデータがnullならここが実行される
				sql_data = true;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(rs);
			this.close(pStmt);
		}
		return sql_data;
	}
}
