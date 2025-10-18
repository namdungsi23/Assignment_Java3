package implement;

import utils.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.TrangchuDao;
import entity.News;

/**
 * Implementation class for TrangchuDao
 */
public class TrangchuDaoImpl implements TrangchuDao {

    @Override
    public void updateViewCount(String id) {
        String sql = "UPDATE News SET ViewCount = ViewCount + 1 WHERE Id = ?";
        try (Connection conn = JDBC.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("Không tìm thấy bản ghi với id = " + id + " để cập nhật lượt xem");
            } else {
                System.out.println("Cập nhật lượt xem thành công cho id = " + id);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật số lượt xem cho id " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<News> findHomeNews() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News WHERE IsActive = 1 ORDER BY publishedDate DESC";
        try {
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
                News n = mapResultSetToNews(rs);
                list.add(n);
            }
            closeResources(rs);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin tức trang chủ: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public News findById(String id) {
        News n = null;
        String sql = "SELECT * FROM News WHERE id = ? AND IsActive = 1";
        try {
            ResultSet rs = JDBC.executeQuery(sql, id);
            if (rs.next()) {
                n = mapResultSetToNews(rs);
            }
            closeResources(rs);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin tức theo id " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<News> findNewsByCategory(String categoryId) {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News WHERE categoryId = ? AND IsActive = 1 ORDER BY publishedDate DESC";
        try {
            ResultSet rs = JDBC.executeQuery(sql, categoryId);
            while (rs.next()) {
                News n = mapResultSetToNews(rs);
                list.add(n);
            }
            closeResources(rs);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin tức theo danh mục " + categoryId + ": " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public News findFirst() {
        News n = null;
        String sql = "SELECT TOP 1 * FROM News WHERE IsActive = 1 ORDER BY publishedDate ASC";
        try {
            ResultSet rs = JDBC.executeQuery(sql);
            if (rs.next()) {
                n = mapResultSetToNews(rs);
            }
            closeResources(rs);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin tức đầu tiên: " + e.getMessage());
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public News[] findPrevNext(String id) {
        News prev = null, next = null;
        String sql = "SELECT * FROM News WHERE IsActive = 1 ORDER BY publishedDate";
        try {
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("id").equals(id)) {
                    int currentPos = rs.getRow();
                    if (rs.previous()) {
                        prev = mapResultSetToNews(rs);
                    }
                    rs.absolute(currentPos);
                    if (rs.next()) {
                        next = mapResultSetToNews(rs);
                    }
                    break;
                }
            }
            closeResources(rs, ps, conn);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin trước/sau cho id " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
        return new News[] { prev, next };
    }

    @Override
    public List<News> findLatestNews() {
        String sql = "SELECT TOP 5 * FROM News WHERE IsActive = 1 ORDER BY publishedDate DESC";
        List<News> newsList = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(sql);
            while (rs.next()) {
                News n = mapResultSetToNews(rs);
                newsList.add(n);
            }
            closeResources(rs);
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy tin tức mới nhất: " + e.getMessage());
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
        n.setPublishedDate(rs.getDate("publishedDate"));
        n.setViewCount(rs.getInt("viewCount"));
        n.setFavoriteCount(rs.getInt("favoriteCount"));
        n.setActive(rs.getBoolean("IsActive"));
        n.setCategoryId(rs.getString("categoryId"));
        n.setUserId(rs.getString("userId"));
        return n;
    }

    private void closeResources(ResultSet rs) {
        if (rs != null) {
            try {
                rs.getStatement().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
