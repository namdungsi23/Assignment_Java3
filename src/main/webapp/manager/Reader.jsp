<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
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

#main-content {
	display: grid;
	grid-template-columns: 2fr 1fr;
	width: 100%;
  	height: 50vh;
  	padding: 20px;
  	box-sizing: border-box;
}

.main {
  background-color: #f5f5f5; 
  padding: 10px;
  overflow-y: auto;
  max-height: 100%; /* tránh tràn grid */
  box-sizing: border-box;
}

.news-content {
	width:100%;
  	height: auto;
}

.news-content img {
	width:100%;
  height: auto;
  border-radius: 8px;
  display: block;
}

.sidebar {
  display: grid;
  grid-template-rows: repeat(4, 1fr); 
  gap: 10px;
  background-color: #ddd;
  padding: 10px;
}

.hottest { background-color: orange; color: white; }
.newest { background-color: yellow; }
.recently { background-color: lightgreen; color: white;}
.newsletter { background-color: gray; color: white; }

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
	
	<!-- Menu -->
	<%@ include file="menu.jsp"%>
	
	<!-- Khu vực hiển thị nội dung --> 
	<div id="main-content" style="padding: 20px;">
		<!-- Main content -->
		<div class="main">
			 <c:import url="${ contentPage}"/>
		</div>
		
		<!-- Sidebar -->
		<div class="sidebar">
			<div class="sb-content hottest"><a href="${pageContext.request.contextPath}/UserControl?page=home&hottest=true">5 bản tin được xem nhiều</a></div>
			<div class="sb-content newest"><a href="${pageContext.request.contextPath}/UserControl?page=home&latest=true">5 bản tin mới nhất</a></div>
			<div class="sb-content recently">5 bản tin đã bạn đã xem</div>
			<div class="sb-content newsletter">Newsletter</div>
		</div>
		
	</div>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
</body>
</html>