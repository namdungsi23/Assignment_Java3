package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.News;
import utils.JDBC;

public class TinTucDaoImpl {
	// 1. Lấy tất cả tin tức
    public List<News> findAll() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News";

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getString("Id"));
                n.setTitle(rs.getString("Title"));
                n.setContent(rs.getString("Content"));
                n.setImage(rs.getString("Image"));
                n.setPublishedDate(rs.getTimestamp("PublishedDate"));
                n.setViewCount(rs.getInt("ViewCount"));
                n.setFavoriteCount(rs.getInt("FavoriteCount"));
                n.setActive(rs.getBoolean("IsActive"));
                n.setCategoryId(rs.getString("CategoryId"));
                n.setUserId(rs.getString("UserId"));
                list.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Lấy tin tức theo Id
    public News findById(String id) {
        String sql = "SELECT * FROM News WHERE Id = ?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                News n = new News();
                n.setId(rs.getString("Id"));
                n.setTitle(rs.getString("Title"));
                n.setContent(rs.getString("Content"));
                n.setImage(rs.getString("Image"));
                n.setPublishedDate(rs.getTimestamp("PublishedDate"));
                n.setViewCount(rs.getInt("ViewCount"));
                n.setFavoriteCount(rs.getInt("FavoriteCount"));
                n.setActive(rs.getBoolean("IsActive"));
                n.setCategoryId(rs.getString("CategoryId"));
                n.setUserId(rs.getString("UserId"));
                return n;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 3. Thêm tin tức
    public int insert(News n) {
        String sql = """
            INSERT INTO News 
            (Id, Title, Content, Image, PublishedDate, ViewCount, FavoriteCount, IsActive, CategoryId, UserId)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, n.getId());
            ps.setString(2, n.getTitle());
            ps.setString(3, n.getContent());
            ps.setString(4, n.getImage());
            ps.setTimestamp(5, n.getPublishedDate());
            ps.setInt(6, n.getViewCount());
            ps.setInt(7, n.getFavoriteCount());
            ps.setBoolean(8, n.isActive());
            ps.setString(9, n.getCategoryId());
            ps.setString(10, n.getUserId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 4. Cập nhật tin tức
    public int update(News n) {
        String sql = """
            UPDATE News
            SET Title=?, Content=?, Image=?, PublishedDate=?, ViewCount=?, FavoriteCount=?, 
                IsActive=?, CategoryId=?, UserId=?
            WHERE Id=?
        """;

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, n.getTitle());
            ps.setString(2, n.getContent());
            ps.setString(3, n.getImage());
            ps.setTimestamp(4, n.getPublishedDate());
            ps.setInt(5, n.getViewCount());
            ps.setInt(6, n.getFavoriteCount());
            ps.setBoolean(7, n.isActive());
            ps.setString(8, n.getCategoryId());
            ps.setString(9, n.getUserId());
            ps.setString(10, n.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 5. Xóa tin tức
    public int delete(String id) {
        String sql = "DELETE FROM News WHERE Id = ?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
