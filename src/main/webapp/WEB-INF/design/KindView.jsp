<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .category-button {
            width: 100%;
            height: 60px;
            margin-bottom: 30px; /* 간격 조절 */
            background-color: #007bff;
            color: #fff;
            font-size: 1.5em;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 50px; /* 동그랗게 만들기 */
        }
    </style>
</head>

<body>
    <div class="container mt-4 text-center">
        <button class="btn btn-primary mb-4">종류별 찾기</button>
        <div class="category-button">한식</div>
        <div class="category-button">양식</div>
        <div class="category-button">아시아</div>
        <div class="category-button">일식</div>
        <div class="category-button">중식</div>
        <div class="category-button">분식</div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
