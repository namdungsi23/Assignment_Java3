<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
.menu {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;                /* hiển thị ngang */
  justify-content: center;      /* căn giữa menu ra giữa màn hình */
  background-color: #008080;       /* nền tối */
}

.menu li {
  margin: 0;
  padding: 0;
}

.menu li a {
  display: flex;                /* dùng flex trong từng thẻ a */
  justify-content: center;      /* chữ ra giữa ngang */
  align-items: center;          /* chữ ra giữa dọc */
  padding: 12px 20px;
  color: white;
  text-decoration: none;
  font-size: 15px;
  font-weight: bold;
  transition: background 0.3s, color 0.3s;
}

.menu li a:hover {
  background-color: #ff9800;    /* đổi màu nền khi hover */
  color: #000;                  /* đổi màu chữ khi hover */
}

</style>
	<ul class="menu">
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=home">Trang
				chủ</a></li>
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=vanhoa">Văn
				hóa</a></li>
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=thethao">Thể
				thao</a></li>
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=suckhoe">Sức
				khỏe</a></li>
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=chinhtri">Chính
				trị</a></li>
		<li><a
			href="${pageContext.request.contextPath}/UserControl?page=dulich">Du
				lịch</a></li>
	<li><a
			href="${pageContext.request.contextPath}/UserControl?page=doisong">Đời sống</a></li>
	<li><a
			href="${pageContext.request.contextPath}/UserControl?page=giaoduc">Giáo dục</a></li>
	<li><a
			href="${pageContext.request.contextPath}/UserControl?page=congnghe">Công nghệ</a></li>
	</ul>



</body>
</html>