<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>다이어리 등록</title>
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
            max-width: 800px;
            margin: 0 auto;
            padding: 20px; 
            border: 2px solid #e0e0e0;  /* 연한 검정색 테두리 */
            border-radius: 8px; /* 테두리를 둥글게 */
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
</head>
<body>

	<div class="mb-3 center-form">
	    <form action="Registration-Diary" method="post">
	        <h3>다이어리 작성</h3>
	
	        <label for="input_title" class="form-label">제목</label>
	        <input type="text" class="form-control" id="input_title" placeholder="제목을 입력하세요" required><br/>
			
			<label for="input_place" class="form-label">장소</label>
	  		<input type="submit" class="form-control" id="input_place" value="장소찾기" ><br/> 
	  		
	  		<label for="input_picture" class="form-lbel">사진</label>
	  		<input type="file" class="form-control" id="input_picture" value="사진찾기" name="file"><br/>
	  		
	  		<label for="input-friend" class="form-label">친구</label>
	        <!--  <input class="form-check-input" type="checkbox" value="" id="input-friend" checked><br/><br/> -->
	        
	        
	       	<div class="form-check-label">
            <div style="display: flex; align-items: center;">
                <input class="form-control" type="checkbox" value="친구공유" id="input-friend" checked required>
                
            </div>
        </div><br/>
        
	  		<label for="input_content" class="form-label">내용</label>
	        <textarea class="form-control" id="input_content" rows="7" placeholder="내용을 작성하세요" required></textarea><br/>
	        
	
	        <!--  <button type="submit" class="btn btn-primary">등록하기</button>-->
	    	<a href="/diary/view" class="btn btn-primary">등록하기</a>
	    </form>
	</div>

	
</body>

</html>