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
    <link rel="stylesheet" href="<c:url value="/css/book-car.css"/>">
</head>

<body>
    <%@include file="HeadTemplate.jsp"%>
    <div class="container">
        <div class="car-warpper">
            <table id="shop-car" class="book-car">
                <tr id="title">
                    <th>商品信息</th>
                    <th>作者</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>金额</th>
                    <th>操作</th>
                </tr>
                <tr id="my-book">
                    <td id="book-info">
                        <input type="checkbox" name="" id="select-book">
                        <img src="<c:url value="/img/bstore/b0004.jpg/book-004.jpg"/> " />
                        <span>Java8函数编程</span>
                    </td>
                    <td>[英] Richard Warburton</td>
                    <td class="book-price">￥100.00</td>
                    <td id="count-number">
                        <button id="incle">-</button>
                        <input id="number" type="number" value="1" />
                        <button id="add">+</button>
                    </td>
                    <td id="total_price" class="book-price">￥100.00</td>
                    <td><button id="close">删除</button></td>
                </tr>
                <tr id="my-book">
                    <td id="book-info">
                        <input type="checkbox" name="" id="select-book">
                        <img src="<c:url value="/img/bstore/b0009.jpg/book-009.jpg"/>" />
                        <span>射雕英雄传</span>
                    </td>
                    <td>金庸</td>
                    <td class="book-price">￥100.99</td>
                    <td id="count-number">
                        <button id="incle">-</button>
                        <input id="number" type="number" value="1" />
                        <button id="add">+</button>
                    </td>
                    <td id="total_price" class="book-price">￥100.99</td>
                    <td><button id="close">删除</button></td>
                </tr>
                <tr id="my-book">
                    <td id="book-info">
                        <input type="checkbox" name="" id="select-book">
                        <img src="<c:url value="/img/bstore/b0010.jpg/book-010.jpg"/>" />
                        <span>平凡的世界</span>
                    </td>
                    <td>路遥</td>
                    <td class="book-price">￥100.22</td>
                    <td id="count-number">
                        <button id="incle">-</button>
                        <input id="number" type="number" value="1" />
                        <button id="add">+</button>
                    </td>
                    <td id="total_price" class="book-price">￥100.22</td>
                    <td><button id="close">删除</button></td>
                </tr>
            </table>
        <div class="total-price">
            <div class="total-select">
                <input type="checkbox" name="" id="select-all">
                <span>全选</span>
            </div>
            <div class="submit">
                <span id="my_total_money">￥ 0.00</span>
                <input id="submit" type="submit" value="去结算">
            </div>
        </div>
    </div>
    </div>
    <script src="<c:url value="/js/book-car.js"/>"></script>
</body>

</html>