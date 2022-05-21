package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.Get_room_dto;
public class Get_room_dao extends Connect_database{
	public List<Get_room_dto> get_room_list(){
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		List<Get_room_dto> room_list = new ArrayList<Get_room_dto>();
		String sql = "SELECT * FROM tweet_room_index;";
		try {
			pStmt = conn.prepareStatement(sql);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int create_user_id = rs.getInt("create_user");
				String room_name = rs.getString("room_name");
				String room_profile = rs.getString("room_profile");
				LocalDateTime create_time = rs.getObject("create_time",LocalDateTime.class);
				Get_room_dto set_room = new Get_room_dto(id,create_user_id,room_name,room_profile,create_time);
				room_list.add(set_room);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(rs);
			this.close(pStmt);
		}
		return room_list;
	}
}
