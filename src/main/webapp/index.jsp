<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书城首页</title>
    <%@include file="ResourcesTemplate.jsp" %>
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>

<body>

<%@include file="HeadTemplate.jsp" %>
<div class="container">
    <div id="top-warp">
        <div class="left">
            bStore书城是一个开放与包容的网上购书平台，书友们在这购书和写下他们的书评，使得网站充满了朝气与活力。我们期待您的加入。
            <a class="shop-now" href="#">购书</a>
        </div>
        <div class="right">
            <div id="swiper">
                <ul>
                    <c:forEach items="${ requestScope.bookCharts }" var="bookChart">
                        <li><a target="_blank" href="<c:url value="/book?actionType=getBook&bookCode=${ bookChart.bookCode }" />"><img src="<c:url value="${ bookChart.bookImg }"/>"></a></li>
                    </c:forEach>
                </ul>
                <div class="number-point">
                    <span class="active"></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <a href="javascript:;" class="prev"><i class="fa fa-chevron-left"></i></a>
                <a href="javascript:;" class="next"><i class="fa fa-chevron-right"></i></a>
            </div>
        </div>
    </div>
    <h4 id="good-book">好书推荐</h4>
    <div id="product-hunt">
        <c:forEach items="${ requestScope.goodBookLists }" var="goodBookList">
            <div class="box">
                <div class="image">
                    <a target="_blank" href="<c:url value="/book?actionType=getBook&bookCode=${ goodBookList.bookCode }"/> ">
                        <img src="<c:url value="${ goodBookList.bookImg }"/> "/>
                    </a>
                </div>
                <div class="content">
                    <p>${ goodBookList.bookName }</p>
                    <p>${ goodBookList.bookAuthor }</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <div id="midlle-warp">
        <div class="left">
            <h4 id="notice"><i class="fa fa-bell"></i>公告板 <span>more&nbsp;<i class="fa fa-chevron-right"></i></span>
            </h4>
            <li id="info-notice">图书3折起，支持在线浏览，先看再买不后悔，任何商品免费送</li>
            <li id="info-notice">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每一个角落</li>
            <li id="info-notice">2007年中旅游图书畅销榜速递 中国游，世界游，旅游图书全部7折封顶</li>
            <li id="info-notice">50万种图书3折，百货团购价热卖 畅销榜新书速递，促销天天有</li>
        </div>
        <div id="right-info-hot">
            <c:forEach items="${ requestScope.bookHots }" var="bookHot">
                <div class="contxt">
                    <h4><i class="fa fa-fire"></i>本周热卖</h4>
                    <p>${ bookHot.bookName }</p>
                    <p>${ bookHot.bookAuthor }</p>
                </div>
                <a target="_blank" href="<c:url value="/book?actionType=getBook&bookCode=${ bookHot.bookCode }"/> ">
                    <img src="<c:url value="${ bookHot.bookImg }"/> "/>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="FooterTemplate.jsp" %>
<script src="<c:url value="/js/swiper.js" />"></script>
</body>

</html>
