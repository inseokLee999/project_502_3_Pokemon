document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("updatePokemonButton").addEventListener("click", function() {
        updatePokemon();
    });
});

function updatePokemon() {
    fetch('/project_502_3_poketmon/random', {
        method: 'POST'
    }).then(data => {
            if (data>1) {
                alert('포켓몬 업데이트 성공!');
            } else {
                console.log(data);
                alert('포켓몬 업데이트 실패!');
            }
        })
        .catch(error => {
            console.error('에러 발생:', error);
            alert('포켓몬 업데이트 중 에러가 발생했습니다.');
        });
}
function update(){

}