package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import implement.TrangchuDaoImpl;
import dao.TrangchuDao;
import entity.News;

/**
 * Servlet implementation class VanHoaControl
 */
@WebServlet("/van-hoa")
public class VanHoaControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TrangchuDao dao = new TrangchuDaoImpl();

    public VanHoaControl() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> newsList = dao.findNewsByCategory("CAT04");
        request.setAttribute("newsList", newsList);
        request.getRequestDispatcher("/manager/Vanhoa.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
