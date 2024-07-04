<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons"/>
<c:url var="cssUrl" value="/css/"/>
<c:url var="jsUrl" value="/js/"/>
<c:url var="imageUrl" value="/images/"/>
<c:url var="imgUrl" value="/img"/>
<c:url var="homeUrl" value="/"/>
<c:url var="searchUrl" value="/board/write"/>
<c:url var="searchUrl2" value="/board/list/freetalk"/>

<c:url var="logoUrl" value="/images/logo.png"/>
<c:url var="pokemonUrl" value="/pokemon"/>
<c:url var="gameUrl" value="/game"/>
<c:url var="mycardUrl" value="/mycard"/>
<c:url var="mainLogoUrl" value="/images/pokemonLogo.png"/>
<c:url var="adminUrl" value="/admin"/>
<c:url var="randomUrl" value="/random"/>
<c:url var="freeUrl" value="/board/list/freetalk"/>
<c:url var="noticeUrl" value="/board/list/notice"/>

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
                    <util:guestOnly>
                    <a href="<c:url value="/member/join" />">
                        <i class="xi-user-plus-o"></i>
                        <fmt:message key="회원가입"/>
                    </a>
                    <a href="<c:url value="/member/login" />">
                        <i class="xi-log-in"></i>
                        <fmt:message key="로그인"/>
                    </a>
                    </util:guestOnly>
                    <util:memberOnly>
                        <div class="logged-in-right">
                        <c:if test="${myProfile!=null}">
                            <img src="${myProfile.frontImage}">
                        </c:if>
                            <fmt:message key="LOGIN_MSG">
                            <fmt:param>${loggedMember.userName}</fmt:param>
                            <fmt:param>${loggedMember.email}</fmt:param>
                        </fmt:message>
                            <a href="<c:url value="/mypage" />">
                                <i class="xi-user-o"></i>
                                <fmt:message key="마이페이지"/>
                            </a>
                            <a href="<c:url value="/member/logout" />">
                                <i class="xi-log-out"></i>
                                <fmt:message key="로그아웃"/>
                            </a>
                        </div>
                    </util:memberOnly>
                </div>
            </div>
        </section>
        <section class="logo-search">
                <div class="layout-width inner">
                <div class="center">
                    <a href="${homeUrl}" class="logo">
                        <img src="${logoUrl}" alt="<fmt:message key="로고"/>">
                    </a>
                </div>
                <div class="main-center">
                    <a href="${homeUrl}" class="center-logo">
                        <img src="${mainLogoUrl}" alt="<fmt:message key="메인 로고"/>">
                    </a>
                </div>
                <div class="right">
                    <form class="search-box" method="GET" action="${searchUrl}" autocomplete="off">
                        <input type="text" id="searchInput" name="keyword" placeholder="<fmt:message key="검색어를_입력하세요."/>">
                        <button type="button" onclick="submitSearchForm()">
                            <i class="xi-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </section>
           <script type="text/javascript">
               function submitSearchForm() {
                   var searchKeyword = document.getElementById('searchInput').value;
                   var encodedKeyword = encodeURIComponent(searchKeyword);

                   var baseUrl = "/project_502_3_poketmon/board/list";
                   var pokUrl = "/project_502_3_poketmon"
                   var targetUrl;

                   if (searchKeyword === "자유게시판") {
                       targetUrl = baseUrl + "/freetalk";
                   } else if (searchKeyword === "공지사항") {
                       targetUrl = baseUrl + "/notice";
                   } else if (searchKeyword === "게임하기") {
                       targetUrl = pokUrl + "/game/step1";
                   } else if (searchKeyword === "포켓몬 도감" || searchKeyword === "포켓몬도감") {
                       targetUrl = pokUrl + "/pokemon";
                   }else if (searchKeyword === "포켓몬 뽑기" || searchKeyword === "포켓몬뽑기") {
                       targetUrl = pokUrl + "/random";
                   }else if (searchKeyword === "내 카드함" || searchKeyword === "내카드함") {
                       targetUrl = pokUrl + "/mycard";
                   }else {
                       targetUrl = baseUrl + "/freetalk";
                   }
                   window.location.href = targetUrl;
               }
           </script>
        </section>
        <nav>
            <div class="inner layout-width">
                <div class="dropdown">
                    <a href="#" class="ac">
                        <img src="${imageUrl}/boardLogo.png" alt="게시판 아이콘">
                        게시판
                    </a>
                    <div class="dropdown-content">
                        <a href="${freeUrl}">자유게시판</a>
                        <a href="${noticeUrl}">공지사항</a>
                    </div>
                </div>
                <a href="${pokemonUrl}">
                    <img src="${imageUrl}/wikiLogo.png" alt="도감 아이콘">
                    포켓몬 도감
                </a>
                <a href="${randomUrl}">
                    <img src="${imageUrl}/randomLogo.png" alt="뽑기 아이콘">
                    포켓몬 뽑기
                </a>
                <a href="${mycardUrl}">
                    <img src="${imageUrl}/RocketDan.webp" alt="내 카드 아이콘" id="myCard">
                    내 카드함
                </a>
                <a href="${gameUrl}">
                    <img src="${imageUrl}/gameLogo.png" alt="게임 아이콘">
                    게임하기
                </a>
                <util:adminOnly>
                    <a href="${adminUrl}">
                        <img src="${imageUrl}/masterBall.png" alt="게시판 아이콘">게시판 관리</a>
                </util:adminOnly>
            </div>
        </nav>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <footer id="ft" class="page-pokemon">
            <div class="ft-left">
                <h4> @All copyrights are in TEAM 4 <br></h4>
                <h5> choongang 502 class </h5>
            </div>
            <div class="ft-right">
                <div class="ft-top align-right">
                    <div class="flex-justify-space">
                        <a href="https://pokemonkorea.co.kr/" target="_blank">
                            <div class="pokeCorp">
                                Pokemon Korea, Inc.
                            </div>
                        </a>
                    </div>
                </div>
                <div class="ft-mdl align-right">
                    <div class="container flex-justify-space url-container">
                        <ul class="d-flex">
                            <a href="https://www.facebook.com/PokemonCoKr" target="_blank" class="icon-face"><li class="facebook"><i
                                    class="xi-facebook-official"></i>Facebook</li></a>
                            <a href="https://instagram.com/pokemon_korea_official?igshid=OGQ5ZDc2ODk2ZA=="
                                   target="_blank" class="icon-insta"><li class="instagram"><i class="xi-instagram"></i>Instagram</li></a>
                            <a href="https://www.youtube.com/user/PokemonKoreaInc" target="_blank"
                                   class="icon-youtube"><li class="youtube"><i
                                    class="xi-youtube"></i>YouTube</li></a>
                            <a href="http://www.pokemonstore.co.kr" target="_blank" class="icon-pokemon"><li class="pokemonStore"><i
                                    class="xi-shop"></i>Pokemon Store</li></a>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>

    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</layout:common>