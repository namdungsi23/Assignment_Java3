<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Độc giả</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<%-- 
	<h2>Chào mừng đến với Trang Độc giả</h2>
	<p>Vui lòng chọn mục trên menu để xem danh sách tin tức.</p>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="${pageContext.request.contextPath}/UserControl?page=home">Trang Chủ</a>
	  </div>
	</nav>
--%>
	<div class="news-content container mt-4" >
		<div class="content" style="">
			<img src="manager/img/${news.image }" class="content-img-top" alt="${news.title }">
			<div class="content-body">
				<h3 class="content-title">${news.title }</h3>
			</div>
		</div>
		
		<div class="navigation mt-3 d-flex justify-content-between">
			<a href="${pageContext.request.contextPath}/UserControl?page=home&action=prev&id=${news.id}" class="btn btn-outline-primary">Tin trước</a>
    			<a href="${pageContext.request.contextPath}/UserControl?page=home&action=next&id=${news.id}" class="btn btn-outline-primary">Tin sau</a>
		</div>
		
	</div>

</body>
</html>