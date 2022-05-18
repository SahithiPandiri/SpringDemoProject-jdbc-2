<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns:c="">
<head>
    <title>list of employees</title>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style.css"/>
    <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
<h2>Employee Update Page</h2>
    </div>
</div>
<div id="container">
 <div id="container">
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
    <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><form:input path="first_name"/></td>
            </tr>
            <tr>
                        <td><label>Last Name:</label></td>
                        <td><form:input path="last_name"/></td>
              </tr>

                <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save" class="save"/></td>
                        </tr>
            </tbody>
        </table>
        <div style="clear; both;"></div>
    </form:form>
    </div>
<br><br>
 <a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>