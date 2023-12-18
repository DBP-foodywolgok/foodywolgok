<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 맛집 등록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<style>
		.container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
        .center-text {
        	text-align: center;
        }
	</style>
	<script>
		function validateForm() {
			var keyword = document.getElementById('keyword');
			
			if (keyword.value.trim() === '') {
				alert('검색어를 입력하세요.');
				return false;
			}
			
			return true;
		}
	</script>
</head>
<body>
	<div class="container">
	<form action="/myRestaurant/find" method="post" onsubmit="return validateForm()">
		<div class="input-group mb-3">
  			<input type="text" class="form-control" id="keyword" name="keyword" placeholder="검색할 식당을 입력하세요." aria-label="Recipient's username" aria-describedby="button-addon2">
  			<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
		</div>
	</form>
	<div class="list-group">
	<c:choose>
		<c:when test="${ResultCode eq 0}">
			<hr>
			<p class="center-text">검색된 식당이 없습니다.</p>
		</c:when>
		<c:when test="${ResultCode eq 1}">
			<hr>
			<c:forEach var="rstr" items="${list}">
				<a href="/myRestaurant/register?id=${rstr[0]}&name=${rstr[1]}&address=${rstr[2]}&category=${rstr[3]}" class="list-group-item list-group-item-action">
					<div class="d-flex w-100 justify-content-between">
						<h5 class="mb-1">${rstr[1]}</h5>
						<small>${rstr[4]}</small>
					</div>
					<p class="mb-1">${rstr[2]}</p>
				</a>
			</c:forEach>
		</c:when>
	</c:choose>
	</div>
	</div>
</body>
</html>