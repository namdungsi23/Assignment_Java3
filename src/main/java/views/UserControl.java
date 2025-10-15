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
	            case "vanhoa":  file = "Vanhoa.jsp"; break;
	            case "thethao": file = "Thethao.jsp"; break;
	            case "suckhoe": file = "Suckhoe.jsp"; break;
	            case "chinhtri":file = "Chinhtri.jsp"; break;
	            case "dulich":  file = "Dulich.jsp"; break;
	            case "doisong":  file = "DoiSong.jsp"; break;
	            case "giaoduc":  file = "Giaoduc.jsp"; break;
	            case "congnghe":  file = "Congnghe.jsp"; break;
	            default:        file = "Home.jsp";
	        }

	        // Gửi tên file sang JSP chính
	        request.setAttribute("contentPage", file);
	        request.getRequestDispatcher("/manager/Reader.jsp").forward(request, response);
	       //xuất dữ liệu từ database lên
	        List<News> list = dao.findHomeNews();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
