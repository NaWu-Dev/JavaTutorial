<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>


<html>
<head>
    <title>Student form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName"/>
        <br><br>
        Last name: <form:input path="lastName" />
        <br><br>
        <input type="submit" value="Submit"/>
        <br><br>
    </form:form>
</body>
</html>