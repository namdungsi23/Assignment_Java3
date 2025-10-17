package implement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.TrangchuDao;
import entity.Categories;
import entity.News;


/**
 * Servlet implementation class TrangchuDaoImpl
 */
public class TrangchuDaoImpl implements TrangchuDao{
	
	public void updateViewCount(String id) {
		String sql = "UPDATE News SET ViewCount = ViewCount + 1 WHERE Id = ?";
		
		try {
			JDBC.executeUpdate(sql, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public List<News> findHomeNews() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News";

        try {
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getString("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setImage(rs.getString("image"));
                n.setPublishedDate(rs.getTimestamp("publishedDate"));
                n.setViewCount(rs.getInt("ViewCount"));
                n.setFavoriteCount(rs.getInt("favoriteCount"));
                n.setActive(rs.getBoolean("IsActive"));
                n.setCategoryId(rs.getString("categoryId"));
                n.setUserId(rs.getString("userId"));
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
                n.setId(rs.getString("id"));
                n.setTitle(rs.getString("title"));
                n.setContent(rs.getString("content"));
                n.setImage(rs.getString("image"));
                n.setPublishedDate(rs.getTimestamp("publishedDate"));
                n.setViewCount(rs.getInt("viewCount"));
                n.setFavoriteCount(rs.getInt("favoriteCount"));
                n.setActive(rs.getBoolean("IsActive"));
                n.setCategoryId(rs.getString("categoryId"));
                n.setUserId(rs.getString("userId"));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public News findFirst() {
        News n = null;
        String sql = "SELECT TOP 1 * FROM News ORDER BY publishedDate ASC"; 

        try {
            ResultSet rs = JDBC.executeQuery(sql);
            if (rs.next()) { 
                n = this.mapResultSetToNews(rs);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n;
    }
    
    
    public News[] findPrevNext(String id) {
    		News prev = null, next = null;
        String sql = "SELECT * FROM News ORDER BY publishedDate";
        
        try {
        		Connection conn = JDBC.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
        				ResultSet.CONCUR_READ_ONLY);
        		
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            		if(rs.getString("id").equals(id)) {
            			int currentPo = rs.getRow();
            			
            			 if(rs.previous()) {
                 		prev = this.mapResultSetToNews(rs);
                     }
                     
                     rs.absolute(currentPo);
                     
                     if(rs.next()) {
                 		next = this.mapResultSetToNews(rs);
                     }
                     
                     break;
            		}
                
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new News[] {prev,next};
    }
    
    public List<News> findLatestNews() {
    		String sql = "SELECT TOP 5 * FROM News ORDER BY publishedDate DESC"; 
    		List<News> newsList = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
            		News n = new News();
                n = this.mapResultSetToNews(rs);
                newsList.add(n);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
    
    private News mapResultSetToNews(ResultSet rs) throws SQLException {
        News n = new News();
        n.setId(rs.getString("id"));
        n.setTitle(rs.getString("title"));
        n.setContent(rs.getString("content"));
        n.setImage(rs.getString("image"));
        n.setPublishedDate(rs.getTimestamp("publishedDate"));
        n.setViewCount(rs.getInt("viewCount"));
        n.setFavoriteCount(rs.getInt("favoriteCount"));
        n.setActive(rs.getBoolean("IsActive"));
        n.setCategoryId(rs.getString("categoryId"));
        n.setUserId(rs.getString("userId"));
        return n;
    }
    
}

