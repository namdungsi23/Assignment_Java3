<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin người dùng</title>
<style>
    table { border-collapse: collapse; width: 100%; }
    th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: left; }
    th { background: #f4f4f4; }
    .status-active { color: green; font-weight: bold; }
    .status-inactive { color: #999; }
    .delete-btn {
      color: white;
      background-color: #d9534f;
      border: none;
      padding: 5px 10px;
      border-radius: 5px;
      cursor: pointer;
    }
    .delete-btn:hover {
      background-color: #c9302c;
    }
    
    .btn-back {
	  display: inline-block;
	  background-color: #007bff;
	  color: white;
	  padding: 8px 16px;
	  border-radius: 6px;
	  text-decoration: none;
	  transition: background 0.3s;
	}
	.btn-back:hover {
	  background-color: #0056b3;
	}
	
	 input[type="text"],
    input[type="email"],
    input[type="password"] {
      width: 300px;
      padding: 5px;
    }
    .form-group {
      margin-bottom: 15px;
    }
    button {
      margin-right: 10px;
      padding: 8px 16px;
    }
	
  </style>
</head>
<body>
	<h3>Quản lý người dùng</h3>
	<p>Danh sách user, quyền hạn, thông tin chi tiết...</p>
	
	<table>
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Username</th>
	        <th>Email</th>
	        <th>Vai trò (Role)</th>
	        <th>Trạng thái (Status)</th>
	        <th>Hành động (Action)</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="u" items="${users}">
	        <tr>
	          <td>${u.id}</td>
	          <td>${u.userName}</td>
	          <td>${u.email}</td>
	          <td>${u.roleId}</td> 
	          <td>
	            <c:choose>
	              <c:when test="${u.active == true}">
	                <span class="status-active">Hoạt động (Active)</span>
	              </c:when>
	              <c:otherwise>
	                <span class="status-inactive">Không hoạt động (Inactive)</span>
	              </c:otherwise>
	            </c:choose>
	          </td>
	          <td>
	          	<form action="${pageContext.request.contextPath}/nguoi-dung" method="post">
				    <input type="hidden" name="action" value="delete">
				    <input type="hidden" name="id" value="${u.id}">
				    <button type="submit">Delete</button>
				</form>
	          </td>
	        </tr>
	      </c:forEach>
	    </tbody>
  	</table>
  	<br><br>
  	
  	<h2>User Information Form</h2>
	<form action="${pageContext.request.contextPath}/nguoi-dung" method="post">
	  <div class="form-group">
	    <label for="id">ID:</label>
	    <input type="text" id="id" name="id">
	  </div>
	
	  <div class="form-group">
	    <label for="userName">Username:</label>
	    <input type="text" id="userName" name="userName">
	  </div>
	
	  <div class="form-group">
	    <label for="fullName">Full Name:</label>
	    <input type="text" id="fullName" name="fullName">
	  </div>
	
	  <div class="form-group">
	    <label for="email">Email:</label>
	    <input type="email" id="email" name="email">
	  </div>
	
	  <div class="form-group">
	    <label for="passwordHash">Password:</label>
	    <input type="password" id="passwordHash" name="passwordHash">
	  </div>
	
	  <div class="form-group">
	    <label for="roleId">Role ID:</label>
	    <input type="text" id="roleId" name="roleId">
	  </div>
	
	  <div class="form-group">
	    <label for="isActive">Is Active:</label>
	    <input type="checkbox" id="isActive" name="isActive">
	  </div>
	
	  <button type="submit" name="action" value="create">Create</button>
	  <button type="submit" name="action" value="Update">Update</button>
	  <button type="reset">Reset</button>
	</form>

  	

</body>
</html>