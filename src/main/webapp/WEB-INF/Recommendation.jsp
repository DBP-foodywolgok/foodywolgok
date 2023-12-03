<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>음식 카테고리</title>

    <!-- 부트스트랩 스타일 시트를 로드 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous">

    <!-- 커스텀 스타일 -->
    <style>
        /* 전체 스타일링 */
        body {
            background-color: #f8f9fa;
        }

        /* 카드 스타일 */
        .card {
            border: none;
        }

        /* 상세보기 버튼 스타일 */
        .detail-button {
            position: absolute;
            bottom: 10px;
            right: 10px;
        }
    </style>
</head>

<body>
    <main>
        <section class="py-5 text-center container">
            <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <h1 class="fw-light">추천 음식</h1>
                </div>
            </div>
        </section>

        <hr>

      <h2 class="text-center">사용자 선호 음식</h2>

<div class="album py-5 bg-body-tertiary">
    <div class="container">
        <div class="row row-cols-1 row-cols-md-3 g-3">
            <!-- 추가된 div 1 -->
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">음식 8</p>
                    </div>
                    <!-- 상세보기 버튼 -->
                    <button class="btn btn-primary detail-button">상세보기</button>
                </div>
            </div>

            <!-- 추가된 div 2 -->
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">음식 8</p>
                    </div>
                    <!-- 상세보기 버튼 -->
                    <button class="btn btn-primary detail-button">상세보기</button>
                </div>
            </div>

            <!-- 추가된 div 3 -->
            <div class="col">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <p class="card-text">음식 8</p>
                    </div>
                    <!-- 상세보기 버튼 -->
                    <button class="btn btn-primary detail-button">상세보기</button>
                </div>
            </div>
        </div>
    </div>
</div>

<hr>
  <h2 class="text-center">사용자 추천 음식</h2>
        <div class="album py-5 bg-body-tertiary">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <!-- 카드 1 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 1</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 2 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 2</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 3 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 3</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 4 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 4</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 5 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 5</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 6 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 6</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 7 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 7</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>

                    <!-- 카드 9 -->
                    <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 9</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>
                    
                       <div class="col">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <p class="card-text">음식 10</p>
                            </div>
                            <!-- 상세보기 버튼 -->
                            <button class="btn btn-primary detail-button">상세보기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- 부트스트랩 및 자바스크립트 라이브러리 로드 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>