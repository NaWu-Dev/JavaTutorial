<html>

<head>
    <title>Add Student</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css"/>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>** University</h2>
    </div>
</div>
    <div>
        <h3>Update Student</h3>
        <form action="StudentControllerServlet" method="get">
            <input type="hidden" name="command" value="UPDATE" />

            <table>
                <tbody>
                <tr>
                    <td><label>First name: </label></td>
                    <td><input type="text" name="firstName"/> </td>
                </tr>
                <tr>
                    <td><label>Last name:</label></td>
                    <td><input type="text" name="lastName"/> </td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

<div style="clear: both;"></div>

<p>
    <a href="StudentControllerServlet">Back to List</a>
</p>

</body>

</html>