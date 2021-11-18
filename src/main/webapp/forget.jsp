<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>找回密码</title>
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/register.css"/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/img/book.png" />" type="image/png">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="left-img">
        <img src="<c:url value="/img/forget.png" />"/>
        <div class="notice">
            <p><img src="<c:url value="/img/notice.png" />"/>密码最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符</p>
        </div>
    </div>
    <div class="right-login">
        <form action="/book-store/user?rqType=userForget" method="post">
            <div class="header"><h1>找回密码</h1></div>
            <div class="user-box">
                <input type="text" name="username" placeholder="用户名" class="username"/>
            </div>
            <div class="pass-box">
                <input type="password" name="password" placeholder="新密码" class="password">
            </div>
            <div class="check-code">
                <input type="text" style="width: 37%;" name="checkcode" placeholder="验证码" class="checkout">
                <div style="width: 70px;"></div>
                <button type="button" class="send-email">发送验证码</button>
            </div>
            <br/>
            <input type="submit" class="submit" value="修改">
            <br/>
            <a href="<c:url value="/page?to=login"/>" class="reset">已有帐号，去登录.</a>
        </form>
    </div>
</div>
<script type="module" src="<c:url value="/js/checkForget.js"/>"></script>
<script type="text/javascript">
    let info = '<%=request.getParameter("error")%>'
    const pageinfo = {
        "service": `<div id="error-msg" style="animation: .6s forword ease-in;">
                          <a id="close-info">❌</a> 服务器异常，请稍后再试
                      </div>`,
        "code": `<div id="error-msg" style="animation: .6s forword ease-in;">
                          <a id="close-info">❌</a> 验证码错误，请正确填写
                      </div>`
    }
    if (info !== null) {
        $(".right-login").append(pageinfo[info])
        $("#close-info").on("click", () => {
            $("#error-msg").attr("style", "display: none;")
        })
    }
</script>
</body>
</html>
