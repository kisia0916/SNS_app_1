package dao;

import java.util.List;

import dto.Tweet_data_dto;

public class Run_tweet_dao {
	public List<Tweet_data_dto> main_list(){
		Get_tweet_dao main_class = new Get_tweet_dao();
		List<Tweet_data_dto>data_list = main_class.get_tweet();
		return data_list;
	}
}
