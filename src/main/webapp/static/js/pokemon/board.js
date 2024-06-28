document.addEventListener("DOMContentLoaded", function() {
    var containers = document.querySelectorAll('.pokemon-data');
    containers.forEach(function(container) {
        container.addEventListener('mousemove', function(e) {
            let x = e.offsetX;
            var y = e.offsetY;
            var rotateX = 4/30 * y-20;
            var rotateY = -1/5 * x+20;
            container.style.transform = `perspective(350px) rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
        });

        container.addEventListener('mouseleave', function() {
            container.style.transform = 'rotateY(0deg)';
        });
    })
});
