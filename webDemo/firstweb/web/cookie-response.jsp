<html>
<head><title>Confirmation</title></head>
<%
    // read from data
    String favLang = request.getParameter("favoriteLanguage");

    // create cookie
    Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);

    // set total seconds
    theCookie.setMaxAge(60*60*24*365);

    // send cookie to browser
    response.addCookie(theCookie);
%>

<body>
    Thanks. We set your favorite language: ${param.favoriteLanguage}.
    <br><br>
    <a href="cookie-homepage.jsp">Return to home page</a>
</body>
</html>