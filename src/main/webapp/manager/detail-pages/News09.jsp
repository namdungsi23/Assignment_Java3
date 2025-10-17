<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>DeepSeek tung V3.2-Exp xử lý văn bản dài, giá API rẻ hơn 50%</title>
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

    <h1>DeepSeek tung V3.2-Exp xử lý văn bản dài, giá API rẻ hơn 50%</h1>
    <div class="date">Ngày đăng: 30/09/2025</div>
    <img src="<%=request.getContextPath()%>/manager/img/news09.png" alt="DeepSeek V3.2-Exp">

    <div class="content">
        Ngày 29-9, Công ty công nghệ DeepSeek (Trung Quốc) công bố mô hình AI thử nghiệm mới mang tên DeepSeek-V3.2-Exp, tập trung phát triển khả năng xử lý văn bản dài và giảm chi phí tính toán.  

        Điểm nổi bật của V3.2-Exp là cơ chế Sparse Attention, chọn vùng thông tin cần tập trung để giảm tải tính toán, tiết kiệm GPU và tăng tốc suy luận. Giá API dự kiến rẻ hơn 50% so với trước đây, giúp DeepSeek cạnh tranh với các đối thủ như OpenAI, Alibaba hay Baidu, đặc biệt trong nhóm doanh nghiệp vừa và nhỏ.  

        Mô hình phù hợp với các ứng dụng doanh nghiệp và dịch vụ: trợ lý số đọc tài liệu, hỗ trợ lập trình với ngữ cảnh mã nguồn phức tạp, phân tích dữ liệu chuyên ngành, vận hành chatbot duy trì hội thoại dài, hoặc tạo nội dung dài với độ nhất quán cao.  

        DeepSeek gọi V3.2-Exp là "bước trung gian" để thử nghiệm kiến trúc mới, thu thập phản hồi và tiếp tục đầu tư R&D trước khi tung phiên bản hoàn thiện.
    </div>

    <jsp:include page="/manager/footer.jsp" />

</body>
</html>
