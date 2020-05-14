$(document).ready(function(){
    // loging popup & popdown
    $('#login').on('click', function(){
        $('.modal').css("display", "block");
    })
    $(".cancelbtn").on('click', function(){
        $('.modal').css("display", "none");
    })
    $(".close").on('click', function(){
        $('.modal').css("display", "none");
    })
});