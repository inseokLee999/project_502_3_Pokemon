<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/admin/board/save" />
<layout:admin title="게시판 등록">
    <h1>게시판 등록</h1>
    <form name="frmSave" method="post" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
        <input type="hidden" name="mode" value="register">
        <jsp:include page="_form.jsp"/>

        <div class="button-group">
            <div class="button">
                <p class="btnText">등록하기</p>
                <div class="btnTwo">
                    <p class="btnText2"> ✔ </p>
                </div>
            </div>

            <div class="button">
                <p class="btnText">다시입력</p>
                <div class="btnTwo">
                    <p class="btnText2"> ↺ </p>
                </div>
            </div>
        </div>
    </form>
</layout:admin>