<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="로그인" />
<c:url var="actionUrl" value="/member/login" />
<c:url var="joinUrl" value="/member/join" />
<layout:main title="${pageTitle}">
    <div class="content-box-login">
        <h1>${pageTitle}</h1>

        <form name="frmLogin" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <c:if test="${! empty param.redirectUrl}">
                <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
            </c:if>

            <input type="text" name="email" placeholder="<fmt:message key="이메일" />" autofocus value="${cookie.saveEmail != null ? cookie.saveEmail.value : ''}">
            <input type="password" name="password" placeholder="<fmt:message key="비밀번호" />">
            <div class="save-email">
                <input type="checkbox" name="saveEmail" value="true" id="saveEmail"${cookie.saveEmail  != null ? ' checked':''}>
                <label for="saveEmail">
                    <fmt:message key="이메일_기억하기" />
                </label>
            </div>
            <button type="submit">
                <fmt:message key="로그인" />
            </button>
        </form>
        <a href="${joinUrl}" class="joinButton">
            아직 회원이 아니신가요?
        </a>
    </div>


</layout:main>