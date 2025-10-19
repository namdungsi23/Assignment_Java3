<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng tin tức</title>
<style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f6fa;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 850px;
            margin: 40px auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
            padding: 30px 40px;
        }
        h1 {
            text-align: center;
            font-size: 22px;
            color: #333;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 14px;
            font-weight: 600;
            color: #444;
        }
        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
            margin-top: 6px;
            box-sizing: border-box;
        }
        textarea {
            min-height: 240px;
            resize: vertical;
            font-family: "Segoe UI", sans-serif;
            line-height: 1.5;
        }
        input[type="file"] {
            margin-top: 8px;
        }
        .actions {
            text-align: right;
            margin-top: 20px;
        }
        .btn {
            padding: 10px 18px;
            border-radius: 8px;
            border: none;
            cursor: pointer;
            font-weight: 600;
            font-size: 15px;
        }
        .btn-submit {
            background-color: #3b82f6;
            color: #fff;
        }
        .btn-reset {
            background-color: #e5e7eb;
            color: #111827;
            margin-right: 8px;
        }
        .note {
            font-size: 12px;
            color: #666;
            margin-top: 10px;
        }
</style>	
</head>
<body>
<div class="container">
    <h1>Đăng tin tức (Post News)</h1>
    <form action="${pageContext.request.contextPath}/dang-tin" method="post" enctype="multipart/form-data">
        <!-- Mã tin tức -->
        <label for="id">Mã tin tức (id):</label>
        <input type="text" id="id" name="id" placeholder="Nhập mã tin tức...">

        <!-- Tiêu đề -->
        <label for="title">Tiêu đề (title):</label>
        <input type="text" id="title" name="title" placeholder="Nhập tiêu đề bài viết...">

        <!-- Nội dung -->
        <label for="content">Nội dung (content):</label>
        <textarea id="content" name="content" placeholder="Nhập nội dung bài viết tại đây..."></textarea>

        <!-- Upload ảnh -->
        <label for="image">Ảnh minh họa (image):</label>
        <input type="file" id="image" name="image" accept="image/*">

        <!-- Thể loại -->
        <label for="category">Thể loại (categoryId):</label>
        <select id="category" name="category">
        <c:forEach var="c" items="${catList }">
        		<option value="${c.alias }">${c.name }</option>
        </c:forEach>
        </select>
        
        <div class="actions">
            <button type="reset" class="btn btn-reset">Làm mới (Reset)</button>
            <button type="submit" class="btn btn-submit" name="action" value="submit"
            onclick="return confirmAction('Đăng tin')">Đăng tin (Submit)</button>
        </div>
    </form>
</div>
<script type="text/javascript">
	function confirmAction(action) {
		return confirm('Bạn có xác nhận muốn ' + action + '?');
	}
</script>
</body>
</html>