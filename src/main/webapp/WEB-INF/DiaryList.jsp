<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>다이어리 리스트</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iK7ZFVoZlYc8l3RgApH3KAe10LZjwgtaz0EtxU8F5uYYjC61q6bNHJOPc" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            padding: 0;
            width: 60%; /* 폭 조절 */
            margin: 0 auto; /* 양쪽 조절 */
        }

        header {
            text-align: center;
            padding: 5px;
        }

        form {
            text-align: center;
            margin: 20px 0;
        }

        label {
            display: inline-block;
            text-align: left;
        }

        hr {
            border: 1px solid #dee2e6;
        }

        .diary-entry {
            background-color: white;
            margin: 5px;
            padding: 10px;
            border: 1px solid #ced4da;
            border-radius: 8px;
        }

        .diary-title {
        	margin-top: 0px;
            color: #007bff;
            font-weight: bold;
            font-size: 1.5em; /* 크게 */
            margin-bottom: 2px; /* 제목과 내용 간격 조절 */
        }

        .diary-content {
            margin-top: 2px; /* 제목과 내용 간격 조절 */
        }

        .diary-image {
            max-width: 50%;
            height: auto;
        }

        .card-text .text-muted {
            color: #aaa; /* 연한 회색 */
            font-size: 0.8em; /* 작게 */
            margin-top: 2px; /* 상단 간격 조절 */
        }
        
        /* 링크에 밑줄 제거 */
    	a {
        	text-decoration: none;
    	}
    	
    	.btn-group-custom {
            margin-bottom: 20px;
        }

        .btn-custom {
            background-color: #0077cc;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        .btn-custom:hover {
            background-color: #005fa6;
        }
        
    </style>
 	<script>
    /*function myDiaryList() {
    	updateFormAction('/diary/list?command=my');
    	form.submit();
    }
    function friendDiaryList() {
    	updateFormAction('/diary/list?command=friend');
    	form.submit();
    }*/
    </script>
</head>
<body>
    <div class="container mt-3">
    	<div class="btn-group btn-group-custom" role="group" aria-label="Basic example">
	        <button class="btn btn-custom" onclick="location.href='/diary/register/form'">다이어리 추가</button>
			<button class="btn btn-custom" onclick="location.href='/customer/main'">메인 페이지</button>
	        <header class="text-center mt-3">
            	<h1>다이어리</h1> 
        	</header>
	
	        <!--  <form class="text-center mt-3" action="Diary-List" method="post">
	            <label class="form-check-label">
	                <input type="checkbox" class="form-check-input" value="yes">친구 게시글
	            </label>
	        </form>-->
	        <!--  <form name="form" method="POST" action="/diary/list">
	        	<button class="btn btn-primary" onClick= "myDiaryList()">내 다이어리 보기</button>
	        	<button class="btn btn-primary" onClick= "friendDiaryList()">친구 다이어리 보기</button>
			</form>-->
			
			<form name="form" method="POST" action="/diary/list?command=my">
	    		<button class="btn btn-custom">내 다이어리 보기</button>
			</form>
			<form name="form" method="POST" action="/diary/list?command=friend">
	    		<button class="btn btn-custom">친구 다이어리 보기</button>
			</form>
		</div>
		
        <hr />

        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
            <c:forEach var="diary" items="${diaryList}">
                <div class="col mb-4">
                    <div class="card diary-entry">
                        <div class="card-body">
                        	<p class="card-text text-muted">
                                <fmt:formatDate value="${diary.nowDate}" pattern="yyyy.MM.dd" var="formattedDate" />
                                ${formattedDate}
                            </p>
                            
                            <c:if test="${not empty diary.picture}">
                                <img src="<c:url value='/upload/${diary.picture}'/>" class="card-img-top diary-image" alt="다이어리 이미지">
                            </c:if>
                            
                            <p><a href="<c:url value='/diary/view'>
					   			<c:param name='diaryId' value='${diary.diary_id}'/>
			 		 		</c:url>" class="card-title diary-title">
								${diary.title}
							</a></p>
               
                            <p class="card-text diary-content">${diary.content}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <hr />
    </div>

    <!-- Bootstrap JS 및 Popper.js 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY0iD70B9B5PHL2QFjvqE+6qZ8rWHinI586d5" crossorigin="anonymous">
    
    </script>
    
