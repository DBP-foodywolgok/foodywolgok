<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 맛집 리스트</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<style>
		.container {
            max-width: 750px;
            margin: 0 auto;
            padding: 20px;
        }
        .center-text {
        	text-align: center;
        }
	</style>
</head>
<body>
<div class="container">
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<div class="container text-center">
			<div class="row align-items-center justify-content-between">
    			<div class="col-4 text-start">
      				<h2><strong>나의 맛집</strong></h2>
    			</div>
    			<div class="col-4 text-end">
      				<input class="btn btn-outline-primary" type="button" value="등록" onClick="location.href='/myRestaurant/register'">
    			</div>
    		</div>
  		</div>
	</div>
	<hr>
    <div class="list-group">
    <c:choose>
		<c:when test="${ResultCode eq 0}">
			<p class="center-text">나의 맛집이 없습니다.</p>
		</c:when>
		<c:when test="${ResultCode eq 1}">
			<c:forEach var="rstr" items="${list}">
				<a href="#" class="list-group-item list-group-item-action" aria-current="true">
					<div class="d-flex w-100 justify-content-between">
      					<h5 class="mb-1">${rstr.getName()}</h5>
      					<small>${rstr.getCategory()}</small>
    				</div>
    				<p class="mb-1">${rstr.getAddress()}</p>
    				<small>별점 : ${rstr.getScore()}</small>
  				</a>
			</c:forEach>
		</c:when>
	</c:choose>
  	</div>
</div> 
</body>
</html>