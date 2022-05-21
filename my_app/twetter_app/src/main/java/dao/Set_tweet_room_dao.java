package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Set_tweet_room_dao extends Connect_database{
	public void set_tweet_room(int room_id,int user_id,String tweet_text,String user_name) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tweet_room_date(room_id,user_id,user_name,tweet_text) VALUES (?,?,?,?);";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, room_id);
			pStmt.setInt(2, user_id);
			pStmt.setString(3, user_name);
			pStmt.setString(4, tweet_text);
			pStmt.executeQuery();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(pStmt);
			this.close(rs);
		}
	}
}
