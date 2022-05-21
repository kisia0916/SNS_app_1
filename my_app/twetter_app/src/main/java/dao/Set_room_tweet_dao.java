package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Set_room_tweet_dao extends Connect_database{
	public void set_tweet(int room_id,int user_id,String user_name,String tweet_text) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO room_tweet_date(room_id,user_id,user_name,tweet_text) VALUES(?,?,?,?);";
		try {
			pStmt = conn.prepareStatement(sql);
			System.out.println(tweet_text);
			pStmt.setInt(1, room_id);
			pStmt.setInt(2, user_id);
			pStmt.setString(3, user_name);
			pStmt.setString(4, tweet_text);
			
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
