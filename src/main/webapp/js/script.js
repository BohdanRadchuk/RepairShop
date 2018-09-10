function drop() {
    $(".dropdown").on("hide.bs.dropdown", function () {
        $(".btn").html('Leave comment<span class="caret"></span>');
    });
    $(".dropdown").on("show.bs.dropdown", function () {
        $(".btn").html('Leave comment<span class="caret caret-up"></span>');
    });
};