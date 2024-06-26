<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons"/>
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/"/>
<c:url var="logoUrl" value="/images/logo.png"/>
<c:url var="pokemonUrl" value="/pokemon/board"/>
<c:url var="gameUrl" value="/game/play"/>
<c:url var="mycardUrl" value="/mycard/privatecard"/>
<c:url var="pokemonOffUrl" value="https://www.pokemonkorea.co.kr/"/>
<c:url var="instagramUrl" value="/images/sns/instagram.jpeg"/>
<layout:common title="${title}">
    <jsp:attribute name="header">
        <section class="site-top">
            <div class="layout-width inner">
                <div class="left">
                    <a href="${homeUrl}">
                        <i class="xi-home-o"></i>
                        <fmt:message key="메인화면"/>
                    </a>
                </div>
                <div class="right">
                    <a href="<c:url value="/member/join" />">
                        <i class="xi-user-plus-o"></i>
                        <fmt:message key="회원가입"/>
                    </a>
                    <a href="<c:url value="/member/login/"/> ">
                        <i class="xi-log-in"></i>
                        <fmt:message key="로그인"/>
                    </a>
                </div>
            </div>
        </section>
        <section class="logo-search">
            <div class="layout-width inner">
                <div class="left">
                    <a href="${homeUrl}" class="logo">
                        <img src="${logoUrl}" alt="<fmt:message key="로고"/>">
                    </a>
                </div>
                <div class="right">
                    <form class="search-box" method="GET" action="${searchUrl}" autocomplete="off">
                        <input type="text" name="keyword" placeholder="<fmt:message key="검색어를_입력하세요."/> ">
                        <button type="submit">
                            <i class="xi-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </section>
        <nav>
            <div class="layout-width inner">
                <a href="#">메뉴 1</a>
                <a href="${pokemonUrl}">포켓몬</a>
                <a href="#">메뉴 3</a>
                <a href="${mycardUrl}">내카드함</a>
                <a href="${gameUrl}">게임하기</a>
                <a href="#">메뉴 4</a>
                <a href="#">메뉴 5</a>
            </div>
        </nav>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <section class="site-bottom">
            <div class="layout-width inner">
                <div class="information">
                    <div>
                        <a href="${pokemonOffUrl}">
                            pokemon korea, inc.
                        </a>
                    </div>
                    <ul class="list-split">
                        <li>
                            <a href="#">회사소개</a>
                        </li>
                        <li>
                            <a href="#">사업내용</a>
                        </li>
                        <li>
                            <a href="#">제휴안내</a>
                        </li>
                        <li>
                            <a href="#">이용약관</a>
                        </li>
                    </ul>
                </div>
            </div>
        </section>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>