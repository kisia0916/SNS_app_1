package dto;

import java.time.LocalDateTime;

public class Get_like_dto {
	private int id;
	private int user_id;
	private String user_name;
	private LocalDateTime create_time;
	public int get_id() {
		return id;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public int get_user_id() {
		return user_id;
	}
	public void set_user_id(int user_id) {
		this.user_id = user_id;
	}
	public String  get_user_name() {
		return user_name;
	}
	public void set_user_name(String user_name) {
		this.user_name = user_name;
	}
	public LocalDateTime get_create_time() {
		return create_time;
	}
	public void set_id(LocalDateTime create_time) {
		this.create_time = create_time;
	}
	public Get_like_dto(int id,int user_id,String user_name,LocalDateTime create_time) {
		this.id = id;
		this.user_id = user_id;
		this.user_name = user_name;
		this.create_time = create_time;
	}
	
}
