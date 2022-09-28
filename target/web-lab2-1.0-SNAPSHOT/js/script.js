$(function(){
    $("form").submit(formSubmit);
});
function formSubmit(event){
    event.preventDefault();
    requestWithArgs(getX(), getY());
}
function getX(){
    return parseFloat($("#xValue").val());
}
function getR(){
    return parseFloat($("#rValue").val());
}
function getY(){
    return parseFloat($("#y").val());
}
function showPopUp(){
    $("#pop_up_panel").click(function(){
        $("#pop_up_message").slideUp(200);
        $("#pop_up_panel").fadeOut();
        });
}
function requestWithArgs(xArg, yArg) {
    $.ajax({
        url: "controller",
        type: "POST",
        data: {x: xArg, y: yArg, r: getR()},
        success: function (data) {
            $("table").html(data);
        }
    });
}   



