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
 * Servlet implementation class reporterControl
 */
@WebServlet("/phongvien")
public class reporterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reporterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null) {
			if(User.ROLE_REPORTER.equals(user.getRoleId().trim())) {
				String page = request.getParameter("page");
		        if (page == null) page = "home";

		        String file;
		        switch (page) {
		        		case "home": 
		        			file="/thong-tin";
		        			break;
		        			
		            case "Thongtin":
		                file = "/thong-tin";
		                break;
		            case "Baiviet":
		                file = "/bai-viet";
		                break;
		            case "Dangtin":
		                file = "/dang-tin";
		                break;
		            case "Thongke":
		                file = "/thong-ke";
		                break;
		            default:
		                file = "/thong-tin"; 
		        }

		       
		        request.setAttribute("contentPage", file);
		        request.getRequestDispatcher("/Reporter/PhongvienPage.jsp").forward(request, response);
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
