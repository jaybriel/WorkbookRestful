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


</body>
</html>