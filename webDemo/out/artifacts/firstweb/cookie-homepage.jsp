<html>
<body>
<h3>Training Portal</h3>
<!-- read the cookie -->
<%
    // set default value
    String favLang = "Java";

    // get cookie from the browser request
    Cookie[] theCookies = request.getCookies();

    // find out the favorite language
    if (theCookies!= null)
    {
        for (Cookie tempCookie : theCookies) {
            if ("myApp.favoriteLanguage".equals(tempCookie.getName())) {
                favLang =  tempCookie.getValue();
                break;
            }
        }
    }
%>

<h4>New books for <%= favLang%></h4>
<ul>
    <li>aaaa</li>
    <li>bbbb</li>
</ul>

<h4>Latest news reports for <%= favLang%></h4>
<ul>
    <li>cccc</li>
    <li>dddd</li>
</ul>

<hr>
<a href="cookie-form.html">Personalize this page</a>
</body>
</html>