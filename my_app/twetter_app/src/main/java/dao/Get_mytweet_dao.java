package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Mytweet_dto;
public class Get_mytweet_dao extends Connect_database{
	public List<Mytweet_dto> get_mytweet(int user_id){
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<Mytweet_dto>tweet_list = new ArrayList<Mytweet_dto>();
		String sql = "SELECT id,user_id,tweet_text,tweet_user,create_time FROM tweet_data WHERE user_id = ? ORDER BY create_time DESC;";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				String tweet_text = rs.getString("tweet_text");
				int user_id_1 = rs.getInt("user_id");
				int tweet_id_1 = rs.getInt("id");
				String tweet_user = rs.getString("tweet_user");
				LocalDateTime create_time = rs.getObject("create_time", LocalDateTime.class);
				Mytweet_dto My_tweet = new Mytweet_dto(tweet_text,tweet_user,create_time,user_id_1,tweet_id_1);
				tweet_list.add(My_tweet);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(pStmt);
			this.close(rs);
		}
		return tweet_list;
	}
}
