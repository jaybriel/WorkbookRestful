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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.0.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

</head>

<body>

<g:if test="${actionName == "viewWorkplace"}">
</g:if>
<g:else>
    <g:form method="GET">
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

            <div class="container">
                <div class="jumbotron">
                  <div class="row">
                      <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                          <g:if test="${workbook.image}">
                              <img src="${resource(dir: "contact-image", file: "/${workbook.id}-${workbook.image}")}" class="card-img-top rounded-circle"/>
                          </g:if>
                          <g:else>
                              <g:img dir="images" file="grails.svg" class="card-img-top"/>
                          </g:else>  </div>
                      <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                          <div class="container" style="border-bottom:1px solid black">
                            <h2>${workbook.firstName} ${workbook.lastName}</h2>
                          </div>
                            <hr>
                          <ul class="container details">
                            <li><p><span class="fa fa-birthday-cake" style="width:50px;"></span>${workbook.dateOfBirth}</p></li>
                            <li><p><span class="fa fa-child" style="width:50px;"></span>${workbook.age}</p></li>
                            <li><p><span class="fa fa-passport" style="width:50px;"></span>${workbook.passportNumber}</p></li>
                            <li><p><span class="fa fa-envelope" style="width:50px;"></span>${workbook.email}</p></li>
                              <li><p><span class="fa fa-address-book" style="width:50px;"></span>${workbook.phone}</p></li>
                          </ul>
                      </div>
                  </div>
                </div>

            </div>

        </div>
        </div>

        <div role="tabpanel" class="tab-pane" id="workplaceList">
            <h1>Workplace List Details</h1>
            <g:render template="template/workplacelist" model="[workbook: workbook, action: 'view']"/>
        </div>
    </div>
    </g:form>
</g:else>

</body>
</html>