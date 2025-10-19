<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang phóng viên</title>
</head>
<body>
<style>
   body { 
   margin:0;
    font-family: Arial, sans-serif; }
    .header, .footer { 
    background: #0066cc; 
    color: white;
     text-align: center;
     padding: 10px; }
    .menu { background: #f0f0f0; 
    text-align: center;
     padding: 10px; }
    .menu a {
     margin: 0 10px;
     text-decoration: none;
      color: #0033cc;
       font-weight: bold;
         
    padding: 8px 12px;
    border-radius: 5px;
    transition: 0.3s; }
    .menu a:hover{
    background-color: #ff9800;    
  color: #000;                  
    }
   .headers {
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
   <!-- Menu -->
   <%@ page import="java.text.SimpleDateFormat, java.util.Date"%>

	<%
    // Lấy ngày giờ hiện tại
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String now = sdf.format(new Date());
%>
	<div class="headers">
		<!-- Bên trái -->
		<div class="header-left">
			<div class="header-logo">📰 MyNews</div>
			<div class="header-date"><%= now %></div>
		</div>

		<!-- Bên phải -->
		<div class="header-right">
			<a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>

		</div>
	</div>
    <div class="menu">
    <a href="<%= request.getContextPath() %>/phongvien?page=Thongtin">Thông tin phóng viên</a> 
    <a href="<%= request.getContextPath() %>/phongvien?page=Baiviet"> Quản lý bài viết</a> 
    <a href="<%= request.getContextPath() %>/phongvien?page=Dangtin"> Đăng tin</a> 
    <!-- <a href="<%= request.getContextPath() %>/phongvien?page=Thongke"> Thống kê</a>  -->
   
</div>

<jsp:include page="${contentPage}" />  

	<div class="footer">
        Welcome ${sessionScope.user.userName}
    </div>
</body>
</body>
</html>
