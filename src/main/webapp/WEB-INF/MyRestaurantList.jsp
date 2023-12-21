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
        #title {
        	text-decoration: none;
        	color: inherit;
        	cursor: pointer;
        }
	</style>
</head>
<body>
<div class="container">
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<div class="container text-center">
			<div class="row align-items-center justify-content-between">
    			<div class="col-4 text-start">
      				<h2><strong><a id ="title" href="/myRestaurant/list">나의 맛집</a></strong></h2>
    			</div>
    			<div class="col-8 text-end">
    				<div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
  						<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list'">최신순</button>
  						<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list?sort=1'">오래된순</button>
  						<button type="button" class="btn btn-outline-primary" onClick="location.href='/myRestaurant/list?sort=2'">별점순</button>
					</div>
      				<input class="btn btn-outline-primary" type="button" value="등록" onClick="location.href='/myRestaurant/register'">
    			</div>
    		</div>
  		</div>
	</div>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  		<div class="container-fluid">
    		<div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      			<ul class="navbar-nav">
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=1">양식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=2">퓨전요리</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=3">태국식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=4">샐러드</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=5">죽</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=6">디저트</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=7">음료</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=8">한식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=9">중식</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
  		<div class="container-fluid">
    		<div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      			<ul class="navbar-nav">
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=10">아시아</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=11">일식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=12">분식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=13">치킨</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=14">고기</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=15">패스트푸드</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=16">족발</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=17">야식</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="/myRestaurant/list?category=18">주점</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>
	<hr>
    <div class="list-group">
    <c:choose>
		<c:when test="${ResultCode eq 0}">
			<p class="center-text">나의 맛집이 없습니다.</p>
		</c:when>
		<c:when test="${ResultCode eq 1}">
			<c:forEach var="rstr" items="${list}">
				<a href="/myRestaurant/view?id=${rstr.getId()}" class="list-group-item list-group-item-action" aria-current="true">
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