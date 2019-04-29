<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 7:00 PM
--%>

<%@ page import="org.springframework.validation.FieldError" contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>

<g:hasErrors bean="${errorBean}">
    <div class="container alert alert-danger">
        <ul role="alert">
            <g:eachError bean="${errorBean}" var="error">
                <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </div>
</g:hasErrors>

<g:hiddenField name="id" value="${workbook.id}"/>



<fieldset>
    <div class="content">

        %{--<div class="col-5">--}%
            %{--<label><g:message code="image"/></label>--}%
            %{--<g:field name="contactImage" class="form-control" type="file" placeholder="Please Upload Image"/>--}%
            %{--<g:if test="${workbook.image}">--}%
                %{--<img src="${resource(dir: "contact-image", file: "/${workbook.id}-${workbook.image}")}" class="img-thumbnail form-control-file" style="margin-top: 10px; height: 100px; width: 100px;"/>--}%
            %{--</g:if>--}%
        %{--</div>--}%


        <div class="col-5">
            <label for="firstName"><g:message code="workbook.firstName.label" default="Company"/></label>
            <g:field type="text" id="firstName" class="form-control col-xs-3" placeholder="E.G. JOSE PROTASIO JR"
                     name="firstName" value="${workbook.firstName}"/>

        </div>

        <div class="col-5">
            <label for="lastName"><g:message code="workbook.lastName.label" default="Company"/></label>
            <g:field type="text" id="lastName" class="form-control" name="lastName" placeholder="E.G. MERCADO RIZAL"
                     value="${workbook.lastName}"/>

        </div>

        <div class="col-5">
            <label for="dateOfBirth"><g:message code="workbook.dateOfBirth.label" default="Company"/></label>
            <input autocomplete="off" type="text" data-provide="datepicker" data-date-autoclose="true" data-date-format="yyyy-mm-dd"
                   placeholder="click here to select date in calendar" class="datepicker form-control"
                   onchange="getBirthDate();" name="dateOfBirth" id="dateOfBirth" value="${workbook.dateOfBirth}"/>

        </div>

        <div class="col-5">
            <label for="age"><g:message code="workbook.age.label" default="Company"/></label>
            <g:textField id="age" class="form-control" readonly="readonly" name="age" value="${workbook.age}"/>

        </div>

        <div class="col-5">
            <label id="passportNumber"><g:message code="workbook.passNumber.label" default="Company"/></label>
            <input type="text" maxlength="9" name="passportNumber"
                   placeholder="Alphanumeric only E.G EB6684441" class="form-control"
                   pattern="(?=.*\d)(?=.*[A-Z]).{9}" value="${workbook.passportNumber}"/>

        </div>

        <div class="col-5">
            <label for="email"><g:message code="workbook.email.label" default="Company"/></label>
            <g:field type="email" id="email" class="form-control" placeholder="someone@mail.com" name="email"
                     value="${workbook.email}"/>

        </div>

        <div class="col-5">
            <label for="phone"><g:message code="workbook.phone.label" default="Company"/></label>
            <input type="text" maxlength="12" name="phone" id="phone" class="form-control" pattern="[0-9]{10,12}"
                   placeholder="E.G. 632XXXXXXX(Landline) / 639XXXXXXXXXX(cellphone)"
                   value="${workbook.phone}"/>

        </div>

    </div>
</fieldset>
</body>
</html>