<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>

    <!-- 부트스트랩 스타일 시트를 로드 -->
    <link href="https://getbootstrap.kr/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
          
    <!-- 커스텀 스타일 -->
    <style>
        /* 페이지 스타일 */
        body {
            background-color: #f8f9fa;
        }

        .container {
            max-width: 800px; /* 폼의 크기를 조정할 수 있습니다. */
            margin: 0 auto;
            padding: 20px;
        }

        /* 양식 스타일 */
        .form-signin {
            background-color: #fff;
            padding: 40px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }

        .form-signin .form-signin-heading {
            text-align: center;
        }

        .form-signin .form-control {
            border-radius: 10px;
            margin-bottom: 15px;
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
<div class="container">

<form class="form-signin" method="post" action="<c:url value='/customer/register' />">
        <h2 class="form-signin-heading text-center">회원 가입</h2>

      <!-- 이름 입력 필드 -->
<label for="inputName" class="visually-hidden">이름</label>
<input type="text" id="inputName" name="inputName" class="form-control" placeholder="이름" required autofocus>

<!-- 이메일 입력 필드 -->
<label for="inputEmail" class="visually-hidden">이메일 주소</label>
<input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="이메일 주소" required>

<!-- 비밀번호 입력 필드 -->
<label for="inputPassword" class="visually-hidden">비밀번호</label>
<input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="비밀번호" required>

<!-- 비밀번호 재입력 필드 -->
<label for="inputConfirmPassword" class="visually-hidden">비밀번호 확인</label>
<input type="password" id="inputConfirmPassword" name="inputConfirmPassword" class="form-control" placeholder="비밀번호 확인" required>

        <!-- 선호하는 음식 종류 선택 -->
        <label class="visually-hidden">선호하는 음식 종류</label>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType1" value="한식">
            <label class="form-check-label" for="foodType1">한식</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType2" value="중식">
            <label class="form-check-label" for="foodType2">중식</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType3" value="양식">
            <label class="form-check-label" for="foodType3">양식</label>
        </div>
        <!-- 나머지 음식 종류 체크박스 추가 -->
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType4" value="퓨전요리">
            <label class="form-check-label" for="foodType4">퓨전요리</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType5" value="태국식">
            <label class="form-check-label" for="foodType5">태국식</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType6" value="샐러드">
            <label class="form-check-label" for="foodType6">샐러드</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType7" value="죽">
            <label class="form-check-label" for="foodType7">죽</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType8" value="디저트">
            <label class="form-check-label" for="foodType8">디저트</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="foodType9" value="음료">
            <label class="form-check-label" for="foodType9">음료</label>
        </div>

        <!-- 회원 가입 버튼 -->
        <button class="btn btn-lg btn-primary btn-block btn-purple" type="submit">회원 가입</button>
    </form>
</div>

<!-- 부트스트랩 및 자바스크립트 라이브러리 로드 -->
<script src="https://getbootstrap.kr/docs/5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>