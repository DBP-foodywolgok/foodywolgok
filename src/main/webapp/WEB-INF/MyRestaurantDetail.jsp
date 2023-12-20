<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 맛집 정보</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<style>
		.container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
	</style>
</head>
<body>
	<div class="container">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
  			<input type="text" id="name" name="name" value="<c:out value='${mr.name}'/>" class="form-control" aria-label="Restaurant's Name" aria-describedby="button-addon2" readonly>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">위치</span>
  			<input type="text" id="address" name="address" value="<c:out value='${mr.address}'/>" class="form-control" aria-label="Location" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">별점</span>
  			<input type="text" id="score" name="score" value="<c:out value='${mr.score}'/>" class="form-control" aria-label="Score" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">카테고리</span>
  			<input type="text" id="category" name="category" value="<c:out value='${mr.category}'/>" class="form-control" aria-label="Category" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group">
  			<span class="input-group-text">메모</span>
  			<textarea id="memo" name="memo" class="form-control" aria-label="Memo" rows="8" readonly><c:out value="${mr.memo}" /></textarea>
		</div><br>
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/update'">수정</button>
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/delete'">삭제</button>
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list'">목록</button>
	</div>
</body>
</html>