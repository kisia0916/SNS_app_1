package conpage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Longin_user_dto;
import selever.Run_login_class;
/**
 * Servlet implementation class Index_page_class
 */
@WebServlet("/top_login")
public class Index_page_class extends HttpServlet {
	String mail_2 = null;
	String pass_2 = null;
	static Longin_user_dto login_1 = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_page_class() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("index");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/top_1.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubcdc
		//doGet(request, response);
		mail_2 = request.getParameter("mail");
		pass_2 = request.getParameter("pass");
		System.out.println(mail_2);
		System.out.println(pass_2);
		Run_login_class main_class = new Run_login_class();
		login_1 = main_class.run_dao(mail_2,pass_2);
		
		if (login_1 != null) {
			System.out.println("goodt");
			System.out.println(login_1.get_profile());
			response.sendRedirect("/twetter_app/top_mypage");
		}else {
			System.out.println("test unnko");
			response.sendRedirect("/twetter_app/top_login_no");
		}
	}
	public Longin_user_dto return_user() {
		return login_1;
	}
	public String return_mail() {
		return mail_2;
	}
	public String return_pass() {
		return pass_2;
	}
}
