package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conpage.Create_con;

public class Create_user_dao extends Connect_database{
	public String create_user_class() {
		System.out.println("dao");
		Connect_database dbconn = new Connect_database();
		Create_con create_void = new Create_con();
		String[] user_lis = create_void.return_user();
		//System.out.println(user_lis);
		String get_mail = user_lis[2];
		String get_display_name = user_lis[0];
		String get_pass = user_lis[1];
		String get_profile = user_lis[3];
		String bool_1 = null;
		Connection conn = Connect_database.getConnection();
		PreparedStatement pStmt_1 = null;
		ResultSet re = null;
		String sql = new StringBuilder("INSERT INTO ")
				.append("user_data (mail, name, pass, profile)")
				.append("VALUES (?, ?, ?, ?);")
				.toString();
		try {
				System.out.println("tstete");
				System.out.println("aaaaaaaaa");
				pStmt_1 = conn.prepareStatement(sql);
				pStmt_1.setString(1,get_mail);
				pStmt_1.setString(2,get_display_name);
				pStmt_1.setString(3,get_pass);
				pStmt_1.setString(4,get_profile);
				pStmt_1.executeUpdate();
				bool_1 = "yes";
		} catch (SQLException e) {
			System.out.println("aaa"+e.getMessage());
			bool_1 = "no";
		}finally {
			this.close(pStmt_1);
			this.close(conn);
		}
		return bool_1;
	}
}
