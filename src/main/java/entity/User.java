package entity;

public class User {
	 	private String id;
	    private String userName;
	    private String fullName;
	    private String email;
	    private String passwordHash;
	    private String roleId;
	    private boolean isActive;
	    
	    public static final String ROLE_ADMIN = "R001";
	    public static final String ROLE_REPORTER = "R003";
	    public static final String ROLE_EDITOR = "R002";
	    public static final String ROLE_READER = "R004";
	    
	    public User() {}

	    public User(String id, String userName, String fullName, String email,
	                String passwordHash, String roleId, boolean isActive) {
	        this.id = id;
	        this.userName = userName;
	        this.fullName = fullName;
	        this.email = email;
	        this.passwordHash = passwordHash;
	        this.roleId = roleId;
	        this.isActive = isActive;
	    }

	    // Getter và Setter
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPasswordHash() {
	        return passwordHash;
	    }

	    public void setPasswordHash(String passwordHash) {
	        this.passwordHash = passwordHash;
	    }

	    public String getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(String roleId) {
	        this.roleId = roleId;
	    }

	    public boolean isActive() {
	        return isActive;
	    }

	    public void setActive(boolean isActive) {
	        this.isActive = isActive;
	    }

}
