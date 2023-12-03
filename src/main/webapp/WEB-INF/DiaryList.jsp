<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>다이어리 리스트</title>
    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
            background-color: #f8f9fa; /* 전체 배경색 */
            color: #495057; /* 전체 글자색 */
            margin: 0;
            padding: 0;
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
            border: 1px solid #dee2e6; /* 구분선 스타일 */
        }

        .diary-entry {
            background-color: white;
            margin: 20px;
            padding: 20px;
            border: 1px solid #ced4da; /* 리스트 각 항목 테두리 스타일 */
            border-radius: 8px;
        }

        .diary-title {
            color: #007bff; /* 제목 색상 */
        }

        .diary-content {
            margin-top: 10px;
        }

        .diary-image {
            max-width: 50%;
            height: auto;
        }
    </style>
</head>
<body>

    <header>
        <h1>다이어리</h1>
    </header>

    <form action="Diary-List" method="post">
        <label>
            <input type="checkbox" value="yes">친구 게시글
        </label>
    </form>

    <hr/>

    <div class="diary-entry">
        <span>2023년 9월 25일 월요일</span>
        <h4 class="diary-title">푸디 월곡 최고 맛집</h4>
        <img src="https://i.namu.wiki/i/l_6dm5qRYU1uu24fnGveMGaeHP-RtuJ5SLPxtC7ilHMiv9fnu-IZyyht_k4G26T6PQNDmfvotEaLVQoYk_0FwskeoOwawaeI-NDeXCKV5RupLawYCyOMvMe4uGxQrxA02xDZkSjc-VBJFuCWIYl_xw.webp" width="200" alt="다이어리 이미지" class="diary-image">
        <div class="diary-content">
            월곡의 모든 맛집은 푸디 월곡에..
        </div>
    </div>

    <hr/>

</body>
</html>