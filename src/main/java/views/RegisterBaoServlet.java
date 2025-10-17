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

@WebServlet("/registerbao")
public class RegisterBaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

  
        Cookie cUser = new Cookie("username", username);
        Cookie cPass = new Cookie("password", password);
        cUser.setMaxAge(24 * 60 * 60); 
        cPass.setMaxAge(24 * 60 * 60);
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
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Account/register.jsp");
    }
}
