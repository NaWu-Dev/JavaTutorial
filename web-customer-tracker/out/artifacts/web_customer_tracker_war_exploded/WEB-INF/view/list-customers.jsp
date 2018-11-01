<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>List customers</title>

    <!-- referenece our style sheet -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <!-- button: Add customer -->
            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false; "
                   class="add-button"
            />

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Tel</th>
                </tr>
                <c:forEach var="tempCustomer" items="${customers}">
                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>${tempCustomer.tel}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>

</html>