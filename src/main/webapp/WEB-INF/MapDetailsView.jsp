<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Restaurant" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>식당 정보</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .restaurant-info {
            background-color: #87CEEB;
            padding: 40px;
            width: 80%;
            margin: auto;
        }
        .restaurant-name {
            font-size: 4em;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .restaurant-intro {
            font-size: 2.4em;
            margin-bottom: 20px;
        }
        .restaurant-photos img {
            max-width: 90%;
            margin-right: 20px;
        }
    </style>
</head>
<body>
<c:if test="${not empty sessionScope.customerName}">
        <div class="container mt-4">
            <div class="row align-items-center">
                <div class="col-md-6">
                    <p>${sessionScope.customerName}님!</p>
                </div>
                <div class="col-md-6 text-end">
                    <form class="form-signin" method="post" action="/restaurant/viewWishList">
                        <button class="btn btn-primary rounded" type="submit">
                            위시리스트 보기
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </c:if>

<div class="container mt-4">
    <div class="input-group mb-3 rounded">
        <button class="btn btn-outline-secondary rounded" type="button" id="backButton">
            <i class="fas fa-arrow-left"></i>
        </button>
        <script>
            document.getElementById("backButton").addEventListener("click", function() {
                window.history.back(); // 브라우저의 뒤로 가기 기능 실행
            });
        </script>
        <input type="text" class="form-control border-0 rounded-start" placeholder="음식점, 주소를 검색하세요" aria-label="Search" aria-describedby="basic-addon2">
        <div class="input-group-append">
            <button class="btn btn-primary rounded-end" type="button">검색</button>
        </div>
    </div>
</div>

<div class="container text-center">
    <div class="row">
        <div class="col-md-2 mx-auto"> <!-- col 클래스로 간격을 조절하고 mx-auto로 가운데 정렬 -->
            <a href="/kindlist?category=한식" class="btn btn-primary" role="button">한식</a>
        </div>
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=양식" class="btn btn-primary" role="button">양식</a>
        </div>
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=아시아" class="btn btn-primary" role="button">아시아</a>
        </div>
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=일식" class="btn btn-primary" role="button">일식</a>
        </div>
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=중식" class="btn btn-primary" role="button">중식</a>
        </div>
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=분식" class="btn btn-primary" role="button">분식</a>
        </div>
    </div>
</div>

<div class="restaurant-info">
    <c:if test="${not empty restaurant and not empty isInWishlist}">
        <c:set var="starClass" value="${isInWishlist ? 'fas' : 'far'}" />
        <a href="/restaurant/chooseWishList?id=${restaurant.restaurant_id}">
            <!-- 별표 아이콘 -->
            <i class="${starClass} fa-star" id="wishlistStar" data-restaurant-id="${restaurant.restaurant_id}"></i>
            <div class="restaurant-name">${restaurant.name}</div>
            <div class="restaurant-intro">${restaurant.introduction}</div>
            <div class="restaurant-name">${restaurant.address}</div>
        </a>
    </c:if>
</div>

<!-- 지도를 표시할 div 추가 -->
<div id="map" style="height: 600px; margin: 0 auto; text-align: center;">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3160.901990278006!2d127.03975467629151!3d37.60446562195151!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357cbb7e4d2a422d%3A0x91b78f50c2063ab!2z7Yag66as64-I6rmM7Iqk!5e0!3m2!1sko!2skr!4v1703099804155!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</div>

<!-- Bootstrap JS 추가 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
