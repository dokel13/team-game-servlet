<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle var="application" basename="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title><fmt:message key="title" bundle="${application}"/></title>
        <style><%@include file="/WEB-INF/css/home.css"%></style>
    </head>
    <div class="language">
        <fmt:message var="choose_ukrainian" key="choose_ukrainian" bundle="${application}"/>
        <a href="${pageContext.request.contextPath}/api/home?locale=ua" title="${choose_ukrainian}">UA</a>/
        <a href="${pageContext.request.contextPath}/api/home?locale=en" title="choose English">EN</a>
    </div>
        <div class="login-container">
            <div class="login-form-1">
                <h3><fmt:message key="enter_game" bundle="${application}"/></h3>
                <form class="login-form" method="post" action="${pageContext.request.contextPath}/api/login?locale=${sessionScope.locale}">
                    <div class="form-group">
                        <fmt:message var="your_login" key="your_login" bundle="${application}"/>
                        <input class="input-form" required="required"
                               type="text" name="login" placeholder="${your_login} *" value="" />
                    </div>
                    <div class="form-group">
                        <fmt:message var="your_password" key="your_password" bundle="${application}"/>
                        <input class="input-form" required="required"
                               type="password" name="password" placeholder="${your_password} *" value="" />
                    </div>
                    <div class="form-group">
                        <fmt:message var="login" key="login" bundle="${application}"/>
                        <input type="submit" class="btnSubmit" value="${login}" />
                    </div>
                </form>
            </div>
            <div class="login-form-2">
                <h3><fmt:message key="register_enter" bundle="${application}"/></h3>
                <form class="registration-form" method="post" action="${pageContext.request.contextPath}/api/register?locale=${sessionScope.locale}">
                    <div class="form-group">
                        <fmt:message var="new_login" key="new_login" bundle="${application}"/>
                        <input class="input-form" required="required"
                               type="text" name="login" placeholder="${new_login} *" value="" />
                    </div>
                    <div class="form-group">
                        <fmt:message var="new_password" key="new_password" bundle="${application}"/>
                        <input class="input-form" required="required"
                               type="password" name="password" placeholder="${new_password} *" value="" />
                    </div>
                    <div class="form-group">
                        <fmt:message var="register" key="register" bundle="${application}"/>
                        <input type="submit" class="btnSubmit" value="${register}" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>