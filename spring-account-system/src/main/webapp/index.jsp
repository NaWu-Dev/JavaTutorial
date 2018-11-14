<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<script type = "text/javascript">
    function getValue(){
        document.getElementById("linkGetUser").href=
            "${pageContext.request.contextPath}/api/users/"+document.getElementById("userId").value;

        //var value = document.getElementById("userId").value;
        //alert(value);
    }
</script>

<body>
<h2>Account management system</h2>

<h3>User API</h3>
<a href="${pageContext.request.contextPath}/api/users">Get - Users</a><br>
<input type="text" id="userId" name="userId" oninput="getValue()"/>
<a id="linkGetUser" href="">Get - User</a>
<hr>

<h3>Host API</h3>
<a href="${pageContext.request.contextPath}/api/hosts">Get - Hosts</a>
<hr>

<h3>Account API</h3>
<a href="${pageContext.request.contextPath}/api/accounts">Get - Accounts</a>

</body>
</html>
