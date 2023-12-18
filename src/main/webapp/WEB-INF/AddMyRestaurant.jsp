<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	</style>
</head>
<body>
	<div class="container">
	<form action="/myRestaurant/register" method="post">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
  			<input type="text" id="name" name="name" class="form-control" placeholder="식당의 이름을 입력하세요." aria-label="Restaurant's Name" aria-describedby="button-addon2">
  			<button class="btn btn-outline-secondary" type="button" id="button-addon2" onClick="location.href='${pageContext.request.contextPath}/restaurant/find'">검색</button>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">위치</span>
  			<input type="text" id="address" name="address" class="form-control" placeholder="식당의 위치를 입력하세요." aria-label="Location" aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
  			<label class="input-group-text" for="inputGroupSelect01">별점</label>
  			<select class="form-select" id="score" name="score">
    			<option selected>별점을 선택하세요.</option>
    			<option value="1">1</option>
    			<option value="2">2</option>
    			<option value="3">3</option>
    			<option value="4">4</option>
    			<option value="5">5</option>
  			</select>
		</div>
		<div class="input-group mb-3">
  			<label class="input-group-text" for="inputGroupSelect01">카테고리</label>
  			<select class="form-select" id="category" name="category">
    			<option selected>식당의 카테고리를 선택하세요.</option>
    			<option value="1">양식</option>
    			<option value="2">퓨전요리</option>
    			<option value="3">태국식</option>
    			<option value="4">샐러드</option>
    			<option value="5">죽</option>
    			<option value="6">디저트</option>
    			<option value="7">음료</option>
    			<option value="8">한식</option>
    			<option value="9">중식</option>
    			<option value="10">아시아</option>
    			<option value="11">일식</option>
    			<option value="12">분식</option>
  			</select>
		</div>
		<div class="input-group">
  			<span class="input-group-text">메모</span>
  			<textarea id="memo" name="memo" class="form-control" aria-label="Memo" rows="8"></textarea>
		</div><br>
		<input type="hidden" name="type" value="1">
		<input class="btn btn-outline-primary" type="submit" value="등록"> 
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list'">취소</button>
	</form>
	</div>
</body>
</html>