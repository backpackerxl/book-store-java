<%@ page import="static java.lang.System.out" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BookStore-index</title>
    <link rel="shortcut icon" href="<c:url value="/img/book.png" />" type="image/png">
</head>
<body>
<h2>Hello
    <%=request.getSession().getAttribute("username")%>
</h2>
</body>
</html>
