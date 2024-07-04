<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:url var="searchUrl" value="/pokemon" />
<c:url var="loginUrl" value="/member/login"/>
<c:set var="item" value="${items}"/>

<layout:main>
    <util:guestOnly>
        <div class="content-box">
            <h1>로그인이 필요한 페이지입니다.</h1>
            <div class="centered">
                <a href="<c:url value="../../..${loginUrl}?redirectUrl=/mycard"/>" class="button button-secondary">로그인 하러가기</a>
            </div>

        </div>
    </util:guestOnly>

    <util:memberOnly>
    <section class="layout-width">
        <div class="search-box">
        <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
            포켓몬 검색 :
            <input type="text" name="skey" value="${param.skey}" placeholder="원하시는 포켓몬 이름을 입력하세요.">
            <button type="submit" class="button button-secondary">검색</button>
        </form>
        </div>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class='no-data'>조회된 포켓몬이 없습니다.</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <jsp:include page="_my_Pokemon2.jsp" />

            </c:if>
        </ul>
    </section>
    </util:memberOnly>
</layout:main>