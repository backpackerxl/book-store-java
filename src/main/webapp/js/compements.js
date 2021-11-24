import { BookComment, showReplay } from '../compoments/comment/index.js';

$(function () {
    /**
     * 通过组件化去渲染评论列表
     */
    BookComment().mount("#compents");
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
        if(childnode.is(':hidden')){
            childnode.slideDown(200)
            const upInfo = $(this).html().replace('展开','收起').replace('fa-caret-down','fa-caret-up');
            $(this).html(upInfo);
        }else{
            childnode.slideUp(200)
            const downInfo = $(this).html().replace('收起','展开').replace('fa-caret-up','fa-caret-down');
            $(this).html(downInfo);
        }
    })
});

