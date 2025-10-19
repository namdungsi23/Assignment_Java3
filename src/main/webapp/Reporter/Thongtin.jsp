<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin phóng viên</title>
<style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: #f6f8fb;
            color: #222;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 760px;
            max-width: 95%;
            margin: 36px auto;
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.06);
            padding: 22px;
        }
        h1 {
            margin: 0 0 12px 0;
            font-size: 20px;
            text-align: center;
        }
        .grid {
            display: grid;
            grid-template-columns: 170px 1fr;
            gap: 12px 20px;
            align-items: center;
        }
        .label {
            font-weight: 600;
            color: #444;
            font-size: 14px;
        }
        .value {
            padding: 10px 12px;
            background: #fafbff;
            border: 1px solid #e8eaf6;
            border-radius: 6px;
            font-size: 14px;
            word-break: break-all;
        }
        .actions {
            margin-top: 18px;
            text-align: right;
        }
        .btn {
            display: inline-block;
            padding: 8px 14px;
            border-radius: 8px;
            border: none;
            cursor: pointer;
            font-weight: 600;
        }
        .btn-edit { background: #3b82f6; color: white; }
        .btn-back { background:#f1f5f9; color:#111827; margin-right:8px; }
        .meta {
            font-size: 12px;
            color: #6b7280;
            margin-top: 10px;
        }
        /* responsive */
        @media (max-width:480px){
            .grid { grid-template-columns: 1fr; }
            .label { font-size:13px; }
        }
</style>
</head>
<body>
	<div class="container">
        <h1>Thông tin người dùng (User Info)</h1>
        <div class="grid">
            <div class="label">Mã (id)</div>
            <div class="value">${user.id}</div>

            <div class="label">Tên đăng nhập (userName)</div>
            <div class="value">${user.userName}</div>

            <div class="label">Họ và tên (fullName)</div>
            <div class="value">${user.fullName}</div>

            <div class="label">Email (email)</div>
            <div class="value">${user.email}</div>

            <div class="label">Mật khẩu (hash) (passwordHash)</div>
            <div class="value">
                <!-- Không hiển thị hash đầy đủ — chỉ một phần hoặc dấu ☆ để an toàn -->
                <c:choose>
                    <c:when test="${not empty user.passwordHash}">
                        ${fn:substring(user.passwordHash, 0, 6)}... (hash)
                    </c:when>
                    <c:otherwise>—</c:otherwise>
                </c:choose>
            </div>

            <div class="label">Mã vai trò (roleId)</div>
            <div class="value">${user.roleId}</div>

            <div class="label">Trạng thái (isActive)</div>
            <div class="value">
                <c:choose>
                    <c:when test="${user.active or user.isActive}">
                        Đang hoạt động (Active)
                    </c:when>
                    <c:otherwise>Không hoạt động (Inactive)</c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="actions">

            <form action="${pageContext.request.contextPath}/thong-tin" method="get">
                <input type="hidden" name="id" value="${user.id}" />
                <button type="submit" class="btn btn-edit">Sửa thông tin (Edit)</button>
            </form>
        </div>

        <div class="meta">
            Lưu ý: Trường "Mật khẩu (passwordHash)" chỉ hiển thị một phần để bảo mật.  
        </div>
    </div>
</body>
</html>