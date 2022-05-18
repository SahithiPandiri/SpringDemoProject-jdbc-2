<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns:c="">
<head>
    <title>list of employees</title>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
<h2>Employee Salary List</h2>
    </div>
</div>
<div id="container">
    <div id="content">

        <table>
            <tr>
                <th>Salary_Id</th>
                <th>Salary</th>
                 <th>Action</th>
                  <th>Details</th>

            </tr>
            <c:forEach var="tempAccount" items="${accounts}">
                <c:url var="updateLink" value="/payroll/showFormForUpdateAccount">
                    <c:param name="EmpId" value="${tempAccount.user_id}"/>
                </c:url>
                  <c:url var="updateLink1" value="/payroll/employeeDetails">
                   <c:param name="EmpId" value="${tempAccount.user_id}"/>
                   </c:url>
                 <tr>
                     <td>${tempAccount.user_id}</td>
                     <td>${tempAccount.salary}</td>
                     <td>
                     <a href="${updateLink}">Update</a>
                     </td>
                      <td>
                       <a href="${updateLink1}">Details</a>
                      </td>
                 </tr>
            </c:forEach>
        </table>
    </div>
</div>
<br><br>
 <a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>