<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Lùi thời hạn chuyển đổi tài khoản giao thông của người nước ngoài, doanh nghiệp hết ngày 31-12</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0 auto; width: 80%; line-height: 1.6; }
        h1 { color: #003366; margin-top: 30px; }
        img { width: 100%; max-width: 800px; display: block; margin: 20px auto; border-radius: 10px; }
        .date { color: gray; font-size: 14px; margin-bottom: 10px; }
        .content { text-align: justify; }
        .back-btn {
            display: inline-block; margin-top: 30px; padding: 10px 20px;
            background-color: #0056b3; color: white; text-decoration: none;
            border-radius: 6px; transition: background 0.3s;
        }
        .back-btn:hover { background-color: #003d80; }
    </style>
</head>
<body>


    <h1>Lùi thời hạn chuyển đổi tài khoản giao thông của người nước ngoài, doanh nghiệp hết ngày 31-12</h1>
    <div class="date">Ngày đăng: 30/09/2025</div>
    <img src="<%=request.getContextPath()%>/manager/img/news01.jpg" alt="Chuyển đổi tài khoản giao thông">

    <div class="content">
        Theo Cục Đường bộ Việt Nam, hiện nhiều người nước ngoài, doanh nghiệp còn gặp khó khăn trong chuyển đổi tài khoản thu phí sang tài khoản giao thông kết nối với phương tiện thanh toán.  

        Việc lùi thời hạn nói trên nhằm tránh nguy cơ ùn tắc ở các trạm thu phí, ảnh hưởng tới đi lại và vận chuyển, cung ứng các hàng hóa thiết yếu phục vụ nhân dân.  

        Tính đến 30-9, các đơn vị thống kê về cơ bản các tài khoản thu phí đã được chuyển đổi thành tài khoản giao thông, tuy nhiên mới có hơn 3 triệu/tổng số 5,8 triệu tài khoản giao thông kết nối với phương tiện thanh toán không dùng tiền mặt.  

        Còn khoảng 2,8 triệu tài khoản giao thông chưa thực hiện kết nối với phương tiện thanh toán không dùng tiền mặt, trong đó có gần 170.000 tài khoản của doanh nghiệp vận tải.  

        Nguyên nhân khó khăn là ví điện tử cho doanh nghiệp chưa được cung cấp rộng rãi; thẻ tín dụng kết nối với tài khoản giao thông phải chịu phí cao (1-2%).  

        Để tháo gỡ, Cục Đường bộ Việt Nam yêu cầu các nhà cung cấp dịch vụ tiếp tục sử dụng tài khoản thu phí hiện hành đối với các trường hợp chưa hoàn tất chuyển đổi đến hết 31-12.
    </div>


    <jsp:include page="/manager/footer.jsp" />

</body>
</html>
