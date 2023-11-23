<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <!-- 부트스트랩 CSS 링크 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <title>마이페이지</title>
  <!-- 추가 스타일 -->
  <style>
    .pager li {
      margin-bottom: 10px; /* 버튼 간격 조절 */
    }
    .pager a {
      display: block;
      padding: 10px 20px; /* 버튼 크기 조절 */
    }
    .center-text {
      text-align: center; /* 텍스트 가운데 정렬 */
    }
  </style>
</head>
<body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  <div class="center-text">
    <h1>마이페이지</h1>
    <nav>
      <ul class="pager">
        <li><a href="#">회원 정보</a></li>
        <br> <!-- 줄 바꿈 추가 -->
        <br>
        <li><a href="#">비밀번호 변경</a></li>
        <br> <!-- 줄 바꿈 추가 -->
        <br>
        <li><a href="#">친구 리스트 조회</a></li>
        <br> <!-- 줄 바꿈 추가 -->
        <br>
        <li><a href="#">로그아웃</a></li>
      </ul>
    </nav>
  </div>
</body>
</html>