<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
    <header class="heeder">
        <div class="left">
            <h4><i class="fa fa-book"></i>eSHOP</h4>
            <p>backpackerxl.cn</p>
        </div>
        <div class="right">
            <ul>
                <a href="<c:url value="/page?to=book-car" />"><i class="fa fa-shopping-cart"></i>购物车</a>
                <a href="<c:url value="/page?to=book-help"/> "><span>|</span><i class="fa fa-question-circle"></i>帮助中心</a>
                <a href="#"><span>|</span><i class="fa fa-user"></i>我的账户</a>
                <a href="<c:url value="/page?to=register"/> "><span>|</span><i class="fa fa-registered"></i>新用户注册</a>
            </ul>
        </div>
    </header>
    <div class="top">
        <ul>
            <a href="<c:url value="/"/> "><i class="fa fa-home"></i>首页</a>
            <a href="#"><span>|</span><i class="fa fa-user"></i>我的账户</a>
            <a href="#"><span>|</span><i class="fa fa-user-circle-o"></i>圈子</a>
        </ul>
        <div class="search">
            <input type="text">
            <button id="search"><i class="fa fa-search"></i>搜索</button>
        </div>
    </div>
    <div id="middle-nav" class="middle">
        <ul>
            <a href="#">文学</a>
            <a href="#">生活</a>
            <a href="#">计算机</a>
            <a href="#">外语</a>
            <a href="#">经管</a>
            <a href="#">励志</a>
            <a href="#">社科</a>
            <a href="#">学术</a>
            <a href="#">少儿</a>
            <a href="#">艺术</a>
            <a href="#">原版</a>
            <a href="#">科技</a>
            <a href="#">考试</a>
            <a href="#">生活百科</a>
            <a href="#">全部商品目录</a>
        </ul>
        <div id="username" class="user">
            <img src="<c:url value="/img/buser/avater.jpg"/> ">
            <span><%=request.getSession().getAttribute("username")%></span>
            <ul id="menu-pop">
                <a href="#">帐号管理</a>
                <a href="#">退出登录</a>
            </ul>
        </div>
    </div>
</nav>
<script>
    $(() => {
        $("#username").on("click", () => {
            if ($("#menu-pop").is(":hidden")) {
                $("#menu-pop").show(100);
            } else {
                $("#menu-pop").hide(100);
            }
        })
        $(window).bind("scroll", () => {
            if ($(document).scrollTop() >= 100) {
                $("#middle-nav").css({ "position": "fixed", "top": 0, "width": "100%" })
            } else {
                $("#middle-nav").removeAttr("style")
            }
        })
    })
</script>
