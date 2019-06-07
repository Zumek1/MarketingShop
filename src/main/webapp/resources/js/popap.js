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




})