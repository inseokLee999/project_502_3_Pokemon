<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="${board.BName}">
    <section class="layout-width">
        <h1>${board.BName}</h1>
        <jsp:include page="_header.jsp" />
    </section>
</layout:main>v