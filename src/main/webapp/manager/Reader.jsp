<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang độc giả</title>
</head>
<body>
	<!-- Menu chung -->
	<style>
.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #f1f1f1;
	padding: 10px 20px;
	font-family: Arial, sans-serif;
	border-bottom: 2px solid #ccc;
}

.header-left {
	display: flex;
	align-items: center;
	gap: 20px;
}

.header-logo {
	font-size: 22px;
	font-weight: bold;
	color: #333;
}

.header-date {
	font-size: 14px;
	color: #555;
}

.header-right a {
	text-decoration: none;
	font-size: 14px;
	color: #007bff;
	font-weight: bold;
}

.header-right a:hover {
	color: #0056b3;
}
</style>
	<%@ page import="java.text.SimpleDateFormat, java.util.Date"%>

	<%
    // Lấy ngày giờ hiện tại
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String now = sdf.format(new Date());
%>
	<div class="header">
		<!-- Bên trái -->
		<div class="header-left">
			<div class="header-logo">📰 MyNews</div>
			<div class="header-date"><%= now %></div>
		</div>

		<!-- Bên phải -->
		<div class="header-right">
			<a href="${pageContext.request.contextPath}/loginbao">Đăng nhập</a>
		</div>
	</div>
	<%@ include file="menu.jsp"%>
	<!-- Khu vực hiển thị nội dung --> 
	<div id="main-content" style="padding: 20px;">
		<jsp:include page="${contentPage}" />
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>