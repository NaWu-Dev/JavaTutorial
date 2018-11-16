<html>
<head>
    <title>Create Location</title>
</head>

<body>
<form action="saveLoc" method="post">
    <pre>
    Id: <input type="text" name="id"/>
    Code: <input type="text" name="code"/>
    Name: <input type="text" name="name"/>
    Type: Urban <input type="radio" name="type"/>
        Rural <input type="radio" name="type"/>
    <input type="submit" value="Save"/>
    </pre>
</form>
${msg}
</body>
</html>