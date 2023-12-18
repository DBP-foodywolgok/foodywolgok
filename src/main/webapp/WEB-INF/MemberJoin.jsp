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

<form class="form-signin" method="post" action="/customer/register" id="registrationForm">
    <h2 class="form-signin-heading text-center">회원 가입</h2>

    <label for="inputName" class="visually-hidden">이름</label>
    <input type="text" id="inputName" name="inputName" class="form-control" placeholder="이름" required autofocus>

    <label for="inputEmail" class="visually-hidden">이메일 주소</label>
    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="이메일 주소" required>

    <label for="inputPassword" class="visually-hidden">비밀번호</label>
    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="비밀번호" required>

    <label for="inputConfirmPassword" class="visually-hidden">비밀번호 확인</label>
    <input type="password" id="inputConfirmPassword" name="inputConfirmPassword" class="form-control" placeholder="비밀번호 확인" required>

    <!-- 선호하는 음식 종류 선택 -->
    <label class="visually-hidden">선호하는 음식 종류</label>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType1" value="한식">
        <label class="form-check-label" for="foodType1">한식</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType2" value="중식">
        <label class="form-check-label" for="foodType2">중식</label>
    </div>
    <!-- 나머지 음식 종류 체크박스들 -->
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType3" value="양식">
        <label class="form-check-label" for="foodType3">양식</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType4" value="퓨전요리">
        <label class="form-check-label" for="foodType4">퓨전요리</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType5" value="태국식">
        <label class="form-check-label" for="foodType5">태국식</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType6" value="샐러드">
        <label class="form-check-label" for="foodType6">샐러드</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType7" value="죽">
        <label class="form-check-label" for="foodType7">죽</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType8" value="디저트">
        <label class="form-check-label" for="foodType8">디저트</label>
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType9" value="음료">
        <label class="form-check-label" for="foodType9">음료</label>
    </div>
    
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType10" value="아시아">
        <label class="form-check-label" for="foodType10">아시아</label>
    </div>
    
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType11" value="일식">
        <label class="form-check-label" for="foodType11">일식</label>
    
    </div>
    <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType12" value="분식">
        <label class="form-check-label" for="foodType12">분식</label>
    </div>
    
     <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType13" value="치킨">
        <label class="form-check-label" for="foodType13">치킨</label>
    </div>
     <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType14" value="고기">
        <label class="form-check-label" for="foodType14">고기</label>
    </div>
     <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType15" value="패스트푸드">
        <label class="form-check-label" for="foodType15">패스트푸드</label>
    </div>
     <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType16" value="족발">
        <label class="form-check-label" for="foodType16">족발</label>
    </div>
     <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType17" value="야식">
        <label class="form-check-label" for="foodType17">야식</label>
    </div>
        <div class="form-check">
        <input class="form-check-input" name="foodType" type="checkbox" id="foodType18" value="주점">
        <label class="form-check-label" for="foodType18">주점</label>
    </div>
    
    

    <!-- 선택한 카테고리들을 저장할 hidden input -->
    <input type="hidden" id="selectedCategoriesInput" name="selectedCategories" value="">

    <button class="btn btn-lg btn-primary btn-block btn-purple" type="button" onclick="submitForm()">회원 가입</button>
</form>
</div>

<script src="https://getbootstrap.kr/docs/5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

<script>
function submitForm() {
    let selectedCategories = [];
    let checkboxes = document.querySelectorAll('input[name="foodType"]:checked');
    checkboxes.forEach((checkbox) => {
        selectedCategories.push(checkbox.value);
    });

    // 여러 체크박스의 값을 콤마로 구분하여 하나의 문자열로 만들어 hidden input에 저장
    let selectedCategoriesInput = document.getElementById('selectedCategoriesInput');
    selectedCategoriesInput.value = selectedCategories.join(',');

    document.getElementById('registrationForm').submit();
}
</script>
</body>
</html>