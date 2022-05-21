package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Longin_user_dto;
public class Login_user_dao extends Connect_database{
	public Longin_user_dto get_db_data(String mail,String pass) {
		Connection conn = getConnection();
		PreparedStatement pStmt = null;
		//Longin_user_dto login_User = null;
		ResultSet rs = null;
		Longin_user_dto loginUser = null;
		String sql_code =  new StringBuilder("SELECT id,name,mail,pass, profile")
			.append(" FROM user_data")
			.append(" WHERE mail = ? AND pass = ?;")
			.toString();
		try {
			pStmt = conn.prepareStatement(sql_code);
			pStmt.setString(1,mail);
			pStmt.setString(2, pass);
			rs = pStmt.executeQuery();
			//System.out.print("aaaa"+rs);
			if (rs.next()) {
				int id = rs.getInt("id");
				String mail_1 = rs.getString("mail");
				String pass_1 = rs.getString("pass");
				String name_1 = rs.getString("name");
				String profile_1 = rs.getString("profile");
				loginUser = new Longin_user_dto(id,mail_1,name_1,pass_1,profile_1);
				System.out.println("LOGIN"+loginUser);
			}
		}catch(SQLException e){
			System.out.print(e.getMessage());
		}finally{
			this.close(rs);
			this.close(pStmt);
			this.close(conn);
		}
		return loginUser;
	}
}
