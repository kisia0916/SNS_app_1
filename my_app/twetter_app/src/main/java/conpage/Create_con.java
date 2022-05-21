package conpage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Create_user_dao;

/**
 * Servlet implementation class Create_con
 */
@WebServlet("/top_create")
public class Create_con extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String new_name;
	public static String new_pass;
	public static String new_mail;
	public static String new_profile;
	public static String[] user_list =new String[4];
	static String test_bool = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_con() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_create.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		new_mail = request.getParameter("create_mail");
		new_pass = request.getParameter("create_pass");
		new_profile = request.getParameter("create_profile");
		new_name = request.getParameter("create_name");
		System.out.println("unnko:"+new_name);
		user_list[0] = new_name;
		user_list[1] = new_pass;
		user_list[2] = new_mail;
		user_list[3] = new_profile;
		Create_user_dao create_class = new Create_user_dao();
		test_bool = create_class.create_user_class();
		if (test_bool == "yes") {
			//response.sendRedirect("/tweet_servlet/");
			System.out.println("seikou!!!!!");
			response.sendRedirect("/twetter_app/top_login");
		}else {
			//response.sendRedirect("");
			System.out.println("siltupai");
			response.sendRedirect("/twetter_app/top_create");
		}
	}
	public String[] return_user() {
		System.out.println(user_list);
		return user_list;
	}

}
