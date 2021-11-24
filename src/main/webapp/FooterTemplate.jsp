<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>
    <div class="link">
        <ul>
            <li class="title">快速进入</li>
            <li><a href="<c:url value="/"/> "><i class="fa fa-arrow-right"></i>首页</a></li>
            <li><a href="#"><i class="fa fa-arrow-right"></i>分类</a></li>
            <li><a href="#"><i class="fa fa-arrow-right"></i>书屋</a></li>
            <li><a href="#"><i class="fa fa-arrow-right"></i>书评</a></li>
        </ul>
        <ul>
            <li class="title">好书推荐</li>
            <c:forEach items="${ requestScope.bottomBookLists }" var="bottomBookList" >
                <li><a target="_blank" href="<c:url value="/book?actionType=getBook&bookCode=${ bottomBookList.bookCode }"/> "><i class="fa fa-arrow-right"></i>${ bottomBookList.bookName }</a></li>
            </c:forEach>
        </ul>
        <ul>
            <li class="title">服务中心</li>
            <li><a href="<c:url value="/bhelp"/> "><i class="fa fa-arrow-right"></i>帮助中心</a></li>
            <li><a href="<c:url value="/register"/> "><i class="fa fa-arrow-right"></i>新用户注册</a></li>
            <li><a href="https://github.com/Backpackerxl/book-store-java"><i class="fa fa-arrow-right"></i>我们的团队</a>
            </li>
        </ul>
    </div>
    <div>
        <span id="logo">
        <a href="http://gitee.com/backpackerxl">
            <svg t="1637236201533" class="icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" p-id="1834"
                 width="25" height="25"><path
                    d="M512 1024C229.248 1024 0 794.752 0 512S229.248 0 512 0s512 229.248 512 512-229.248 512-512 512z m259.168-568.896h-290.752a25.28 25.28 0 0 0-25.28 25.28l-0.032 63.232c0 13.952 11.296 25.28 25.28 25.28h177.024a25.28 25.28 0 0 1 25.28 25.28v12.64a75.84 75.84 0 0 1-75.84 75.84h-240.224a25.28 25.28 0 0 1-25.28-25.28v-240.192a75.84 75.84 0 0 1 75.84-75.84h353.92a25.28 25.28 0 0 0 25.28-25.28l0.064-63.2a25.312 25.312 0 0 0-25.28-25.312H417.184a189.632 189.632 0 0 0-189.632 189.6v353.952c0 13.952 11.328 25.28 25.28 25.28h372.928a170.656 170.656 0 0 0 170.656-170.656v-145.376a25.28 25.28 0 0 0-25.28-25.28z"
                    p-id="1835" fill="#d81e06"></path></svg>
        </a>
        <a href="https://github.com/Backpackerxl">
            <svg t="1637236316900" class="icon" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" p-id="3000"
                 width="25" height="25"><path
                    d="M512 42.666667A464.64 464.64 0 0 0 42.666667 502.186667 460.373333 460.373333 0 0 0 363.52 938.666667c23.466667 4.266667 32-9.813333 32-22.186667v-78.08c-130.56 27.733333-158.293333-61.44-158.293333-61.44a122.026667 122.026667 0 0 0-52.053334-67.413333c-42.666667-28.16 3.413333-27.733333 3.413334-27.733334a98.56 98.56 0 0 1 71.68 47.36 101.12 101.12 0 0 0 136.533333 37.973334 99.413333 99.413333 0 0 1 29.866667-61.44c-104.106667-11.52-213.333333-50.773333-213.333334-226.986667a177.066667 177.066667 0 0 1 47.36-124.16 161.28 161.28 0 0 1 4.693334-121.173333s39.68-12.373333 128 46.933333a455.68 455.68 0 0 1 234.666666 0c89.6-59.306667 128-46.933333 128-46.933333a161.28 161.28 0 0 1 4.693334 121.173333A177.066667 177.066667 0 0 1 810.666667 477.866667c0 176.64-110.08 215.466667-213.333334 226.986666a106.666667 106.666667 0 0 1 32 85.333334v125.866666c0 14.933333 8.533333 26.88 32 22.186667A460.8 460.8 0 0 0 981.333333 502.186667 464.64 464.64 0 0 0 512 42.666667"
                    fill="#231F20" p-id="3001"></path></svg>
        </a>
        </span>
        <p>
            bSTORE图书商城 &copy; 蜀ICP备2021023328号
        </p>
    </div>
</footer>
