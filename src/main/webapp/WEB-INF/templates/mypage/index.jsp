<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<c:url var="infoUrl" value="/mypage/info"/>
<layout:main title="마이페이지">
    <a href="${infoUrl}">회원 정보 수정</a>

</layout:main>