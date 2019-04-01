<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 7:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name = "layout" content ="main"/>
    <asset:javascript src="bootstrap-datepicker.js"/>
    <asset:javascript src="jquery-3.3.1.min.js.js"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-datepicker.css')}" type="text/css">
</head>
<body>
<div class = "nav" role = "navigation">
    <ul>
        <li><g:link class="home" controller="workbook" action = "index">Home</g:link></li>
    </ul>
</div>
<ul class = "nav nav-tabs">
    <li><g:link controller="workbook" action="create">Workbook</g:link></li>
    <li class="active"><g:link controller="workplace" action="create">Create Workplace</g:link></li>
</ul>


<table class="table order-list" id="myTable">
    <tr>
        <th></th>
        <th>Company Code</th>
        <th>Company Name</th>
        <th>City Code</th>
        <th>City Description</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
<tr>
    <td>

        <button  id="addrow"class="btn btn-info btn-lg">
        <span class="glyphicon glyphicon-plus"></span> Add
    </button></td>
    <g:form method="GET">
        <g:each in = "${workplaceList}" var="workplace">

                <td>${workplace.cmpCode}</td>
                <td>${workplace.cmpName}</td>
                <td>${workplace.ctyCode}</td>
                <td>${workplace.ctyDesc}</td>
                <td>${workplace.startDate}</td>
                <td>${workplace.endDate}</td>
                <td><g:link action = "edit" controller="workbook"  params = "${[id:workplace.id]}"><button type ="button" class="btn btn-warning"> Update </button></g:link></td>
                <td><g:link class="delete" onclick="return confirm('Are you sure?')"  action="delete" params = "${[id:workplace.id]}"><button type ="button" class="btn btn-danger"> Delete </button></g:link></td>
                <td><g:link params = "${[id:workplace.id]}" action ="view" controller ="workbook" class="view"><button type ="button" class="btn btn-info"> View </button></g:link></td>


            </tr>
        </g:each>
    </g:form>
</table>

</body>
</html>