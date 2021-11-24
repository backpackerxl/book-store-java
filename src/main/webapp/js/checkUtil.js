/**
 * 各输入框的正则表达式
 * @type {{".username": RegExp, ".phone": RegExp, ".password": RegExp, ".email": RegExp}}
 */
const objRegExp = {
    ".username": /^[\u4e00-\u9fa5_a-zA-Z0-9_-]{2,15}$/,
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    ".password": /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/,
    ".phone": /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/,
    ".email": /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/
}

/**
 * 校验失败的函数
 * @param namenode -> 输入框节点的类名
 * @param secondnodename -> 输入组件节点的类名
 * @param blog -> 显示的错误信息
 */
function showError(nodename, secondnodename, blog) {
    $(nodename).val("")
    //在添加错误图片之前，删除正确图片
    $("#check-success").remove()
    //若已存在错误图片，先删除在添加
    if ($("#check-error").length > 0) {
        $("#check-error").remove()
    }
    //添加错误图片，以及错误提示信息，改变输入框的样式
    $(secondnodename).append(`<img id="check-error" src="/bstore/img/error.png">`)
    $(nodename).attr("placeholder", `${blog}`).css({
        "background": "#fff0f0",
        "border-left": ".3rem solid #d95c5c"
    })
    $(".submit").attr("disabled", "disabled").css({"cursor": "not-allowed", "opacity": ".4"})
    if ($(".submit").attr("disabled") === "disabled") {
        $(".notice").css({"color": "#d95c5c"})
    }
}

/**
 * 校验成功的函数
 * @param namenode -> 输入框节点的类名
 * @param secondnodename -> 输入组件节点的类名
 * @param blog -> 显示的错误信息
 */
function showSuccess(nodename, secondnodename) {
    //在添加正确图片之前，删除错误图片
    $("#check-error").remove()
    //若已存在正确图片，先删除在添加
    if ($("#check-success").length > 0) {
        $("#check-success").remove()
    }
    //添加正确图片，改变输入框的样式
    $(secondnodename).append(`<img id="check-success" src="/bstore/img/success.png">`)
    $(nodename).css({
        "background": "#E8F0FEFF",
        "border-left": "1px solid #fe7300"
    })
    $(".submit").removeAttr("disabled").css({"cursor": "pointer", "opacity": ".7"})
}

/**
 * 输入框失去焦点的非空校验
 * @param namenode -> 输入框节点的类名
 * @param secondnodename -> 输入组件节点的类名
 * @param blog -> 显示的错误信息
 */
function isEmpty(nodename, secondnodename, blog) {
    $(nodename).blur(() => {
        const value = $(nodename).val()
        if ($.trim(value) === "") {
            showError(nodename, secondnodename, blog)
        } else {
            if ($(".submit").attr("disabled") === 'disabled') {
                $(".notice").css({"color": "#d95c5c"})
            }
            showSuccess(nodename, secondnodename)
        }
    })
}

/**
 * 提交的非空校验
 * @param namenode -> 输入框节点的类名
 * @param secondnodename -> 输入组件节点的类名
 * @param blog -> 显示的错误信息
 */

function isSubmit(namenode, secondnodename, blog) {
    $(".submit").on("click", () => {
        if ($.trim($(namenode).val()) === "") {
            showError(namenode, secondnodename, blog)
        }
    })
}

/**
 * 正则校验的方法
 * @param namenode -> 输入框节点的类名
 * @param secondnodename -> 输入组件节点的类名
 * @param blog -> 显示的错误信息
 */
function isCheckRegExp(namenode, secondnodename, blog) {
    $(namenode).blur(() => {
        if ($.trim($(namenode).val()) !== "") {
            if (objRegExp[namenode].test($(namenode).val())) {
                showSuccess(namenode, secondnodename)
            } else {
                showError(namenode, secondnodename, blog)
            }
        }
    })
}

/**
 * 用于校验用户是否已经被注册
 * @param namenode
 * @param secondnodename
 */
function isCheckRegister(namenode, secondnodename) {
    $(namenode).blur(() => {
        const obj = {
            ".username": "registerCheckUsername",
            ".email": "registerCheckEmail",
            ".phone": "registerCheckPhone"
        }
        $.ajax({
            type: "GET",
            url: '/bstore/user?rqType=' + obj[namenode],
            data: {
                type: $.trim($(namenode).val())
            },
            dataType: "json",
            success: function (result) {
                const info = result.info
                if ($.trim($(namenode).val()) !== "") {
                    if (info === null) {
                        showSuccess(namenode, secondnodename)
                    } else {
                        showError(namenode, secondnodename, info)
                    }
                }
            },
            error: function () {
            }
        })
    })
}

/**
 * 发送邮件的事件
 * @param sendType
 */
function sendToEmail(namenode, secondnamenode, blog, sendType) {
    $(".send-email").on("click", () => {
        let time = 60
        let setTime = null;
        if ($.trim($(namenode).val()) === "") {
            showError(namenode, secondnamenode, blog)
        } else {
            if (time == 60) {
                setTime = setInterval(function () {
                    if (time == 0) {
                        $(".send-email").html("&nbsp;重新发送")
                        $(".send-email").removeAttr("disabled").css({"cursor": "pointer", "opacity": ".8"})
                        time = 60
                        clearInterval(setTime)
                    } else {
                        $(".send-email").attr("disabled", "disabled").css({"cursor": "not-allowed", "opacity": ".5"})
                        $(".send-email").html(`${time}s后重新发送`)
                        time--;
                    }
                }, 1000)
            }
            $.ajax({
                type: "GET",
                url: '/bstore/sendemail',
                data: {
                    sendTypeName: $.trim($(namenode).val()),
                    sendType: sendType
                },
                dataType: "json",
                success: function (result) {
                    alert(result.info)
                },
                error: function () {
                }
            })
        }
    })
}

export {
    isEmpty,
    isSubmit,
    isCheckRegExp,
    sendToEmail,
    isCheckRegister
}