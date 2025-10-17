package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Loginpage
 */
@WebServlet("/loginbao")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Account/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String bao = request.getParameter("username");
	    String ha = request.getParameter("password");

	    // Giả sử luôn đăng nhập thành công
	    // ✅ Lưu username vào Cookie (1 ngày)
	    jakarta.servlet.http.Cookie userCookie = new jakarta.servlet.http.Cookie("username", bao);
	    userCookie.setMaxAge(24 * 60 * 60); // 1 ngày
	    response.addCookie(userCookie);

	    // ✅ Chuyển đến trang Home
	    response.sendRedirect(request.getContextPath() + "/AdminManger/Home.jsp");
	}
}

