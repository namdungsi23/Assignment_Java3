package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entity.User;
import implement.NguoiDungDaoImpl;

/**
 * Servlet implementation class NewsletterControl
 */
@WebServlet("/newsletter")
public class NewsletterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NguoiDungDaoImpl userDao = new NguoiDungDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsletterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		System.out.println(email);
		User u = (User)request.getSession().getAttribute("user");
		String id = u.getId();
		System.out.println(id);
		
		userDao.updateNewsletter(id);
		
		request.getRequestDispatcher("/UserControl").forward(request, response);
	}

}
