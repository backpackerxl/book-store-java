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
    <link rel="stylesheet" href="<c:url value="/css/index.css"/>">
</head>

<body>

<%@include file="HeadTemplate.jsp"%>

<div class="container">
    <div id="top-warp">
        <div class="left">
            <div id="swiper">
                <ul>
                    <li><img src="<c:url value="/img/bstore/b0001.jpg"/>"></li>
                    <li><img src="<c:url value="/img/bstore/b0004.jpg"/>"></li>
                    <li><img src="<c:url value="/img/bstore/b0005.jpg"/>"></li>
                    <li><img src="<c:url value="/img/bstore/b0006.jpg"/>"></li>
                    <li><img src="<c:url value="/img/bstore/b0007.jpg"/>"></li>
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
        <div class="right">
            <div class="right-txt">
                <h4>新书上架</h4>
                <p class="title">尼泊尔(Lonely Planet 旅行指南系列)</p>
                <p class="contxt">尼泊尔王国地处巍峨的喜马拉雅山区，山地的冷气流与印度平原的暖气流在此交汇。这里不仅是耗牛、雪人、佛塔和夏尔巴人的国度，而且拥有世界上最好的徒步旅行线路</p>
            </div>
            <img src="<c:url value="/img/bstore/b0002.png" />">
        </div>
    </div>
    <div id="midlle-warp">
        <div class="left">
            <h4 id="notice"><i class="fa fa-bell"></i>公告板 <span>more&nbsp;<i class="fa fa-chevron-right"></i></span></h4>
            <li id="info-notice">图书3折起，支持在线浏览，先看再买不后悔，任何商品免费送</li>
            <li id="info-notice">Lonely Planet 已出版600多种旅行指南，几乎覆盖了全世界的每一个角落</li>
            <li id="info-notice">2007年中旅游图书畅销榜速递 中国游，世界游，旅游图书全部7折封顶</li>
            <li id="info-notice">50万种图书3折，百货团购价热卖 畅销榜新书速递，促销天天有</li>
        </div>
        <div id="right-info-hot">
            <div class="contxt">
                <h4><i class="fa fa-fire"></i>本周热卖</h4>
                <p>Java2 入门经典(JDK8)</p>
                <p>作者：(美)霍顿</p>
            </div>
            <img src="<c:url value="/img/bstore/b0003.png" />">
        </div>
    </div>
</div>

<footer>
    <p>eSHOP图书商城 &copy; <a href="http://gitee.com/backpackerxl">Gitee Backpackerxl</a></p>
</footer>
<script src="<c:url value="/js/swiper.js" />"></script>
</body>

</html>
