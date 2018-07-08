$('#campo-senha').keyup(function () {
    var senha = $('#campo-senha').val();
    console.log('aqui: ' + senha);
    if (senha != "") {
        var obj = JSON.stringify({ senha: senha });
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: URL_SERVER + '/validar-senha',
            data: obj,
            success: function (res) {
                score = res.score;
                $('#complexidade').text(res.complexidade);
                $('#score').text(score + '%');
                var cor = mudarCorComplexidade(score);
                removeClasses();
                $('#complexidade').addClass(cor);
            }
        });
    } else {
        removeClasses();
        $('#complexidade').text('Muito curta');
        $('#score').text('0%');
    }
});

function mudarCorComplexidade(score) {
    var cor = " ";
    if (score >= 0 && score < 20) { cor = "deep-orange darken-2"; }
    else if (score >= 20 && score < 40) { cor = "orange darken-2"; }
    else if (score >= 40 && score < 60) { cor = "amber darken-1"; }
    else if (score >= 60 && score < 80) { cor = " light-green darken-1"; }
    else if (score >= 80 && score <= 100) { cor = " light-green darken-4"; }

    return cor;
}
function removeClasses(){
    $('#complexidade').removeClass('deep-orange darken-2');
    $('#complexidade').removeClass('orange darken-2');
    $('#complexidade').removeClass('amber darken-1');
    $('#complexidade').removeClass(' light-green darken-1');
    $('#complexidade').removeClass('light-green darken-4');
}