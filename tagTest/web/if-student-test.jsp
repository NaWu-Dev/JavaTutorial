<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.*, com.test.jsp.tagdemo.Student"%>

<%
    // Create sample data
    List<Student> data = new ArrayList();

    data.add(new Student("John", "Doe", false));
    data.add(new Student("Na", "WU", true));
    data.add(new Student("Angelo", "Chen", false));

    pageContext.setAttribute("myStudents", data);
%>

<html>
<body>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gold Customer</th>
    </tr>

    <c:forEach var="tempStudent" items="${myStudents}">
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>
                    <c:if test="${tempStudent.goldCustomer}">
                    Special Discount
                    </c:if>
                <c:if test="${not tempStudent.goldCustomer}">
                    -
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
