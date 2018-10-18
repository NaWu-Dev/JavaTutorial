<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Confirmation</title>
</head>

<body>
The student is confirmed: ${student.firstName}, ${student.lastName}.
<br><br>

Country: ${student.country}
<br><br>

Favorite Language: ${student.favoriteLanguage}
<br><br>

Operating System: ${student.operatingSystem}
<br><br>

</body>
</html>