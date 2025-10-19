package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.TrangchuDao;
import entity.News;
import implement.TrangchuDaoImpl;

/**
 * Servlet implementation class HomePageControl
 */
@WebServlet("/home-control")
public class HomePageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrangchuDaoImpl homeDao = new TrangchuDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageControl() {
        super();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String latest = request.getParameter("latest");
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		if("true".equals(latest)) {
			 List<News> newsList = homeDao.findLatestNews();
			 News news = newsList.get(0); 
			 request.setAttribute("news", news);
			 
			 if(id != null && action != null) {
		            int index = -1;
		            for(int i=0; i<newsList.size(); i++) {
		                if(newsList.get(i).getId().equals(id)) {
		                    index = i;
		                    break;
		                }
		            }
		            
		            if("prev".equals(action) && index > 0) news = newsList.get(index - 1);
		            else if("next".equals(action) && index < newsList.size() - 1) news = newsList.get(index + 1);
		            else news = newsList.get(index);
	        } else {
	            news = newsList.get(0); 
	        }
	    }else {
		    	if(id!=null) {

					News[] newsArr = homeDao.findPrevNext(id);
					News prev = newsArr[0];
					News next = newsArr[1];
					
					if("prev".equals(action)) request.setAttribute("news", prev);
					else if("next".equals(action)) request.setAttribute("news", next);
			}else {
				News news = homeDao.findFirst();
				System.out.println(news.getId());
				request.setAttribute("news", news);
			}
	    }
		
		request.getRequestDispatcher("/manager/Home.jsp").include(request, response);
	} */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String latest = request.getParameter("latest");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        News news = null;
        List<News> newsList = homeDao.findHomeNews(); // Lấy danh sách tin tổng hợp


        if ("true".equals(latest)) {
            List<News> latestNewsList = homeDao.findLatestNews();
            if (latestNewsList != null && !latestNewsList.isEmpty()) {
                news = latestNewsList.get(0);
                request.setAttribute("news", news);

                if (id != null && action != null) {
                    int index = -1;
                    for (int i = 0; i < latestNewsList.size(); i++) {
                        if (latestNewsList.get(i).getId().equals(id)) {
                            index = i;
                            break;
                        }
                    }
                    if ("prev".equals(action) && index > 0) news = latestNewsList.get(index - 1);
                    else if ("next".equals(action) && index < latestNewsList.size() - 1) news = latestNewsList.get(index + 1);
                    else if (index >= 0) news = latestNewsList.get(index);
                    request.setAttribute("news", news);
                }
            } else {
                System.out.println("Danh sách tin tức mới nhất trả về rỗng hoặc null");
            }
        } 
        
         if(id != null) {
            News[] newsArr = homeDao.findPrevNext(id);
            if (newsArr != null && newsArr.length > 0) {
                if ("prev".equals(action)) news = newsArr[0];
                else if ("next".equals(action)) news = newsArr[1];
            }
            request.setAttribute("news", news);
        } else {
            news = homeDao.findFirst();
            if (news != null) {
                System.out.println("Hình ảnh tin đầu tiên: " + news.getImage());
            } else {
                System.out.println("Tin đầu tiên trả về null");
            }
            request.setAttribute("news", news);
        }


        // Truyền danh sách tin tổng hợp
        if (newsList != null) {
            request.setAttribute("newsList", newsList);
        } else {
            System.out.println("Danh sách tin tổng hợp trả về null");
        }

        request.setAttribute("contentPage", "/manager/Home.jsp");
        request.getRequestDispatcher("/manager/Home.jsp").include(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
