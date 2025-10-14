package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class reporterControl
 */
@WebServlet("/phongvien")
public class reporterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reporterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
        if (page == null) page = "home";

        String file;
        switch (page) {
            case "Thongtin":
                file = "Thongtin.jsp";
                break;
            case "Baiviet":
                file = "baiviet.jsp";
                break;
            case "Dangtin":
                file = "Dangtin.jsp";
                break;
            case "Thongke":
                file = "Thongke.jsp";
                break;
            default:
                file = "Thongtin.jsp"; // 👉 đổi tên khác thay vì Home.jsp để tránh vòng lặp
        }

       
        request.setAttribute("contentPage", file);
        request.getRequestDispatcher("Reporter/PhongvienPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
