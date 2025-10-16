package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import implement.TrangchuDaoImpl;
import dao.TrangchuDao;
import entity.News;
/**
 * Servlet implementation class UserControl
 */
@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TrangchuDao dao = new TrangchuDaoImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControl() {
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
	        		case "home": file = "/home-control"; break;
	            case "vanhoa":  file = "/van-hoa"; break;
	            case "thethao": file = "/the-thao"; break;
	            case "suckhoe": file = "/suc-khoe"; break;
	            case "chinhtri":file = "/chinh-tri"; break;
	            case "dulich":  file = "/du-lich"; break;
	            case "doisong":  file = "/doi-song"; break;
	            case "giaoduc":  file = "/giao-duc"; break;
	            case "congnghe":  file = "/cong-nghe"; break;
	            default:        file = "/home-control";
	        }

	        // Gửi tên file sang JSP chính
	        request.setAttribute("contentPage", file);
	        request.getRequestDispatcher("/manager/Reader.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
