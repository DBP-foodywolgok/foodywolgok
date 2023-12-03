<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<div class="text-center">
  			<img src="../images/tora.jpg" class="rounded" alt="사진">
		</div><br>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">이름</span>
  			<input type="text" class="form-control" placeholder="맛집 A" aria-label="Restaurant's Name" aria-describedby="button-addon2" readonly>
		</div>
		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">위치</span>
  			<input type="text" class="form-control" placeholder="월곡동 1번지" aria-label="Location" aria-describedby="inputGroup-sizing-default" readonly>
		</div>
		<div class="input-group mb-3">
  			<label class="input-group-text" for="inputGroupSelect01">카테고리</label>
  			<select class="form-select" id="inputGroupSelect01">
    			<option>식당의 카테고리를 입력하세요.</option>
    			<option value="1" selected>한식</option>
    			<option value="2">양식</option>
    			<option value="3">중식</option>
    			<option value="4">일식</option>
  			</select>
		</div>
		<div class="input-group">
  			<span class="input-group-text">메모</span>
  			<textarea class="form-control" placeholder="여기 맛있다~" aria-label="Memo" rows="8"></textarea>
		</div><br>
		<input class="btn btn-outline-primary" type="button" value="수정"> 
		<button type="button" class="btn btn-outline-primary">삭제</button>
	</div>
</body>
</html>