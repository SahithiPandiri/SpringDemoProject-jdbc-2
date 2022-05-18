<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html xmlns:form="http://www.w3.org/1999/html">
<head>
<title>Save Customer Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/css/add-customer-style.css"/>
 <style>
          		.error {color:red}
          	</style>

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Employee PayRoll Management</h2>
    </div>
</div>
    <div id="container">
<form:form action="saveAccount" modelAttribute="Employee" method="POST">
<form:hidden path="user_id"/>
    <table>
        <tbody>
        <tr>
                    <td><label>Salary</label></td>
                    <td><form:input path="salary"/><form:errors path="salary" cssClass="error" /> </td>
          </tr>
            <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
        </tbody>
    </table>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/payroll/accounts"/>Back to List</a>
    </p>
</form:form>
    </div>
</body>
</html>