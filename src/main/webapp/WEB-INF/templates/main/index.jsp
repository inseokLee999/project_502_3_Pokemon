<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<layout:main>
    <head>
        <meta charset="utf-8" />
        <title>Swiper demo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
        <!-- Link Swiper's CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

        <!-- Demo styles -->
        <style>
            html,
            body {
                position: relative;
                height: 100%;
            }

            body {
                background: #ffffff;
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
            }

            .swiper-slide img {
                display: block;
                width: 100%;
                height: 100%;
                object-fit: cover;
            }
        </style>
    </head>

    <body>
    <!-- Swiper -->
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="027401ys.png" alt="입새코 영산">"입새코 영산"</div>
            <div class="swiper-slide"><img src="webapp/static/images/mianBanner/000701yz.png" alt="꼬부기 유정">"꼬부기 유정"</div>
            <div class="swiper-slide"><img src="webapp/static/images/mianBanner/015001is.png" alt="뮤츠 인석">"뮤츠 인석"</div>
            <div class="swiper-slide"><img src="webapp/static/images/mianBanner/002601sj.png" alt="라이츄 성준">"라이츄 성준"</div>
            <div class="swiper-slide"><img src="webapp/static/images/mianBanner/004801ms.png" alt="콘팡 민수">"콘팡 민수"</div>
            <div class="swiper-slide"><img src="webapp/static/images/mianBanner/00181km.png" alt="피죤투 경미">"피죤투 경미"</div>
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
            freeMode: true,
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
            },
        });
    </script>
    </body>
</layout:main>