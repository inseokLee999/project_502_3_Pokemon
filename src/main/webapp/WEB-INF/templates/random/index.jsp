<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:url var="loginUrl" value="/member/login"/>
<c:url var="pokemonUrl" value="/pokemon"/>
<c:set var="item" value="${items}"/>
<layout:main>
    <util:guestOnly>
        <div class="content-box">
        <h1>로그인이 필요한 페이지입니다.</h1>
            <div class="centered">
                <a href="<c:url value="..${loginUrl}?redirectUrl=/random"/>" class="button button-secondary">로그인 하러가기</a>
            </div>

        </div>
    </util:guestOnly>
    <util:memberOnly>
        <h1>포켓몬 뽑기 페이지</h1>
        <h2>${loggedMember.userName} 님 포켓몬 뽑기!!</h2>
        <a href="<c:url value="..${pokemonUrl}/${loggedMember.myPokemonSeq}"/> ">
            <img src="${data.frontImage}">
        </a>
        <div>
            현재 포켓몬 : ${loggedMember.myPokemonSeq}<br>
                ${data.nameKr}
        </div>
        <a href="<c:url value='/random' />">
            <button id="updatePokemonButton" >포켓몬 다시 뽑기</button>
        </a>
    </util:memberOnly>
</layout:main>