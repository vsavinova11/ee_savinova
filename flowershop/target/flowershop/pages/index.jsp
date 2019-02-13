<%--
  Created by IntelliJ IDEA.
  User: valentina.savinova
  Date: 06.02.2019
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Flowershop</title>

        <!-- Bootstrap core CSS -->
        <link href="pages/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="dashboard.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="font-weight-bold navbar-brand text-uppercase" href="#">Flowershop</a>
            <div class="ml-auto">
                <span class="navbar-brand text-capitalize">Hello, ${client.fullName}</span>
                <span class="navbar-brand text-capitalize">Balance: ${client.balance}</span>
                <span class="navbar-brand text-capitalize">Discount: ${client.discount}%</span>
            </div>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="logout">Sign out</a>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <table class="table">
                        <thead class="thead-light">
                        <h1>Order list</h1>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Total</th>
                            <th scope="col">Creation date</th>
                            <th scope="col">Closing date</th>
                            <th scope="col">Status</th>
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
                                    <c:if test="${order.status == 'Created'}">
                                        <form:form action="./order/pay?id=${order.id}">
                                        <td><button class="btn btn-secondary btn-block btn-sm " type="submit">Pay</button></td>
                                        </form:form>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-8">
                    <table class="table">
                        <thead class="thead-dark">
                        <h1>Flower catalog</h1>
                        <div class="container flex-lg-nowrap row">
                            <form:form action="." method="post" modelAttribute="searchInfo">
                                <form:input path="name" type="text" class="form-control m-2" name="name" placeholder="Name" />
                                <form:input path="from" type="number" class="form-control m-2" name="from" placeholder="From" />
                                <form:input path="to" type="number" class="form-control m-2" name="to" placeholder="To" />
                                <button class="btn btn-secondary btn-block btn-sm m-2 " type="submit">Search</button>
                            </form:form>
                        </div>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Count</th>
                            <th scope="col">    </th>
                        </tr>
                        </thead>
                        <tbody>


                            <c:forEach items="${flowers}" var="flower">
                                <tr>
                                    <th scope="row">${flower.id}</th>
                                    <td>${flower.name}</td>
                                    <td>${flower.price}</td>
                                    <td>${flower.count}</td>
                                    <form:form action="./flower/add" method="post" modelAttribute="itemInfo">
                                        <form:input path="id" type="hidden" value="${flower.id}" />
                                        <td> <form:input path="count" type="number" class="form-control w-50" name="count" placeholder="1" min="1" max="${flower.count}" /></td>
                                        <td> <button class="btn btn-secondary btn-block btn-sm " type="submit">AddToCart</button> </td>
                                    </form:form>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
                <div class="col-4">
                    <table class="table">
                        <thead class="thead-light">
                        <h1>Cart</h1>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Count</th>
                            <th scope="col">Price</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.cartInfo.cart}" var="orderItem" varStatus="loop">
                                <tr>
                                    <th scope="row">${loop.index+1}</th>
                                    <td>${orderItem.flower.name}</td>
                                    <td>${orderItem.count}</td>
                                    <td>${orderItem.price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <p>Total with discount: ${sessionScope.cartInfo.total}</p>
                    <a class="btn btn-lg btn-light btn-block" href="./order/add" type="button">Create Order</a>
                </div>
            </div>
        </div>
        <footer class="bg-light p-3">
            Error: ${sessionScope.error.message}
        </footer>

    </body>
</html>
