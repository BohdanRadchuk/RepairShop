function drop() {
    $(".dropdown").on("hide.bs.dropdown", function () {
        $(".btn").html('Dropdown <span class="caret"></span>');
    });
    $(".dropdown").on("show.bs.dropdown", function () {
        $(".btn").html('Dropdown <span class="caret caret-up"></span>');
    });
};