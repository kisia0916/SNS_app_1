package dto;

public class Room_id_dto {
	private String room_id = null;
	public String get_room_id() {
		return room_id;
	}
	public void set_room_id(String id) {
		this.room_id = id;
	}
	public Room_id_dto(String id) {
		this.room_id = id;
	}
}
