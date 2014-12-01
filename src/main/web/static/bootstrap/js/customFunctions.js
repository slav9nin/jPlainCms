/**
 * Created by artem.telizhenko on 01.12.2014.
 */
/*
 * this function is need for dropdown menus on mouse hover*/
$(function () {
    $(".dropdown").hover(
        function () {
            $(this).addClass('open')
        },
        function () {
            $(this).removeClass('open')
        }
    );
});
