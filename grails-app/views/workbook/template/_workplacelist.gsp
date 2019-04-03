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


<!--<button class="btn btn-default" id="saveAll" type="button" >Save All</button>-->



<g:if test="${actionName =="view"}">
</g:if>
<g:else>
<g:form method="POST" action="save" controller="workbook">
<g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
<%-- <g:link action="save" controller="workbook"><button type="button" class="btn btn-outline-success">Save All</button></g:link>--%>
   <%--   <g:actionSubmit class= "btn btn-outline-success"  controller="workbook" action ="save" value="Save All"/>--%>
        <!--<button type="button" class= "btn btn-outline-success" id ="saveWorkbook" >Add</button>-->

</g:form>

</g:else>




<g:form method="POST">
<table class="table order-list" id="myTable">
<tr>
    <th></th>
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

    <g:if test="${actionName =="view"}">
    </g:if>
    <g:else>
        <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
        <button type="button" class="btn btn-default" id="addWorkplace">Add Workplace</button>

    </g:else>

    <!--
    <a href="#" data-target="#workplaceform" class="media_node span" id="workplaceform_tab" data-toggle="tabajax" rel="tooltip">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
    </a>--></td>
</tr>
<tr>

    <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
    <g:each status = "i" in = "${workplaceList}" var="workplace">
            <td><g:hiddenField name="id" id ="id"  value="${workplace.id}" /></td>
        <td><g:hiddenField name="rank" id ="rank"  value="${i}" /></td>
            <td>${workplace.cmpCode}</td>
            <td>${workplace.cmpName}</td>
            <td>${workplace.ctyCode}</td>
            <td>${workplace.ctyDesc}</td>
            <td>${workplace.startDate}</td>
            <td>${workplace.endDate}</td>

        <g:if test="${actionName =="view"}">
        </g:if>
        <g:else>
            %{--<td><g:link action = "edit" controller="workplace"  params = "${[id:workplace.id]}"><button type ="button" class="btn btn-warning"> Update </button></g:link></td>--}%
            %{--<td><g:link class="delete" onclick="return confirm('Are you sure?')" controller="workplace" action="delete" params = "${[rank:i]}"><button type ="button" class="btn btn-danger"> Delete </button></g:link></td>--}%
            %{--<td><g:link params = "${[id:workplace.id]}" action ="view" controller ="workbook" class="view"><button type ="button" class="btn btn-info"> View </button></g:link></td>--}%
            %{--<td><g:link class="delete" onclick="return confirm('Are you sure?')" controller="workplace" action="delete" params = "${[rank:i]}"><button type ="button" class="btn btn-danger"> Delete </button></g:link></td>--}%
            <td><button type="button" class="btn btn-default" id="deleteWorkplace">Delete</button></td>
            <td><button type="button" class="btn btn-default" id="updateWorkplace">Update</button></td>
            <td><button type="button" class="btn btn-default" id="showWorkplace">View</button></td>
        </g:else>

        </tr>
    </g:each>

</table>
</g:form>
<%--<g:actionSubmit value="Save All"  controller="workbook" action="save"/>--%>

<!--<button type="submit" class="btn btn-default" id="saveAll">Save All</button>-->

</body>
</html>