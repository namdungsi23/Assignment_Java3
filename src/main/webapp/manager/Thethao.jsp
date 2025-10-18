<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tin Thể thao</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .news-item {
        border-bottom: 1px solid #ddd;
        padding: 15px 0;
    }
    .news-item img {
        max-width: 150px;
        height: auto;
        margin-right: 15px;
    }
    .news-item h5 {
        font-size: 18px;
        font-weight: 600;
        margin-bottom: 5px;
    }
    .news-item p {
        color: #666;
        font-size: 14px;
    }
</style>
</head>
<body>
    <h2>Danh sách các tin Thể thao</h2>
    <div class="container">
        <c:choose>
            <c:when test="${not empty newsList and not empty newsList}">
                <c:forEach var="news" items="${newsList}">
                    <div class="news-item d-flex">
                        <c:if test="${not empty news.image}">
                            <img src="${pageContext.request.contextPath}/manager/img/${news.image}" alt="${news.title}" class="img-fluid">
                        </c:if>
                        <div>
                            <h5><a href="${pageContext.request.contextPath}/UserControl?page=home&action=detail&id=${news.id}">${news.title}</a></h5>
                            <p>${news.content.substring(0, 100)}...</p>
                            <p><small>Ngày đăng: ${news.publishedDate} | Lượt xem: ${news.viewCount}</small></p>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>Không có tin tức nào trong danh mục Thể thao.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>