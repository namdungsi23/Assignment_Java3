package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Categories;
import entity.News;
import entity.User;
import implement.LoaiTinDaoImpl;
import implement.TinTucDaoImpl;

/**
 * Servlet implementation class DangTinControl
 */
@WebServlet("/dang-tin")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
				maxFileSize = 1024 * 1024 * 8,
				maxRequestSize = 1024 * 1024* 30,
				location = "F:/uploadTemp")
public class DangTinControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoaiTinDaoImpl catDao = new LoaiTinDaoImpl();
	TinTucDaoImpl newsDao = new TinTucDaoImpl();
    List<Categories> catList = new ArrayList<>();
    User user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangTinControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		catList = catDao.findAll();
		request.setAttribute("catList", catList);
		
	    request.getRequestDispatcher("/Reporter/Dangtin.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("image");
		String fileName = part.getSubmittedFileName();
		String uploadPath = getServletContext().getRealPath("/upload");
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) uploadDir.mkdir();
		part.write(uploadDir + File.separator + fileName);
		
	    News news = new News();
		news.setId(request.getParameter("id"));
		news.setTitle(request.getParameter("title"));
		news.setContent(request.getParameter("content"));
		news.setImage(fileName);
		news.setActive(true);
		news.setFavoriteCount(0);
		news.setViewCount(0);
		news.setPublishedDate(new Timestamp(System.currentTimeMillis()));
		//Set User Id
		user = (User)request.getSession().getAttribute("user");
		news.setUserId(user.getId());
		//Set Category
		String category = request.getParameter("category");
		Categories cat = catDao.findByCatName(category);
		if(cat!=null) news.setCategoryId(cat.getId());
		else System.out.println("Không tìm thấy mã loại!");
		
		newsDao.insert(news);
		response.sendRedirect("/dang-tin");
	}

}
