<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
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
	<h3>Quản lý loại tin</h3>
	<p>Thêm, sửa, xóa loại tin.</p>
	
	<table>
	    <thead>
	      <tr>
	        <th>Mã loại tin</th>
	        <th>Tên loại tin</th>
	        <th>Bí danh</th>
	        <th>Trạng thái (Status)</th>
	        <th>Hành động (Action)</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="c" items="${categories}">
	        <tr>
	          <td>${c.id}</td>
	          <td>${c.name}</td>
	          <td>${c.alias }</td>
	          <td>
	            <c:choose>
	              <c:when test="${c.active == true}">
	                <span class="status-active">Hoạt động (Active)</span>
	              </c:when>
	              <c:otherwise>
	                <span class="status-inactive">Không hoạt động (Inactive)</span>
	              </c:otherwise>
	            </c:choose>
	          </td>
	          <td>
	          	<form action="${pageContext.request.contextPath}/loai-tin" method="post">
				    <input type="hidden" name="action" value="delete">
				    <input type="hidden" name="id" value="${c.id}">
				    <button type="submit">Delete</button>
				</form>
	          </td>
	          <td>
	          	<form action="${pageContext.request.contextPath}/loai-tin" method="post">
				    <input type="hidden" name="action" value="edit">
				    <input type="hidden" name="id" value="${c.id}">
				    <button type="submit">Edit</button>
				</form>
	          </td>
	        </tr>
	      </c:forEach>
	    </tbody>
  	</table>
  	<br><br>
  	
  	<h2>Categories Information Form</h2>
	<form action="${pageContext.request.contextPath}/loai-tin" method="post">
		<div class="form-group">
		    <label for="id">ID:</label>
		    <input type="text" id="id" name="id" value="${editedCat!=null ? editedCat.id : ''}">
		  </div>
	
	  	<div class="form-group">
		    <label for="name">Tên loại tin:</label>
		    <input type="text" id="name" name="name" value="${editedCat!=null ? editedCat.name : ''}">
  		</div>
  		
  		<div class="form-group">
		    <label for="alias">Bí danh:</label>
		    <input type="text" id="alias" name="alias" value="${editedCat!=null ? editedCat.alias : ''}">
  		</div>
	
		<div class="form-group">
		  	<label for="isActive">Is Active:</label>
		  	<input type="checkbox" id="isActive" name="isActive" 
			     <c:if test="${editedCat != null && editedCat.active}">
			          checked
			      </c:if>
			>
		 </div>
	
	  <button type="submit" name="action" value="create">Create</button>
	  <button type="submit" name="action" value="update">Update</button>
	  <button type="reset">Reset</button>
	</form>
	
</body>
</html>