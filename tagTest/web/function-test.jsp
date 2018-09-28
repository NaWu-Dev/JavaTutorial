<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<c:set var="data" value="testing"/>

Length of the string <b>${data}</b>: ${fn:length(data)}

<br><br>

Uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}

<br><br>

Does the string <b>${data}</b> start with <b>t</b>?: ${fn:startsWith(data, "t")}


</body>
</html>