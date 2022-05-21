package dto;
import java.time.LocalDateTime;
public class Tweet_data_dto {
	private String tweet_text;
	private String tweet_user;
	private LocalDateTime create_time;
	private int user_id;
	private int tweet_id;
	private int tweet_like;
	public String get_tweet_text() {
		return tweet_text;
	}
	public void set_tweet_text(String tweet_text) {
		this.tweet_text = tweet_text;
	}
	public String get_tweet_user() {
		return tweet_user;
	}
	public void set_tweet_user(String tweet_user) {
		this.tweet_user = tweet_user;
	}
	public LocalDateTime get_create_time() {
		return create_time;
	}
	public void set_create_time(LocalDateTime create_time) {
		this.create_time = create_time;
	}
	public int get_user_id() {
		return user_id;
	}
	public void set_user_id(int user_id) {
		this.user_id = user_id;
	}
	public int get_tweet_id() {
		return tweet_id;
	}
	public void set_tweet_id(int tweet_id) {
		this.tweet_id = tweet_id;
	}
	public int get_tweet_like() {
		return tweet_like;
	}
	public void set_tweet_like(int tweet_like) {
		this.tweet_like = tweet_like;
	}
	public Tweet_data_dto(String tweet_text,String tweet_user,LocalDateTime create_time,int user_id,int tweet_id,int tweet_like) {
		this.tweet_text = tweet_text;
		this.tweet_user = tweet_user;
		this.create_time = create_time;
		this.user_id = user_id;
		this.tweet_id = tweet_id;
		this.tweet_like = tweet_like;
	}
}
