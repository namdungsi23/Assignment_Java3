<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${news.title} - VietnamNet</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	body {
		font-family: 'Segoe UI', Roboto, Arial, sans-serif;
		background-color: #f8f9fa;
	}
	.navbar {
		background-color: #b71c1c; /* đỏ đặc trưng Vietnamnet */
	}
	.navbar-brand {
		font-weight: bold;
		font-size: 1.4rem;
		text-transform: uppercase;
		color: white !important;
	}
	.news-content {
		max-width: 900px;
		background: #fff;
		padding: 20px 30px;
		border-radius: 8px;
		box-shadow: 0 2px 8px rgba(0,0,0,0.05);
	}
	.news-title {
		font-size: 1.8rem;
		font-weight: 700;
		color: #111;
		margin-bottom: 15px;
	}
	.news-meta {
		font-size: 0.9rem;
		color: #888;
		margin-bottom: 20px;
	}
	.news-img {
		width: 100%;
		border-radius: 6px;
		margin-bottom: 20px;
	}
	.news-body {
		font-size: 1.1rem;
		line-height: 1.8;
		color: #333;
	}
	.navigation a {
		border-radius: 20px;
	}
	footer {
		margin-top: 60px;
		padding: 20px 0;
		text-align: center;
		background-color: #f1f1f1;
		font-size: 0.9rem;
		color: #777;
	}
</style>
</head>
<body>
	<!-- Nội dung -->
	<div class="container my-5">
		<div class="news-content mx-auto">
			<h1 class="news-title">${news.title}</h1>
			<p class="news-meta">
    Ngày đăng: ${news.publishedDate} |
    Người đăng: ${news.userId}
          </p>

			<img src="manager/img/${news.image}" alt="${news.title}" class="news-img">
			<div class="news-body">
				<p>${news.content}</p>
			</div>

			<div class="navigation mt-4 d-flex justify-content-between">
				<a href="${pageContext.request.contextPath}/UserControl?page=home&action=prev&id=${news.id}" class="btn btn-outline-danger px-4">← Tin trước</a>
				<a href="${pageContext.request.contextPath}/UserControl?page=home&action=next&id=${news.id}" class="btn btn-outline-danger px-4">Tin sau →</a>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<footer>
		<p>&copy; 2025 VietnamNet - Bản quyền thuộc về Báo FPolyNews</p>
	</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
