document.addEventListener('mousemove', (event) => {
    const image = document.querySelector('.follow-image');
    const mouseX = event.clientX;
    const mouseY = event.clientY;
    const imageWidth = image.offsetWidth;
    const imageHeight = image.offsetHeight;

    // 이미지의 중심을 마우스 포인터에 맞추기 위해 위치 조정
    image.style.left = `${mouseX}px`;
    image.style.top = `${mouseY}px`;

});
