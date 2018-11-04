
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Customer Form</title>
</head>

<body>
<h2>Customer Form</h2>

<form:form method="POST" action="saveCustomer" modelAttribute="customer" >

    <form:hidden path="id"/>
    <form:hidden path="customerContactsList[0].telephoneId"/>

    <table>
        <tr>
            <td>First Name: </td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Telephone: </td>
            <td><form:input path="customerContactsList[0].telephoneNumber"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
