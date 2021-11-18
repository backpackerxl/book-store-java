<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书籍详情页</title>
    <%@include file="ResourcesTemplate.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/book-info.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/book-shop.css"/> ">
</head>

<body>
    <%@include file="HeadTemplate.jsp"%>

    <div class="container">
        <div class="productlist-left">
            <h4>分类</h4>
            <ul>
                <a href="#"><i class="fa fa-check-square"></i>计算机</a>
                <a href="#" class="active"><i class="fa fa-check-square"></i>外语</a>
                <a href="#"><i class="fa fa-check-square"></i>艺术</a>
                <a href="#"><i class="fa fa-check-square"></i>经管</a>
                <a href="#"><i class="fa fa-check-square"></i>人文社科</a>
                <a href="#"><i class="fa fa-check-square"></i>少儿</a>
                <a href="#"><i class="fa fa-check-square"></i>生活</a>
                <a href="#"><i class="fa fa-check-square"></i>进口原版</a>
                <a href="#"><i class="fa fa-check-square"></i>科技</a>
                <a href="#"><i class="fa fa-check-square"></i>考试</a>
                <a href="#"><i class="fa fa-check-square"></i>励志</a>
                <a href="#"><i class="fa fa-check-square"></i>学术</a>
                <a href="#"><i class="fa fa-check-square"></i>小说</a>
                <a href="#"><i class="fa fa-check-square"></i>古籍</a>
                <a href="#"><i class="fa fa-check-square"></i>哲学</a>
                <a href="#"><i class="fa fa-check-square"></i>旅游</a>
                <a href="#"><i class="fa fa-check-square"></i>法律</a>
                <a href="#"><i class="fa fa-check-square"></i>宗教</a>
                <a href="#"><i class="fa fa-check-square"></i>历史</a>
                <a href="#"><i class="fa fa-check-square"></i>地理</a>
                <a href="#"><i class="fa fa-check-square"></i>政治</a>
                <a href="#"><i class="fa fa-check-square"></i>军事</a>
                <a href="#"><i class="fa fa-check-square"></i>心理学</a>
                <a href="#"><i class="fa fa-check-square"></i>传记</a>
            </ul>
        </div>
        <div class="productlist-right">
            <h4 class="book-list"><i class="fa fa-info-circle"></i>商品详情</h4>
            <div class="porduct-book">
                <div class="product-img-warp">
                    <img src="<c:url value="/img/bstore/b0008.jpg/book-008.jpg"/>" />
                </div>
                <div class="product-information">
                    <h4 class="book-name"><i class="fa fa-book"></i>ECMAScript 6 入门教程</h4>
                    <div class="book-content">
                        <div class="book-author">
                            <span>作&nbsp;&nbsp;&nbsp;者<i class="fa fa-caret-right"></i></span>
                            <span>阮一峰 著</span>
                        </div>
                        <div class="book-price">
                            <span>售&nbsp;&nbsp;&nbsp;价<i class="fa fa-caret-right"></i></span>
                            <span id="money">￥99 <del>原价：￥110</del></span>
                        </div>
                        <div class="book-press">
                            <span>出版社<i class="fa fa-caret-right"></i></span>
                            <sapn>电子工业出版社</sapn>
                        </div>
                        <div class="book-description">
                            <h5>内容简介</h5>
                            <p>《ECMAScript 6 入门教程》是一本开源的 JavaScript 语言教程，全面介绍 ECMAScript 6 新引入的语法特性。
                                本书覆盖 ES6 与上一个版本 ES5 的所有不同之处，对涉及的语法知识给予详细介绍，并给出大量简洁易懂的示例代码。
                                本书为中级难度，适合已经掌握 ES5 的读者，用来了解这门语言的最新发展；也可当作参考手册，查寻新增的语法点。
                                如果你是 JavaScript 语言的初学者，建议先学完《JavaScript 语言入门教程》，再来看本书。
                            </p>
                        </div>
                        <div class="add-car">
                            <button><i class="fa fa-shopping-cart"></i> 加入购物车</button>
                            <button><i class="fa fa-credit-card-alt"></i> 立即支付</button>
                        </div>
                    </div>
                </div>
            </div>
            <div id="compents" class="compents">
                <h4 id="return-master"><i class="fa fa-commenting-o"></i>用户评价</h4>
                <div class="add-compents">
                    <div id="img-user" class="user-img">
                        <img src="<c:url value="/img/buser/man.png/man.png"/>">
                    </div>
                    <textarea id="compents-input" placeholder="请使用文明用语，谢谢" maxlength="1000"></textarea>
                    <button>提交</button>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <p>eSHOP图书商城 &copy; <a href="http://gitee.com/backpackerxl">Gitee Backpackerxl</a></p>
    </footer>
    <div id="up-to-top">
        <i class="fa fa-arrow-up"></i>
    </div>
    <script>
        $(function () {
            let newtop;
            $(window).bind("scroll", function () {
                if ($(document).scrollTop() >= 100) {
                    $("#up-to-top").show(50)
                } else {
                    $("#up-to-top").hide(50)
                }
            })
            $('#up-to-top').click(function () {
                const timer = setInterval(function () {
                    newtop = $(document).scrollTop();
                    if ($(document).scrollTop() == 0) {
                        clearInterval(timer);
                    } else {
                        var a = $(document).scrollTop(newtop - 20);
                    }
                }, 10);

            });
        })
    </script>
    <script src="<c:url value="/js/compements.js"/> " type="module"></script>
</body>

</html>