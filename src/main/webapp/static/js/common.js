document.addEventListener('mousemove', (event) => {
    const image = document.querySelector('.follow-image');
    const mouseX = event.clientX;
    const mouseY = event.clientY;
    const imageWidth = image.offsetWidth;
    const imageHeight = image.offsetHeight;

    // 이미지의 오른쪽 하단 모서리를 마우스 포인터에 맞추기 위해 위치 조정
    // image.style.left = `${mouseX}px`;
    // image.style.top = `${mouseY}px`;
    image.style.transform = `translate(${mouseX}px, ${mouseY}px)`;
});
