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

        .result-list hr {
            border-top: 1px solid #ccc;
        }
    </style>
</head>

<body>
    <div class="container mt-4">
        <div class="input-group mb-3 rounded">
            <button class="btn btn-outline-secondary rounded" type="button" id="backButton">
                <i class="fas fa-arrow-left"></i>
            </button>
            <input type="text" class="form-control border-0 rounded-start" placeholder="음식점, 주소를 검색하세요" aria-label="Search" aria-describedby="basic-addon2" id="searchInput">
            <div class="input-group-append">
                <button class="btn btn-primary rounded-end" type="button" onclick="searchRestaurants()">검색</button>
            </div>
        </div>
    </div>

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-12">
                <h3>검색 결과</h3>
                <hr>
                <div class="result-list" id="resultList">
                    <!-- 검색 결과가 여기에 동적으로 추가됩니다 -->
                    <div class="restaurant-info" onclick="showDetails('음식점 이름', '음식점 주소')">음식점 이름: [음식점 이름]<br>주소: [음식점 주소]</div>
                    <hr>
                    <div class="restaurant-info" onclick="showDetails('음식점 이름', '음식점 주소')">음식점 이름: [음식점 이름]<br>주소: [음식점 주소]</div>
                    <hr>
                    <div class="restaurant-info" onclick="showDetails('음식점 이름', '음식점 주소')">음식점 이름: [음식점 이름]<br>주소: [음식점 주소]</div>
                    <hr>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    
    <script>
        function searchRestaurants() {
            var searchInput = document.getElementById('searchInput').value;
            var resultList = document.getElementById('resultList');
            resultList.innerHTML = '';

            // 여기에 검색 결과를 받아와서 동적으로 추가하는 코드를 작성합니다.
            // 예시: resultList.innerHTML += '<div class="restaurant-info">음식점 이름: [음식점 이름]<br>주소: [음식점 주소]</div>';
        }
        function showDetails(name, address) {
            // 해당 음식점의 디테일한 정보를 보여주는 페이지로 이동
            window.location.href = '/restaurant/view?name=' + encodeURIComponent(name) + '&address=' + encodeURIComponent(address);
        }
    </script>
</body>
</html>
