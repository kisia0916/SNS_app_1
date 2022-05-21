package dto;

import java.time.LocalDateTime;

public class Get_room_dto {
	private int id;
	private int create_user_id;
	private String room_name;
	private String room_profile;
	private LocalDateTime create_time;
	public int get_id() {
		return id;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public int get_create_user_id() {
		return create_user_id;
	}
	public void set_create_user_id(int create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String get_room_profile() {
		return room_profile;
	}
	public void set_room_profile(String room_profile) {
		this.room_profile = room_profile;
	}
	public String get_room_name() {
		return room_name;
	}
	public void set_room_name(String room_name) {
		this.room_name = room_name;
	}
	public LocalDateTime get_create_time() {
		return create_time;
	}
	public void set_create_time(LocalDateTime create_time) {
		this.create_time = create_time;
	}
	public Get_room_dto(int id,int create_user_id,String room_name,String room_profile,LocalDateTime create_time) {
		this.id = id;
		this.create_user_id = create_user_id;
		this.room_name = room_name;
		this.room_profile = room_profile;
		this.create_time = create_time;
	}
}
