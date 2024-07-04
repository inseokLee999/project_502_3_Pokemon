// main.js 파일 예제
document.addEventListener('DOMContentLoaded', function() {
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: 4,
        spaceBetween: 30,
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
        },
        autoplay: {
            delay: 2500,  // 2.5초마다 슬라이드 변경
            disableOnInteraction: false,  // 사용자가 슬라이드 클릭해도 자동 재생 계속
        },
    });
});
