package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DangnhapDao;
import entity.User;
import implement.DangnhapDaoImpl;

/**
 * Servlet implementation class LoginReaderControl
 */
@WebServlet("/login-reader")
public class LoginReaderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DangnhapDao dn=new DangnhapDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginReaderControl() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
		
		User reader = dn.loginReader(username, password);
		if(reader != null) {
			request.getSession().setAttribute("login", true);
			request.getSession().setAttribute("role", "reader");
			request.getSession().setAttribute("user", reader);
    			request.getRequestDispatcher("/UserControl").forward(request, response);
    			return;
		}
		request.getRequestDispatcher("/Account/login.jsp").forward(request, response);
	}
}


