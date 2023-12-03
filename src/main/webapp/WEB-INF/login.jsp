<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인 템플릿 · Bootstrap v5.3</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        /* 전체적인 스타일링 */
        body {
            background-color: #f8f9fa;
        }
        
        .container {
            max-width: 500px; /* 폼의 최대 너비 설정 */
            margin: 0 auto;
            padding: 20px;
        }
        
        /* 로그인 폼 스타일 */
        .form-signin {
            background-color: #fff;
            padding: 40px; /* 폼의 패딩을 더 크게 늘림 */
            border: 1px solid #ccc;
            border-radius: 10px; /* 모서리를 둥글게 */
        }
        
        .form-signin .form-signin-heading {
            text-align: center;
        }
        
        .form-signin .form-control {
            border-radius: 10px;
            margin-bottom: 15px; /* 입력 필드 간격을 늘림 */
        }
        
        .btn-darkpurple {
            background-color: #6528e0;
            border-color: #6528e0;
            color: #fff;
        }
        
        .btn-darkpurple:hover {
            background-color: #5a23c8;
            border-color: #5a23c8;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin">
        <h4 class="form-signin-heading">푸디 월곡에 오신 것을 환영합니다.</h4>
        <label for="inputEmail" class="sr-only">이메일</label>
        <!-- placeholder 속성에 원하는 플레이스홀더 텍스트를 넣으세요 -->
        <input type="email" id="inputEmail" class="form-control" placeholder="사용자의 이메일 주소가 표시됩니다" required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호</label>
        <!-- placeholder 속성에 원하는 플레이스홀더 텍스트를 넣으세요 -->
        <input type="password" id="inputPassword" class="form-control" placeholder="사용자의 비밀번호가 표시됩니다" required>
        <button class="btn btn-lg btn-darkpurple btn-block" type="submit">로그인하기</button>
       <a href="/customer/findPassword" class="btn btn-lg btn-darkpurple btn-block">비밀번호 찾기</a>
    </form>
</div>
 

    <!-- 부트스트랩 및 자바스크립트 라이브러리 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
   
  
</body>
</html>