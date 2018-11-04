
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer List</title>
</head>

<body>

    <h2>Customer List</h2>

    <input type="button" value="Add Customer"
           onclick="window.location.href='addCustomer'; return false;"/>

    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contacts List</th>
        </tr>

        <c:forEach var="tempCustomer" items="${customers}">
            <tr>
                <td>${tempCustomer.id}</td>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
                <c:forEach var="tempTelephone" items="${tempCustomer.customerContactsList}">
                    <td>${tempTelephone.telephoneNumber}, </td>
                </c:forEach>
            </tr>
        </c:forEach>

    </table>

</body>

</html>