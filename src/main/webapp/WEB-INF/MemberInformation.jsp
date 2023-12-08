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
                <input type="text" class="form-control" id="name" name="name" placeholder="회원의 이름이 표시됨"
                    value="${customer.name}" required>
                <!-- Assuming 'name' is a property in your Customer model -->
            </div>
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="회원의 이메일이 표시됨"
                    value="${customer.email}" required>
                <!-- Assuming 'email' is a property in your Customer model -->
            </div>
            <!-- 9개의 음식 종류 체크박스 -->
            <div class="form-group checkbox-group text-left">
                <label>선호하는 음식 종류</label>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType1" name="foodType1" value="한식">
                    <label class="form-check-label" for="foodType1">한식</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType2" name="foodType2" value="중식">
                    <label class="form-check-label" for="foodType2">중식</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType3" name="foodType3" value="양식">
                    <label class="form-check-label" for="foodType3">양식</label>
                </div>
                <!-- 나머지 음식 종류 체크박스 -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType4" name="foodType4" value="퓨전요리">
                    <label class="form-check-label" for="foodType4">퓨전요리</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType5" name="foodType5" value="태국식">
                    <label class="form-check-label" for="foodType5">태국식</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType6" name="foodType6" value="샐러드">
                    <label class="form-check-label" for="foodType6">샐러드</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType7" name="foodType7" value="죽">
                    <label class="form-check-label" for="foodType7">죽</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType8" name="foodType8" value="디저트">
                    <label class="form-check-label" for="foodType8">디저트</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="foodType9" name="foodType9" value="음료">
                    <label class="form-check-label" for="foodType9">음료</label>
                </div>
            </div>
            <!-- 버튼 -->
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