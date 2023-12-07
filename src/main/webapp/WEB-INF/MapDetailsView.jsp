<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Restaurant" %>
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
    
    <div class="container-fluid d-flex align-items-end justify-content-center fixed-bottom">
        <div class="restaurant-info">
            <% 
            Restaurant restaurant = (Restaurant)request.getAttribute("restaurant");
            if(restaurant != null) {
            %>
            <div class="restaurant-name"><%= restaurant.getName() %></div>
            <div class="restaurant-intro"><%= restaurant.getIntroduction() %></div>
            <div class="restaurant-name"><%= restaurant.getAddress() %></div>
            <% } else { %>
            <div class="no-result">
                음식점 정보를 불러올 수 없습니다.
            </div>
            <% } %>
        </div>
    </div>

    <!-- 지도를 표시할 div 추가 -->
    <div id="map" style="height: 600px;"></div>

    <!-- Bootstrap JS 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <!-- 네이버 지도 API 추가 -->
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=YOUR_CLIENT_ID"></script>

    <!-- 지도를 표시하는 스크립트 추가 -->
    <script>
      var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(37.600231, 127.048681), // 하월곡동과 상월곡동 중심
    zoom: 14 // 확대 수준
});
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>