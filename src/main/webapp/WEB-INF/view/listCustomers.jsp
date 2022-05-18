<%@ taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html xmlns:c="">

<head>
   		  <link type="text/css"
                  rel="stylesheet"
                  href="${pageContext.request.contextPath}/css/style.css"/>
    <title>list of employees</title>
   <style>
   a:link {
     color: black;
   }
   a:visited {
     color: green;
   }
   a:hover {
     color: hotpink;
   }
   a:active {
     color: blue;
   }
   </style>

</head>
<body>
<div id="wrapper">
    <div id="header">
<h2>Employee List</h2>
    </div>
</div>
<div id="container">
    <div id="content">
    <input type="button" value="Add Employee"
           onclick="window.location.href='showFormForAdd';return false"
    class="add-button"/>
     <input type="button" value="Add Account"
               onclick="window.location.href='showFormForAddAccount';return false"
        class="add-button"/>
        <table>
            <tr>
            <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customers}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.user_id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.user_id}"/>
                </c:url>
                 <tr>
                    <td>${tempCustomer.user_name}</td>
                     <td>${tempCustomer.first_name}</td>
                     <td>${tempCustomer.last_name}</td>

                     <td>
                     <a href="${updateLink}">Update</a>
                     |
                     <a href="${deleteLink}"
                     onclick="if(!(confirm('Are you sure want to delete Customer?'))) return false">Delete</a>
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