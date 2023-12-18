<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.dao.RestaurantDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Restaurant" %>
<%@ page import="model.Wishlist" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        /* 요소 정렬 */
        .container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: space-around; /* 요소들 사이의 여백을 일정하게 유지하며 중앙 정렬 */
        }

        /* 네모 상자 스타일링 */
        .wishlist-title {
            font-size: 2em; /* 위시리스트 명의 글자 크기를 크게 설정 */
        }

        .wishlist-container {
            min-width: 500px;
            border: 1px solid purple;
            padding: 10px;
            border-radius: 30px;
            text-align: center;
            font-size: 1.3em;
            margin-bottom: 50px;
        }

        button[type="submit"],
        button.wishlist-add-button {
            width: 100%;
            padding: 10px 15px;
            background-color: purple;
            color: white;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            margin-top: 15px;
        }

        button.wishlist-add-button {
            background-color: white;
            color: purple;
        }

        /* 체크박스 크기 조정 */
        input[type="checkbox"] {
            transform: scale(2); /* 체크박스 크기 확대 */
            margin-right: 2px; /* 체크박스 오른쪽 여백 */
        }
    </style>
</head>
<body>
    <% String customerName = (String) session.getAttribute("customerName");
    if (customerName != null) { %>
        <div class="container">
            <p><%= customerName %>님!</p>
        </div>
    <% } %>
    <div class="container mt-4">
        <form id="wishlistForm" method="post" action="/restaurant/addWish">
            <div class="wishlist-container">
                <p class="wishlist-title">위시리스트</p>
                <% RestaurantDAO restaurantDAO = new RestaurantDAO();
                List<Wishlist> wishlist = (List<Wishlist>) request.getAttribute("wishlist");
                int restaurantId = (int) request.getAttribute("restaurant_id");
                if (wishlist != null && !wishlist.isEmpty()) {
                    for (Wishlist item : wishlist) {
                        boolean isChecked = restaurantDAO.containsRestaurant(item.getWishlist_id(), restaurantId); %>
                        <div>
                            <input type="checkbox" name="wishlistIds" value="<%= item.getWishlist_id() %>" <%= isChecked ? "checked" : "" %>>
                            <%= item.getName() %>
                        </div>
                    <% }
                } %>
                <input type="hidden" name="restaurant_id" value="<%= request.getAttribute("restaurant_id") %>">
                <button type="submit">위시리스트에 추가</button>
            </div>
        </form>
    </div>
    <!-- Bootstrap 및 기타 스크립트 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!-- + 위시리스트 추가 버튼 -->
	<div class="container mt-4">
	    <button class="wishlist-add-button" onclick="location.href='/restaurant/viewAddWish'">+ 위시리스트 추가</button>
	</div>

</body>
</html>
