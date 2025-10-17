package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entity.Categories;
import entity.User;
import implement.LoaiTinDaoImpl;

/**
 * Servlet implementation class LoaiTinControl
 */
@WebServlet("/loai-tin")
public class LoaiTinControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoaiTinDaoImpl catDao = new LoaiTinDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiTinControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Categories> catList = catDao.findAll();
        request.setAttribute("categories", catList);
        
        request.getRequestDispatcher("/AdminManger/Loaitin.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("userName");
        String alias = request.getParameter("alias");
        boolean isActive = request.getParameter("isActive") != null; 

        Categories cat = new Categories();
        cat.setId(id);
        cat.setName(name);
        cat.setAlias(alias);
        cat.setFavoriteCount(0);
        cat.setViewCount(0);
        cat.setActive(isActive);
		
		String action = request.getParameter("action");
        if ("delete".equals(action)) {
            catDao.delete(id);
        } else if ("create".equals(action)) {
            catDao.insert(cat);

        } else if ("update".equals(action)) {
            catDao.update(cat);
        }else if("edit".equals(action)) {
        		Categories editedCat = catDao.findById(id);
        		request.setAttribute("editedCat", editedCat);
        		
        		List<Categories> catList = catDao.findAll();
            request.setAttribute("categories", catList);
                
        		request.getRequestDispatcher("/AdminManger/Loaitin.jsp").forward(request, response);
    		    return; 
        }
        
        response.sendRedirect(request.getContextPath() + "/nguoi-dung");
	}

}
