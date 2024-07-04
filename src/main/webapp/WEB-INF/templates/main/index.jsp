<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="imageUrl" value="/images"/>
<c:url var="pokemonUrl" value="/pokemon" />
<layout:main>
    <div class="swiper mainSwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide swiper-main">
                <a href="https://pokemonkorea.co.kr/pokemon-unite" target="_blank"></a>
            </div>
            <div class="swiper-slide">
                <a href="https://pokemonkorea.co.kr/detective_pikachu" target="_blank"></a>
            </div>
            <div class="swiper-slide">
                <a href="https://www.pokemonsleep.net/ko/" target="_blank"></a>
            </div>
            <div class="swiper-slide">
                <a href="https://pokemoncard.co.kr/card/645" target="_blank"></a>
            </div>
            <div class="swiper-slide">
                <a href="https://pokemonkorea.co.kr/pokemonLR" target="_blank"></a>
            </div>

        </div>
    </div>
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/274"/> ">
                    <img src="<c:url value='/images/mainBanner/027401ys.png' />" alt="입새코 영산">
                    입새코 영산
                </a>
            </div>
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/7"/> ">
                    <img src="<c:url value='/images/mainBanner/000701yz.png' />" alt="꼬부기 유정">
                    꼬부기 유정
                </a>
            </div>
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/1"/> ">
                    <img src="<c:url value='/images/mainBanner/000101is.png' />" alt="이상해씨 인석">
                    이상해씨 인석
                </a>
            </div>
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/26"/> ">
                    <img src="<c:url value='/images/mainBanner/002601sj.png' />" alt="라이츄 성준">
                    라이츄 성준
                </a>
            </div>
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/48"/> ">
                    <img src="<c:url value='/images/mainBanner/004801ms.png' />" alt="콘팡 민수">
                    콘팡 민수
                </a>
            </div>
            <div class="swiper-slide">
                <a href="<c:url value="..${pokemonUrl}/18"/> ">
                    <img src="<c:url value='/images/mainBanner/00181km.png' />" alt="피죤투 경미">
                    피죤투 경미
                </a>
            </div>

        </div>
        <div class="swiper-pagination"></div>
    </div>

</layout:main>