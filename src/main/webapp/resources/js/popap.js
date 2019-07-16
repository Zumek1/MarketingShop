$(document).ready(function () {

    var ulotka = $("#ulotkaVisible")
    var licznik = 0;
    ulotka.on('click', function(){
        licznik = licznik+1;
        if(licznik%2!==0){

            $('.ulotka').css('display', 'block')
        }
        else{

            $('.ulotka').css('display', 'none')
        }
    })

    var inputy = $('tr').find('input')
    inputy.value==null
    inputy.on('keydown', function (e) {
        if(!((e.keyCode>95 && e.keyCode<106)
        || (e.keyCode>47 && e.keyCode<58)
        ||e.keyCode==8)){
            return false;
        }

    })




})