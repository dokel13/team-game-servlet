<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle var="application" basename="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title><fmt:message key="title_game" bundle="${application}"/></title>
        <style><%@include file="/WEB-INF/css/player_home.css"%></style>
    </head>
    <body class="home-body">
        <div class="right-corner">
            <div class="language">
                <a href="${pageContext.request.contextPath}/api/player?locale=ua" title="choose Ukrainian">UA</a>/
                <a href="${pageContext.request.contextPath}/api/player?locale=en" title="choose English">EN</a>
            </div>
            <fmt:message var="logout" key="logout" bundle="${application}"/>
            <a class="logout" href="${pageContext.request.contextPath}/api/logout?locale=${sessionScope.locale}" title="${logout}">${logout}</a>
        </div>
        <table class="game-table">
            <caption><fmt:message key="table_games" bundle="${application}"/></caption>
            <thead>
                <tr>
                    <th><fmt:message key="table_available_games" bundle="${application}"/></th>
                    <th><fmt:message key="table_judge" bundle="${application}"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${activeGames}" var="activeGame">
                    <tr>
                        <fmt:message var="game_link" key="game_link" bundle="${application}"/>
                        <td class="iterable-game"><a href="${pageContext.request.contextPath}/api/player/game?locale=${sessionScope.locale}" title="${game_link}">${game_link}</a></td>
                        <td>${activeGame.judge}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <table class="statistics-table">
            <caption>Games Statistics</caption>
            <thead>
                <tr>
                    <th>Judge</th>
                    <th>Team</th>
                    <th>Captain</th>
                    <th>Right Answers</th>
                    <th>Wrong Answers</th>
                    <th>Winner</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${statistics}" var="statistic">
                    <tr>
                        <td>$(statistic.judge}</td>
                        <td>${statistic.team}</td>
                        <td>${statistic.captain}</td>
                        <td>${statistic.rightAnswers}</td>
                        <td>${statistic.wrongAnswers}</td>
                        <td>${statistic.winner}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>