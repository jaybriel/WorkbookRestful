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
    <meta name="layout" content="main"/>
</head>

<body>
<g:hasErrors bean="${wpErrorBean}">
    <div id="workplacediv" class="container alert alert-danger">
        <ul role="alert">
            <g:eachError bean="${wpErrorBean}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </div>
</g:hasErrors>
<fieldset>
    <g:hiddenField name="id" value="${workplace.id}"/>
    <g:hiddenField name="rank" value="${workplace.rank}"/>

    <div class="content">
        <div class="col-5">
            <label for="cmpCode"><g:message code="workplace.company.label" default="Company"/></label>
            <g:countrySelect class="form-control" name="cmpCode" from="${['WFG', 'IBM', 'PBCOM']}"
                             onchange="checkvalue();" valueMessagePrefix="workplace.companyCode"/>
        </div>

        <div class="col-5">
            <label for="cmpName">Company Name</label>
            <g:field type="text" id="cmpName" class="form-control" placeholder="Webb Fontaine Group Manila Branch"
                     name="cmpName" value="${workplace.cmpName}"/>
        </div>

        <div class="col-5">
            <label for="ctyCode"><g:message code="workplace.city.label" default="Company"/></label>
            <g:select name="ctyCode" from="['MANILA', 'MAKATI', 'TAGUIG','MANDALUYONG']" class="form-control"
                      value="${workplace.ctyCode}"/>
        </div>

        <div class="col-5">
            <label for="ctyDesc"><g:message code="workplace.cityDesc.label" default="Company"/></label>
            <g:textArea name="ctyDesc" class="form-control" id="ctyDesc" placeholder="Enter city description here"
                        value="${workplace.ctyDesc}"/>
        </div>

        <div class="col-5">
            <label for="startDate"><g:message code="workplace.startDate.label" default="Company"/></label>
            <g:textField data-provide="datepicker" placeholder="click here to select date in calendar"
                         data-date-format="yyyy-mm-dd" class="datepicker form-control" data-date-autoclose="true"
                         onchange="getBirthDate();" name="startDate" id="startDate" value="${workplace.startDate}"/>
        </div>

        <div class="col-5">
            <label for="endDate"><g:message code="workplace.endDate.label" default="Company"/></label>
            <g:textField data-provide="datepicker" placeholder="click here to select date in calendar"
                         data-date-format="yyyy-mm-dd" class="datepicker form-control" data-date-autoclose="true"
                         onchange="getBirthDate();" name="endDate" id="endDate" value="${workplace?.endDate}"/>
        </div>

        <div class="col-3">
            <button type="button" class="btn btn-outline-success" id="saveWorkplace">Add</button>
        </div>
    </div>
</fieldset>
</body>
</html>