
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style>
        body{

            background-color: lightcyan;
        }
    </style>


</head>
<body>

<a href="/">Back to home</a>

<c:if test="${param['error'] != null}">
    <p class="error">THIS USER ALREADY EXISTS
        <br/>
        Please go to login <a href="/login">Login</a>
    </p>
</c:if>

<form method="post">
    <label>
        Username<input type="text" name="userName">
    </label>

    <label>
        Password<input type="password" name="password">
    </label>

    <label>
        Name<input type="text" name="name">
    </label>

    <input type="submit" value="Signup">

</form>

</body>
</html>
