<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.dao.RestaurantDAO" %>
<%@ page import="model.Wishlist" %>
<%@ page import="model.Restaurant" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
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
        <form class="form-signin" method="post" action="/restaurant/search">
            <div class="input-group mb-3 rounded">
                <button class="btn btn-outline-secondary rounded" type="button" id="backButton">
                    <i class="fas fa-arrow-left"></i>
                </button>
                <input type="text" class="form-control border-0 rounded-start" name="searchKeyword" placeholder="음식점, 주소를 검색하세요" aria-label="Search" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-primary rounded-end">검색</button>
                </div>
            </div>
        </form>
    </div>

    <div class="container text-center">
        <div class="row">
            <div class="col-md-2 mx-auto">
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

    <!-- 지도를 표시할 div -->
	<div id="map" style="height: 600px;"></div>
	<!-- Bootstrap JS 추가 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

	<script>
	function initMap() {
	    var mapOptions = {
	        center: { lat: 37.6068163, lng: 127.0423832 },
	        zoom: 15
	    };

	    var map = new google.maps.Map(document.getElementById("map"), mapOptions);

	    <c:forEach var="restaurant" items="${restaurants}">
	        var restaurantLocation = new google.maps.LatLng(${restaurant.latitude}, ${restaurant.longitude});
	        var marker = new google.maps.Marker({
	            position: restaurantLocation,
	            map: map,
	            title: "${restaurant.name}"
	        });
	    </c:forEach>
	}
	</script>
	<script
  defer
  src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCDQm_zM-xWsN7J4X6_hSp2S9-YQjH--3A&callback=initMap"
></script>
</body>
</html>
