package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DangnhapDao;
import entity.User;
import implement.DangnhapDaoImpl;

/**
 * Servlet implementation class Loginpage
 */
@WebServlet("/loginbao")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DangnhapDao dn=new DangnhapDaoImpl();
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
		//request.getRequestDispatcher("/Account/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

		String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = dn.login(username, password);

        if (user != null) {
            // Lưu user vào session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Phân quyền dựa theo RoleId
            switch (user.getRoleId()) {
                case "R001": // Admin
                    response.sendRedirect(request.getContextPath() +"/Home.jsp");
                    break;
                case "R002":
                	response.sendRedirect(request.getContextPath() +"/editor.jsp");
                break;
                case "R003": // Reporter
                    response.sendRedirect(request.getContextPath() +"/PhongvienPage.jsp");
                    break;
                case "R004": // Reader
                    response.sendRedirect(request.getContextPath() +"/Reader.jsp");
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/Account/login.jsp?error=role");
                    break;
            }
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            request.getRequestDispatcher("/Account/login.jsp").forward(request, response);
        }
    }
}

