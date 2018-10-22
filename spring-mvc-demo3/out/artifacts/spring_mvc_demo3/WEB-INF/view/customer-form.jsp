<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Customer Registration Form</title>

    <!-- inform css style -->
    <style>
        .error {color:red}
    </style>
</head>

<body>

    <form:form action="processForm" modelAttribute="customer">
        Fill out the form. Asterisk (*) means required.
        <br><br>

        First Name: <form:input path="firstName"/>
        <br><br>

        Last Name(*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        <br><br>

        Free Pass: <form:input path="freePass"/>
        <form:errors path="freePass" cssClass="error"/>
        <br><br>

        Postal Code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>
        <br><br>

        Course Code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>

        Email Address: <form:input path="emailAddress"/>
        <form:errors path="emailAddress" cssClass="error"/>
        <br><br>

        <input type="submit" value="Submit" />
        <br><br>

    </form:form>

</body>

</html>