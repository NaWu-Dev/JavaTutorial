
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer List</title>
</head>

<body>

    <h2>Customer List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Telphone</th>
        </tr>

        <c:forEach var="tempCustomer" items="${customers}">



            <tr>
                <td>${tempCustomer.id}</td>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
                <td>${tempCustomer.customerContactsList}</td>
            </tr>
        </c:forEach>

    </table>

</body>

</html>