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
<div class="content scaffold-edit datepicker">



<g:form  method="POST">
<fieldset

        <g:hiddenField name="id" value="${workbook.id}" />
        <label>First Name: </label>
        <g:textField name="firstName" value="${workbook.firstName}"/><br/>
        <label>Last Name: </label>
        <g:textField name="lastName" value="${workbook.lastName}"/><br/>
        <label>Date Of Birth: </label>
      <g:textField data-provide="datepicker" class="datepicker" onchange="getBirthDate();"  name="dateOfBirth" id ="dateOfBirth" value="${workbook.dateOfBirth}"/><br/>



        <label>Age: </label>
        <g:textField disabled = "true" name="age" value="${workbook.age}"  /><br/>





        <label>Passport Number: </label>
        <g:textField name="passportNumber" value="${workbook.passportNumber}"/><br/>
        <label>Email: </label>
        <g:textField name="email" value="${workbook.email}"/><br/>
        <label>Phone: </label>
        <g:textField name="phone" value="${workbook.phone}"/><br/>

        <g:if test="${actionName =="create"}">


            <g:actionSubmit class= "save"  controller="workbook" action ="save" value="Create"/>

    </g:if>
    <g:else>


 <g:actionSubmit class= "save"  controller="workbook" action ="editWorkbook" value="Update"/>



    </g:else>
    </fieldset>
</g:form>

</div>
</body>
</html>