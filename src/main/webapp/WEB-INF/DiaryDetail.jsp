<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// java.util.Date -> String  
	//System.out.println(System.currentTimeMillis());

	Diary diary = (Diary)request.getAttribute("diary");

%>


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
    <script>
 	//삭제하기 누르면 질문 
   	function diaryRemove() {
   		return confirm("정말 삭제하시겠습니까?");		
   	}
	</script>
    
</head>
<body>

<div class="diary-entry"> 
    <h4 class="diary-date"><fmt:formatDate value="${diary.nowDate}" pattern="yyyy.MM.dd" /></h4>
    <h2 class="diary-title"><%=diary.getTitle() %></h2> 
    <p class="diary-place">토라카츠</p>
    
    <c:if test="${not empty diary.picture}">
    <img src="<c:url value='/upload/${diary.picture}'/>" />
	</c:if>
    
    <div class="diary-content">
        <p><%=diary.getContent()%></p>
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

	<c:if test="${diary.customer_id eq sessionScope.customer_id}">
	    <!-- 다이어리 수정하기, 삭제하기 버튼 -->
	    <div class="diary-buttons">
	       
	        <a href="<c:url value='/diary/update'>
				<c:param name='diaryId' value='${diary.diary_id}'/>
				</c:url>" class="btn btn-info">
				수정하기
			</a>
	        <a href="<c:url value='/diary/delete'>
				<c:param name='diaryId' value='${diary.diary_id}'/>
				</c:url>" onclick="return diaryRemove();" class="btn btn-danger">
				삭제하기
			</a>
	        <a href="<c:url value='/diary/list'/>" class="btn btn-info">다이어리</a> 
	    </div>
	 </c:if>
</div>

</body>
</html>