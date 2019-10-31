<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
Player hello
<form class="login-form" method="post" action="${pageContext.request.contextPath}/api/logout">
    <button type="submit" class="logout-button">
        Log Out
    </button>
</form>
</body>
</html>