package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Create_RoomTable_dao extends Connect_database{
	public void create_table(String table_name,int create_user,String room_profile) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO tweet_room_index (create_user,room_name,room_profile) VALUES (?,?,?);";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, create_user);
			pStmt.setString(2, table_name);
			pStmt.setString(3, room_profile);
			pStmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			this.close(conn);
			this.close(rs);
			this.close(pStmt);
		}
	}
}
