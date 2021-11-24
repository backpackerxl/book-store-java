<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书籍列表业</title>
    <%@include file="ResourcesTemplate.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/book-shop.css"/>">
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
            <h4 class="book-list"><i class="fa fa-list"></i>商品目录</h4>
            <h4 class="book-type">计算机类 <span>共38699种商品</span></h4>
            <div class="book-tag">
                <i class="fa fa-tag"></i>
                文学<span>¦</span>
                传记<span>¦</span>
                动漫<span>¦</span>
                艺术<span>¦</span>
                摄影<span>¦</span>
                设计
            </div>
            <div class="list-warp">PRODUCT LIST</div>
            <div class="book-img-warp">
                <div class="box">
                    <div class="image">
                        <img src="./img/book-004.jpg" />
                    </div>
                    <div class="content">
                        <h4 class="book-name">Java 8函数式编程</h4>
                        <div class="author">作者: [英] Richard Warburton</div>
                    </div>
                </div>
                <div class="box">
                    <div class="image">
                        <img src="./img/book-006.jpg" />
                    </div>
                    <div class="content">
                        <h4 class="book-name">Sping Cloud微服务</h4>
                        <div class="author">作者: 尹吉欢</div>
                    </div>
                </div>
                <div class="box">
                    <div class="image">
                        <img src="./img/book-007.jpg" />
                    </div>
                    <div class="content">
                        <h4 class="book-name">鸟哥的Linux私房菜</h4>
                        <div class="author">作者: 鸟哥</div>
                    </div>
                </div>
                <div class="box loading">
                    <div class="image">
                        <!-- <img src="./img/b0005.jpg" /> -->
                    </div>
                    <div class="content">
                        <!-- 深入React技术栈 -->
                        <!-- 作者: 陈屹 -->
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div>
                <div class="box">
                    <div class="image">
                        <img src="./img/book-001.jpg" />
                    </div>
                    <div class="content">
                        <h4 class="book-name">JavaScript高级程序设计</h4>
                        <div class="author">作者: [美] 马特·弗里斯比</div>
                    </div>
                </div>
                <div class="box">
                    <div class="image">
                        <img src="./img/book-008.jpg" />
                    </div>
                    <div class="content">
                        <h4 class="book-name">ES6标准入门</h4>
                        <div class="author">作者: 阮一峰</div>
                    </div>
                </div>
                <div class="box loading">
                    <div class="image">

                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div>
                <!-- <div class="box loading">
                    <div class="image">
                       
                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div> -->
                <!-- <div class="box loading"> 
                    <div class="image">
                       
                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div> -->
                <!-- <div class="box loading">
                    <div class="image">
                        
                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div> -->
                <!-- <div class="box loading">
                    <div class="image">
                       
                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div> -->
                <!-- <div class="box loading"> 
                    <div class="image">
                       
                    </div>
                    <div class="content">
                        <h4 class="book-name"></h4>
                        <div class="author"></div>
                    </div>
                </div> -->
            </div>
        </div>
    </div>
    <%@include file="FooterTemplate.jsp"%>
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
</body>

</html>