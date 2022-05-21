package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Get_like_dto;

public class Get_like_dao extends Connect_database{
	public List<Get_like_dto> get_like(int user_id,int tweet_id){
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<Get_like_dto> like_list = new ArrayList<Get_like_dto>();
		String sql = "SELECT * FROM like_data WHERE user_id = ? AND tweet_id = ?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);
			pStmt.setInt(2, tweet_id);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				int user_id_1 = rs.getInt("user_id");
				int id = rs.getInt("id");
				String user_name = rs.getString("user_name");
				LocalDateTime create_time = rs.getObject("create_time",LocalDateTime.class);
				Get_like_dto main_get = new Get_like_dto(id,user_id_1,user_name,create_time);
				like_list.add(main_get);
			}
		}catch(SQLException e) {
			System.out.println("not_date");
			
		}finally {
			this.close(conn);
			this.close(pStmt);
			this.close(rs);
		}
		return like_list;
	}
}
