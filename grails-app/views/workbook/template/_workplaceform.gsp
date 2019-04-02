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

<form id="workplaceForm" method="POST">
    <fieldset>
        <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
        <g:hiddenField name="id"  value="${workplace.id}" />
        <div class="content">
            <div class="col-1">
                <label for="cmpCode">Company Code</label>
                <g:field type ="number" id="cmpCode" class="form-control col-xs-3" name="cmpCode" value="${workplace.cmpCode}"/>
                <g:hasErrors bean="${workplace}" field="cmpCode">
                    <g:eachError bean="${workplace}" field="cmpCode">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>
            <div class="col-5">
                <label for="cmpName">Company Name</label>
                <g:field type="text" id="cmpName" class="form-control" name="cmpName" value="${workplace.cmpName}"/>
                <g:hasErrors bean="${workplace}" field="cmpName">
                    <g:eachError bean="${workplace}" field="cmpName">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

            <div class="col-1">
                <label for="ctyCode">City Code</label>
                <g:field type="number" id="ctyCode" class="form-control" name="ctyCode" value="${workplace.ctyCode}"  />
                <g:hasErrors bean="${workplace}" field="ctyCode">
                    <g:eachError bean="${workplace}" field="ctyCode">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>
            <div class="col-2">
                <label id="ctyDesc">City Description</label>
                <g:textArea name="ctyDesc" class="form-control" value="${workplace.ctyDesc}"/>
                <g:hasErrors bean="${workplace}" field="ctyDesc">
                    <g:eachError bean="${workplace}" field="ctyDesc">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>
            <div class="col-3">
                <label for="startDate">Start Date</label>
                <g:textField data-provide="datepicker" data-date-format="yyyy-mm-dd" class="datepicker form-control" onchange="getBirthDate();"  name="startDate" id ="startDate" value="${workplace.startDate}"/>
                <g:hasErrors bean="${workplace}" field="startDate">
                    <g:eachError bean="${workplace}" field="startDate">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>
            <div class="col-3">
                <label for="endDate">End Date</label>
                <g:textField data-provide="datepicker" data-date-format="yyyy-mm-dd" class="datepicker form-control" onchange="getBirthDate();"  name="endDate" id ="endDate" value="${workplace.endDate}"/>
                <g:hasErrors bean="${workplace}" field="endDate">
                    <g:eachError bean="${workplace}" field="endDate">
                        <p style="color: red;"><g:message error="${it}"/></p>
                    </g:eachError>
                </g:hasErrors>
            </div>

        <div class="col-3">
            <g:if test="${actionName =="createWorkplace"}">

                <button type="button" class= "btn btn-outline-success" id ="saveWorkplace" >Add</button>
            </g:if>
            <g:else>
                <g:actionSubmit class= "btn btn-outline-success"  controller="workplace" action ="showList" value="Update"/>
            </g:else>

        </div>
        </div>
    </fieldset>
</form>
</body>
</html>