<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }
    body {
        background: #f53d2d;
    }
    .container {
        width: 100%;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .register-box {
        width: 900px;
        height: 550px;
        background: #fff;
        display: flex;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 4px 12px rgba(0,0,0,0.2);
    }
    .left {
        flex: 1;
        background: url('https://cf.shopee.vn/file/sg-11134201-7rd5w-ltkb7we8f9gve3') center center no-repeat;
        background-size: cover;
    }
    .right {
        flex: 1;
        padding: 40px;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    .right h2 {
        margin-bottom: 25px;
        color: #333;
        font-size: 24px;
    }
    .input-box {
        margin-bottom: 15px;
    }
    .input-box input {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }
    .register-btn {
        width: 100%;
        padding: 12px;
        background: #f53d2d;
        color: #fff;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 10px;
    }
    .register-btn:hover {
        background: #d73225;
    }
    .links {
        margin-top: 15px;
        text-align: center;
    }
    .links a {
        color: #f53d2d;
        text-decoration: none;
        margin: 0 8px;
        font-size: 14px;
    }
    .links a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="register-box">
            <!-- Cột bên trái -->
            <div class="left"></div>

            <!-- Cột bên phải -->
            <div class="right">
                <h2>Tạo tài khoản</h2>
                <form action="${pageContext.request.contextPath}/registerbao" method="post">
                    <div class="input-box">
                        <input type="text" name="fullname" placeholder="Họ và tên" required>
                    </div>
                    <div class="input-box">
                        <input type="text" name="username" placeholder="Tên đăng nhập" required>
                    </div>
                    <div class="input-box">
                        <input type="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="input-box">
                        <input type="password" name="password" placeholder="Mật khẩu" required>
                    </div>
                    <div class="input-box">
                        <input type="password" name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
                    </div>
                    <button type="submit" class="register-btn">Đăng ký</button>
                </form>

                <div class="links">
                    <span>Đã có tài khoản?</span>
                    <a href="login.jsp">Đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
