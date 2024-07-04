document.addEventListener("DOMContentLoaded", function() {
    var containers = document.querySelectorAll('.pokemon-data');

    containers.forEach(function(container) {
        container.addEventListener('mousemove', function(e) {
            let rect = container.getBoundingClientRect();
            let x = e.clientX - rect.left;
            let y = e.clientY - rect.top;
            let centerX = rect.width / 2;
            let centerY = rect.height / 2;
            let rotateX = (centerY - y) / centerY * 20; // 중앙을 기준으로 회전 각도 계산
            let rotateY = (x - centerX) / centerX * 20;

            container.style.transform = `perspective(350px) rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
        });

        container.addEventListener('mouseleave', function() {
            container.style.transform = 'perspective(350px) rotateX(0deg) rotateY(0deg)';
        });
    });
});
