<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Wishlist" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #ffffff;
        }
        .wishlist-header {
            text-align: center;
            margin-bottom: 30px;
        }
        .wishlist-item {
            padding: 20px;
            margin-bottom: 20px;
            width: 100%;
            box-sizing: border-box;
        }
        .btn {
            border: none;
        }
        .item-name {
            font-size: 1.5em; /* ${item.name} 글자 크기 */
            margin-bottom: 10px; /* ${item.name} 아래 여백 */
        }
        .item-memo {
            margin-top: 10px; /* ${item.memo} 위 여백 */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="wishlist-header">
            <h1>위시리스트</h1>
        </div>
        <div class="container mt-4">
            <button class="wishlist-add-button" onclick="location.href='/restaurant/viewAddWish'">+ 위시리스트 추가</button>
        </div>
        <c:choose>
            <c:when test="${not empty wishlist}">
                <c:forEach var="item" items="${wishlist}">
                    <div class="wishlist-item">
                        <button type="button" class="btn btn-primary">
                            <div class="item-name">${item.name}</div>
                            <div class="item-memo">${item.memo}</div>
                        </button>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <p>위시리스트가 비어있습니다.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
