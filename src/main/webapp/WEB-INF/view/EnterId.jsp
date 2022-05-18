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

</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Enter Your Id Please..</h2>

    </div>
</div>
    <div id="container">
<form:form action="getSingleEmployee" modelAttribute="user" method="POST">
<form:hidden path="user_id" />
    <table>
        <tbody>
        <tr>
            <td><label>Employee_Id:</label></td>
            <td><form:input path="user_id" /></td>
        </tr>
            <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Update" class="save"/></td>
                    </tr>
        </tbody>
    </table>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/"/>Back</a>
    </p>
</form:form>
    </div>
</body>
</html>