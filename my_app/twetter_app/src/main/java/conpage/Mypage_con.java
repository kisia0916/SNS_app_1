package conpage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Delete_tweet;
import dto.Longin_user_dto;
import dto.Mytweet_dto;
import selever.Run_my_tweet;
/**
 * Servlet implementation class Mypage_con
 */
@WebServlet("/top_mypage")
public class Mypage_con extends HttpServlet {
	Longin_user_dto user_index = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Index_page_class main_class = new Index_page_class();
		user_index = main_class.return_user();
		request.setAttribute("name",user_index.get_name());
		request.setAttribute("profile",user_index.get_profile());
		Run_my_tweet get_tweet = new Run_my_tweet();
		System.out.println(user_index.get_id());
		List<Mytweet_dto>get_list = get_tweet.main_void(user_index.get_id());
		request.setAttribute("tweet_list",get_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int bool_num = 0;
		Index_page_class main_class = new Index_page_class();
		user_index = main_class.return_user();
		request.setAttribute("name",user_index.get_name());
		request.setAttribute("profile",user_index.get_profile());
		Run_my_tweet get_tweet = new Run_my_tweet();
		System.out.println(user_index.get_id());
		List<Mytweet_dto>get_list = get_tweet.main_void(user_index.get_id());
		request.setAttribute("tweet_list",get_list);
		if (request.getParameter("tweet_id") != null) {
			Delete_tweet delete_class = new Delete_tweet();
			String tweet_id_get = request.getParameter("tweet_id");
			int num = Integer.parseInt(tweet_id_get);
			delete_class.delete_mess(num);
			System.out.println("delete");
			bool_num = 1;
			response.sendRedirect("/twetter_app/top_mypage");
		}
		if (bool_num != 1) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_mypage.jsp");
		dispatcher.forward(request, response);
		}
	}

}
