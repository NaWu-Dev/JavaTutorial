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

        Country:
        <form:select path="country">
            <form:option value="Brazil" label="Brazil"/>
            <form:option value="France" label="France"/>
            <form:option value="China" label="China"/>
            <form:option value="Germany" label="Germany"/>
            <form:option value="Canada" label="Canada"/>
        </form:select>
        <br><br>

        <input type="submit" value="Submit"/>
        <br><br>

    </form:form>
</body>
</html>