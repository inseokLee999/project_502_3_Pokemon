<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원가입' />
<c:url var="actionUrl" value="/member/join" />

<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <form name="frmJoin" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dt>
                    <fmt:message key="이메일" />
                </dt>
                <dd>
                    <input type="text" name="email">
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="비밀번호" />
                </dt>
                <dd>
                    <input type="password" name="password">
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="비밀번호_확인" />
                </dt>
                <dd>
                    <input type="password" name="confirmPassword">
                </dd>
            </dl>
            <dl>
                <dt>
                    <fmt:message key="회원명" />
                </dt>
                <dd>
                    <input type="text" name="userName">
                </dd>
            </dl>
            <div class="terms">
                <div class="tit">
                    <fmt:message key="약관_동의" />
                </div>
                <div class="termsContent">개인정보 수집 및 이용 동의
                    1. 수집하는 개인정보 항목
                    수집하는 개인정보의 종류:
                    이름
                    이메일 주소
                    전화번호
                    주소
                    기타 필요한 정보 (선택)
                    2. 개인정보의 수집 목적
                    개인정보는 다음 목적을 위해 수집합니다:
                    서비스 제공 및 운영
                    고객 상담 및 서비스 개선
                    마케팅 및 광고 활동
                    3. 개인정보의 보유 및 이용 기간
                    회사는 개인정보를 다음과 같은 목적을 위해 보유합니다:
                    서비스 제공 기간 동안
                    관련 법령에 따른 보유 기간 동안
                    4. 개인정보의 제3자 제공
                    회사는 다음과 같은 경우에 개인정보를 제3자에게 제공할 수 있습니다:
                    사용자의 동의가 있는 경우
                    법령에 따른 경우
                    5. 개인정보의 처리 위탁
                    회사는 개인정보 처리를 외부 업체에 위탁할 수 있습니다. 이 경우 필요한 법적 절차를 준수하고 안전한 처리를 보장합니다.
                    6. 이용자의 권리
                    이용자는 개인정보에 대한 열람, 정정, 삭제 등의 권리를 가집니다. 이에 대한 절차와 방법은 다음과 같습니다:
                    열람 및 수정: 사용자 본인의 계정을 통해 직접 수정 가능
                    삭제: 회사 고객 서비스 센터 또는 이메일로 요청 가능
                    7. 쿠키와 같은 기술적 정보의 수집
                    회사는 쿠키 등의 기술적 정보를 수집할 수 있으며, 이는 다음 목적으로 사용될 수 있습니다:
                    사용자 경험 개선
                    트래픽 분석 및 사이트 운영 개선
                    8. 개인정보 보호책임자 및 연락처
                    회사는 개인정보 보호책임자를 지정하여 개인정보 보호 관련 문의를 처리합니다. 연락처는 다음과 같습니다:
                    이름: 박유정
                    전화번호: 010-0000-0000
                    이메일: admin@poketmon.org</div>

                <input type="checkbox" name="termsAgree" value="true" id="termsAgree">
                <label for="termsAgree">
                    <fmt:message key="약관에_동의합니다." />
                </label>
            </div>
            <div class="button-group">
                <button type="reset">
                    <fmt:message key="다시입력" />
                </button>
                <button type="submit">
                    <fmt:message key="가입하기" />
                </button>
            </div>
        </form>
    </section>
</layout:main>