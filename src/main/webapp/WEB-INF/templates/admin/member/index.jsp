<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:admin>

<c:if test="${memberList != null && !memberList.isEmpty()}">
<div class="container-adminMember">
        <ul>
            <c:forEach var="member" items="${memberList}">
                <li>
                    <label>
                        ${member.userName}님, 가입 이메일: ${member.email}, 타입: ${member.userType}
                    </label>
                </li>
            </c:forEach>
        </ul>
</div>
</c:if>
</layout:admin>