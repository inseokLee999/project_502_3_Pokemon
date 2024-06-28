<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<layout:main>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

    <!-- Demo styles -->
    <style>
        html,
        body {
            position: relative;
            height: 100%;
        }

        body {
            background: #ffff;
            font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
            font-size: 14px;
            color: #000;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh; /* 최소 화면 높이를 화면 전체로 설정 */
        }

        .header {
            position: fixed;
            top: 0;
            width: 100%;
            background: #333;
            color: white;
            padding: 10px;
            z-index: 1000; /* 헤더가 항상 슬라이더 위에 있도록 z-index 설정 */
        }

        .swiper-container {
            flex: 1; /* 슬라이더 영역이 남은 화면을 모두 차지하도록 설정 */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            position: relative;
            z-index: 1; /* 슬라이더의 z-index를 낮게 설정 */
            margin-top: 60px; /* 헤더 높이만큼 슬라이더의 위치 조정 */
        }

        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            display: flex;
            flex-direction: column; /* 세로 방향으로 정렬 */
            justify-content: center;
            align-items: center;
            height: auto; /* 슬라이드 높이를 자동으로 조정 */
            border-radius: 8px; /* 이미지를 라운드 처리 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 호버 시 그림자 효과 추가 */
        }

        .swiper-slide img {
            display: block;
            max-width: 100%;
            height: auto;
            object-fit: contain; /* 이미지가 슬라이드 안에 적절히 맞도록 조정 */

        }



        .footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            width: 100%;
            flex-shrink: 0; /* 스크롤 시 푸터가 화면 밖으로 안나가도록 설정 */
        }
    </style>

    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/027401ys.png'/>" alt="입새코 영산"/>입새코 영산" </div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/000701yz.png'/>" alt="꼬부기 유정"/> "꼬부기 유정"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/015001is.png'/>" alt="뮤츠 인석"/> "뮤츠 인석"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/002601sj.png'/>" alt="라이츄 성준"/> "라이츄 성준"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/004801ms.png'/>" alt="콘팡 민수"/> "콘팡 민수"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/00181km.png'/>" alt="피죤투 경미"/> "피죤투 경미"</div>
        </div>
        <div class="swiper-pagination"></div>
    </div>

    <!-- Swiper JS -->
    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
        var swiper = new Swiper(".mySwiper", {
            slidesPerView: 3,
            spaceBetween: 30,
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
            },
            autoplay: {        // 자동 재생 설정
                delay: 1000,   // 2.5초마다 슬라이드 변경
                disableOnInteraction: false,  // 사용자가 슬라이드 클릭해도 자동 재생 계속
            },
        });
    </script>

</layout:main>