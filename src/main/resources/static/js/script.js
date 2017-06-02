$(function(){
    $(".menu a").click(function(e){
        e.preventDefault();

        $(document.body).toggleClass("responsive");
    });

    var my_custom_options = {
        "no-duplicate": true,
        "edit-on-delete": false,
    };

    var obj = $("#tag");

    if (obj.length != 0) {
        var t, $tag_box;

        var t = obj.tagging(my_custom_options);

        $tag_box = t[0];

        $.getJSON("/grupos/tags", { id: $("#id").val() }, function(dados){
            for(var i = 0; i < dados.length; i++){
                $tag_box.tagging("add", dados[i].descricao);
            }

            $tag_box.on("add:after", function ( el, text, tagging ) {
                $.getJSON("/grupos/criarTag", { grupoEstudo: $("#id").val(), descricao: text });
            });

            $tag_box.on("remove:after", function ( el, text, tagging ) {
                $.getJSON("/grupos/excluirTag", { grupoEstudo: $("#id").val(), descricao: text });
            });
        });
    }
})