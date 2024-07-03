<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url var="searchUrl" value="/pokemon" />

<layout:main>
    <section class="layout-width">
        <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
            포켓몬 검색 :
            <input type="text" name="skey" value="${param.skey}" placeholder="검색어를 입력하세요.">
            <button type="submit">검색</button>
        </form>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class='no-data'>조회된 포켓몬이 없습니다.</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <jsp:include page="../mypage/_my_pokemon.jsp" />

            </c:if>
        </ul>
    </section>

</layout:main>