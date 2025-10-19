<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang quản lí</title>
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

</head>

<body>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    // 🕒 Lấy thời gian hiện tại
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String now = sdf.format(new Date());

    // 🍪 Lấy tên người dùng từ Cookie (nếu có)
    String username = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
                break;
            }
        }
    }
%>

<div class="headers">
    <!-- Bên trái -->
    <div class="header-left">
        <div class="header-logo">📰 MyNews</div>
        <div class="header-date"><%= now %></div>
    </div>

    <!-- Bên phải -->
    <div class="header-right">
        <% if (username != null) { %>
            <span>👋 <%= username %></span>
        <% } else { %>
            <a href="<%= request.getContextPath() %>/logout">Đăng xuất</a>
        <% } %>
    </div>
</div>

<!-- Menu -->
<div class="menu">
    <a href="<%= request.getContextPath() %>/AdminControl?page=home">Quản lý chung</a> 
    <a href="<%= request.getContextPath() %>/AdminControl?page=tintuc">Quản lý Tin tức</a> 
    <a href="<%= request.getContextPath() %>/AdminControl?page=Loaitin">Quản lý Loại tin</a> 
    <a href="<%= request.getContextPath() %>/AdminControl?page=nguoidung">Quản lý Người dùng</a> 
    <a href="<%= request.getContextPath() %>/AdminControl?page=Newsletter">Quản lý Newsletter</a>
</div>

	<c:import url="${contentPage}" />  

</body>
</html>
