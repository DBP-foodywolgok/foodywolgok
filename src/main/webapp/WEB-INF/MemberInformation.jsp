<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원 정보</title>

    <!-- 부트스트랩 스타일 시트를 로드 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous">

    <style>
        /* 추가적인 스타일링을 필요한 경우 여기에 추가합니다. */
        .form-container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f8f8f8;
        }

        /* 텍스트와 입력 필드를 가운데 정렬하는 스타일 */
        .text-center {
            text-align: center;
        }

        .btn-purple {
            background-color: purple;
            border-color: purple;
            color: white;
        }

        .btn-purple:hover {
            background-color: darkpurple;
            border-color: darkpurple;
        }
    </style>
</head>

<body>
    <div class="container text-center">
        <h1>회원 정보</h1>
        <form class="form-container" action="changeInformation.jsp" method="post">
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="회원의 이름이 표시됨" required>
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="회원의 이메일이 표시됨" required>
            </div>
            <div class="form-group">
                <label for="favoriteFood">선호하는 음식 종류</label>
                <input type="text" class="form-control" id="favoriteFood" name="favoriteFood" placeholder="회원이 선호하는 음식 종류가 표현됨">
            </div>
            <button type="button" class="btn btn-lg btn-primary btn-purple">확인</button>
            <button type="submit" class="btn btn-lg btn-primary btn-purple">정보 변경하기</button>
        </form>
    </div>

    <!-- 부트스트랩 및 자바스크립트 라이브러리 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>