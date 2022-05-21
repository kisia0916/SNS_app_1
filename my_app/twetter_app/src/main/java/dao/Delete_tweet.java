package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete_tweet extends Connect_database{
	public void delete_mess(int id_1) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM tweet_data WHERE id = ?";
		try {
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id_1);
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
