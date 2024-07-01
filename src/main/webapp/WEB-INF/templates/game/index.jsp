<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<fmt:message var="gamepageTitle" key='게임창' />

<c:url var="loginUrl" value="/member/login"/>
<c:url var="gameUrl" value="/game" />
<c:set var="item" value="${items}"/>
<layout:main title="${gamepageTitle}">
    <util:guestOnly>
        <div class="content-box">
            <h1>로그인이 필요한 페이지입니다.</h1>

            <div class="centered">
                <a href="<c:url value="..${loginUrl}"/>" class="button button-secondary">로그인 하러가기</a>
            </div>
        </div>

    </util:guestOnly>

    <util:memberOnly>
        <a href="<c:url value="..${gameUrl}/${loggedMember.myPokemonSeq}"/> ">
            <img src="${data.frontImage}">
        </a>
        <div>
            현재 포켓몬 : ${loggedMember.myPokemonSeq} - ${data.nameKr}<br>
                ${data.nameKr}
        </div>

        <h2>대결할 포켓몬 뽑기!!</h2>

        <a href="<c:url value='/random' />">
            <button id="updatePokemonButton" >포켓몬 다시 뽑기</button>
        </a>


</util:memberOnly>
</layout:main>