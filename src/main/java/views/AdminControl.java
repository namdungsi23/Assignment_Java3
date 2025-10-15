package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		 String page = request.getParameter("page");
	        if (page == null) page = "home";

	        String file;
	        switch (page) {
	            case "tintuc":
	                file = "Tintuc.jsp";
	                break;
	            case "Loaitin":
	                file = "Loaitin.jsp";
	                break;
	            case "nguoidung":
	                file = "Nguoidung.jsp";
	                break;
	            case "Newsletter":
	                file = "Newsletter.jsp";
	                break;
	            default:
	                file = "Dashboard.jsp"; // 👉 đổi tên khác thay vì Home.jsp để tránh vòng lặp
	        }

	       
	        request.setAttribute("contentPage", file);
	        request.getRequestDispatcher("/AdminManger/Home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
