<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>다이어리 상세 보기 </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 0;
            padding: 0;
        }

        header {
            text-align: center;
            padding: 10px;
        }

        .diary-entry {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .diary-date {
            font-size: 16px;
            color: #555;
        }

        .diary-title {
            font-size: 24px;
            color: #007bff;
            margin-top: 10px;
        }

        .diary-place {
            font-size: 11px;
            color: #343a40;
            margin-top: 10px;
            text-decoration: underline;
            
        }

        .diary-image {
            max-width: 100%;
            height: auto;
            margin-top: 20px;
        }

        .diary-content {
            margin-top: 20px;
        }

        .comment-section {
            margin-top: 30px;
        }

        .comment-title {
            font-size: 18px;
            color: #007bff;
            margin-bottom: 10px;
        }

        .comment {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #e0e0e0;
            border-radius: 8px;
            background-color: #f8f9fa;
        }

        .comment-author {
            font-weight: bold;
        }

        .comment-date {
            color: #777;
        }

        .comment-content {
            margin-top: 10px;
        }

        .comment-buttons {
            margin-top: 10px;
        }

        .diary-buttons {
            margin-top: 20px;
        }
		
		.edit-button {
            background-color: #28a745; /* 수정 버튼 색상 */
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        .delete-button {
            background-color: #dc3545; /* 삭제 버튼 색상 */
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        
        button {
            background-color: #0077cc;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        button:hover {
            background-color: #005fa6;
        }
    </style>
</head>
<body>

<div class="diary-entry">
    <h4 class="diary-date">2023년 9월 25일</h4>
    <h2 class="diary-title">푸디 월곡 최고 맛집</h2>
    <p class="diary-place">토라카츠</p>
    <img src="https://i.namu.wiki/i/l_6dm5qRYU1uu24fnGveMGaeHP-RtuJ5SLPxtC7ilHMiv9fnu-IZyyht_k4G26T6PQNDmfvotEaLVQoYk_0FwskeoOwawaeI-NDeXCKV5RupLawYCyOMvMe4uGxQrxA02xDZkSjc-VBJFuCWIYl_xw.webp" alt="다이어리 이미지" class="diary-image">
    <div class="diary-content">
        <p>월곡의 모든 맛집은 푸디 월곡에 있다. </p>
    </div>

    <!-- 댓글 섹션 -->
    <div class="comment-section">
        <h3 class="comment-title">댓글</h3>

        <!-- 각 댓글 -->
        <div class="comment">
            <p class="comment-author">친구1</p>
            <p class="comment-date">2023년 9월 26일</p>
            <p class="comment-content">친구1의 댓글</p>
        </div>

        <!-- 새로운 댓글 작성 폼 -->
        <form action="#" method="post">
            <label for="input_comment" class="form-label">댓글 작성</label>
            <textarea class="form-control" id="input_comment" rows="3" placeholder="댓글을 작성하세요" required></textarea><br/>
            <button type="submit" class="btn btn-primary">댓글 작성</button>
        </form>
    </div>

    <!-- 다이어리 수정하기, 삭제하기 버튼 -->
    <div class="diary-buttons">
        <button type="button" class="btn btn-info">다이어리 수정하기</button>
        <button type="button" class="btn btn-danger">다이어리 삭제하기</button>
    </div>
</div>

</body>
</html>