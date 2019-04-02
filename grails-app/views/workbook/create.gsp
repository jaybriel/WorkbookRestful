<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 3:28 PM
--%>

<%
    /*
${actionName}


    <g:render template="template/workbookform" model="[workbook:workbook, actionName:actionName]"/>
*/

 %>


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




<div>

<!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li role="presentation" class="active"><a href="#workbook" aria-controls="home" role="tab" data-toggle="tab">Workbook</a></li>
        <li role="presentation"><a href="#workplaceList" aria-controls="profile" role="tab" data-toggle="tab">Workplace</a></li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
    <g:hiddenField name="sessionId" id="sessionId" value="${params.instId}" />
        <div role="tabpanel" class="tab-pane active" id="workbook"><g:render template="template/workbookform" model="[workbook:workbook, sessionId:params.instId, action:'createWorkbook',]"/></div>
        <div role="tabpanel" class="tab-pane" id="workplaceList"><g:render template="template/workplacelist" model="[workbook:workbook,workplaceList:workbook.workplaces,action:'showList']" /></div>
    </div>

</div>

</body>
</html>

