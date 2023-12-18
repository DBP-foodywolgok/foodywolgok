<%@ page language="java" contentType="text/html; charset=UTF-8"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <h2>Add Wishlist</h2>
    <form method="post" action="/restaurant/updateWish">
        <!-- 사용자로부터 입력 받는 필드들 -->
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>

        <label for="memo">Memo:</label><br>
        <textarea id="memo" name="memo"></textarea><br><br>

        <!-- 폼 제출 버튼 -->
        <input type="submit" value="Submit">
    </form>
</body>
</html>