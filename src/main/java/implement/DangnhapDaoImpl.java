package implement;


import utils.JDBC;

import java.sql.ResultSet;
import dao.DangnhapDao;
import entity.User;

/**
 * Servlet implementation class DangnhapDaoImpl
 */
public class DangnhapDaoImpl implements DangnhapDao {
	 @Override
	    public User login(String username, String password) {
	        String sql = "SELECT * FROM [Users] WHERE UserName = ? AND PasswordHash = ? AND IsActive = 1";
	        try {
	            ResultSet rs = JDBC.executeQuery(sql, username, password);
	            if (rs.next()) {
	                User u = new User();
	                u.setId(rs.getString("Id"));
	                u.setUserName(rs.getString("UserName"));
	                u.setFullName(rs.getString("FullName"));
	                u.setEmail(rs.getString("Email"));
	                u.setPasswordHash(rs.getString("PasswordHash"));
	                u.setRoleId(rs.getString("RoleId"));
	                u.setActive(rs.getBoolean("IsActive"));
	                rs.getStatement().getConnection().close();
	                return u;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	}
