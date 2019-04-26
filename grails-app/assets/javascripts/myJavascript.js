

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

function calculateAge (birthDate, otherDate) {
    birthDate = new Date(birthDate);
    otherDate = new Date(otherDate);

    var years = (otherDate.getFullYear() - birthDate.getFullYear());

    if (otherDate.getMonth() < birthDate.getMonth() ||
        otherDate.getMonth() === birthDate.getMonth() && otherDate.getDate() < birthDate.getDate()) {
        years--;
    }

    return years;
}



function getBirthDate(){
    var dateOfBirth = document.getElementById("dateOfBirth").value;
    var calculatedage = calculateAge(dateOfBirth,new Date());
    document.getElementById("age").value = calculatedage;

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


$(document).on('click', '#showWorkbookform', function (e) {
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
$(document).on('click', '#deleteWorkbook', function (e) {
    console.log("here");
    // var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workbook/delete",
        data: {
            "id": $("#id").val()
        },
        // data: {sessionId: sessio},
        success: function (result) {
            console.log("here inside");
            // console.log(sessio);
            $("#indexWorkbook").html(result)
        }
    });
});


$(document).on('click', '#addWorkplace', function () {
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workplace/createWorkplace",
        data: {sessionId: sessio},
        async: false,
        success: function (result) {
            console.log("here inside");
            console.log(sessio);
            $("#workplaceList").html(result)
        }
    });
});

$(document).on('click', '#showWorkplace', function () {
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        url: "/workplace/showList",
        data: {sessionId: sessio},
        success: function (result) {
            console.log(sessio);

            $("#workplaceList").html(result)


        }
    });
});

function editWorkplace(ele){
    var target='#updateWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () {
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workplace/edit",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result)
            }
        });
    });
}

function viewWorkplace(ele){
    var target='#viewWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () {
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workplace/viewWorkplace",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result)
            }
        });
    });
}


function deleteWorkplace(ele)
{
    var target='#deleteWorkplace_' + ele;
    console.log(ele);
    $(document).on('click', target, function () {
        console.log("here");
        var sessio = document.getElementById("sessionId").value;
        var rank = $(this).attr("rank");



        $.ajax({
            type: 'POST',
            url: "/workplace/delete",
            async:false,
            data: {sessionId:sessio,rank:rank},
            success: function (result) {
                console.log("here inside");
                console.log(rank);
                $("#workplaceList").html(result)
            }
        });
    });
}



$(document).on('click', '#deleteWorkplace', function () {
    console.log("here");
    var sessio = document.getElementById("sessionId").value;

    var rank = $(this).attr("rank");



    $.ajax({
        type: 'POST',
        url: "/workplace/delete",
        async:false,
        data: {sessionId:sessio,rank:rank},
        success: function (result) {
            console.log("here inside");
            console.log(rank);
            $("#workplaceList").html(result)
        }
    });
});


$(document).on('click', '#saveWorkplace', function () {
    console.log("save here");
    var sessio = document.getElementById("sessionId").value;

    $.ajax({
        type: 'POST',
        async: false,
        url: "/workplace/save",
        data: {
            "sessionId": $("#sessionId").val(),
            "rank": $("#rank").val(),
            "ctyCode": $("#ctyCode").val(),
            "cmpName": $("#cmpName").val(),
            "ctyDesc": $("#ctyDesc").val(),
            "cmpCode": $("#cmpCode").val(),
            "startDate": $("#startDate").val(),
            "endDate": $("#endDate").val()
        },
        success: function (result) {
            console.log(sessio);
            $("#workplaceList").html(result)
        }
    });

});
