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
            background: #eee;
            font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
            font-size: 14px;
            color: #000;
            margin: 0;
            padding: 0;
        }

        .swiper {
            width: 100%;
            height: 100%;
        }

        .swiper-slide {
            text-align: center;
            font-size: 18px;
            background: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: auto; /* 슬라이드 높이를 자동으로 조정 */
        }

        .swiper-slide img {
            display: block;
            max-width: 100%;
            height: auto;
            object-fit: contain; /* 이미지가 슬라이드 안에 적절히 맞도록 조정 */
        }
    </style>

    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/027401ys.png'/>" alt="입새코 영산"/>입새코 영산 </div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/000701yz.png' />" alt="꼬부기 유정"/> "꼬부기 유정"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/015001is.png' />" alt="뮤츠 인석"/> "뮤츠 인석"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/002601sj.png' />" alt="라이츄 성준"/> "라이츄 성준"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/004801ms.png' />" alt="콘팡 민수"/> "콘팡 민수"</div>
            <div class="swiper-slide"><img src="<c:url value='/images/mainBanner/00181km.png' />" alt="피죤투 경미"/> "피죤투 경미"</div>
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
        });
    </script>

</layout:main>