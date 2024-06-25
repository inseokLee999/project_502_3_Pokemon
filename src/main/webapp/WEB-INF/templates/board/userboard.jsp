<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="userPageTitle" key="유저게시판"/>

<layout:main title="${userPageTitle}">
   <h1>유저 게시판</h1>
</layout:main>