<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书城登录</title>
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/img/book.png" />" type="image/png">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="left-img">
        <img src="<c:url value="/img/login.png" />"/>
    </div>
    <div class="right-login">
        <form action="/book-store/user?rqType=userLogin" method="post">
            <div class="header"><h1>登录</h1> <span>没有账号? <a href="<c:url value="/page?to=register"/>">点此注册</a></span>
            </div>
            <div class="user-box">
                <input type="text" name="username" placeholder="用户名" class="username"/>
            </div>
            <div class="pass-box">
                <input type="password" name="password" placeholder="密码" class="password">
            </div>
            <div class="check-code">
                <input type="text" name="checkcode" placeholder="验证码" class="checkout">
                <img src="<c:url value="/verificationcode" />" id="verificationcode"/>
                <span id="refluse">看不清,换一张</span>
            </div>
            <br/>
            <input type="submit" class="submit" value="登录"><br/>
            <a href="<c:url value="/page?to=forget"/>" class="reset">已有帐号，忘记密码?</a>
        </form>
    </div>
</div>
<script type="module" src="<c:url value="/js/checkLogin.js"/>"></script>
<script type="text/javascript">
    $("#refluse, #verificationcode").on("click", () => {
        $("#verificationcode").attr("src", "/book-store/verificationcode" + "?" + Math.random())
    })
    let info = '<%=request.getParameter("error")%>'
    const pageinfo = `<div id="error-msg" style="animation: .6s forword ease-in;">
                          <a id="close-info">❌</a> 用户名或密码或验证码错误！
                      </div>`
    if (info == "yes") {
        $(".right-login").append(pageinfo)
        $("#close-info").on("click", () => {
            $("#error-msg").attr("style","display: none;")
        })
    }
</script>
</body>
</html>
