<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.dao.RestaurantDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .restaurant-info {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
            width: 80%;
            text-align: center;
        }

        .line {
            border-top: 1px solid #ccc;
            margin: 10px 0;
            width: 80%;
        }

        h4 {
            font-size: 2em; /* 위시리스트 목록을 2배 크기로 설정 */
        }

        p {
            font-size: 1.2em;
        }

        /* 위시리스트 추가 버튼 */
        .wishlist-button {
            width: 200px; /* 버튼의 너비를 설정 */
            border-radius: 20px; /* 둥근 모양 */
            padding: 10px;
            font-size: 1.2em;
        }
    </style>
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
        <a href="/restaurant/kindview" class="btn btn-primary">종류별 찾기</a>
        <button class="btn btn-outline-secondary rounded" type="button" id="backButton">
            <i class="fas fa-arrow-left"></i>
        </button>
        <script>
            document.getElementById("backButton").addEventListener("click", function() {
                window.history.back(); // 브라우저의 뒤로 가기 기능 실행
            });
        </script>
    </div>
    <div class="container mt-4">
        <%
            List<Restaurant> categoryRestaurants = (List<Restaurant>) request.getAttribute("categoryRestaurants");
            if (categoryRestaurants != null && !categoryRestaurants.isEmpty()) {
                for (Restaurant restaurant : categoryRestaurants) {
            %>
            <div class="restaurant-info">
                <h4><%= restaurant.getName() %></h4>
                <p><%= restaurant.getAddress() %></p>
            </div>
            <div class="line"></div>
            <%
                }
            } else {
            %>
            <!-- 해당 카테고리에 속하는 음식점이 없을 때 처리하는 부분 -->
            <p>해당하는 음식점이 없습니다.</p>
            <%
            }
        %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
