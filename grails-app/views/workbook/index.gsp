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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>

<body>
<div id="indexWorkbook">
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="createWorkbook">Create</g:link></li>
    </ul>
</div>
<hr>

%{--<div id="list-workbook" class="content scaffold-list" role="main">--}%
<g:form method="GET">
<div class="container">
    <div class="card-deck">


<g:each in="${workbookList}" var="workbook">
    <div class="col-xs-12 col-sm-6 col-md-4">
<div class="card border-dark" style="width: 18rem;">
        <g:if test="${workbook.image}">
            <img src="${resource(dir: "contact-image", file: "/${workbook.id}-${workbook.image}")}" class="card-img-top rounded-circle"/>
        </g:if>
        <g:else>
            <g:img dir="images" file="grails.svg" class="card-img-top"/>
        </g:else>
        <div class="card-body">
            <h5 class="card-title text-center">${workbook.firstName} ${workbook.lastName}</h5>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"> <span class="fa fa-birthday-cake"></span> ${workbook.dateOfBirth}</li>
            <li class="list-group-item"> <span class="fa fa-child"></span> ${workbook.age}</li>
            <li class="list-group-item"> <span class="fa fa-passport"></span> ${workbook.passportNumber}</li>
            <li class="list-group-item"> <span class="fa fa-envelope"></span> ${workbook.email} </li>
            <li class="list-group-item"> <span class="fa fa-address-book"></span> ${workbook.phone}</li>
        </ul>
        <div class="card-body">
            <g:link action="edit" controller="workbook" params="${[id: workbook.id, actionName: 'edit']}"><button type="button" class="btn btn-warning ">Update</button></g:link>
            %{--<g:link class="delete" onclick="return confirm('Are you sure?')" action="delete" params="${[id: workbook.id]}"><button type="button" class="btn btn-danger">Delete</button></g:link>--}%
            <g:hiddenField name="id" value="${workbook.id}"/>
                <button type="button" id="deleteWorkbook" onclick="return confirm('Are you sure?')" class="btn btn-danger">Delete</button>
            <g:link params="${[id: workbook.id]}" action="show" controller="workbook" class="view"><button type="button" class="btn btn-info">View</button></g:link>
        </div>
    </div>
    </div>
</g:each>

    </div>
</div>
</g:form>

</div>
</body>
</html>