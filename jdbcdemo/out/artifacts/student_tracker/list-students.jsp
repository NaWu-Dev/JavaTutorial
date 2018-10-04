<%@ page import="java.util.*, com.test.web.jdbc.*"%>
<html>
<head>
    <title>Student Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>

<%
    // get the students from the request object (send by servlet)
    List<Student> theStudents = (List<Student>) request.getAttribute("STUDENTS_LIST");
%>
<body>
<div id="wrapper">
    <div id="header">
        <h2>** University</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <% for (Student tempStudent : theStudents) { %>
                <tr>
                    <td><%=tempStudent.getFirstName()%></td>
                    <td><%=tempStudent.getLastName()%></td>
                    <td><%=tempStudent.getEmail()%></td>
                </tr>
            <% }  %>
            <tr></tr>
        </table>
    </div>
</div>

</body>
</html>