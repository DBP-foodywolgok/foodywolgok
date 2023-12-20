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
	<script>
		function validateForm() {
			var name = document.getElementById("name").value.trim();
			var address = document.getElementById("address").value.trim();
			var score = document.getElementById("score").value;
			var category = document.getElementById("category").value;
			
			if (name === "" || address === "" || score === "0" || category === "0") {
				alert("이름, 주소, 별점, 카테고리는 필수 항목입니다.");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<div class="container">
	<form action="/myRestaurant/register" method="post" onsubmit="return validateForm()">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
  			<input type="text" id="name" name="name" value="<%= (request.getParameter("name") != null) ? request.getParameter("name") : "" %>" class="form-control" placeholder="식당의 이름을 입력하세요." aria-label="Restaurant's Name" aria-describedby="button-addon2">
  			<button class="btn btn-outline-secondary" type="button" id="button-addon2" onClick="location.href='/myRestaurant/find'">검색</button>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">위치</span>
  			<input type="text" id="address" name="address" value="<%= (request.getParameter("address") != null) ? request.getParameter("address") : "" %>" class="form-control" placeholder="식당의 위치를 입력하세요." aria-label="Location" aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
  			<label class="input-group-text" for="inputGroupSelect01">별점</label>
  			<select class="form-select" id="score" name="score">
    			<option disabled value="0" selected>별점을 선택하세요.</option>
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
    			<option disabled value="0" selected>식당의 카테고리를 선택하세요.</option>
    			<option value="1" ${param.category == '1' ? 'selected' : ''}>양식</option>
    			<option value="2" ${param.category == '2' ? 'selected' : ''}>퓨전요리</option>
    			<option value="3" ${param.category == '3' ? 'selected' : ''}>태국식</option>
    			<option value="4" ${param.category == '4' ? 'selected' : ''}>샐러드</option>
    			<option value="5" ${param.category == '5' ? 'selected' : ''}>죽</option>
    			<option value="6" ${param.category == '6' ? 'selected' : ''}>디저트</option>
    			<option value="7" ${param.category == '7' ? 'selected' : ''}>음료</option>
    			<option value="8" ${param.category == '8' ? 'selected' : ''}>한식</option>
    			<option value="9" ${param.category == '9' ? 'selected' : ''}>중식</option>
    			<option value="10" ${param.category == '10' ? 'selected' : ''}>아시아</option>
    			<option value="11" ${param.category == '11' ? 'selected' : ''}>일식</option>
    			<option value="12" ${param.category == '12' ? 'selected' : ''}>분식</option>
    			<option value="13" ${param.category == '13' ? 'selected' : ''}>치킨</option>
    			<option value="14" ${param.category == '14' ? 'selected' : ''}>고기</option>
    			<option value="15" ${param.category == '15' ? 'selected' : ''}>패스트푸드</option>
    			<option value="16" ${param.category == '16' ? 'selected' : ''}>족발</option>
    			<option value="17" ${param.category == '17' ? 'selected' : ''}>야식</option>
    			<option value="18" ${param.category == '18' ? 'selected' : ''}>주점</option>
  			</select>
		</div>
		<div class="input-group">
  			<span class="input-group-text">메모</span>
  			<textarea id="memo" name="memo" class="form-control" aria-label="Memo" rows="8"></textarea>
		</div><br>
		<input type="hidden" name="type" value="<%= (request.getParameter("id") != null) ? 0 : 1 %>">
		<input type="hidden" name="restaurantId" value="<%= (request.getParameter("id") != null) ? request.getParameter("id") : 0 %>">
		<input class="btn btn-outline-primary" type="submit" value="등록"> 
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list'">취소</button>
	</form>
	</div>
</body>
</html>