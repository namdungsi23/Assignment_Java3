package dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entity.User;

/**
 * Servlet implementation class DangnhapDao
 */
public interface DangnhapDao  {
	  User login(String username, String password);
	  
}
