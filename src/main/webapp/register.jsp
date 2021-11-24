<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>书城注册</title>
    <link href="<c:url value="/css/login.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/register.css"/>" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/img/book.png" />" type="image/png">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="left-img">
        <img src="<c:url value="/img/register.png" />" id="register"/>
        <div class="notice">
            <p><img src="<c:url value="/img/notice.png" />"/>用户名不能包括特殊字符下划线和横杠除外，且最少为2位最多15位</p>
            <p><img src="<c:url value="/img/notice.png" />"/>密码最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符</p>
        </div>
    </div>
    <div class="right-login">
        <form style="margin: 0;" action="<c:url value="/user?rqType=userRegister"/>" method="post">
            <div class="header"><h1>注册</h1> <span>已有帐号，<a href="<c:url value="/login"/>">去登录.</a></span></div>
            <div class="user-box">
                <input type="text" name="username" placeholder="用户名" class="username"/>
            </div>
            <div class="pass-box">
                <input type="password" name="password" placeholder="密码" class="password">
            </div>
            <div class="phone-box">
                <input type="text" name="phone" placeholder="手机号" class="phone"/>
            </div>
            <div class="email-box">
                <input type="text" name="email" placeholder="邮箱" class="email"/>
            </div>
            <div class="info-box">
                <textarea class="info" name="info" placeholder="自我介绍限制在30个字以内"></textarea>
            </div>
            <div class="check-code">
                <input type="text" style="width: 37%;" name="checkcode" placeholder="验证码" class="checkout">
                <div style="width: 70px;"></div>
                <button type="button" class="send-email">发送验证码</button>
            </div>
            <br/>
            <input type="submit" class="submit" value="注册"><br/>
        </form>
    </div>
</div>
<script type="module" src="<c:url value="/js/checkLogin.js"/>"></script>
<script type="module" src="<c:url value="/js/checkRegister.js"/>"></script>
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
