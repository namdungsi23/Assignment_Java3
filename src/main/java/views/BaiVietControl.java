package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entity.News;
import entity.User;
import implement.TinTucDaoImpl;

/**
 * Servlet implementation class BaiVietControl
 */
@WebServlet("/bai-viet")
public class BaiVietControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TinTucDaoImpl newsDao = new TinTucDaoImpl();
	User user;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaiVietControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user = (User) request.getSession().getAttribute("user");
		List<News> newsList = newsDao.findByReporterId(user.getId());
		request.setAttribute("newsList", newsList);
		
		request.getRequestDispatcher("/Reporter/baiviet.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
