// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-3.3.1.min
//= require bootstrap
//= require popper.min
//= require_self



$(function() {
    $('a[data-toggle="tab"]').on('click', function(e) {
        window.localStorage.setItem('activeTab', $(e.target).attr('href'));
    });
    var activeTab = window.localStorage.getItem('activeTab');
    if (activeTab) {
        $('#myTab a[href="' + activeTab + '"]').tab('show');
        window.localStorage.removeItem("activeTab");
    }
});







function getBirthDate(){
    var dateOfBirth = document.getElementById("dateOfBirth").value;

    //alert(dateOfBirth);
    splitString = dateOfBirth.split("-");

   // alert(splitString[2]);

    var yearToday = new Date().getFullYear();

    var age = yearToday - splitString[0];




    document.getElementById("age").value = age;

}

$('[data-toggle="tabajax"]').click(function(e) {
    var $this = $(this),
        loadurl = $this.attr('href'),
        targ = $this.attr('data-target');

    $.get(loadurl, function(data) {
        $(targ).html(data);
    });

    $this.tab('show');
    return false;
});

$(document).ready(function() {
    $("#button_1").click(function (e) {
        e.preventDefault();
        sendAjaxRequest($(this), '/workbook/create');
    });
});


$(document).on('click', '#showWorkbookform', function (e) { //addWorkplace is selector
    console.log("here")
    var sessio = document.getElementById("sessionId").value

    $.ajax({
        type: 'POST',
        url: "/workbook/workbook/showCreateWorkbook",
        data: {sessionId: sessio},
        success: function (result) {
            console.log("here inside")
            $("#workbook").html(result).addClass("active") //selector of the tab
            $("#workplacelist").html(result).removeClass("active") //selector of the tab

        }
    });

});



$(document).on('click', '#addWorkplace', function () { //addWorkplace is selector
    console.log("here")
    var sessio = document.getElementById("sessionId").value

    $.ajax({
        type: 'POST',
        url: "/workbook/workplace/createWorkplace",
        data: {sessionId: sessio},
        async: false,
        success: function (result) {
            console.log("here inside")
            $("#workplaceList").html(result) //selector of the tab
        }
    });
});

$(document).on('click', '#showWorkplace', function () { //addWorkplace is selector
    console.log("here")
    var sessio = document.getElementById("sessionId").value

    $.ajax({
        type: 'POST',
        url: "/workbook/workplace/showList",
        async:false,
        data: {sessionId: sessio},
        success: function (result) {
            console.log(sessio)

            $("#workplacelist").html(result)


        }
    });
});

$(document).on('click', '#saveAll', function () { //addWorkplace is selector
    console.log("here")
    var sessio = document.getElementById("sessionId").value
    var data = $('#workbook').serialize()
    $.ajax({
        type: 'POST',
        url: "/workbook/workbook/save",
        data: {sessionId:sessio},
        success: function (result) {
            console.log("here inside")
            $("#workbook").html(result) //selector of the tab
        }
    });
});

$(document).on('click', '#saveWorkplace', function () { //addWorkplace is selector
    console.log("save here")
    var sessio = document.getElementById("sessionId").value;
    var data = $('#workplaceForm').serialize()

    $.ajax({
        type: 'POST',
        async: false,
        url: "/workbook/workplace/save",
        data: data,
       // data: {sessionId:sessio},
        success: function (result) {
           console.log(sessio)
            $("#workplaceList").html(result) //selector of the tab
        }
    });
    // $.ajax({
    //     type: 'POST',
    //     url: "/workbook/workplace/showList",
    //     data: data,
    //     success: function (result) {
    //         console.log("here inside")
    //         $("#workplacelist").html(result) //selector of the tab
    //     }
    // });
});
