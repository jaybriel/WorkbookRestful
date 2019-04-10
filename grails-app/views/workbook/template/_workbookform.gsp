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

    %{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-datepicker.css')}" type="text/css">--}%
</head>
<body>



<g:form method="POST">
   <g:hiddenField name="sessionId" id="sessionId" value="${params.sessionId}" />
   <g:hiddenField name="id" value="${workbook.id}" />

       <g:if test="${actionName =="createWorkbook"}">
       <g:actionSubmit class= "btn btn-outline-success" actionName="create"  controller="workbook" action ="save" value="Save All"/>




        </g:if>
        <g:else>
             <button type="button" class= "btn btn-outline-success" id ="saveAll" >Update</button>
         </g:else>

 <fieldset>
     <div class="content">
         <div class="col-5">
         <label for="firstName">First Name</label>
         <g:field type="text" id="firstName" class="form-control col-xs-3"  placeholder="E.G. JOSE PROTASIO JR" name="firstName" value="${workbook.firstName}"/>
             <g:hasErrors bean="${workbook}" field="firstName">
                 <g:eachError bean="${workbook}" field="firstName">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-5">
         <label for="lastName">Last Name</label>
         <g:field type="text" id="lastName" class="form-control" name="lastName"  placeholder="E.G. MERCADO RIZAL" value="${workbook.lastName}"/>
             <g:hasErrors bean="${workbook}" field="lastName">
                 <g:eachError bean="${workbook}" field="lastName">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="dateOfBirth">Date Of Birth</label>
         %{--<g:field type="text" data-provide="datepicker" data-date-format="yyyy-mm-dd" placeholder="click here to select date in calendar" class="datepicker form-control" onchange="getBirthDate();"  name="dateOfBirth" id ="dateOfBirth" value="${workbook.dateOfBirth}"/>--}%
         <input type="text" data-provide="datepicker" data-date-format="yyyy-mm-dd" placeholder="click here to select date in calendar" class="datepicker form-control" onchange="getBirthDate();"  name="dateOfBirth" id ="dateOfBirth" value="${workbook.dateOfBirth}"/>

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
         <g:field type="text" maxlength="9" name="passportNumber" pattern="[A-Za-z0-9]{9}" placeholder="Alphanumeric only" class="form-control" value="${workbook.passportNumber}"/>
             <g:hasErrors bean="${workbook}" field="passportNumber">
                 <g:eachError bean="${workbook}" field="passportNumber">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="email">Email </label>
         <g:field type="email" id="email" class="form-control" placeholder="someone@mail.com" name="email" value="${workbook.email}"/>
             <g:hasErrors bean="${workbook}" field="email">
                 <g:eachError bean="${workbook}" field="email">
                     <p style="color: red;"><g:message error="${it}"/></p>
                 </g:eachError>
             </g:hasErrors>
         </div>
         <div class="col-3">
         <label for="phone">Phone </label>
         <%--<g:field type="number" maxlength="11" class="form-control" name="phone" value="${workbook.phone}"/><br/>--%>
             <input type="text" maxlength="12" name="phone" id="phone" class="form-control" pattern="[0-9]{10,12}" placeholder="E.G. 632XXXXXXX(Landline) / 639XXXXXXXXXX(cellphone)" value="${workbook.phone}" /> <br/>
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