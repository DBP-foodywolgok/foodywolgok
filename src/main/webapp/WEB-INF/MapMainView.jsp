<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>

<body>
  <% 
        String customerName = (String) session.getAttribute("customerName");
        if (customerName != null) {
    %>
            <div class="container">
                <p><%= customerName %>!</p>
            </div>
    <% 
        }
    %>
    <div class="container mt-4">
 	   <form class="form-signin" method="post" action="/restaurant/search">
	        <div class="input-group mb-3 rounded">
	            <button class="btn btn-outline-secondary rounded" type="button" id="backButton">
				    <i class="fas fa-arrow-left"></i>
				</button>
				<script>
				    document.getElementById("backButton").addEventListener("click", function() {
				        window.history.back(); // 브라우저의 뒤로 가기 기능 실행
				    });
				</script>
	            <input type="text" class="form-control border-0 rounded-start" name="searchKeyword" placeholder="음식점, 주소를 검색하세요" aria-label="Search" aria-describedby="basic-addon2">
	            <div class="input-group-append">
		             <button type="submit" class="btn btn-primary rounded-end">검색</button>
	            </div>
	        </div>
	        </form>
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

    <!-- 지도를 표시할 div 추가 -->
    <div id="map" style="height: 600px; margin: 0 auto; text-align: center;">
    	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3160.8019231069825!2d127.03980290993829!3d37.60682052170297!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357cbb7f99870231%3A0x385ba8fa17b75534!2z64-Z642V7Jes7J6Q64yA7ZWZ6rWQ!5e0!3m2!1sko!2skr!4v1702763149423!5m2!1sko!2skr" width="700" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>

    <!-- Bootstrap JS 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html> 