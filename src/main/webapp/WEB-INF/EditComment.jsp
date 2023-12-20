<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>댓글 수정 폼</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 0;
            padding: 0;
        }

        .comment-form {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-primary {
            background-color: #0077cc;
            border: none;
        }

        .btn-primary:hover {
            background-color: #005fa6;
        }
    </style>
</head>
<body>

<div class="comment-form">
    <h4 class="text-center mb-4">댓글을 수정하세요</h4>

    <form id="editCommentForm" action="/comments/update" method="post">
    	<input type="hidden" name="diaryId" value="${comment.diary_id}"/>	 
    	<input type="hidden" name="commentId" value="${comment.comment_id}"/>	
        <div class="form-group">
            <label for="commentContent">댓글 내용:</label>
            <textarea class="form-control" id="updatedContent" name="updatedContent" rows="5" placeholder="${comment.content}" required>${comment.content}</textarea>
        </div>


        <button type="submit" class="btn btn-primary btn-block">댓글 수정</button>
    </form>
</div>

</body>
</html>
