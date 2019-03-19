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

function getBirthDate(){
    var dateOfBirth = document.getElementById("dateOfBirth").value;

    //alert(dateOfBirth);
    splitString = dateOfBirth.split("-");

   // alert(splitString[2]);

    var yearToday = new Date().getFullYear();

    var age = yearToday - splitString[0];




    document.getElementById("age").value = age;

}