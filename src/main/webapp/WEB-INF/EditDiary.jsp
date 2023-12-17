<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<title>다이어리 수정</title>
	<style>
        body {
            font-family: Arial, sans-serif;
        }

        .center-form {
            text-align: center;
        }

       
        .mb-3 {
            margin-bottom: 20px;
        }

        
        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px; 
            border: 2px solid #e0e0e0;  /* 연한 검정색 테두리*/
            border-radius: 8px; /* 테두리를 둥글게*/
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            text-align: left; /* 왼쪽 정렬 */
        }
		
		
		
        input,
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #0077cc; 
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #005fa6;
        }
        .form-check-label {
            display: flex;
            align-items: center;
            margin-bottom: 8px;
        }
       
    </style>
    <script>
    function diaryModify() {
    	if (form.diary_title.value == "") {
    		alert("제목을 입력하십시오.");
    		form.diary_title.focus();
    		return false;
    	}
    	if (form.diary_content.value == ""){
    		alert("내용을 입력하십시오.");
    		form.diary_content.focus();
    		return false;
    	}
    	form.submit();
    }
    </script>
</head>
<body>

	<div class="mb-3 center-form">
	    <form name="form" method="POST" action="/diary/update">
	    	<input type="hidden" name="diaryId" value="${diary.diary_id}"/>	  
	        <h3>다이어리 수정</h3>
	
	        <label for="input_title" class="form-label">제목</label>
	        <input type="text" class="form-control" id="input_title" name="diary_title" value="${diary.title}"><br/>
	
	  
	        <label for="input-friend" class="form-label">친구</label>
	        <!--  <input class="form-check-input" type="checkbox" value="" id="input-friend" checked><br/><br/> -->
	        
	        <div class="form-check-label">
            <div style="display: flex; align-items: center;">
       			
       			<input class="form-control" type="checkbox" value="0" id="input-friend" name="diary_friend" 
       				<c:choose>
           				<c:when test="${diary.isShared == 1}">
               				checked
           				</c:when>
           				<c:otherwise>
           				</c:otherwise>
       				</c:choose>
       			>
            </div>
        	</div><br/>
	
	        <label for="input_content" class="form-label">내용</label>
	        <textarea class="form-control" id="input_content" name="diary_content" rows="7" placeholder="${diary.content}" >${diary.content}</textarea><br/>
	
	        <input type="button" value="수정하기" onClick="diaryModify()" class="btn btn-primary"> 
	        <!--  <button type="submit" class="btn btn-primary">수정하기</button>-->
	    </form>
	</div>

	
</body>
</html>