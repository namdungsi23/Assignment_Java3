<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết tin tức</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .news-detail img {
            max-width: 300px;
            height: auto;
            margin-right: 15px;
        }
        .news-detail h3 {
            font-weight: 600;
            margin-bottom: 10px;
        }
        .news-detail p {
            color: #333;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:if test="${not empty news}">
            <div class="news-detail">
                <h3>${news.title}</h3>
                <c:if test="${not empty news.image}">
                    <img src="${pageContext.request.contextPath}/manager/img/${news.image}" alt="${news.title}" class="img-fluid">
                </c:if>
                <p>${news.content}</p>
                <p><small>Ngày đăng: ${news.publishedDate} | Lượt xem: ${news.viewCount}</small></p>
            </div>
        </c:if>
        <c:if test="${empty news}">
            <p>Không tìm thấy tin tức.</p>
        </c:if>
    </div>
</body>
</html>