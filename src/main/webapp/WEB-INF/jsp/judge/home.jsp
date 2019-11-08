<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle var="application" basename="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title><fmt:message key="title_game" bundle="${application}"/></title>
        <style><%@include file="/WEB-INF/css/judge_home.css"%></style>
    </head>
    <body class="home-body">
        <div class="right-corner">
            <a class="logout" href="${pageContext.request.contextPath}/api/logout?locale=${sessionScope.locale.language}" title="Log Out">Log Out</a>
        </div>
        <div>
            <a class="create-game-button" href="${pageContext.request.contextPath}/api/judge/game?locale=${sessionScope.locale.language}">Create game</a>
        </div>
    </body>
</html>