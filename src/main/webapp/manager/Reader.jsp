<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>
<%
    // Lấy ngày giờ hiện tại
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String now = sdf.format(new Date());
%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang Độc Giả - MyNews</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
        font-family: "Segoe UI", Roboto, Arial, sans-serif;
        margin: 0;
    }

    /* ===== HEADER ===== */
    .header {
        background-color: #b71c1c; /* đỏ VietnamNet */
        color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 12px 40px;
    }
    .header-left {
        display: flex;
        align-items: center;
        gap: 20px;
    }
    .header-logo {
        font-size: 26px;
        font-weight: bold;
        letter-spacing: 1px;
    }
    .header-date {
        font-size: 14px;
        opacity: 0.8;
    }
    .header-right a {
        color: white;
        font-weight: 600;
        text-decoration: none;
        transition: 0.3s;
    }
    .header-right a:hover {
        text-decoration: underline;
        opacity: 0.9;
    }

    /* ===== MENU ===== */
    nav {
        background-color: #e53935;
        border-bottom: 3px solid #c62828;
    }
    nav ul {
        display: flex;
        list-style: none;
        margin: 0;
        padding: 8px 40px;
        gap: 20px;
    }
    nav ul li a {
        color: white;
        text-decoration: none;
        font-weight: 600;
        font-size: 15px;
    }
    nav ul li a:hover {
        text-decoration: underline;
    }

    /* ===== MAIN CONTENT ===== */
    #main-content {
        display: grid;
        grid-template-columns: 2fr 1fr;
        gap: 20px;
        padding: 30px 40px;
        box-sizing: border-box;
    }
    .main {
        background-color: #fff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.05);
    }

    /* ===== SIDEBAR ===== */
    .sidebar {
        display: flex;
        flex-direction: column;
        gap: 15px;
    }
    .sb-box {
        background-color: #fff;
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.05);
    }
    .sb-box h5 {
        font-size: 16px;
        font-weight: 700;
        margin-bottom: 10px;
        border-left: 4px solid #b71c1c;
        padding-left: 8px;
        color: #b71c1c;
    }
    .sb-box a {
        text-decoration: none;
        color: #333;
        display: block;
        margin: 4px 0;
        transition: 0.2s;
    }
    .sb-box a:hover {
        color: #b71c1c;
        text-decoration: underline;
    }

    /* ===== FOOTER ===== */
    footer {
        background-color: #f1f1f1;
        padding: 20px;
        text-align: center;
        color: #666;
        font-size: 14px;
        margin-top: 40px;
        border-top: 1px solid #ddd;
    }
</style>
</head>
<body>

<!-- ===== HEADER ===== -->
<div class="header">
    <div class="header-left">
        <div class="header-logo">📰 MyNews</div>
        <div class="header-date"><%= now %></div>
    </div>
    <div class="header-right">
    	<c:choose>
    		<c:when test="${sessionScope.login eq true}">
    			<a href="${pageContext.request.contextPath}/logout-reader">Đăng xuất</a> 
		</c:when>
    		<c:otherwise>
    			<a href="${pageContext.request.contextPath}/login-reader">Đăng nhập</a>
		</c:otherwise>
    	</c:choose>
    </div>
</div>

<!-- ===== MENU ===== -->
<nav>
    <%@ include file="menu.jsp" %>
</nav>

<!-- ===== MAIN CONTENT + SIDEBAR ===== -->
<div id="main-content">
    <!-- Nội dung chính -->
    <div class="main">
        <c:import url="${contentPage}" />
    </div>

    <!-- Thanh bên -->
    <div class="sidebar">
        <div class="sb-box">
            <h5>Tin nổi bật</h5>
            <a href="${pageContext.request.contextPath}/UserControl?hottest=true&id=${news.id}" class="btn btn-outline-primary"">5 bản tin được xem nhiều</a>
        </div>
        <div class="sb-box">
            <h5>Tin mới nhất</h5>
            <a href="${pageContext.request.contextPath}/UserControl?latest=true&id=${news.id}" class="btn btn-outline-primary"">5 bản tin mới nhất</a>
        </div>
        <div class="sb-box">
            <h5>Tin bạn đã xem</h5>
            <p class="text-muted">Chưa có lịch sử xem</p>
        </div>
        <div class="sb-box">
            <h5>Newsletter</h5>
            <form>
                <input type="email" class="form-control mb-2" placeholder="Nhập email của bạn">
                <button class="btn btn-danger w-100">Đăng ký</button>
            </form>
        </div>
    </div>
</div>

<!-- ===== FOOTER ===== -->
	<!-- Footer -->
	<jsp:include page="footer.jsp" />

</body>
</html>
