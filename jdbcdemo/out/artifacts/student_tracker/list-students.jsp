<%@ page import="java.util.*, com.test.web.jdbc.*"%>
<html>
<head><title>Student Tracker App</title></head>

<%
    // get the students from the request object (send by servlet)
    List<Student> theStudents = (List<Student>) request.getAttribute("STUDENTS_LIST");
%>
<body>
<%=theStudents%>
</body>
</html>