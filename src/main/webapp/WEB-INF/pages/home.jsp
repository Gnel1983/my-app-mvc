<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: lightblue;
        }

        div {

            margin-top: 0px;
            margin-bottom: 100px;
            margin-right: 10px;
            margin-left: 1650px;

        }


        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #2b34ba;
        }

        .button1:hover {
            background-color: #2b34ba;
            color: white;
        }

        .welcome {
            color: blue;
        }


    </style>

</head>
<body>
<div>
    <button class="button button1" onclick="window.location='/add';" value=>Add post</button>
    <button class="button button1" onclick="window.location='/account';" value=>My account</button>
    <button class="button button1" onclick="window.location='/logout';" value=>Log out</button>
    <button class="button button1" onclick="window.location='/signup';" value=>Signup</button>




</div>


<c:forEach var="post" items="${post}">
    <c:out value="${post.title}"/>

    <img src="${post.imageUrl}"/>


</c:forEach>


</body>
</html>
