package dto;

public class Longin_user_dto {
	private int id;
	private String mail;
	private String name;
	private String pass;
	private String profile;
	public int get_id() {
		return id;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public String get_mail() {
		return mail;
	}
	public void set_mail(String mail) {
		this.mail = mail;
	}
	public String get_name() {
		return name;
	}
	public void set_name(String name) {
		this.name = name;
	}
	public String get_pass() {
		return pass;
	}
	public void set_pass(String pass) {
		this.pass = pass;
	}
	public String get_profile() {
		return profile;
	}
	public void set_profile(String profile) {
		this.profile = profile;
	}

	public Longin_user_dto(int id,String mail,String name,String pass,String profile) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.pass = pass;
		this.profile = profile;
	}
}
