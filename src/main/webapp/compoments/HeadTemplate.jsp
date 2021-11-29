<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
    <header class="header">
        <div class="left">
            <h4><i class="fa fa-book"></i>bSTORE</h4>
            <p>backpackerxl.cn</p>
        </div>
        <div class="right">
            <form action="${ pageContext.request.contextPath }/book?actionType=searchBook" method="post">
                <div class="search-shop">
                    <c:choose>
                        <c:when test="${ requestScope.keywords == null }">
                            <input type="text" name="keywords" placeholder="搜索喜欢的商品">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="keywords" placeholder="搜索喜欢的商品" value="${ requestScope.keywords }">
                        </c:otherwise>
                    </c:choose>
                    <i class="fa fa-search"></i>
                </div>
            </form>
        </div>
    </header>
    <div id="middle-nav" class="middle">
        <ul>
            <a href="<c:url value="/"/> "><i class="fa fa-home"></i>首页</a>
            <a href="<c:url value="/book?actionType=getBookType&typeId=1"/> "><i class="fa fa-info-circle"></i>分类</a>
            <a href="<c:url value="/book?actionType=findAll&currPage=1" /> "><i class="fa fa-book"></i>书屋</a>
            <a href="#"><i class="fa fa-commenting"></i>书评</a>
        </ul>
        <%
            String username = (String) request.getSession().getAttribute("username");
            if (username == null) {
        %>
        <a class="user-to-login" href="<c:url value="/login"/>">登录</a>
        <%} else {%>
        <div id="username" class="user">
            <div id="avater">
                <img src="<c:url value="${ userImg }"/> ">
                <span>${ username }</span>
            </div>
            <ul id="menu-pop">
                <a href="<c:url value="/bcar"/>"><i class="fa fa-cart-plus"></i> 购 物 车</a>
                <a href="#"><i class="fa fa-user"></i> 帐号管理</a>
                <a href="<c:url value="/user?rqType=loginOut"/>"><i class="fa fa-sign-out"></i> 退出登录</a>
            </ul>
        </div>
        <%}%>
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
                $("#middle-nav").css({"position": "fixed", "top": 0, "width": "100%"})
            } else {
                $("#middle-nav").removeAttr("style")
            }
        })
    })
</script>
