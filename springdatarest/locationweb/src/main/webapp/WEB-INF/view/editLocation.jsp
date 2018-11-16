<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<html>
<head>
    <title>Edit location</title>
</head>

<body>
<form action="updateLoc" method="post">
    <pre>
    Id: <input type="text" name="id" value="${location.id}" readonly="true"/>
    Code: <input type="text" name="code" value="${location.code}"/>
    Name: <input type="text" name="name" value="${location.name}"/>
    Type: Urban <input type="radio" name="type" value="URBAN" ${location.type=='URBAN' ? 'checked':'' }/>
        Rural <input type="radio" name="type" value="RURAL" ${location.type=='RURAL' ? 'checked':'' }/>
    <input type="submit" value="Save"/>
    </pre>
</form>
</body>

</html>