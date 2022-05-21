package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Tweet_data_dto;

public class Get_tweet_dao extends Connect_database{
	public List<Tweet_data_dto> get_tweet(){
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<Tweet_data_dto> tweet_list = new ArrayList<Tweet_data_dto>();
		String sql = "SELECT * FROM tweet_data ORDER BY create_time DESC;";
		try {
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				int tweet_id = rs.getInt("id");
				String tweet_text = rs.getString("tweet_text");
				String tweet_user = rs.getString("tweet_user");
				int tweet_like = rs.getInt("like_data");
				LocalDateTime create_time = rs.getObject("create_time", LocalDateTime.class);
				Tweet_data_dto main_dto = new Tweet_data_dto(tweet_text,tweet_user,create_time,user_id,tweet_id,tweet_like);
				tweet_list.add(main_dto);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(rs);
			this.close(pStmt);
		}
		return tweet_list;
	}
 
}
