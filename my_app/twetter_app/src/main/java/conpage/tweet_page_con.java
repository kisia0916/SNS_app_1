package conpage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Check_like_dao;
import dao.Run_tweet_dao;
import dao.Set_good_dao;
import dao.Set_like_dao;
import dao.Set_tweet_dao;
import dto.Longin_user_dto;
import dto.Tweet_data_dto;

/**
 * Servlet implementation class tweet_page_con
 */
@WebServlet("/top_mypage/tweet_page")
public class tweet_page_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String tweet_text = null;
    String uset_name = null;
    int user_id;
    String mail_3;
    String pass_3;
    //List<Tweet_data_dto> data_list = new ArrayList<Tweet_data_dto>();
    Longin_user_dto user_index = null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tweet_page_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubi
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Run_tweet_dao runner = new Run_tweet_dao();
		List<Tweet_data_dto> data_list = runner.main_list();
		request.setAttribute("tweet_data", data_list);
		request.setAttribute("list_long",data_list.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_tweet.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean main_true = false;
		request.setCharacterEncoding("UTF-8");
		String like_num = request.getParameter("tweet_like");
		System.out.println(like_num);
		if (like_num == null) {
			request.setCharacterEncoding("UTF-8");
			System.out.println("bububub");//ここ重要
			tweet_text = request.getParameter("tweet_data");
			System.out.println(tweet_text);
			Index_page_class main_class = new Index_page_class();
			user_index = main_class.return_user();
			System.out.println(user_index.get_id());
			Set_tweet_dao main_dao =new Set_tweet_dao();
			main_dao.Set_tweet(user_index.get_name(),user_index.get_id(),tweet_text);
			Run_tweet_dao runner_1 = new Run_tweet_dao();
			List<Tweet_data_dto> data_list_1 = runner_1.main_list();
			request.setAttribute("tweet_data", data_list_1);
			//request.setAttribute("list_long",data_list_1.size());)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_tweet.jsp");
			dispatcher.forward(request, response);
			//doGet(request, response);
		}
		if (like_num != null) {
			Index_page_class main_class = new Index_page_class();
			user_index = main_class.return_user();
			Check_like_dao get_like_class = new Check_like_dao();
			int tweet_id_1 =  Integer.parseInt(request.getParameter("tweet_id"));
			main_true = get_like_class.check_like(user_index.get_id(),tweet_id_1);
			System.out.println(main_true);
			if (main_true) {	
				System.out.println("bububub");
				request.setCharacterEncoding("UTF-8");
				Set_like_dao sub_class = new Set_like_dao();
				sub_class.like_set(tweet_id_1, user_index.get_id());
				//Get_like_dao like_if = new Get_like_dao();
				//List<Get_like_dto> good_list = like_if.get_like(Integer.parseInt(request.getParameter("tweet_id")),user_index.get_id());
				System.out.println("testetetete");
				Run_tweet_dao get_list = new Run_tweet_dao();
				Index_page_class main_class_2 = new Index_page_class();
				user_index = main_class_2.return_user();
				String test_like = request.getParameter("tweet_like_num");
				int test_like_2 = Integer.parseInt(test_like);
				String tweet_user = request.getParameter("tweet_id");
				int tweet_user_1 = Integer.parseInt(tweet_user);
				Set_good_dao set_like = new Set_good_dao();
				System.out.println("1:"+tweet_user_1);
				System.out.println("2:"+test_like_2);
				set_like.main_void(tweet_user_1,test_like_2);
				response.sendRedirect("/twetter_app/top_mypage/tweet_page");
			}
			if (!main_true) {
				response.sendRedirect("/twetter_app/top_mypage/tweet_page");
			}
		}
	}
}
