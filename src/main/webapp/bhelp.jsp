<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书城首页</title>
    <%@include file="ResourcesTemplate.jsp"%>
    <link rel="stylesheet" href="<c:url value="/css/book-help.css"/>">
</head>

<body>
    <%@include file="HeadTemplate.jsp"%>

    <div class="container">
        <div class="warp-txt">
            <h4>欢迎来到Backpackerxl书城帮助中心</h4>
            <p>尊敬的用户您好，首先欢迎您一直以来支持我们，您的满意就是我们发展的动力。下面我们将对一些常见问题进行回答。</p>
            <h4><i class="fa fa-question-circle"></i>关于购买图书的问题？</h4>
            <p>*书城平台一律采用虚拟货币进行交易，不存在货到付款这一说法，若遇到此类问题，您可拨打投诉电话，平台收到回电，会尽快处理(运费除外)</p>
            <h4><i class="fa fa-question-circle"></i>关于充值的问题？</h4>
            <p>*书城平台支持支付宝、微信进行充值，一旦充值，概不退还。未成年人请在家长的陪同下进行充值。钱包中的虚拟货币，只能在平台中消费。</p>
            <h4><i class="fa fa-question-circle"></i>关于注册及登录的问题？</h4>
            <p>*打开书城平台，无账号点击注册；有账号输入帐号及密码即可登录；若忘记密码，可通过注册邮箱找回密码。</p>
            <h4><i class="fa fa-question-circle"></i>关于物流的问题？</h4>
            <p>*书城用户下单后平台会立即发货，用户可自由更换物流公司，但产生的额外费用，需用户自行承担。</p>
            <h4><i class="fa fa-question-circle"></i>关于版权的问题？</h4>
            <p>*书城平台所有书籍数据，均为虚构，没有得到任何版权商的授权，大家可以放心购买。</p>
            <h4><i class="fa fa-question-circle"></i>关于站长的问题？</h4>
            <p>*书城平台的站长是个神秘的人，不愿透露个人信息，大家可以去他的GitHub或者Gitee上去了解它<i class="fa fa-arrow-right"></i>
                <a target="_blank" href="https://www.github.com/Backpackerxl">GitHub</a>
                <a target="_blank" href="https://www.gitee.com/backpackerxl">Gitee</a>
            </p>
        </div>
    </div>

    <%@include file="FooterTemplate.jsp"%>
</body>

</html>