package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Categories;
import utils.JDBC;

public class LoaiTinDaoImpl {
	// 1. Lấy tất cả Categories
    public List<Categories> findAll() {
        List<Categories> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getString("Id"));
                c.setName(rs.getString("Name"));
                c.setAlias(rs.getString("Alias"));
                c.setViewCount(rs.getInt("ViewCount"));
                c.setFavoriteCount(rs.getInt("FavoriteCount"));
                c.setActive(rs.getBoolean("IsActive"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Lấy Category theo Id
    public Categories findById(String id) {
        String sql = "SELECT * FROM Categories WHERE Id = ?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getString("Id"));
                c.setName(rs.getString("Name"));
                c.setAlias(rs.getString("Alias"));
                c.setViewCount(rs.getInt("ViewCount"));
                c.setFavoriteCount(rs.getInt("FavoriteCount"));
                c.setActive(rs.getBoolean("IsActive"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 3. Thêm Category
    public int insert(Categories c) {
        String sql = "INSERT INTO Categories (Id, Name, Alias, ViewCount, FavoriteCount, IsActive) VALUES (?, ?, ?, ?, ?, ?)";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
        		ps.setString(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getAlias());
            ps.setInt(4, c.getViewCount());
            ps.setInt(5, c.getFavoriteCount());
            ps.setBoolean(6, c.isActive());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 4. Cập nhật Category
    public int update(Categories c) {
        String sql = "UPDATE Categories SET Name=?, Alias=?, ViewCount=?, FavoriteCount=?, IsActive=? WHERE Id=?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getAlias());
            ps.setInt(3, c.getViewCount());
            ps.setInt(4, c.getFavoriteCount());
            ps.setBoolean(5, c.isActive());
            ps.setString(6, c.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 5. Xóa Category
    public int delete(String id) {
        String sql = "DELETE FROM Categories WHERE Id = ?";
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
