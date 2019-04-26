<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 3:28 PM
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
        <li><g:link class="home" action="index">Home</g:link></li>
    </ul>
</div>


<div>
    <g:form method="POST" enctype="multipart/form-data">
        <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}"/>
        <ul class="nav nav-tabs" role="tablist" id="myTab">
            <li role="presentation" class="active"><a href="#workbook" aria-controls="home" role="tab"
                                                      data-toggle="tab">Workbook</a></li>
            <li role="presentation"><a href="#workplaceList" aria-controls="profile" role="tab"
                                       data-toggle="tab">Workplace</a></li>
            <li style="margin-left:85vw;" >
                <g:if test="${actionName == "edit"}">
                    <g:actionSubmit class="btn btn-outline-success pull-right" actionName="create" controller="workbook" action="update"
                                    value="Save"/>
                </g:if>
                <g:else>
                    <g:actionSubmit class="btn btn-outline-success pull-right" actionName="create" controller="workbook" action="save"
                                    value="Save"/>
                </g:else>

            </li>
        </ul>

        <div class="tab-content">

            <div role="tabpanel" class="tab-pane active" id="workbook"><g:render template="template/workbookform"
                                                                                 model="[workbook: workbook, action: 'createWorkbook', errorBean: errorBean]"/></div>

            <div role="tabpanel" class="tab-pane" id="workplaceList"><g:render template="template/workplacelist"
                                                                               model="[workbook: workbook, workplaceList: workbook.workplaces, sessionId: params.sessionId, action: 'showList', wpErrorBean: wpErrorBean]"/></div>
        </div>
    </g:form>
</div>

</body>
</html>

