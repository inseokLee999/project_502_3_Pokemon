<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@taglib prefix="pk" tagdir="/WEB-INF/tags/pokemon" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="searchUrl" value="/pokemon"/>
<layout:main>
    <section class="layout-width">
        <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off">
            포켓몬 검색 :
            <input type="text" name="skey" value="${param.skey}" placeholder="검색어를 입력하세요.">
            <button type="submit" class="button button-secondary">검색</button>

        </form>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class='no-data'>조회된 포켓몬이 없습니다.</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <div>

                    </div>
                    <li>
                        <div class="pokemon-data">
                            <a href="<c:url value='/pokemon/${item.seq}' />">
                                <img src="${item.frontImage}" alt="${item.nameKr}">
                                <div class="p-text">
                                    <div class="p-name">
                                            ${item.nameKr}<br>(${item.name})<br>
                                        <span class="badge badge-${item.type1}"><fmt:message key="${item.type1}"/></span>
                                        <c:if test="${item.type2!=null &&item.type2.length()<10}">
                                            <span class="badge badge-${item.type2}"><fmt:message key="${item.type2}"/></span>
                                        </c:if>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div>
                            <pk:myPokemon seq="${item.seq}"/>
                        </div>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </section>
    <util:pagination/>
    <script src="js/pokemon/board.js"></script>
</layout:main>
