<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<h2>기본 설정</h2>
<table class="table-cols">
    <tr>
        <th width="150">게시판 ID</th>
        <td>
            <input type="text" name="bId">
        </td>
    </tr>
    <tr>
        <th>게시판 이름</th>
        <td>
            <input type="text" name="bName">
        </td>
    </tr>
    <tr>
        <th>1페이지 행수</th>
        <td>
            <input type="number" name="rowsPerPage" min="1">
        </td>
    </tr>
    <tr>
        <th>사용 여부</th>
        <td>
            <input type="radio" name="active" value="true" id="active_true">
            <label for="active_true">사용</label>

            <input type="radio" name="active" value="false" id="active_false">
            <label for="active_false">미사용</label>
        </td>
    </tr>
</table>
<h2>분류 설정</h2>
<table class="table-cols">
    <tr>
        <th width="150">사용여부</th>
        <td>
            <input type="radio" name="activeCategoty" value="true" id="activeCategoty_true">
            <labe for="activeCategoty_true">사용</labe>

            <input type="radio" name="activeCategory" value="false" id="activeCategoty_false">
            <lable for="activeCategoty_false">미사용</lable>
        </td>
    </tr>
    <tr>
        <th>분류</th>
        <td>
            <textarea name="category"></textarea>
            <div class="message">분류가 여러개이면 줄개행을 통해 입력</div>
        </td>
    </tr>
</table>
<h2>권한 설정</h2>
<table class="table-cols">
    <tr>
        <th width="150">글쓰기/글수정</th>
        <td>
            <input type="radio" name="authority" value="ALL" id="authority_ALL">
            <lable for="authority_ALL">
                비회원+회원+관리자
            </lable>
            <input type="radio" name="authority" value="USER" id="authority_USER">
            <lable for="authority_USER">
                회원+관리자
            </lable>
            <input type="radio" name="ADMIN" value="ALL" id="authority_ADMIN">
            <lable for="authority_ADMIN">
                관리자
            </lable>
        </td>
    </tr>
</table>
