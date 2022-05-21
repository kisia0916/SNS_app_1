package conpage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Set_room_tweet_dao;
import dto.Longin_user_dto;
import dto.Room_id_dto;

/**
 * Servlet implementation class room_tweet_com
 */
@WebServlet("/room_add/message_room")
public class Room_tweet_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Room_id_dto get_class;
	String rooom_id_1;
	int rooom_id_2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Room_tweet_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tweet_room.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String rooom_id = request.getParameter("room_id");
		System.out.println("$$$$"+rooom_id);
		System.out.println("docker");
		String text_3 = request.getParameter("tweet_text");
		System.out.println(text_3);
		//String room_id_text = get_class.room_id_4;
		Longin_user_dto user_index = null;
		Index_page_class main_class = new Index_page_class();
		user_index = main_class.return_user();
		int user_id = user_index.get_id();
		String user_name = user_index.get_name();
		Set_room_tweet_dao main_class_3 = new Set_room_tweet_dao();
		if (rooom_id != null) {
			System.out.println("uuuuu");
			get_class = new Room_id_dto(rooom_id);
			System.out.println(get_class.get_room_id());
		}else if(rooom_id == null & get_class.get_room_id() != null) {
			System.out.println("aaaa"+get_class.get_room_id());////取得成功
			rooom_id_1 = get_class.get_room_id();
			rooom_id_2 = Integer.parseInt(rooom_id_1);
			main_class_3.set_tweet(rooom_id_2, user_id, user_name, text_3);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tweet_room.jsp");
		dispatcher.forward(request, response);
	}

}
