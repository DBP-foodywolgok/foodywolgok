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
        .restaurant-info {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
        }

        .line {
            border-top: 1px solid #ccc;
            margin: 10px 0;
        }

        .restaurant-card {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px 0;
        }
    </style>
</head>

<body>
    <div class="container mt-4">
        <button class="btn btn-primary">종류별 찾기</button>
    </div>

    <div class="container mt-4">
        <%
            // 카테고리 파라미터 받아오기
            String category = request.getParameter("category");
            if (category != null) {
                RestaurantDAO restaurantDAO = new RestaurantDAO();
                List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCategory(category);

                // 받아온 음식점 목록을 출력하는 코드 작성
                if (restaurants != null && !restaurants.isEmpty()) {
                    for (Restaurant restaurant : restaurants) {
        %>
                        <div class="restaurant-card">
                        <%--<img src="<%= restaurant.getImageURL() %>" alt="<%= restaurant.getName() %> 사진">--%>
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
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>

</html>
