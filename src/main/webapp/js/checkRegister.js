import {isEmpty, isSubmit, isCheckRegExp, sendToEmail, isCheckRegister} from "./checkUtil.js";

isEmpty(".phone", ".phone-box", "手机号为必填项")
isEmpty(".email", ".email-box", "邮箱为必填项")
isEmpty(".info", ".info-box", "自我介绍为必填项")

isSubmit(".phone", ".phone-box", "手机号为必填项")
isSubmit(".email", ".email-box", "邮箱为必填项")
isSubmit(".info", ".info-box", "自我介绍为必填项")

isCheckRegExp(".username", ".user-box", "用户名不符合规则")
isCheckRegExp(".password", ".pass-box", "密码不符合规则")
isCheckRegExp(".phone", ".phone-box", "手机号不符合规则")
isCheckRegExp(".email", ".email-box", "邮箱不符合规则")

isCheckRegister(".username", ".user-box")
isCheckRegister(".phone", ".phone-box")
isCheckRegister(".email", ".email-box")


sendToEmail(".email", ".email-box", "邮箱为必填项", "sendRegisterCode")