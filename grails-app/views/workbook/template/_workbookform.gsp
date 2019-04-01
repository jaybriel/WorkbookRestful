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
        <li><g:link class="home" action = "index">Home</g:link></li>
    </ul>
</div>

<ul class = "nav nav-tabs">
    <li class="active"><a href ="#"> Workbook</a></li>
    <li><g:link controller="workplace" action="create">Create Workplace</g:link></li>
</ul>

<g:form  method="POST">
    <fieldset>
        <g:hiddenField name="id"  value="${workbook.id}" />
        <div class="content">
            <div class="col-5">
            <label for="firstName">First Name</label>
            <g:textField id="firstName" class="form-control col-xs-3" name="firstName" value="${workbook.firstName}"/>
            </div>
            <div class="col-5">
            <label for="lastName">Last Name</label>
            <g:textField id="lastName" class="form-control" name="lastName" value="${workbook.lastName}"/>
            </div>
            <div class="col-3">
            <label for="dateOfBirth">Date Of Birth</label>
            <g:textField data-provide="datepicker" data-date-format="yyyy-mm-dd" class="datepicker form-control" onchange="getBirthDate();"  name="dateOfBirth" id ="dateOfBirth" value="${workbook.dateOfBirth}"/>
            </div>
            <div class="col-1">
            <label for="age">Age </label>
            <g:textField id="age" class="form-control" readonly="readonly" name="age" value="${workbook.age}"  />
            </div>
            <div class="col-2">
            <label id="passportNumber">Passport Number </label>
            <g:textField name="passportNumber" class="form-control" value="${workbook.passportNumber}"/>
            </div>
            <div class="col-3">
            <label for="email">Email </label>
            <g:textField id="email" class="form-control" name="email" value="${workbook.email}"/>
            </div>
            <div class="col-3">
            <label for="phone">Phone </label>
            <g:textField class="form-control" name="phone" value="${workbook.phone}"/><br/>
            </div>
        <div class="col-3">
        <g:if test="${actionName =="create"}">
            <g:actionSubmit class= "btn btn-outline-success"  controller="workbook" action ="save" value="Create"/>
        </g:if>
        <g:else>
             <g:actionSubmit class= "btn btn-outline-success"  controller="workbook" action ="save" value="Update"/>
        </g:else>
        </div>
    </div>
    </fieldset>
</g:form>

</body>
</html>