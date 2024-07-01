document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("updatePokemonButton").addEventListener("click", function() {
        updatePokemon();
    });
});

function updatePokemon() {
    fetch('/project_502_3_poketmon/random', {
        method: 'POST'
    }).then(data => {
            alert("포켓몬 업데이트 완료");
        })
        .catch(error => {
            console.error('에러 발생:', error);
            alert('포켓몬 업데이트 중 에러가 발생했습니다.');
        });
}
