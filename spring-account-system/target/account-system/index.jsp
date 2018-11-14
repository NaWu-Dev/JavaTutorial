<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<script type = "text/javascript">
    function getValue(){
        document.getElementById("linkGetUser").href=
            "${pageContext.request.contextPath}/api/users/"+document.getElementById("userId").value;

        document.getElementById("linkGetHost").href=
            "${pageContext.request.contextPath}/api/hosts/"+document.getElementById("hostId").value;

        document.getElementById("linkGetAccount").href=
            "${pageContext.request.contextPath}/api/accounts/"+document.getElementById("accountId").value;

    }
</script>

<body>
<h2>Account management system</h2>

<h3>User API</h3>
<a href="${pageContext.request.contextPath}/api/users">Get - Users</a><br>
<input type="text" id="userId" name="userId" oninput="getValue()"/>
<a id="linkGetUser" href="${pageContext.request.contextPath}/api/users/">Get - User</a>
<hr>

<h3>Host API</h3>
<a href="${pageContext.request.contextPath}/api/hosts">Get - Hosts</a><br>
<input type="text" id="hostId" name="hostId" oninput="getValue()"/>
<a id="linkGetHost" href="${pageContext.request.contextPath}/api/hosts/">Get - Host</a>
<hr>

<h3>Account API</h3>
<a href="${pageContext.request.contextPath}/api/accounts">Get - Accounts</a><br>
<input type="text" id="accountId" name="accountId" oninput="getValue()"/>
<a id="linkGetAccount" href="${pageContext.request.contextPath}/api/accounts/">Get - Account</a>

</body>
</html>
