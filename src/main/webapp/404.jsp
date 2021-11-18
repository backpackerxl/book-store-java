<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>404页面走丢了</title>
    <link rel="shortcut icon" href="<c:url value="/img/book.png" />" type="image/png">
    <style>
        body{
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .container img{
            width: 510px;
        }
    </style>
</head>
<body>
<div class="container">
    <img src="<c:url value="/img/404.png"/>"/>
</div>
</body>
</html>
