// script.js

document.addEventListener('DOMContentLoaded', function() {
    // Lấy tất cả các nút có class 'icon-btn'
    const actionButtons = document.querySelectorAll('.icon-btn');

    // Thêm sự kiện click cho mỗi nút
    actionButtons.forEach(button => {
        button.addEventListener('click', function() {
            // Lấy icon bên trong nút để biết chức năng
            const iconClass = this.querySelector('i').className;
            alert(`Bạn đã nhấn nút với icon: ${iconClass}`);
        });
    });
});
