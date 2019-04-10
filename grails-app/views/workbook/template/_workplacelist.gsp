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
    <g:javascript library='jquery' />
    <asset:javascript src="jquery-3.3.1.min.js.js"/>

    <asset:javascript src="bootstrap-datepicker.js"/>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-datepicker.css')}" type="text/css">
</head>
<body>
<g:if test="${actionName =="viewWorkplace"}">
    <form method = "GET">
    <button type="button" class="btn btn-default" id="showWorkplace">Go Back to Workplace</button>
    </form>
    <h1>Workplace Details</h1>
    <table align="center">
        <tr>
            <td>Company Code:</td>
            <td>${workplace.cmpCode}</td>
        </tr>
        <tr>
            <td>Company Name:</td>
            <td>${workplace.cmpName}</td>
        </tr>
        <tr>
            <td>City Code:</td>

            <td>${workplace.ctyCode}</td>
        </tr>
        <tr>
            <td>City Description:</td>



            <td>${workplace.ctyDesc}</td>

        </tr>
        <tr>
            <td>Start Date:</td>

            <td>${workplace.startDate}</td>
        </tr>
        <tr>
            <td>End Date:</td>



            <td>${workplace.endDate}</td>

        </tr>

    </table>
</g:if>
<g:else>
<g:form method="POST" action="save" controller="workbook">
<g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
</g:form>

    <form method="GET">
        <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
        <table class="table order-list" id="myTable">
            <tr>
                <th></th>
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
                        <button type="button" class="btn btn-default" id="addWorkplace">Add Workplace</button>
                    </g:else>

            </tr>
        <tr>


            <g:each status = "i" in = "${workplaceList}" var="workplace">
                <td> <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" /></td>
                <td><g:hiddenField name="id_${workplace.id}" id ="id_${workplace.id}"  value="${workplace.id}" /></td>
                <td><g:hiddenField name="rank_${workplace.rank}" id ="rank_${workplace.rank}"  value="${workplace.rank}" /></td>
                <td>${workplace.cmpCode}</td>
                <td>${workplace.cmpName}</td>
                <td>${workplace.ctyCode}</td>
                <td>${workplace.ctyDesc}</td>
                <td>${workplace.startDate}</td>
                <td>${workplace.endDate}</td>

                <g:if test="${actionName =="view"}">
                </g:if>
                <g:else>
                    <td><button type="button" class="btn btn-warning" rank = "${workplace.rank}" id="updateWorkplace_${workplace.rank}" value="${workplace.rank}" onclick="editWorkplace(${workplace.rank})">Update</button></td>

                    <td><button type="button" class="btn btn-danger" rank = "${workplace.rank}" id="deleteWorkplace_${workplace.rank}" value="${workplace.rank}" onclick="deleteWorkplace(${workplace.rank})">Delete</button></td>
                    <td><button type="button" class="btn btn-info" rank = "${workplace.rank}" id="viewWorkplace_${workplace.rank}" value="${workplace.rank}" onclick="viewWorkplace(${workplace.rank})">View</button></td>

                %{--<td><button type="button" class="btn btn-default" id="updateWorkplace">Update</button></td>--}%
                %{--<td><button type="button" class="btn btn-default" id="showWorkplace">View</button></td>--}%
                </g:else>

                </tr>
            </g:each>

        </table>
    </form>
</g:else>
</body>
</html>