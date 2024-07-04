<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="guidePopupUrl" value="/game/guide" />

<layout:main title="포켓몬 카드 선택">
    <h1>포켓몬 카드 선택</h1>
    <button id="showGameDescriptionButton" class="button button-secondary" onclick="commonLib.popup.open('${guidePopupUrl}', 700, 800)">게임 설명 보기</button>
    <div class='content-box'>


        <form name="frmStep1" method="POST" action="<c:url value='/game/step2' />" autocomplete="off">
            <ul class='card-items'>
                <c:forEach var="item" items="${items}">
                    <li class='item'>
                        <input type="radio" name="seq" value="${item.seq}" onclick="frmStep1.submit();" id="seq_${item.seq}">
                        <label for="seq_${item.seq}">
                            <img src="${item.frontImage}" alt="${item.nameKr}">
                            <div class="p-name">${item.nameKr}</div>
                            <div class="p-point">
                                <fmt:formatNumber value="${item.weight * item.height * item.baseExperience}" />점
                            </div>
                        </label>
                    </li>
                </c:forEach>
            </ul>
        </form>
    </div>

    <!-- game.js 파일 포함 -->
    <script src="<c:url value='/js/game.js' />"></script>
</layout:main>