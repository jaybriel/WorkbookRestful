<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 3:32 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title></title>
    <meta name = "layout" content = "main" />
</head>

<body>
    <div class = "nav" role = "navigation">
        <ul>
            <li><g:link class="create" action = "create">Create</g:link></li>
        </ul>
    </div>
    <div id = "list-workbook" class="content scaffold-list" role = "main">

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Age</th>
            <th>Passport Number</th>
            <th>Email</th>
            <th>Phone</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>

        <g:each in = "${workbookList}" var="workbook">
        <tr>

            <td>${workbook.firstName}</td>
            <td>${workbook.lastName}</td>
            <td>${workbook.dateOfBirth}</td>
            <td>${workbook.age}</td>
            <td>${workbook.passportNumber}</td>
            <td>${workbook.email}</td>
            <td>${workbook.phone}</td>
            <td><g:link action = "edit" controller="workbook"  params = "${[id:workbook.id]}">Update</g:link></td>
            <td><g:link class="delete" action="delete" params = "${[id:workbook.id]}">Delete</g:link></td>
            <td><g:link params = "${[id:workbook.id]}" action ="view" controller ="workbook" class="view">View</g:link></td>


        </tr>
        </g:each>
    </table>
    </div>

</body>
</html>