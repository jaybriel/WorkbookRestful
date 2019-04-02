<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 3:24 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name = "layout" content = "main"/>
</head>

<body>

<div class = "nav" role = "navigation">
    <ul>
        <li><g:link class="home" action = "index">Home</g:link></li>
    </ul>
</div>
<h1>Workbook Details</h1>
<table align="center">
    <tr>
        <td>First Name:</td>
        <td>${workbook.firstName}</td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td>${workbook.lastName}</td>
    </tr>
    <tr>
        <td>Date of Birth:</td>

        <td>${workbook.dateOfBirth}</td>
    </tr>
    <tr>
        <td>Age:</td>



    <td>${workbook.age}</td>

    </tr>
    <tr>
        <td>Passport Number:</td>

    <td>${workbook.passportNumber}</td>
    </tr>
    <tr>
        <td>Email:</td>



    <td>${workbook.email}</td>

    </tr>
    <tr>
        <td>Phone:</td>

    <td>${workbook.phone}</td>

    </tr>
</table>


<h1>Workplace List Details</h1>
<g:render template="template/workplacelist" model="[workbook:workbook, action:'view']"/>


</body>
</html>