<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang tin tức</title>
<style>
    table { border-collapse: collapse; width: 100%; }
    th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: center; }
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
    input[type="password"],
    input[type="date"],
    input[type="file"] {
      width: 300px;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-group {
      margin-bottom: 15px;
      text-align: left;
      width: 350px;
      margin: 10px auto;
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

    .input-field h2 {
      text-align: center;
      margin-bottom: 20px;
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
	<h3>Danh sách tin tức</h3>
	<p>Hiển thị các tin tức trong hệ thống...</p>
	
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
	        <th colspan=2>Hành động</th>
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
	          	<form action="${pageContext.request.contextPath}/tin-tuc" method="post" enctype="multipart/form-data" onsubmit="return confirmAction('delete')">
				    <input type="hidden" name="action" value="delete">
				    <input type="hidden" name="id" value="${n.id}">
				    <button type="submit">Delete</button>
				</form>
	          </td>
	          <td>
	          	<form action="${pageContext.request.contextPath}/tin-tuc" method="post" enctype="multipart/form-data">
				    <input type="hidden" name="action" value="edit">
				    <input type="hidden" name="id" value="${n.id}">
				    <button type="submit">Edit</button>
				</form>
	          </td>
	        </tr>
	      </c:forEach>
	    </tbody>
  	</table>
  	<br><br>
  	
  	<h2>News Information Form</h2>
	<form id="upload-form" class="input-field" action="${pageContext.request.contextPath}/tin-tuc" method="post" enctype="multipart/form-data">
		<div class="form-group">
		    <label for="id">ID:</label><br>
		    <input type="text" id="id" name="id" value="${editedNews!=null ? editedNews.id : ''}">
		  </div>
	
	  	<div class="form-group">
		    <label for="title">Tiêu đề:</label><br>
		    <input type="text" id="title" name="title" value="${editedNews!=null ? editedNews.title : ''}">
  		</div>
  		
  		<div class="form-group">
		    <label for="content">Nội dung:</label><br>
		    <input type="text" id="content" name="content" value="${editedNews!=null ? editedNews.content : ''}">
  		</div>
  		
  		<div class="form-group">
		    <label for="image">Ảnh:</label><br>
		    <input type="file" id="image" name="image">
		    <c:if test="${editedNews != null && not empty editedNews.image}">
		        <p>Ảnh hiện tại: ${editedNews.image}</p>
		    </c:if>
		</div>
		
		<div class="form-group">
		  	<label for="isActive">Trạng thái (Active):</label><br>
		  	<input type="checkbox" id="isActive" name="isActive" 
			     <c:if test="${editedNews != null && editedNews.active}">
			          checked
			      </c:if>
			>
		 </div>
		 
		 <div class="form-group">
		    <label for="categoryId">Mã thể loại:</label><br>
		    <input type="text" id="categoryId" name="categoryId" value="${editedNews!=null ? editedNews.categoryId : ''}">
  		</div>
  		
  		<div class="form-group">
		    <label for="userId">Mã phóng viên:</label><br>
		    <input type="text" id="userId" name="userId" value="${editedNews!=null ? editedNews.userId : ''}">
  		</div>
	
		 <button type="submit" class="form-button" name="action" value="create"
          onclick="return confirmAction('create')">Create</button>
  		 <button type="submit" class="form-button" name="action" value="update"
          onclick="return confirmAction('update')">Update</button>
		<button type="reset" class="form-button">Reset</button>
	</form>

	<c:if test="${editedNews != null }">
		<script>
			window.onload = function() {
				document.getElementById("upload-form").scrollIntoView({behavior:"smooth"});
				document.getElementById("upload-form").focus();
			}
			
		</script>
	</c:if>

	<script>
		function confirmAction(actionType) {
		  return confirm("Bạn có chắc muốn " + actionType + " bản tin này không?");
		}
	</script>
</body>
</html>