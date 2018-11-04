
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Customer Form</title>
</head>

<body>
<h2>Customer Form</h2>

<form:form method="POST" action="saveCustomer" modelAttribute="customer" >

<table>
    <tr>
        <td>First Name: </td>
        <td><input type="text" name="firstName" id="firstName"/> </td>
    </tr>
    <tr>
        <td>Last Name: </td>
        <td><input type="text" name="lastName" id="lastName"/></td>
    </tr>
    <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email"/> </td>
    </tr>
    <tr>
        <td>Telephone: </td>
        <td><input type="text" name="telephone" id="telephone"/> </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Save"></td>
    </tr>
</table>
</form:form>

</body>
</html>
