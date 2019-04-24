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
    <meta name="layout" content="main"/>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="createWorkbook">Create</g:link></li>
    </ul>
</div>

<div id="list-workbook" class="content scaffold-list" role="main">

    <table>
        <tr>
            <th></th>
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
        <g:form method="GET">
            <g:each in="${workbookList}" var="workbook">
                <tr>
                    <td>
                        <g:if test="${workbook.image}">
                        <img src="${resource(dir: "contact-image", file: "/${workbook.id}-${workbook.image}")}" class="img-thumbnail" style="height: 50px; width: 50px;"/>
                    </g:if>
                        <g:else>
                            <g:img dir="images" file="grails.svg" class="img-thumbnail" style="height: 50px; width: 50px;"/>
                        </g:else></td>
                    <td>${workbook.firstName}</td>
                    <td>${workbook.lastName}</td>
                    <td>${workbook.dateOfBirth}</td>
                    <td>${workbook.age}</td>
                    <td>${workbook.passportNumber}</td>
                    <td>${workbook.email}</td>
                    <td>${workbook.phone}</td>
                    <td><g:link action="edit" controller="workbook"
                                params="${[id: workbook.id, actionName: 'edit']}"><button type="button"
                                                                                          class="btn btn-warning">Update</button></g:link>
                    </td>
                    <td><g:link class="delete" onclick="return confirm('Are you sure?')" action="delete"
                                params="${[id: workbook.id]}"><button type="button"
                                                                      class="btn btn-danger">Delete</button></g:link>
                    </td>
                    <td><g:link params="${[id: workbook.id]}" action="view" controller="workbook" class="view"><button
                            type="button" class="btn btn-info">View</button></g:link></td>

                </tr>
            </g:each>
        </g:form>
    </table>
</div>

</body>
</html>