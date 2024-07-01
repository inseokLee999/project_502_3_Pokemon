<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="infoUrl" value="/mypage/info" />
<c:url var="alertUrl" value="mypage/alert" />
<layout:main title="마이페이지">
    <a href="${infoUrl}" class="button1">
    회원정보 수정
    </a>
    <a href="${alertUrl}" class="button2">
        서비스 설정
    </a>
</layout:main>

