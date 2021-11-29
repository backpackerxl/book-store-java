/**
 * 回复按钮的点击事件
 */
function toReplay(e, id, name) {
    const img_user = $("#img-user img").attr('src')
    showReplay(img_user, name, e.parentNode.parentNode.parentNode, id)
}
/**
 * 显示回复模块
 * @param {*用户头像} img_user
 * @param {*待回复人的姓名} index
 * @param {*回复模块要显示的位置} position
 */
function showReplay(img_user, replay_name, position, id) {
    const templ = `<div id="replay-input">
                            <div class="add-compents">
                                <div id="close-replay" class="user-img">
                                <img src="${ img_user }">
                                </div>
                                <textarea id="compents-input" placeholder="回复${replay_name}" maxlength="1000"></textarea>
                                <button onclick="submitReplay(this, '${id}')">回复</button>
                            </div>
                    </div>`
    $('.compents #replay-input').remove();
    let div = document.createElement('div');
    div.innerHTML = templ;
    position.appendChild(div.firstChild)
    $("#close-replay").click(function () {
        $('.compents-box #replay-input').slideUp(90, function () {
            $(this).remove();
        });
    })
}

/**
 * 提交回复评论
 * @param e
 * @param id
 */
function submitReplay(e, id) {
    let content = e.previousElementSibling.value.trim();
    const address = $("#submit-comment").attr("data-submit");
    const uid = parseInt($("#submit-comment").attr("data-code"));
    const bookCode = $("#submit-comment").attr("data-bookCode");
    if (content == "") {
        alert("评论内容不能为空！！")
    } else if (address === undefined){
        alert("请先登录 ！！")
    } else {
        $("#comment-container").load(`${address}/comment?actionType=submit`, {
            "userId": uid,
            "content": content,
            "product_code": bookCode,
            "parent_comment_id": parseInt(id),
        }, function (responseTxt, statusTxt, xhr) {
            $("#compents-input").val("")
        });
    }
}

/**
 * 显示或隐藏子级评论信息
 */
$(".compents-box #more-compents").click(function () {
    const childnode = $(this).parent().parent().next();
    if (childnode.is(':hidden')) {
        childnode.slideDown(200)
        const upInfo = $(this).html().replace('展开', '收起').replace('fa-caret-down', 'fa-caret-up');
        $(this).html(upInfo);
    } else {
        childnode.slideUp(200)
        const downInfo = $(this).html().replace('收起', '展开').replace('fa-caret-up', 'fa-caret-down');
        $(this).html(downInfo);
    }
})