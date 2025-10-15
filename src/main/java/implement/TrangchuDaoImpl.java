package implement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JDBC;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.TrangchuDao;
import entity.Categories;
import entity.News;


/**
 * Servlet implementation class TrangchuDaoImpl
 */
public class TrangchuDaoImpl implements TrangchuDao{
	@Override
    public List<News> findHomeNews() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News WHERE home = 1";

        try {
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setImage(rs.getString("image"));
                n.setPublishedDate(rs.getDate("publishDate"));
                n.setViewCount(rs.getInt("views"));
                n.setFavoriteCount(rs.getInt("favoriteCount"));
                n.setActive(rs.getBoolean("status"));
                n.setCategoryId(rs.getInt("categoryId"));
                n.setUserId(rs.getInt("userId"));
                list.add(n);
            }
            rs.getStatement().getConnection().close(); // đóng kết nối sau khi dùng xong
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public News findById(String id) {
        News n = null;
        String sql = "SELECT * FROM News WHERE id = ?";
        try {
            ResultSet rs = JDBC.executeQuery(sql, id);
            if (rs.next()) {
                n = new News();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setImage(rs.getString("image"));
                n.setPublishedDate(rs.getDate("publishDate"));
                n.setViewCount(rs.getInt("views"));
                n.setFavoriteCount(rs.getInt("favoriteCount"));
                n.setActive(rs.getBoolean("status"));
                n.setCategoryId(rs.getInt("categoryId"));
                n.setUserId(rs.getInt("userId"));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
}

