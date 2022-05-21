package selever;

import java.util.List;

import dao.Get_mytweet_dao;
import dto.Mytweet_dto;
public class Run_my_tweet {
	public List<Mytweet_dto> main_void(int id_1) {
		Get_mytweet_dao main_class = new Get_mytweet_dao();
		List<Mytweet_dto> tweet_list= main_class.get_mytweet(id_1);
		return tweet_list;
	}
}
