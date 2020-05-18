var acc = document.getElementsByClassName('accordion')[0];

acc.addEventListener("click", function(){
    var panel = this.nextElementSibling;
    if(panel.style.display == "block"){
        panel.style.display = "none"
    } else {
        panel.style.display = "block";
    }
});