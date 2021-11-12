import { Comment } from './map-comment-reduce.js';
$(function () {
    const replayCompement = [{
        "id": 1,
        "name": "backpackerxl",
        "user_img": "/img/man.png",
        "content": "for every developer who loves javascript ,this book is very good !for every developer who loves javascript ,this book is very good !",
        "createTime": "2021-11-5",
        "product_id": 2,
        "parent_comment_id": null
    }, {
        "id": 2,
        "name": "alice",
        "user_img": "/img/elyse.png",
        "content": "for every developer who loves javascript ,this book is very good !",
        "createTime": "2021-11-5",
        "product_id": 2,
        "parent_comment_id": null
    }, {
        "id": 3,
        "name": "Tom",
        "user_img": "/img/man.png",
        "content": "this book is very good !",
        "createTime": "2021-11-6",
        "product_id": 2,
        "parent_comment_id": null
    }, {
        "id": 4,
        "name": "luck",
        "user_img": "/img/man.png",
        "content": "nice nice nice !",
        "createTime": "2021-11-2",
        "product_id": 2,
        "parent_comment_id": 1
    }, {
        "id": 5,
        "name": "judy",
        "user_img": "/img/elyse.png",
        "content": "very nice , yes yes !",
        "createTime": "2021-11-5",
        "product_id": 2,
        "parent_comment_id": 1
    }, {
        "id": 6,
        "name": "alice",
        "user_img": "/img/man.png",
        "content": "oh my god ! this very intertesing",
        "createTime": "2021-11-1",
        "product_id": 2,
        "parent_comment_id": 4
    }, {
        "id": 7,
        "name": "luck",
        "user_img": "/img/man.png",
        "content": "nice nice nice !",
        "createTime": "2021-11-2",
        "product_id": 2,
        "parent_comment_id": 6
    }, {
        "id": 8,
        "name": "judy",
        "user_img": "/img/elyse.png",
        "content": "very nice , yes yes !",
        "createTime": "2021-11-5",
        "product_id": 2,
        "parent_comment_id": 6
    }, {
        "id": 9,
        "name": "小白",
        "user_img": "/img/man.png",
        "content": "very nice , yes yes ,no,no,no!",
        "createTime": "2021-11-5",
        "product_id": 2,
        "parent_comment_id": 2
    }, {
        "id": 10,
        "name": "小明",
        "user_img": "/img/man.png",
        "content": "very nice , yes yes ,no,no,no!",
        "createTime": "2021-11-6",
        "product_id": 2,
        "parent_comment_id": 9
    }, {
        "id": 11,
        "name": "小红",
        "user_img": "/img/elyse.png",
        "content": "you are welcome",
        "createTime": "2021-11-7",
        "product_id": 2,
        "parent_comment_id": 3
    },
    {
        "id": 12,
        "name": "小朱",
        "user_img": "/img/elyse.png",
        "content": "you are welcome",
        "createTime": "2021-11-8",
        "product_id": 2,
        "parent_comment_id": 11
    }];
    function showReplay(img_user, index, position) {
        const templ = `
                        <div id="replay-input">
                                <div class="add-compents">
                                    <div id="close-replay" class="user-img">
                                    <img src=${img_user}>
                                    </div>
                                    <textarea id="compents-input" placeholder="回复${replayCompement[index].name}" maxlength="1000"></textarea>
                                    <button>回复</button>
                                </div>
                        </div>`
        $('.compents #replay-input').remove();
        $('.compents').append(templ)
        $(".compents #replay-input").css("top", position)
        $("#close-replay").click(function () {
            $('.compents #replay-input').remove();
        })
    }
    function showCompements() {
        new Comment(replayCompement).mapReduce().forEach(compemnet => {
            const templmaster = `<div class="compents-box">
                                    <div class="compents-img">
                                         <img src=${compemnet.user_img}>
                                    </div>
                                    <div class="compents-content">
                                         <p>${compemnet.name}</p>
                                         <p>${compemnet.content}</p>
                                         <p>
                                            <span><i class="fa fa-calendar-minus-o"></i>${compemnet.createTime}</span>
                                            ${compemnet.childrenComment.length > 0 ? `<b data-index=${compemnet.id} id="more-compents">— 展开${compemnet.childrenComment.length}条回复 <i class="fa fa-caret-down"></i></b>` : ''}
                                            <a data-index=${compemnet.id} id="reply-compents" href="javascript:;">回复</a>
                                         </p>
                                    </div>
                                    <div style="display: none;" id="child-compents">
                                        ${showChildCompement(compemnet.childrenComment, compemnet.id)}
                                    </div>
                                    </div>
                                </div>`
            $(".compents").append(templmaster)
        })
        $(".compents #child-compents").each(function () {
            const compement = $(this).children()
            $(this).empty();
            $(this).append(compement)
        });
        $(".compents #reply-compents, #child-compents #reply-compents-child").click(function (e) {
            const img_user = $("#img-user img").attr('src')
            const index = parseInt(e.target.dataset.index) - 1
            showReplay(img_user, index, e.pageY)
        })
    }
    showCompements()
    function showChildCompement(childArray, selectIndex) {
        let childFragment = []
        childArray.forEach(comment => {
            const resname = comment.parent_comment_id === selectIndex ? "" : `@${replayCompement[comment.parent_comment_id - 1].name}`
            const templ = `<div class="compents-box">
            <div class="compents-img">
                 <img src=${comment.user_img}>
            </div>
            <div class="compents-content">
                 <p>${comment.name} ${resname}</p>
                 <p>${comment.content}</p>
                 <p>
                 <span><i class="fa fa-calendar-minus-o"></i>${comment.createTime}</span>
                 <a data-index=${comment.id} id="reply-compents-child" href="javascript:;">回复</a>
                 </p>
            </div>
        </div>`
            childFragment.push(templ)
        })
        return childFragment;
    }
    $(".compents-box #more-compents").click(function (e) {
        const index = parseInt(e.target.dataset.index) - 1
        $(".compents-box #child-compents").each(function (item) {
            if ($(this).is(":hidden") && item == index) {
                $(this).slideDown(200)
            } else {
                $(this).slideUp(200)
            }
        })
    })
});

