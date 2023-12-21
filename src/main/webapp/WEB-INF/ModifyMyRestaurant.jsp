<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 맛집 수정</title>
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
	<div class="container text-center">
	<form action="/myRestaurant/update" method="post">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
  			<input type="text" id="name" name="name" value="${mr.name}" class="form-control" aria-label="Restaurant's Name" aria-describedby="button-addon2" readonly>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">위치</span>
  			<input type="text" id="address" name="address" value="${mr.address}" class="form-control" aria-label="Location" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group mb-3">
  			<label class="input-group-text" for="inputGroupSelect01">별점</label>
  			<select class="form-select" id="score" name="score">
    			<option disabled value="0" selected>별점을 선택하세요.</option>
    			<option value="1" ${mr.score == '1' ? 'selected' : ''}>1</option>
    			<option value="2" ${mr.score == '2' ? 'selected' : ''}>2</option>
    			<option value="3" ${mr.score == '3' ? 'selected' : ''}>3</option>
    			<option value="4" ${mr.score == '4' ? 'selected' : ''}>4</option>
    			<option value="5" ${mr.score == '5' ? 'selected' : ''}>5</option>
  			</select>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">카테고리</span>
  			<input type="text" id="category" name="category" value="${mr.category}" class="form-control" aria-label="Category" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group">
  			<span class="input-group-text">메모</span>
  			<textarea id="memo" name="memo" class="form-control" aria-label="Memo" rows="8">${mr.memo}</textarea>
		</div><br>
		<input type="hidden" name="mrId" value="${param.id}">
		<input class="btn btn-outline-primary" type="submit" value="수정"> 
		<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/view?id=${param.id}'">취소</button>
	</form>
	</div>
</body>
</html>