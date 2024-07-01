<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="마이 페이지" />
<c:url var="actionUrl" value="/mypage" />

<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>개인 정보 수정</h1>
        <form name="frmUpdateProfile" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dt><fmt:message key="이름" /></dt>
                <dd><input type="text" name="name" required /></dd>
            </dl>
            <dl>
                <dt><fmt:message key="이메일_주소" /></dt>
                <dd><input type="email" name="email" required /></dd>
            </dl>
            <dl>
                <dt><fmt:message key="전화번호" /></dt>
                <dd><input type="text" name="phone" /></dd>
            </dl>
            <dl>
                <dt><fmt:message key="주소" /></dt>
                <dd><input type="text" name="address" /></dd>
            </dl>
            <dl>
                <dt><fmt:message key="비밀번호_변경" /></dt>
                <dd>
                    <input type="password" name="currentPassword" placeholder="<fmt:message key='현재_비밀번호' />" required /><br/>
                    <input type="password" name="newPassword" placeholder="<fmt:message key='새_비밀번호' />" /><br/>
                    <input type="password" name="confirmPassword" placeholder="<fmt:message key='새_비밀번호_확인' />" />
                </dd>
            </dl>
            <div class="button-group">
                <button type="reset"><fmt:message key="다시입력" /></button>
                <button type="submit"><fmt:message key="저장" /></button>
            </div>
        </form>
    </section>

    <section class="content-box">
            <h1>서비스 알림 설정</h1>
            <form name="frmManageSettings" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
                <dl>
                    <dt><fmt:message key="푸시_알림_설정" /></dt>
                    <dd><input type="checkbox" name="pushNotification" /></dd>
                </dl>
                <dl>
                    <dt><fmt:message key="이메일_알림_설정" /></dt>
                    <dd><input type="checkbox" name="emailNotification" /></dd>
                </dl>
                <dl>
                    <dt><fmt:message key="언어_설정" /></dt>
                    <dd>
                        <select name="language">
                            <option value="ko"><fmt:message key="한국어" /></option>
                            <option value="en"><fmt:message key="영어" /></option>
                            <!-- 다른 언어 옵션 추가 -->
                        </select>
                    </dd>
                </dl>
                <div class="button-group">
                    <button type="reset"><fmt:message key="다시입력" /></button>
                    <button type="submit"><fmt:message key="저장" /></button>
                </div>
            </form>
    </section>

    <section class="content-box">
        <h1>회원 탈퇴하기</h1>
        <form name="frmDeleteAccount" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dt><fmt:message key="회원_탈퇴_사유" /></dt>
                <dd>
                    <select name="reason">
                        <option value="no_reason"><fmt:message key="이유_없음" /></option>
                        <option value="personal_reason"><fmt:message key="개인적인_이유" /></option>
                        <option value="found_alternative"><fmt:message key="대체_서비스_찾음" /></option>
                        <option value="privacy_concerns"><fmt:message key="개인정보_보호_우려" /></option>
                    </select>
                </dd>
            </dl>
            <dl>
                <dt><fmt:message key="추가적인_의견" /></dt>
                <dd><textarea name="additionalComments" rows="4" cols="50"></textarea></dd>
            </dl>
            <dl>
                <dt><fmt:message key="탈퇴_확인을_위한_현재_비밀번호" /></dt>
                <dd><input type="password" name="confirmPassword" required /></dd>
            </dl>
            <div class="button-group">
                <button type="reset"><fmt:message key="다시입력" /></button>
                <button type="submit"><fmt:message key="탈퇴" /></button>
            </div>
        </form>
    </section>
</layout:main>


