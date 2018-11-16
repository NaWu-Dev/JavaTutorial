<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Display Locations</title>
</head>

<body>
<h2>Locations: </h2>
<br>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>type</th>
    </tr>

    <c:forEach var="tempLocation" items="${locations}">
        <tr>
            <td>${tempLocation.id}</td>
            <td>${tempLocation.code}</td>
            <td>${tempLocation.name}</td>
            <td>${tempLocation.type}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>