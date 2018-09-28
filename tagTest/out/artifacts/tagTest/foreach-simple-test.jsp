<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String[] cities = {"Montreal", "Chongqing", "Chengdu"};

    pageContext.setAttribute("myCities", cities);
%>

<html>
<body>
    <c:forEach var="tempCity" items="${myCities}">
        ${tempCity} <br/>
    </c:forEach>
</body>
</html>