package selever;

import dao.Login_user_dao;
import dto.Longin_user_dto;

public class Run_login_class {
	public Longin_user_dto run_dao(String mail,String pass) {
		Login_user_dao main_class = new Login_user_dao();
		Longin_user_dto loginUser_1 = main_class.get_db_data(mail,pass);
		return loginUser_1;
	}
}
