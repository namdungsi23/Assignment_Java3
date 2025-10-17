package entity;

public class Role {
	 private String roleId;
	    private String roleName;

	    public Role() {}

	    public Role(String roleId, String roleName) {
	        this.roleId = roleId;
	        this.roleName = roleName;
	    }

	    // Getter và Setter
	    public String getRoleId() {
	        return roleId;
	    }

	    public void setRoleId(String roleId) {
	        this.roleId = roleId;
	    }

	    public String getRoleName() {
	        return roleName;
	    }

	    public void setRoleName(String roleName) {
	        this.roleName = roleName;
	    }
}
