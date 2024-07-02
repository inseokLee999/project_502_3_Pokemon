<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="로그아웃" />
<c:url var="actionUrl" value="/member/logout" />
<c:url var="logoutLogo" value="/images/logoutLogo.gif" />
<c:url var="loginUrl" value="/member/login" />
<layout:main title="${pageTitle}">
    <div class="container">
        <h1>${pageTitle}</h1>
        <img src="${logoutLogo}">
        <!-- 움짤 넣을 예정 -->

        <p>로그아웃 되었습니다.</p>
        <p>안녕히 가세용.</p>
        <a href="${loginUrl}" class="button">
            로그인 바로가기
        </a>
        <!-- 로그인 바로가기 -->
    </div>
</layout:main>