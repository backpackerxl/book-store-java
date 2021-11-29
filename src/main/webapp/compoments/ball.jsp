<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>全部书籍</title>
    <%@include file="/compoments/ResourcesTemplate.jsp" %>
    <link rel="stylesheet" href="<c:url value="/css/book-shop.css"/>">
</head>

<body>
<%@include file="/compoments/HeadTemplate.jsp" %>

<div class="container">
    <div style="width: 960px;" class="productlist-right">
        <h4 style="border: none;" class="book-list"><i class="fa fa-list"></i>
            全部商品列表
        </h4>
        <div class="list-warp">PRODUCT LIST</div>
        <div class="book-img-warp">
            <c:forEach items="${ requestScope.pageBooks.list }" var="pageList">
                <c:choose>
                    <c:when test="${ pageList.bookQuantity == 0 }">
                        <div class="box loading">
                            <div class="image">
                                <img src="<c:url value="${ pageList.bookImg }"/> "/>
                            </div>
                            <div class="content">
                                <h4 class="book-name">${ pageList.bookName }</h4>
                                <div class="author">${ pageList.bookAuthor }</div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="box">
                            <div class="image">
                                <a target="_blank"
                                   href="<c:url value="/book?actionType=getBook&bookCode=${ pageList.bookCode }"/> ">
                                    <img src="<c:url value="${ pageList.bookImg }"/> "/>
                                </a>
                            </div>
                            <div class="content">
                                <h4 class="book-name">${ pageList.bookName }</h4>
                                <div class="author">${ pageList.bookAuthor }</div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <div class="page-warp">
            <c:if test="${ requestScope.pageBooks.currentPage > 1 }">
                <a href="<c:url value="/book?actionType=findAll&currPage=${ requestScope.pageBooks.currentPage-1 }"/> ">上一页</a>
            </c:if>
            <span>共${ requestScope.pageBooks.totalSize }本书籍 当前 ${ requestScope.pageBooks.currentPage }/${ requestScope.pageBooks.totalPage } 页</span>
            <c:if test="${ requestScope.pageBooks.currentPage < requestScope.pageBooks.totalPage }">
                <a href="<c:url value="/book?actionType=findAll&currPage=${ requestScope.pageBooks.currentPage+1 }"/> ">下一页</a>
            </c:if>
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