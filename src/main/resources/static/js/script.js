$(function(){
    $(".menu a").click(function(e){
        e.preventDefault();

        $(document.body).toggleClass("responsive");
    });
})