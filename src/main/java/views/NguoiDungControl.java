package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import entity.User;
import implement.NguoiDungDaoImpl;

/**
 * Servlet implementation class NguoiDungControl
 */
@WebServlet("/nguoi-dung")
public class NguoiDungControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NguoiDungDaoImpl userDao = new NguoiDungDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 List<User> users = userDao.findAll();
        request.setAttribute("users", users);
        
        request.getRequestDispatcher("/AdminManger/Nguoidung.jsp").include(request, response);	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String passwordHash = request.getParameter("passwordHash");
        String roleId = request.getParameter("roleId");
        boolean isActive = request.getParameter("isActive") != null; 

        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setFullName(fullName);
        user.setEmail(email);
        if (passwordHash != null && !passwordHash.isEmpty()) {
            user.setPasswordHash(passwordHash);
        }   
        user.setRoleId(roleId);
        user.setActive(isActive);
		
		String action = request.getParameter("action");
        if ("delete".equals(action)) {
            String enitytyId = request.getParameter("id");
            userDao.delete(enitytyId);
        } else if ("create".equals(action)) {
            userDao.insert(user);

        } else if ("update".equals(action)) {
            userDao.update(user);
        }else if("edit".equals(action)) {
        		User editedUser = userDao.findById(id);
        		request.setAttribute("editedUser", editedUser);
        		
        		List<User> users = userDao.findAll();
            request.setAttribute("users", users);
                
            request.setAttribute("contentPage", "/AdminManger/Nguoidung.jsp");
			request.getRequestDispatcher("/AdminManger/Home.jsp").forward(request, response);
	        return; 
        }
        
        response.sendRedirect(request.getContextPath() + "/nguoi-dung");
	}

}
