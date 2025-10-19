package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import entity.User;

/**
 * Servlet implementation class Home
 */
@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (request.getSession()!= null) ? (User) request.getSession().getAttribute("user") : null;
		System.out.println(user.getUserName());
		
		if(user!=null) {
			System.out.println(user.getFullName());
			if("R001".equals(user.getRoleId().trim())) {
				System.out.println(user.getRoleId());
				String page = request.getParameter("page");
		        if (page == null) page = "home";

		        String file;
		        switch (page) {
		        	   case "Home":
		        		   file="Dashboard.jsp";
		        		   break;
		        		   
		            case "tintuc":
		                file = "/tin-tuc";
		                break;
		            case "Loaitin":
		                file = "/loai-tin";
		                break;
		            case "nguoidung":
		                file = "/nguoi-dung";
		                break;
		            case "Newsletter":
		                file = "/newsletter";
		                break;
		            default:
		                file = "Dashboard.jsp"; 
		        }  
		        
		        request.setAttribute("contentPage", file);
		        request.getRequestDispatcher("/AdminManger/Home.jsp").forward(request, response);
			}
		}
			
	}
				

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
