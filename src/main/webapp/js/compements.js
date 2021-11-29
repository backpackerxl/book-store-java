$(function () {
    /**
     * 提交评论信息
     */
    $("#submit-comment").click(function () {
        let content = $(this).prev().val().trim();
        const address = $(this).attr("data-submit");
        const uid = parseInt($(this).attr("data-code"));
        const bookCode = $(this).attr("data-bookCode");
        if (content == "") {
            alert("评论内容不能为空！！")
        }else if (address === undefined){
            alert("请先登录！！")
        } else {
            $("#comment-container").load(`${address}/comment?actionType=submit`, {
                "userId": uid,
                "content": content,
                "product_code": bookCode,
                "parent_comment_id": 0,
            }, function (responseTxt, statusTxt, xhr) {
                $("#compents-input").val("")
            });
        }
    })
});


