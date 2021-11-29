<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>搜索结果</title>
    <%@include file="/compoments/ResourcesTemplate.jsp" %>
    <link rel="stylesheet" href="<c:url value="/css/book-shop.css"/>">
</head>

<body>
<%@include file="/compoments/HeadTemplate.jsp" %>

<div class="container">
    <div style="width: 960px;" class="productlist-right">
        <h4 style="border: none;" class="book-list"><i class="fa fa-list"></i>
            搜索结果 共${ requestScope.resBook.size() }种商品
        </h4>
        <div class="list-warp">PRODUCT LIST</div>
        <div class="book-img-warp">
            <c:choose>
                <c:when test="${ requestScope.resBook.size() == 0 }">
                    <div style="display: flex;justify-content: center; align-items: center;">
                        <img src="<c:url value="/img/empty.png"/>">
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${ requestScope.resBook }" var="res">
                        <c:choose>
                            <c:when test="${ res.bookQuantity == 0 }">
                                <div class="box loading">
                                    <div class="image">
                                        <img src="<c:url value="${ res.bookImg }"/> "/>
                                    </div>
                                    <div class="content">
                                        <h4 class="book-name">${ res.bookName }</h4>
                                        <div class="author">${ res.bookAuthor }</div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="box">
                                    <div class="image">
                                        <a target="_blank"
                                           href="<c:url value="/book?actionType=getBook&bookCode=${ res.bookCode }"/> ">
                                            <img src="<c:url value="${ res.bookImg }"/> "/>
                                        </a>
                                    </div>
                                    <div class="content">
                                        <h4 class="book-name">${ res.bookName }</h4>
                                        <div class="author">${ res.bookAuthor }</div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%@include file="/compoments/FooterTemplate.jsp" %>
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