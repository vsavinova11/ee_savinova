<%--
  Created by IntelliJ IDEA.
  User: valentina.savinova
  Date: 05.02.2019
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="text/html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Регистрация</title>
        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <style>
            .form-control{
                margin: 3px 0;
            }
            label{
                text-align: left;
            }
        </style>
    </head>
    <body>
        <div class="container" style="width: 30%; height: 50%; margin-top: 10%;">
            <form:form action="./registration" method="post" modelAttribute="client">
                <h2 class="form-registration-heading">Registration</h2>
                <label for="inputLogin">Login:</label>
                <form:input path="login" type="text" class="form-control" id="inputLogin" name="login" placeholder="Login"/>
                <label for="inputPassword">Password:</label>
                <form:input  path="password" type="password" class="form-control" id="inputPassword" name="password" placeholder="Password"/>
                <label for="inputFullName">Full Name:</label>
                <form:input  path="fullName" type="text" class="form-control" id="inputFullName" name="full-name" placeholder="Full name"/>
                <label for="inputAddress">Address:</label>
                <form:input path="address" type="text" class="form-control" id="inputAddress" name="address" placeholder="Address"/>
                <label for="inputPhone">Phone:</label>
                <form:input  path="phone" type="text" class="form-control" id="inputPhone" name="phone" placeholder="Phone"/>
                <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Submit form</button>
            </form:form>
        </div>
        <footer id="error" class="bg-light p-3">
            Error: ${error}
        </footer>
    </body>
    <script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script>
    <script>
        $(function ()
        {
            $('#inputLogin').keyup(function ()
            {
                var login = $('#inputLogin').val();
                $.ajax(
                        {
                            url: "./registration/check?login=" + encodeURIComponent(login)
                        }).done(function (data)
                {
                    if (data.loginExists) {
                        $('#submit').attr('disabled', 'disabled');
                        $('#error').html('Error: login exists');
                    } else
                    {
                        $('#submit').removeAttr('disabled');
                        $('#error').html('Error: No error');
                    }
                });
            });
        });
    </script>
</html>
