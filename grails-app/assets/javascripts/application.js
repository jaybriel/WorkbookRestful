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
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workbook/workbook/showCreateWorkbook",
        async:false,
        data: {sessionId: sessio},
        success: function (result) {
            console.log("here inside");
            $("#workbook").html(result)

        }
    });

});



$(document).on('click', '#addWorkplace', function () { //addWorkplace is selector
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workbook/workplace/createWorkplace",
        data: {sessionId: sessio},
        async: false,
        success: function (result) {
            console.log("here inside");
            console.log(sessio);
            $("#workplaceList").html(result) //selector of the tab
        }
    });
});

$(document).on('click', '#showWorkplace', function () { //addWorkplace is selector
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workbook/workplace/showList",
        data: {sessionId: sessio},
        success: function (result) {
            console.log(sessio);

            $("#workplaceList").html(result)


        }
    });
});

$(document).on('click', '#saveAll', function () { //addWorkplace is selector
    console.log("here");
    var sessio = document.getElementById("sessionId").value;
    var data = $('#workbook').serialize();
    $.ajax({
        type: 'POST',
        url: "/workbook/workbook/save",
        async:false,
        data: {sessionId:sessio},
        success: function (result) {
            console.log("here inside");
            $("#workbook").html(result) //selector of the tab
        }
    });
});


function editWorkplace(ele){
    var target='#updateWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () { //addWorkplace is selector
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        // var rank = document.getElementById("rank").value;
        // var rank = $('deleteWorkplace').val();
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workbook/workplace/edit",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result) //selector of the tab
            }
        });
    });
}

function viewWorkplace(ele){
    var target='#viewWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () { //addWorkplace is selector
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        // var rank = document.getElementById("rank").value;
        // var rank = $('deleteWorkplace').val();
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workbook/workplace/viewWorkplace",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result) //selector of the tab
            }
        });
    });
}


function deleteWorkplace(ele)
{
    var target='#deleteWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () { //addWorkplace is selector
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        // var rank = document.getElementById("rank").value;
        // var rank = $('deleteWorkplace').val();
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workbook/workplace/delete",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result) //selector of the tab
            }
        });
    });
}



$(document).on('click', '#deleteWorkplace', function () { //addWorkplace is selector
    console.log("here");
    var sessio = document.getElementById("sessionId").value;
    // var rank = document.getElementById("rank").value;
    // var rank = $('deleteWorkplace').val();
    var rank = $(this).attr("rank");



    $.ajax({
        type: 'POST',
        url: "/workbook/workplace/delete",
        async:false,
        data: {sessionId:sessio,rank:rank},
        success: function (result) {
            console.log("here inside");
            console.log(rank);
            $("#workplaceList").html(result) //selector of the tab
        }
    });
});

$(document).on('click', '#updateWorkplace', function () { //addWorkplace is selector
    console.log("save here");
    var sessio = document.getElementById("sessionId").value;



    var data = $('#workplaceForm').serialize();

    $.ajax({
        type: 'POST',
        async: false,
        url: "/workbook/workplace/update",
        data: data,
        // data: {sessionId:sessio},
        success: function (result) {
            console.log(sessio);
            $("#workplaceList").html(result) //selector of the tab
        }
    });

});

$(document).on('click', '#saveWorkplace', function () { //addWorkplace is selector
    console.log("save here");
    var sessio = document.getElementById("sessionId").value;



    var data = $('#workplaceForm').serialize();

    $.ajax({
        type: 'POST',
        async: false,
        url: "/workbook/workplace/save",
        data: data,
       // data: {sessionId:sessio},
        success: function (result) {
           console.log(sessio);
            $("#workplaceList").html(result) //selector of the tab
        }
    });

});
