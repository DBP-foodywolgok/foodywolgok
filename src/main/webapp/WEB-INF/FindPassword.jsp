<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>비밀번호 찾기</title>
    
    <!-- 부트스트랩 스타일 시트를 로드 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    
    <!-- 커스텀 스타일 -->
    <style>
        /* 전체적인 스타일링 */
        body {
            background-color: #f8f9fa;
        }
        
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        
        /* 폼 스타일 */
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
        
        .btn-darkpurple {
            background-color: #6528e0;
            border-color: #6528e0;
            color: #fff;
        }
        
        .btn-darkpurple:hover {
            background-color: #5a23c8;
            border-color: #5a23c8;
        }
        
        /* 추가적인 커스텀 스타일링 */
        .rounded-input {
            border-radius: 10px;
        }

        .top-aligned-text {
            margin-bottom: 10px;
        }

        .text-center {
            text-align: center;
        }

        .center-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        
        .btn-purple {
            background-color: purple;
            border-color: purple;
        }

        .btn-purple a {
            color: white;
        }

        .btn-purple:hover {
            background-color: darkpurple;
            border-color: darkpurple;
        }
    </style>
</head>
<body>
    <div class="container center-container">
        <form class="form-signin" method="post" action="/customer/findPasswordByEmail">
            <h4 class="form-signin-heading text-center top-aligned-text">가입하신 이메일을 입력해주세요</h4>
            <label for="inputEmail" class="sr-only">이메일</label>
            <input type="text" id="findPasswordByEmail" name="findPasswordByEmail" class="form-control rounded-input" placeholder="이메일 주소" required="" autofocus="">
               <%   String password = (String) request.getAttribute("resultEmail"); %>
            <label for="inputPassword" class="sr-only">사용자의 비밀번호</label>
    <input type="text" id="resultEmail" name="resultEmail" class="form-control rounded-input" placeholder="비밀번호가 표시됩니다" value="<%= password %>" autofocus="">
            <div class="checkbox">
                <div style="margin-bottom: 20px;"></div>
                <label>
                          <button class="btn btn-primary" type="submit">비밀번호 찾기</button>
                             <a href="/customer/main" class="btn btn-primary" style="margin-left: 10px;">메인으로 이동</a>
                </label>
            </div>
         
        </form>
    </div>

    <!-- 부트스트랩 및 자바스크립트 라이브러리 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>