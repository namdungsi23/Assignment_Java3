<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cần Thơ hoàn thành bệnh án điện tử, yêu cầu bỏ sổ khám bệnh giấy</title>
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

    <h1>Cần Thơ hoàn thành bệnh án điện tử, yêu cầu bỏ sổ khám bệnh giấy</h1>
    <div class="date">Ngày đăng: 30/09/2025</div>
    <img src="<%=request.getContextPath()%>/manager/img/news06.jpg" alt="Bệnh án điện tử Cần Thơ">

    <div class="content">
        PGS.TS Hoàng Quốc Cường - Giám đốc Sở Y tế thành phố Cần Thơ - cho biết 61 cơ sở y tế đã hoàn thành hồ sơ bệnh án điện tử và kết nối vào cơ sở dữ liệu dùng chung của y tế quốc gia.  

        Thành quả này giúp người bệnh tiết kiệm thời gian đi lại, giảm chi phí chụp chiếu lặp lại và thuận tiện tiếp cận dịch vụ trong suốt quá trình điều trị.  

        Dù hoàn thành bệnh án điện tử, hiện các cơ sở y tế vẫn còn song song bệnh án giấy; cơ quan bảo hiểm y tế vẫn thanh toán trên cơ sở bệnh án giấy. Ngành y tế Cần Thơ đề xuất liên thông hoàn toàn thanh toán bảo hiểm y tế trên hồ sơ điện tử từ ngày 31-12.  

        Trong thời gian này, Sở Y tế yêu cầu các bệnh viện không được yêu cầu người bệnh dùng sổ khám bệnh giấy; toàn bộ việc đăng ký khám bệnh thực hiện qua VNeID.  

        Hệ thống bệnh án điện tử hỗ trợ quản lý đồng bộ về nhân lực, trang thiết bị, tài chính, chia sẻ dữ liệu với các hệ thống quốc gia, nâng cao chất lượng chẩn đoán và điều trị.  

        Bà Nguyễn Thị Ngọc Điệp - Phó chủ tịch UBND TP Cần Thơ - nhấn mạnh thành quả này hướng tới mục tiêu "y tế không giấy tờ", tăng tính minh bạch, giảm thủ tục hành chính và tiết kiệm chi phí cho người dân.  

        Bà Điệp chỉ đạo bồi dưỡng nâng cao trình độ ứng dụng công nghệ thông tin cho đội ngũ y, bác sĩ và nhân viên y tế để duy trì hiệu quả bệnh án điện tử.
    </div>

    <jsp:include page="/manager/footer.jsp" />

</body>
</html>
