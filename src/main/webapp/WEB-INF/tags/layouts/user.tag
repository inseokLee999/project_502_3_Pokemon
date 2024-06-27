<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons"/>
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="homeUrl" value="/"/>
<c:url var="logoUrl" value="/images/logo.png"/>
<layout:main title="${title}">
    <section>
        <div class="board_search_box2">
            <select name="searchType">
                <option value="TITLE">제목</option>
                <option value="CONTENT">내용</option>
                <option value="WRITER">작성자</option>
            </select>
            <input type="text" id="articleKeyword" class="text" name="keyword">
            <button id="btnArticleSearch" class="btn_board_search"><em>검색</em></button>
        </div>
    </section>
</layout:main>
