import {isEmpty, isSubmit, isCheckRegExp, sendToEmail} from "./checkUtil.js";

// sendEmail("sendForgetCode", "username")

isEmpty(".username", ".user-box", "用户名为必填项")
isEmpty(".password", ".pass-box", "密码为必填项")
isEmpty(".checkout", ".check-code", "验证码为必填项")

isSubmit(".username", ".user-box", "用户名为必填项")
isSubmit(".password", ".pass-box", "密码为必填项")
isSubmit(".checkout", ".check-code", "验证码为必填项")

isCheckRegExp(".password", ".pass-box", "密码不符合规则")

sendToEmail(".username", ".user-box", "用户名为必填项", "sendForgetCode")