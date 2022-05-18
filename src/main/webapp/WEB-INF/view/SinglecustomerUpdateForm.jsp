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
        <h2>Edit Your Details</h2>

    </div>
</div>
    <div id="container">
<form:form action="saveCustomer1" modelAttribute="user2" method="POST">
<form:hidden path="user_id"/>
    <table>
        <tbody>
         <tr>
                    <td><label>User Name:</label></td>
                    <td><form:input path="user_name"/>
                    <form:errors path="user_name" cssClass="error" /></td>
                </tr>


                                    <td><form:input  type="hidden" path="password"/></td>


                                <td><form:input type="hidden" path="role"/></td>

        <tr>
            <td><label>First Name:</label></td>
            <td><form:input path="first_name"/>

            <form:errors path="first_name" cssClass="error" /></td>

        </tr>
        <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="last_name"/> <form:errors path="last_name" cssClass="error" /></td>

          </tr>

            <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
        </tbody>
    </table>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/empList1"/>Back to List</a>
    </p>
</form:form>
    </div>
</body>
</html>