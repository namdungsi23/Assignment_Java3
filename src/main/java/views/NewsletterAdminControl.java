package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.Mailer;

import java.io.IOException;
import java.util.List;

import entity.News;
import entity.User;
import implement.NguoiDungDaoImpl;
import implement.TinTucDaoImpl;

/**
 * Servlet implementation class NewsletterAdminControl
 */
@WebServlet("/newsletter-admin")
public class NewsletterAdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NguoiDungDaoImpl userDao =new NguoiDungDaoImpl();
	TinTucDaoImpl newsDao = new TinTucDaoImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsletterAdminControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> newsletterList = userDao.findAllNewsleter();
		List<News> newsList = newsDao.findAll();
		request.setAttribute("newsList", newsList);
		request.setAttribute("newsletterList", newsletterList);
		
		request.getRequestDispatcher("/AdminManger/Newsletter.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    String action = request.getParameter("action");
	    HttpSession session = request.getSession(false);

	    try {
	        switch (action) {

	            case "selectNews": {
	                String title = request.getParameter("title");
	                String content = request.getParameter("content");

	                // Lưu tin được chọn vào session
	                session.setAttribute("selectedTitle", title);
	                session.setAttribute("selectedContent", content);

	                System.out.println("Tin đã chọn: " + title);
	                request.setAttribute("message", "Đã chọn tin: " + title);
	                response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                break;
	            }

	            case "send": {
	                String email = request.getParameter("email");
	                String selectedTitle = (String) session.getAttribute("selectedTitle");
	                String selectedContent = (String) session.getAttribute("selectedContent");

	                if (selectedTitle == null || selectedContent == null) {
	                    request.setAttribute("error", "Chưa chọn tin tức để gửi!");
	                    response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                    return;
	                }

	                boolean sent = Mailer.sendMail("gaudomun@gmail.com", email, selectedTitle, selectedContent, null);

	                if (sent) {
	                    request.setAttribute("message", "Đã gửi newsletter đến " + email);
	                    System.out.println("Đã gửi email '" + selectedTitle + "' đến: " + email);
	                } else {
	                    request.setAttribute("error", "Gửi mail thất bại đến " + email);
	                }

	                response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                break;
	            }
	            
	            case "sendAll": {
	                String selectedTitle = (String) session.getAttribute("selectedTitle");
	                String selectedContent = (String) session.getAttribute("selectedContent");

	                if (selectedTitle == null || selectedContent == null) {
	                    session.setAttribute("error", "Chưa chọn tin tức để gửi!");
	                    response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                    return;
	                }

	                List<User> list = userDao.findAllNewsleter();
	                int successCount = 0;

	                for (User u : list) {
	                    if (Mailer.sendMail("gaudomun@gmail.com", u.getEmail(), selectedTitle, selectedContent, null)) {
	                        successCount++;
	                    }
	                }

	                session.setAttribute("message", "Đã gửi thành công newsletter đến " + successCount + " người dùng.");
	                response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                break;
	            }

	            default: {
	                System.out.println("Action không hợp lệ: " + action);
	                request.setAttribute("error", "Hành động không hợp lệ!");
	                response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	                break;
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Lỗi xử lý: " + e.getMessage());
	        response.sendRedirect(request.getContextPath() + "/AdminControl?page=Newsletter");
	    }
	}

}
