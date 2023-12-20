<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <c:if test="${not empty sessionScope.customerName}">
        <div class="container">
            <p>${sessionScope.customerName}!</p>
        </div>
    </c:if>

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

    <div class="container mt-4">
        <div class="row">
            <div class="col-md-12">
                <h3>검색 결과</h3>
                <hr>
                <div class="result-list" id="resultList">
                    <c:choose>
                        <c:when test="${not empty searchedRestaurants}">
                            <c:forEach items="${searchedRestaurants}" var="restaurant">
                                <form class="restaurant-info" method="post" action="/restaurant/view">
                                    <input type="hidden" name="id" value="${restaurant.restaurant_id}">
                                    <button type="submit" style="background: none; border: none; cursor: pointer;">
                                        ${restaurant.name} <i class="bi bi-star-fill text-warning"></i><br>주소: ${restaurant.address}
                                    </button>
                                </form>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="no-result">
                                검색 결과가 없습니다.
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
