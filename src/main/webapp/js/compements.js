
$(function () {
    /**
     * 显示回复模块
     * @param {*用户头像} img_user
     * @param {*待回复人的姓名} index
     * @param {*回复模块要显示的位置} position
     */
    function showReplay(img_user, index, position) {
        const templ = `<div id="replay-input">
                            <div class="add-compents">
                                <div id="close-replay" class="user-img">
                                <img src=${img_user}>
                                </div>
                                <textarea id="compents-input" placeholder="回复${UserComments[index].name}" maxlength="1000"></textarea>
                                <button>回复</button>
                            </div>
                    </div>`
        $('.compents #replay-input').remove();
        position.append(templ)
        $("#close-replay").click(function () {
            $('.compents-box #replay-input').slideUp(90, function () {
                $(this).remove();
            });
        })
    }

    /**
     * 回复按钮的点击事件
     */
    $(".compents #reply-compents, #child-compents #reply-compents-child").click(function (e) {
        const img_user = $("#img-user img").attr('src')
        const index = parseInt(e.target.dataset.index) - 1
        showReplay(img_user, index, $(this).parent().parent().parent())
    })
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
    $("#submit-comment").click(function () {
        const content = $("#compents-input").val().trim();
        const address = $(this).attr("data-submit");
        const uid = parseInt($(this).attr("data-code"));
        const bookCode = $(this).attr("data-bookCode");
        console.log($(this).attr("data-submit"), $(this).attr("data-code"), $(this).attr("data-bookCode"))
        if (content == "") {
            alert("评论内容不能为空！！")
        } else {
            $.ajax({
                type: "POST",
                url: `${address}/comment?actionType=submit`,
                data: {
                    userId: uid,
                    content: content,
                    product_code: bookCode,
                    parent_comment_id: 0,
                },
                dataType: "json",
                success: function () {

                },
                error: function () {
                }
            })
        }
    })
});

