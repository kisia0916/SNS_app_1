package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Set_tweet_dao extends Connect_database{
	public void Set_tweet(String user_name,int user_id,String tweet_text) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = new StringBuilder("INSERT INTO ")
				.append("tweet_data (user_id, tweet_text, tweet_user,like_data)")
				.append("VALUES (?, ?, ?,?);")
				.toString();
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,user_id);
			pStmt.setString(2, tweet_text);
			pStmt.setString(3,user_name);
			pStmt.setInt(4, 0);
			pStmt.executeUpdate();
			System.out.print("fkfkfk");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.print("sisisi");
		}finally {
			this.close(rs);
			this.close(pStmt);
			this.close(conn);
		}
	}
}
