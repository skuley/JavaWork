var login = $("#account_info a");
var modelBg = $(".model_bg");

login.on("click", function(){
    modelBg.classList.add('bg_active');
})