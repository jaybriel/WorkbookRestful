<%--
  Created by IntelliJ IDEA.
  User: jsomcio
  Date: 3/11/19
  Time: 3:24 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${actionName == "viewWorkplace"}">
</g:if>
<g:else>

    <div class="nav" role="navigation">
        <ul>
            <li><g:link class="home" action="index">Home</g:link></li>
        </ul>
    </div>

    <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li role="presentation" class="active"><a href="#workbook" aria-controls="home" role="tab"
                                                  data-toggle="tab">Workbook</a></li>
        <li role="presentation"><a href="#workplaceList" aria-controls="profile" role="tab"
                                   data-toggle="tab">Workplace</a></li>
    </ul>

    <div class="tab-content">

        <div role="tabpanel" class="tab-pane active" id="workbook">
            <div id="workbook_tab">
                <h1>Workbook Details</h1>
                <table align="center">
                    <tr>
                        <g:if test="${workbook.image}">
                            <td width="200px" height="200px" rowspan="8"><img src="${resource(dir: "contact-image", file: "/${workbook.id}-${workbook.image}")}"  style="width:300px;height:300px;"/> </td>
                        </g:if>
                        <g:else>
                            <td width="200px" height="200px" rowspan="8"><g:img dir="images" file="grails.svg" class="card-img-top"/></td>
                        </g:else>



                    </tr>

                    <tr>
                        <td>First Name:</td>
                        <td>${workbook.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last Name:</td>
                        <td>${workbook.lastName}</td>
                    </tr>
                    <tr>
                        <td>Date of Birth:</td>

                        <td>${workbook.dateOfBirth}</td>
                    </tr>
                    <tr>
                        <td>Age:</td>



                        <td>${workbook.age}</td>

                    </tr>
                    <tr>
                        <td>Passport Number:</td>

                        <td>${workbook.passportNumber}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>



                        <td>${workbook.email}</td>

                    </tr>
                    <tr>
                        <td>Phone:</td>

                        <td>${workbook.phone}</td>

                    </tr>
                </table>
            </div>

        </div>

        <div role="tabpanel" class="tab-pane" id="workplaceList">
            <h1>Workplace List Details</h1>
            <g:render template="template/workplacelist" model="[workbook: workbook, action: 'view']"/>
        </div>
    </div>

</g:else>

</body>
</html>