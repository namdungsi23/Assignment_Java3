<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer độc giả</title>
</head>
<style>
.footer {
  background-color: #F8F8FF;
  color: #fff;
  padding: 40px 20px 20px;
  margin-top: 30px;
}

.footer-container {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  max-width: 1200px;
  margin: auto;
}

.footer-about,
.footer-links,
.footer-contact {
  flex: 1;
  min-width: 250px;
  margin: 10px;
  
}

.footer h3,
.footer h4 {
  margin-bottom: 15px;
  color: #87CEEB;
}

.footer p,
.footer a {
  color: #87CEEB;
  font-size: 14px;
  line-height: 1.6;
}

.footer a {
  text-decoration: none;
  transition: color 0.3s;
}

.footer a:hover {
  color: #ff9800;
}

.footer-bottom {
  text-align: center;
  border-top: 1px solid #555;
  padding-top: 15px;
  margin-top: 20px;
  font-size: 13px;
  color: #aaa;
}
</style>	
<body>
<footer class="footer">
  <div class="footer-container">
    <div class="footer-about">
      <h3>Báo Điện Tử</h3>
      <p>
        Cập nhật nhanh chóng, chính xác các tin tức về văn hóa, thể thao, sức khỏe,
        chính trị và du lịch.
      </p>
    </div>

    <div class="footer-links">
      <h4>Liên kết nhanh</h4>
      <ul>
        <li><a href="${pageContext.request.contextPath}/UserControl?page=home">Trang chủ</a></li>
        <li><a href="${pageContext.request.contextPath}/UserControl?page=vanhoa">Văn hóa</a></li>
        <li><a href="${pageContext.request.contextPath}/UserControl?page=thethao">Thể thao</a></li>
        <li><a href="${pageContext.request.contextPath}/UserControl?page=suckhoe">Sức khỏe</a></li>
        <li><a href="${pageContext.request.contextPath}/UserControl?page=dulich">Du lịch</a></li>
      </ul>
    </div>

    <div class="footer-contact">
      <h4>Liên hệ</h4>
      <p>Email: lienhe@baodientu.vn</p>
      <p>Điện thoại: 0123 456 789</p>
      <p>Địa chỉ: 123 Nguyễn Văn Cừ, Hà Nội</p>
    </div>
  </div>

  <div class="footer-bottom">
    <p>&copy; 2025 Báo Điện Tử. All rights reserved.</p>
  </div>
</footer>

</body>
</html>