<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons" />
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/mypage/alert" />
<layout:main title="서비스 설정">

<section class="layout-width-alert">
    <h1>서비스 설정</h1>
    <form name="frmManageSettings" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
        <dl>
            <dt>
                <fmt:message key="팝업_알림_수신_동의" />
            </dt>
            <dd>
                <input type="checkbox" name="agree" />
                알림 설정에 동의합니다
                <input type="checkbox" name="no_agree" />
                알림 설정에 동의하지 않습니다
            </dd>
        </dl>
        <dl>
            <dt>
                <fmt:message key="이메일_알림_수신_동의" />
            </dt>
            <dd>
                <input type="checkbox" name="agree" />
                알림 설정에 동의합니다
                <input type="checkbox" name="no_agree" />
                알림 설정에 동의하지 않습니다
            </dd>
        </dl>
        <dl>
            <dt>
                <fmt:message key="SMS_알림_수신_동의" />
            </dt>
            <dd>
                <input type="checkbox" name="agree" />
                알림 설정에 동의합니다
                <input type="checkbox" name="no_agree" />
                알림 설정에 동의하지 않습니다
            </dd>
        </dl>
        <dl>
            <dt><fmt:message key="언어_설정" /></dt>
            <dd>
                <select name="language">
                    <option value="ko">
                        <fmt:message key="한국어" />
                    </option>
                    <option value="en">
                        <fmt:message key="영어" />
                    </option>
                </select>
            </dd>
        </dl>
        <button type="submit">
            <fmt:message key="저장" />
        </button>
    </form>
</section>
</layout:main>