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
          href="${pageContext.request.contextPath}/sources/css/add-customer-style.css"/>

 <style>
          		.error {color:red}
          	</style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Add Employee</h2>

    </div>
</div>
    <div id="container">
<form:form action="saveCustomerReg" modelAttribute="customer" method="POST">
<form:hidden path="user_id"/>
    <table>
        <tbody>
        <tr>
                    <td><label>User Name:</label></td>
                    <td><form:input path="user_name"/>
                    <form:errors path="user_name" cssClass="error" /> </td>
                </tr>
                <tr>
                            <td><label>PassWord</label></td>
                            <td><form:input path="password"/> <form:errors path="password" cssClass="error" /> </td>
                        </tr>
                         <tr>
                                                    <td><label>Role</label></td>
                                                    <td><form:input path="role"/> <form:errors path="role" cssClass="error" /> </td>
                                                </tr>
        <tr>
            <td><label>First Name:</label></td>
            <td><form:input path="first_name"/> <form:errors path="first_name" cssClass="error" /> </td>
        </tr>
        <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="last_name"/><form:errors path="last_name" cssClass="error" /> </td>
          </tr>
            <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
        </tbody>
    </table>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list"/>Back to List</a>
    </p>
</form:form>
    </div>
</body>
</html>