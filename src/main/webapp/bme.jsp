<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书城首页</title>
    <%@include file="ResourcesTemplate.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/book-me.css" />">
</head>

<body>
    <%@include file="HeadTemplate.jsp"%>

    <div class="container">
        <div class="about">
            <div class="left">
                <h4>我的账户</h4>
                <ul>
                    <li><a href="#"><i class="fa fa-user-secret"></i>个人资料</a></li>
                    <li><a href="#"><i class="fa fa-list-alt"></i>订单查询</a></li>
                    <li><a href="#"><i class="fa fa-address-card"></i>收货地址</a></li>
                </ul>
            </div>
            <div class="right">
                <div class="user-img">
                    <img src="./img/man.png" alt="">
                </div>
                <form action="#">
                    
                </form>
            </div>
        </div>
    </div>
    <%@include file="FooterTemplate.jsp"%>
</body>

</html>