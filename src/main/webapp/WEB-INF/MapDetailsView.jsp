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
        <div class="col-md-2 mx-auto">
            <a href="/kindlist?category=한식" class="btn btn-primary" role="button">한식</a>
        </div>
        <!-- 다른 버튼들도 동일하게 추가 -->
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

<!-- 지도를 표시할 div -->
<div id="map" style="height: 600px;"></div>

<!-- Bootstrap JS 추가 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- Google Maps API 초기화 및 지도 표시를 위한 JavaScript -->
<script>
  // Google Maps 초기화
function initMap() {
  // 중심 좌표와 줌 레벨 설정
  var mapOptions = {
    zoom: 20 // 이 값은 지도의 초기 줌 레벨입니다. 필요에 따라 조정할 수 있습니다.
  };

  // restaurant 객체로부터 위도(latitude)와 경도(longitude) 가져오기
  var latitude = ${restaurant.latitude}; // restaurant 객체의 위도 속성
  var longitude = ${restaurant.longitude}; // restaurant 객체의 경도 속성

  // 위도와 경도를 LatLng 객체로 변환
  var restaurantLocation = new google.maps.LatLng(latitude, longitude);

  // 중심 좌표를 restaurant의 위치로 설정
  mapOptions.center = restaurantLocation;

  // 'map'이라는 ID를 가진 div에 지도 표시
  var map = new google.maps.Map(document.getElementById("map"), mapOptions);

}

</script>
<!-- Google Maps API를 호출하여 initMap 함수를 실행 -->
<script
  defer
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCDQm_zM-xWsN7J4X6_hSp2S9-YQjH--3A&callback=initMap"
></script>
</body>
</html>
