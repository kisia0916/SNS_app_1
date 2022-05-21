package conpage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Get_room_dao;
import dto.Get_room_dto;

/**
 * Servlet implementation class Room_add
 */
@WebServlet("/room_add")
public class Room_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String room_id_4;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Room_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Get_room_dao main_class = new Get_room_dao();
		List<Get_room_dto> room_list = main_class.get_room_list();
		request.setAttribute("room_list",room_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room_list.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("room_id"+request.getParameter("room_id"));
		HttpSession session = request.getSession();
		room_id_4 = request.getParameter("room_id");
		int room_id_5 = Integer.parseInt(room_id_4);
		if (request.getParameter("room_id") != null) {
			response.sendRedirect("/twetter_app/room_add/message_room");
		}
	}
	public String get_room_id() {
		System.out.println(room_id_4);
		return room_id_4;
	}

}
