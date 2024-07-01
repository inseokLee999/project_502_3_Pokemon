<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:url var="loginUrl" value="/member/login"/>
<c:set var="item" value="${items}"/>
<layout:main>
    <util:guestOnly>
        <h1>로그인이 필요한 페이지입니다.</h1>
        <a href="<c:url value="..${loginUrl}"/>">
            로그인 하러가기
        </a>
    </util:guestOnly>
    <util:memberOnly>
        <h1>포켓몬 뽑기 페이지</h1>
        <h2>${loggedMember.userName} 님 포켓몬 뽑기!!</h2>
        현재 포켓몬 : ${loggedMember.myPokemonSeq}
        <img src="${data.frontImage}">
        ${data.nameKr}
        <button id="updatePokemonButton">포켓몬 업데이트</button>
    </util:memberOnly>
</layout:main>