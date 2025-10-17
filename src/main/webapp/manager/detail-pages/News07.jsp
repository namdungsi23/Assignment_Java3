<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>TP.HCM triển khai ứng dụng tương tác EDUi của ngành giáo dục</title>
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

    <h1>TP.HCM triển khai ứng dụng tương tác EDUi của ngành giáo dục</h1>
    <div class="date">Ngày đăng: 30/09/2025</div>
    <img src="<%=request.getContextPath()%>/manager/img/news07.jpg" alt="Ứng dụng tương tác EDUi">

    <div class="content">
        Ứng dụng tương tác EDUi được triển khai tại các cơ sở giáo dục TP.HCM theo 3 giai đoạn trong năm học 2025-2026 trên nền tảng iOS và Android.  

        Giai đoạn 1: tập huấn triển khai EDUi tại các cơ sở giáo dục.  
        Giai đoạn 2: tổ chức lễ công bố bàn giao hệ thống ứng dụng EDUi.  
        Giai đoạn 3: hoàn thiện yêu cầu trong quá trình triển khai thực tế (tháng 9-10/2025).  

        Các chức năng miễn phí gồm: cung cấp tin tức, sự kiện; khảo sát công khai; tra cứu kết quả học tập; thông tin giáo dục; gửi yêu cầu nghỉ học; xem thời khóa biểu và ký sổ đầu bài số.  

        Các chức năng quản lý có tính phí gồm: thanh toán học phí trực tuyến qua QR; xây dựng và chia sẻ kho học liệu; liên lạc giáo viên - phụ huynh - nhà trường; quản lý thông tin học sinh, điểm danh, chuyên cần, vi phạm.  

        Ngoài ra, các tính năng như thư viện số, quản lý thiết bị cơ sở vật chất, y tế học đường, theo dõi bài tập, tổ chức họp trực tuyến và ứng dụng AI trong dạy học cũng sẽ được tính phí theo quy định.
    </div>

    <jsp:include page="/manager/footer.jsp" />

</body>
</html>
