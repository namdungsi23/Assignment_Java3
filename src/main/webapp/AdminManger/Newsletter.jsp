<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Newsletter</title>
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
      text-align: left;
      width: 350px;
      margin: 10px auto;
    }
	
	h2 {
      text-align: center;
      margin-bottom: 20px;
    }
	
    .input-field {
      border: 1px solid #ddd;
      padding: 20px;
      width: 400px;
      margin: 30px auto;
      border-radius: 10px;
      background-color: #f9f9f9;
      box-shadow: 0 0 8px rgba(0,0,0,0.1);
    }

    .form-button {
      margin-right: 10px;
      padding: 8px 16px;
      border: none;
      background-color: #28a745;
      color: white;
      border-radius: 5px;
      cursor: pointer;
    }
    
    .form-button:hover {
      background-color: #218838;
    }
	
</style>
</head>
<body>
	<h3>Quản lý newsletter</h3>
	<p>Danh sách email đăng ký nhận tin.</p>
	
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
	      <c:forEach var="u" items="${newsletterList}">
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
	          	<form action="${pageContext.request.contextPath}/newsletter-admin" method="post">
				    <input type="hidden" name="action" value="send">
				    <input type="hidden" name="email" value="${u.email}">
				    <input type="hidden" name="scroll" value="true">
				    <button type="submit">Send</button>
				</form>
	          </td>
	        </tr>
	      </c:forEach>
	    </tbody>
  	</table>
  	<br><br>
  	<form action="${pageContext.request.contextPath}/newsletter-admin" method="post" style="margin-top:10px;">
	    <input type="hidden" name="action" value="sendAll">
	    <input type="hidden" name="scroll" value="true">
	    <button type="submit" class="btn btn-danger">Gửi cho tất cả người dùng</button>
	</form>
  	<p>${error }</p>
  	<br><br><br>
  	
  	<p>Danh sách tin tức.</p>
	<table>
	    <thead>
	      <tr>
	      	<th>No.</th>
	        <th>Mã tin</th>
	        <th>Tiêu đề</th>
	        <th>Nội dung</th>
	        <th>Hình ảnh</th>
	        <th>Ngày đăng</th>
	        <th>Trạng thái</th>
	        <th>Mã loại tin</th>
	        <th>Mã phóng viên</th>
	        <th>Hành động</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="n" items="${newsList}" varStatus="vs">
	        <tr>
	          <td>${vs.count }</td>
	          <td>${n.id}</td>
	          <td>${n.title}</td>
	          <td>${n.content }</td>
	          <td>
			    <img src="${pageContext.request.contextPath}/AdminManger/img/${n.image}" 
			         alt="${n.title}" 
			         width="80">
			  </td>
	          <td>${n.publishedDate }</td>
	          <td>
	            <c:choose>
	              <c:when test="${n.active == true}">
	                <span class="status-active">Hoạt động (Active)</span>
	              </c:when>
	              <c:otherwise>
	                <span class="status-inactive">Không hoạt động (Inactive)</span>
	              </c:otherwise>
	            </c:choose>
	          </td>
     	      <td>${n.categoryId }</td>
     	      <td>${n.userId }</td>

	          <td>
	          	<form action="${pageContext.request.contextPath}/newsletter-admin" method="post">
				    <input type="hidden" name="action" value="selectNews">
				    <input type="hidden" name="title" value="${n.title}">
				    <input type="hidden" name="content" value="${n.content}">
				    <input type="hidden" name="scroll" value="true">
				    <button type="submit">Chọn tin</button>
				</form>
	          </td>
	        </tr>
	      </c:forEach>
	    </tbody>
  	</table>
  	<br><br>
  	
</body>
</html>