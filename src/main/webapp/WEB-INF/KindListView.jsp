<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .restaurant-info {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }

        .line {
            border-top: 1px solid #ccc;
            margin: 10px 0;
        }

        .restaurant-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>

<body>
    <div class="container mt-4">
        <button class="btn btn-primary">종류별 찾기</button>
    </div>

    <div class="container mt-4">
        <div class="restaurant-card">
            <!-- 음식점 정보를 넣어주세요 -->
            <img src="restaurant1.jpg" alt="음식점 사진 1">
            <h4>음식점 이름</h4>
            <p>음식점 주소</p>
        </div>

        <div class="line"></div>

        <div class="restaurant-card">
            <!-- 음식점 정보를 넣어주세요 -->
            <img src="restaurant2.jpg" alt="음식점 사진 2">
            <h4>음식점 이름</h4>
            <p>음식점 주소</p>
        </div>

        <div class="line"></div>

        <!-- 다른 음식점들을 동일한 형식으로 추가하실 수 있습니다. -->
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>

</html>
