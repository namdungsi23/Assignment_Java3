package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import implement.TrangchuDaoImpl;
import dao.TrangchuDao;
import entity.News;

/**
 * Servlet implementation class UserControl
 */
@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrangchuDao dao = new TrangchuDaoImpl(); 

    public UserControl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        if (page == null) page = "home";

        String file;
        switch (page) {
            case "home":
                if (id != null && "detail".equals(action)) {
                    News news = dao.findById(id);
                    if (news != null) {
                        dao.updateViewCount(id); 
                        request.setAttribute("news", news);
                    } else {
                        System.out.println("Không tìm thấy tin tức với id = " + id);
                    }
                    file = "/manager/Home.jsp"; 
                } else {
                    file = "/home-control"; 
                    System.out.println("Đang chuyển hướng tới /home-control");
                }
                break;
            case "vanhoa":
                List<News> newsListVanhoa = dao.findNewsByCategory("CAT04");
                if (newsListVanhoa == null) {
                    newsListVanhoa = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListVanhoa);
                file = "/manager/Vanhoa.jsp";
                break;
            case "thethao":
                List<News> newsListThethao = dao.findNewsByCategory("CAT03");
                if (newsListThethao == null) {
                    newsListThethao = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListThethao);
                file = "/manager/Thethao.jsp";
                break;
            case "suckhoe":
                List<News> newsListSuckhoe = dao.findNewsByCategory("CAT06");
                if (newsListSuckhoe == null) {
                    newsListSuckhoe = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListSuckhoe);
                file = "/manager/Suckhoe.jsp";
                break;
            case "chinhtri":
                List<News> newsListChinhtri = dao.findNewsByCategory("CAT01");
                if (newsListChinhtri == null) {
                    newsListChinhtri = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListChinhtri);
                file = "/manager/Chinhtri.jsp";
                break;
            case "dulich":
                List<News> newsListDulich = dao.findNewsByCategory("CAT04");
                if (newsListDulich == null) {
                    newsListDulich = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListDulich);
                file = "/manager/Dulich.jsp";
                break;
            case "doisong":
                List<News> newsListDoisong = dao.findNewsByCategory("CAT05");
                if (newsListDoisong == null) {
                    newsListDoisong = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListDoisong);
                file = "/manager/Doisong.jsp";
                break;
            case "giaoduc":
                List<News> newsListGiaoduc = dao.findNewsByCategory("CAT07");
                if (newsListGiaoduc == null) {
                    newsListGiaoduc = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListGiaoduc);
                file = "/manager/Giaoduc.jsp";
                break;
            case "congnghe":
                List<News> newsListCongnghe = dao.findNewsByCategory("CAT08");
                if (newsListCongnghe == null) {
                    newsListCongnghe = new ArrayList<>(); 
                }
                request.setAttribute("newsList", newsListCongnghe);
                file = "/manager/Congnghe.jsp";
                break;
            default:
            		file = "/home-control";
        }

        request.setAttribute("contentPage", file);
        request.getRequestDispatcher("/manager/Reader.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
