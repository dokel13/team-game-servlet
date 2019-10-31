<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form class="login-form" method="post" action="${pageContext.request.contextPath}/api/login">
    <div class="login-form">
        <label for="login-login">Enter login</label>
        <input id="login-login" class="login-input" required="required"
               type="text" name="login">
    </div>
    <div class="password-form">
        <label for="login-password">Enter password</label>
        <input id="login-password" class="password-form" required="required"
               type="password" name="password">
    </div>
    <button type="submit" class="login-button">
        Log In
    </button>
</form>
<form class="registration-form" method="post" action="${pageContext.request.contextPath}/api/register">
    <div class="login">
        <label for="registration-login">Enter login</label>
        <input id="registration-login" class="login-input" required="required"
               type="text" name="login">
    </div>
    <div class="password">
        <label for="registration-password">Enter password</label>
        <input id="registration-password" class="password-form" required="required"
               type="password" name="password">
    </div>
    <button type="submit" class="register-button">
        Register
    </button>
</form>
</body>


<%--<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>--%>
<%--<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--<!------ Include the above in your HEAD tag ---------->--%>

<%--<div class="container login-container">--%>
    <%--<div class="row">--%>
        <%--<div class="col-md-6 login-form-1">--%>
            <%--<h3>Login for Form 1</h3>--%>
            <%--<form>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="Your Email *" value="" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="password" class="form-control" placeholder="Your Password *" value="" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="submit" class="btnSubmit" value="Login" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<a href="#" class="ForgetPwd">Forget Password?</a>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<div class="col-md-6 login-form-2">--%>
            <%--<h3>Login for Form 2</h3>--%>
            <%--<form>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="Your Email *" value="" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="password" class="form-control" placeholder="Your Password *" value="" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="submit" class="btnSubmit" value="Login" />--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>

                    <%--<a href="#" class="ForgetPwd" value="Login">Forget Password?</a>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

</html>