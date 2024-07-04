//관리자 페이지- 회원관리 -> 체크박스 선택시 전체 체크박스 선택되게 구현

window.addEventListener("DOMContentLoaded", function() {
    const checkAlls = document.getElementsByClassName("checkall");
    for (const el of checkAlls) {
        el.addEventListener("click", function() {
            const targetName = this.dataset.targetName;
            const chks = document.getElementsByName(targetName);
            for (const chk of chks) {
                chk.checked = this.checked;
            }
        });
    }
});
