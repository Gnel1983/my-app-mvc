<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {

            margin-top: 0px;
            margin-bottom: 100px;
            margin-right: 10px;
            margin-left: 1700px;

        }

        body {
            background-color: lavenderblush;
        }


    </style>

</head>
<body>

<div>
    <button class="button button1" onclick="window.location='/add';" value=>Add post</button>
    <button class="button button1" onclick="window.location='/logged';" value=>Back to home</button>

</div>

<c:forEach var="post" items="${post}">
    <c:out value="${post.title}"/>
    <img src="${post.imageUrl}"/>

    <a href="${pageContext.request.contextPath}/delete?id=${post.id}">Delete</a>


    <br/>


</c:forEach>

</body>
</html>
