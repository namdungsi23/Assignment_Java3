package implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import utils.JDBC; 

public class NguoiDungDaoImpl {

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setUserName(rs.getString("UserName"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setRoleId(rs.getString("RoleId"));
                u.setActive(rs.getBoolean("IsActive"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<User> findAllNewsleter() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE Newsletter = 1";

        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setUserName(rs.getString("UserName"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setRoleId(rs.getString("RoleId"));
                u.setActive(rs.getBoolean("IsActive"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User findById(String id) {
        String sql = "SELECT * FROM Users WHERE Id = ?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setUserName(rs.getString("UserName"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setRoleId(rs.getString("RoleId"));
                u.setActive(rs.getBoolean("IsActive"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   //Find first reader on the list
    public User findFirstReader() {
        String sql = "SELECT TOP 1 * FROM Users ORDER BY Id ASC";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setUserName(rs.getString("UserName"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setRoleId(rs.getString("RoleId"));
                u.setActive(rs.getBoolean("IsActive"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Find last reader on the list 
    public User findLastReader() {
        String sql = "SELECT TOP 1 * FROM Users ORDER BY Id DESC";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setUserName(rs.getString("UserName"));
                u.setFullName(rs.getString("FullName"));
                u.setEmail(rs.getString("Email"));
                u.setPasswordHash(rs.getString("PasswordHash"));
                u.setRoleId(rs.getString("RoleId"));
                u.setActive(rs.getBoolean("IsActive"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int insert(User u) {   		
        String sql = "INSERT INTO Users (Id, UserName, FullName, Email, PasswordHash, RoleId, IsActive) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, u.getId());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getFullName());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPasswordHash());
            ps.setString(6, u.getRoleId());
            ps.setBoolean(7, u.isActive());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

   
    public int update(User u) {
        String sql = "UPDATE Users SET UserName=?, FullName=?, Email=?, PasswordHash=?, RoleId=?, IsActive=? WHERE Id=?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getFullName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPasswordHash());
            ps.setString(5, u.getRoleId());
            ps.setBoolean(6, u.isActive());
            ps.setString(7, u.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateNewsletter(String id) {
        String sql = "UPDATE Users SET Newsletter = ? WHERE Id=?";
        try (
            Connection conn = JDBC.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setBoolean(1, true);
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int delete(String id) {
        String sql = "DELETE FROM Users WHERE Id = ?";
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
