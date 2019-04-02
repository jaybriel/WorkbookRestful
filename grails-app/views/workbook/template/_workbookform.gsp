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



<g:form method="POST">
   <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
   <g:hiddenField name="id" value="${workbook.id}" />

       <g:if test="${actionName =="createWorkbook"}">
       <g:actionSubmit class= "btn btn-outline-success" actionName="create"  controller="workbook" action ="save" value="Save All"/>
       %{--<%--  <button type="button" class= "btn btn-outline-success" id ="saveAll" >Save All</button>--%>--}%



        </g:if>
        <g:else>
        <%-- <g:actionSubmit class= "btn btn-outline-success"  controller="workbook" action ="save" value="Update"/>--%>
             <button type="button" class= "btn btn-outline-success" id ="saveAll" >Update</button>
         </g:else>

 <fieldset>
     <div class="content">
         <div class="col-5">
         <label for="firstName">First Name</label>
         <g:field type="text" id="firstName" class="form-control col-xs-3" name="firstName" value="${workbook.firstName}"/>
             <g:hasErrors bean="${workbook}" field="firstName">
                 <g:eachError bean="${workbook}" field="firstName">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-5">
         <label for="lastName">Last Name</label>
         <g:field type="text" id="lastName" class="form-control" name="lastName" value="${workbook.lastName}"/>
             <g:hasErrors bean="${workbook}" field="lastName">
                 <g:eachError bean="${workbook}" field="lastName">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="dateOfBirth">Date Of Birth</label>
         <g:textField data-provide="datepicker" data-date-format="yyyy-mm-dd" class="datepicker form-control" onchange="getBirthDate();"  name="dateOfBirth" id ="dateOfBirth" value="${workbook.dateOfBirth}"/>
             <g:hasErrors bean="${workbook}" field="dateOfBirth">
                 <g:eachError bean="${workbook}" field="dateOfBirth">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-1">
         <label for="age">Age </label>
         <g:textField id="age" class="form-control" readonly="readonly" name="age" value="${workbook.age}"  />
             <g:hasErrors bean="${workbook}" field="age">
                 <g:eachError bean="${workbook}" field="age">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-2">
         <label id="passportNumber">Passport Number </label>
         <g:field type="text" maxlength="9" name="passportNumber" class="form-control" value="${workbook.passportNumber}"/>
             <g:hasErrors bean="${workbook}" field="passportNumber">
                 <g:eachError bean="${workbook}" field="passportNumber">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="email">Email </label>
         <g:field type="email" id="email" class="form-control" name="email" value="${workbook.email}"/>
             <g:hasErrors bean="${workbook}" field="email">
                 <g:eachError bean="${workbook}" field="email">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="phone">Phone </label>
         <%--<g:field type="number" maxlength="11" class="form-control" name="phone" value="${workbook.phone}"/><br/>--%>
             <input type="text" maxlength="11" name="phone" id="phone" class="form-control" value="${workbook.phone}" /> <br/>
             <g:hasErrors bean="${workbook}" field="phone">
                 <g:eachError bean="${workbook}" field="phone">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>

 </div>
 </fieldset>
</g:form>

</body>
</html>