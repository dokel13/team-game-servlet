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
                <fmt:message var="choose_ukrainian" key="choose_ukrainian" bundle="${application}"/>
                <a href="${pageContext.request.contextPath}/api/player?locale=ua" title="${choose_ukrainian}">UA</a>/
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
        <div class="statistics-table-form">
            <table class="statistics-table">
                <caption><fmt:message key="games_statistics" bundle="${application}"/></caption>
                <thead>
                <tr>
                    <th><fmt:message key="judge" bundle="${application}"/></th>
                    <th><fmt:message key="team" bundle="${application}"/></th>
                    <th><fmt:message key="players_amount" bundle="${application}"/></th>
                    <th><fmt:message key="winner" bundle="${application}"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${statistics}" var="statistic">
                    <tr>
                        <td>${statistic.judge}</td>
                        <td>${statistic.team}</td>
                        <td>${statistic.playersAmount}</td>
                        <td>${statistic.winner}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>