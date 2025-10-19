package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletContext;
import java.io.IOException;

import entity.User;
import implement.NguoiDungDaoImpl;

@WebServlet("/registerbao")
public class RegisterBaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    NguoiDungDaoImpl userDao = new NguoiDungDaoImpl();
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        
        //Checking password matching
        if(password.equals(confirmPassword)) {
        	// Adding readers to database
            User reader = new User();
            reader.setFullName(fullname);
            reader.setUserName(username);
            reader.setPasswordHash(password);
            reader.setEmail(email);
            reader.setActive(true);
            reader.setRoleId(User.ROLE_READER);
            //Set Id
            User lastReader = userDao.findLastReader();
            if(lastReader != null) {
            	char firstChar = lastReader.getId().charAt(0);
            	String prevIndex = lastReader.getId().substring(1,lastReader.getId().length()); 
            	int currentIndexInt = Integer.parseInt(prevIndex.trim()) + 1;
                reader.setId(String.valueOf(firstChar) + String.format("%03d",currentIndexInt));
            }
            
            int result = userDao.insert(reader);
            if(result == 0 ) {   //Insert Failed 
            		request.setAttribute("error", "Trùng dữ liệu, vui lòng thử lại!");
            		request.getRequestDispatcher("Account/register.jsp").forward(request, response);
            		return;
            }
            	
            Cookie cUser = new Cookie("username", username);
            Cookie cPass = new Cookie("password", password);
            cUser.setMaxAge(30 * 24 * 60 * 60); 
            cPass.setMaxAge(30 * 24 * 60 * 60);
            cUser.setPath("/"); 
            cPass.setPath("/");
            response.addCookie(cUser);
            response.addCookie(cPass);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
           
            ServletContext application = getServletContext();
            application.setAttribute("username", username);
            application.setAttribute("password", password);

            response.sendRedirect("Account/login.jsp");
        }else {
        		request.setAttribute("error", "Password không trùng khớp, vui lòng thử lại!");
        		request.getRequestDispatcher("Account/register.jsp").forward(request, response);
        }
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Account/register.jsp");
    }
}
