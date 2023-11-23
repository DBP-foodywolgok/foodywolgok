<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
    <script src="/docs/5.3/assets/js/color-modes.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.115.4">
    <title>List groups · Bootstrap v5.3</title>

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#712cf9">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            width: 100%;
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        .btn-bd-primary {
            --bd-violet-bg: #712cf9;
            --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

            --bs-btn-font-weight: 600;
            --bs-btn-color: var(--bs-white);
            --bs-btn-bg: var(--bd-violet-bg);
            --bs-btn-border-color: var(--bd-violet-bg);
            --bs-btn-hover-color: var(--bs-white);
            --bs-btn-hover-bg: #6528e0;
            --bs-btn-hover-border-color: #6528e0;
            --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
            --bs-btn-active-color: var(--bs-btn-hover-color);
            --bs-btn-active-bg: #5a23c8;
            --bs-btn-active-border-color: #5a23c8;
        }

        .bd-mode-toggle {
            z-index: 1500;
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="list-groups.css" rel="stylesheet">


    <meta charset="EUC-KR">
    <title>Insert title here</title>
</head>

<body>
<div class="container mt-5">
    <center>
        <h2 class="mb-4">친구 리스트</h2>
    </center>
    <div class="list-group">
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="">
            <span>
                    첫 번째 친구
                    <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
                </span>
        </label>
        <!-- 나머지 친구 목록 추가 -->
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    두 번째 친구
                    <small class="d-block text-body-secondary">Some other text goes here</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    세 번째 친구
                    <small class="d-block text-body-secondary">And we end with another snippet of text</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    네 번째 친구
                    <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    다섯 번째 친구
                    <small class="d-block text-body-secondary">Some other text goes here</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    여섯 번째 친구
                    <small class="d-block text-body-secondary">And we end with another snippet of text</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="">
            <span>
                    일곱 번째 친구
                    <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
                </span>
        </label>
        <label class="list-group-item d-flex gap-2">
            <input class="form-check-input flex-shrink-0" type="checkbox" value="">
            <span>
                    여덟 번째 친구
                    <small class="d-block text-body-secondary">Some other text goes here</small>
                </span>
        </label>
    </div>
    <div class="mt-4 d-flex justify-content-between">
        <button class="btn btn-primary">친구 추가</button>
        <button class="btn btn-primary">친구 삭제</button>
    </div> 
</div>
</body>

</html>