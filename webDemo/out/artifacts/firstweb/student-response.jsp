<html>
<head><title>Student Confirmation Title</title></head>
<body>
    The student is confirmed: ${param.firstName}, ${param.lastName}.
    <br><br>
    The student's country: ${param.country}.
    <br><br>
    Student type: ${param.studentType}.
    <br><br>
    <!-- Display list of favoriteLanguage -->
    Favorite Language: <br>
    <ul>
        <%
            String[] langs = request.getParameterValues("favoriteLanguage");
            if (langs != null) {
                for (String lang : langs) {
                    out.println("<li>"+lang+"</li>");
                }
            }
        %>
    </ul>
    <br><br>
</body>
</html>