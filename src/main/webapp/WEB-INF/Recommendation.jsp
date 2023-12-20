<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>음식 카테고리</title>

    <!-- 부트스트랩 스타일 시트를 로드 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous">

    <!-- 커스텀 스타일 -->
    <style>
        /* 전체 스타일링 */
        body {
            background-color: #f8f9fa;
        }

        /* 카드 스타일 */
        .card {
            border: none;
        }

        /* 상세보기 버튼 스타일 */
        .detail-button {
            position: absolute;
            bottom: 10px;
            right: 10px;
        }
    </style>
</head>

<body>
    <main>
        <section class="py-5 text-center container">
            <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <h1 class="fw-light">추천 음식</h1>
                </div>
            </div>
        </section>

        <hr>

      <h2 class="text-center">사용자 선호 음식</h2>

<div class="album py-5 bg-body-tertiary">
    <div class="container">
        <div class="row row-cols-1 row-cols-md-3 g-3">
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <!-- 이미지 경로를 웹에서 접근 가능한 경로로 수정 -->
                       <img src="/upload/${favoriteCategories[0].categoryId}.png" alt="음식 이미지" width="200"> 
                
                        <p class="card-text">${favoriteCategories[0].categoryName}</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <!-- 이미지 경로를 웹에서 접근 가능한 경로로 수정 -->
                        <img src="/upload/${favoriteCategories[1].categoryId}.png" alt="음식 이미지" width="200">
                        <p class="card-text">${favoriteCategories[1].categoryName}</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <!-- 이미지 경로를 웹에서 접근 가능한 경로로 수정 -->
                        <img src="/upload/${favoriteCategories[2].categoryId}.png" alt="음식 이미지" width="200">
                        <p class="card-text">${favoriteCategories[2].categoryName}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


<hr>
 <h2 class="text-center">사용자 추천 음식점</h2>

<!-- 카테고리 별 음식점 -->
<c:forEach var="category" items="${favoriteCategories}">
    <!-- 카테고리 이름 출력 -->
    <h3>${category.categoryName}</h3>
    
    <!-- 해당 카테고리에 속하는 음식점들 -->
    <div class="album py-5 bg-body-tertiary">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <!-- 해당 카테고리에 속하는 음식점 카드 3개 출력 -->
                <c:forEach var="restaurant" items="${randomRestaurants}">
                    <c:if test="${restaurant.getCategory() eq category.categoryId}">
                        <div class="col">
                            <div class="card shadow-sm">
                                <div class="card-body">
                                    <h5 class="card-title">${restaurant.getName()}</h5>
                                    <p class="card-text">${restaurant.getAddress()}</p>
                                    <!-- 기타 필요한 정보 출력 -->
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</c:forEach>
    </main>

    <!-- 부트스트랩 및 자바스크립트 라이브러리 로드 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>