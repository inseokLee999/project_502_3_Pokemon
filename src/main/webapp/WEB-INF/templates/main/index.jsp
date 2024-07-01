<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<layout:main>
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

</layout:main>