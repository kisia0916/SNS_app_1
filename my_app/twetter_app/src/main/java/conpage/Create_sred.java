package conpage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Create_RoomTable_dao;
import dto.Longin_user_dto;

/**
 * Servlet implementation class Create_sred
 */
@WebServlet("/create_room")
public class Create_sred extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_sred() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room_create_page.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Create_RoomTable_dao main_class = new Create_RoomTable_dao();
		Index_page_class main_class_1 = new Index_page_class();
		Longin_user_dto user_index = null;
		user_index = main_class_1.return_user();
		main_class.create_table(request.getParameter("room_name"),user_index.get_id(),request.getParameter("room_profile"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/room_create_page.jsp");
		dispatcher.forward(request, response);
	}

}
