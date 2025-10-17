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
import java.util.List;

import entity.News;
import implement.TinTucDaoImpl;

/**
 * Servlet implementation class TinTucControl
 */
@WebServlet("/tin-tuc")
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 1,
			maxFileSize = 1024 * 1021 * 10,
			maxRequestSize =	1024 * 1024 * 80,
			location = "F:/uploadTemp")
public class TinTucControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TinTucDaoImpl newsDao = new TinTucDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinTucControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<News> newsList = newsDao.findAll();
		request.setAttribute("newsList", newsList);
		
		request.getRequestDispatcher("/AdminManger/Tintuc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String image = null;
		Part part = request.getPart("image");
		if(part!=null) {
			String fileName = part.getSubmittedFileName();	
			if (fileName != null && !fileName.isEmpty()) {
			    String uploadPath = getServletContext().getRealPath("/upload");
			    File uploadDir = new File(uploadPath);
			    if (!uploadDir.exists()) uploadDir.mkdir();
			    part.write(uploadPath + File.separator + fileName);
			    image = fileName;
			}
		}
		
		boolean isActive = request.getParameter("isActive") != null;
		String categoryId = request.getParameter("categoryId");
		String userId = request.getParameter("userId");
		
		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		news.setImage(image);
		news.setPublishedDate(new Timestamp(System.currentTimeMillis()));
		news.setActive(isActive);
		news.setCategoryId(categoryId);
		news.setUserId(userId);
		news.setViewCount(0);
		news.setFavoriteCount(0);
		
		String action = request.getParameter("action");
		switch (action) {
		    case "edit":
		        News editedNews = newsDao.findById(id);
		        request.setAttribute("editedNews", editedNews);
		        
		        List<News> newsList = newsDao.findAll();
				request.setAttribute("newsList", newsList);
		        
				request.getRequestDispatcher("/AdminManger/Tintuc.jsp").forward(request, response);
		        return;
		        
		    case "create":
		        newsDao.insert(news);
		        break;
		        
		    case "delete":
		        newsDao.delete(id);
		        break;
		        
		    case "update":
			    	if (image == null || image.isEmpty()) {
			            News oldNews = newsDao.findById(id);
			            news.setImage(oldNews.getImage());
			        }
		        newsDao.update(news);
		        break;
			        
		    default:
		        
		        break;
		}
		
		response.sendRedirect(request.getContextPath() + "/tin-tuc");
	}

}
