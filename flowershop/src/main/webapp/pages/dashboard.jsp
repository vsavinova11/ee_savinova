<%--
  Created by IntelliJ IDEA.
  User: valentina.savinova
  Date: 06.02.2019
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="pages/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Flowershop</a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="logout">Sign out</a>
        </li>
    </ul>
</nav>
<div class="col-12">
    <table class="table">
        <thead class="thead-light">
        <h1>Order list</h1>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Total</th>
            <th scope="col">Creation date (
                <a type="text" href="./dashboard?column=creationDate&direction=ASC">ASC</a>
                <a type="text" href="./dashboard?column=creationDate&direction=DESC">DESC</a>)</th>
            <th scope="col">Closing date</th>
            <th scope="col">Status(
                <a type="text" href="./dashboard?column=status&direction=ASC">ASC</a>
                <a type="text" href="./dashboard?column=status&direction=DESC">DESC</a>)</th></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clientOrders}" var="order">
            <tr>
                <th scope="row">${order.id}</th>
                <td>${order.total}</td>
                <td>${order.creationDate}</td>
                <td>${order.closingDate}</td>
                <td>${order.status}</td>
                <c:if test="${order.status == 'Paid'}">
                    <form:form action="./dashboard/close?id=${order.id}">
                        <td><button class="btn btn-secondary btn-block btn-sm " type="submit">Close</button></td>
                    </form:form>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer class="bg-light p-3">
    Error: ${error.message}
</footer>
<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>
</body>
</html>
