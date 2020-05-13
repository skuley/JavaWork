(function(){

    // 바다
    var $waterFront = $("#water-front");
    var $waterBack = $("#water-back");

    (function loopSea(){
        $waterFront
            .animate({'bottom' : '-65px', 'left' : '-30px'}, 500)
            .animate({'bottom' : '-60px', 'left' : '-25px'}, 500);
        $waterBack
            .animate({'bottom' : '15px', 'left' : '-20px'}, 500)
            .animate({'bottom' : '10px', 'left' : '-15px'}, 500);

        $.when($waterFront, $waterBack).done(loopSea());
    })();

})()