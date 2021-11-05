$(() => {
    let timer = null;
    const Swiper = "#swiper ul";
    const SmailCirle = "#swiper .number-point span";
    const imgNumber = $("#swiper ul li").length - 1;
    let count = 0;
    const liWidth = $("#swiper ul li:first").innerWidth();
    /**
     * 轮播自动播放
     */
    timer = setInterval(() => {
        auto_play();
    }, 2000)

    const auto_play = () => {
        $(Swiper).animate({ left: -liWidth }, () => {
            $(Swiper).css("left", 0).find("li:first").appendTo(Swiper);
            count++;
            if (count > imgNumber) {  //当计数器大于span标签的节点数组的下标值时，手动重置计数器
                count = 0;
            }
            //动态为span标签添加一个active的class属性
            $(SmailCirle).eq(count).addClass("active").siblings().removeClass("active");
        })
    }

    /**
     * 当鼠标悬停在图片上时，暂停播放，离开后又自动播放
     */
    $("#swiper").hover(() => {
        // over
        clearInterval(timer);
    }, () => {
        //out
        timer = setInterval(() => {
            auto_play();
        }, 2000)
    });
    /**
     * 左右箭头切换的效果
     */
    $(".next").click(() => {
        auto_play();
    });
    $(".prev").click(() => {
        /**
         * 1. 先将li 向左移除一个宽度，同时，将显示在最后的一个li追加到ul的最前头
         * 2. 执行动画， 将ul的left修改为0，将最后一个li带回
         */
        $(Swiper).css("left", -liWidth).find("li:last").prependTo(Swiper);
        $(Swiper).animate({ left: 0 });
        /**
         * 让园点跟着prev的动作进行变化
         */
        count--;
        if (count < 0) {//同理
            count = imgNumber;
        }
        $(SmailCirle).eq(count).addClass("active").siblings().removeClass("active");
    });
    /**
     * 实现点击小圆点实现切换效果
     */
    $(SmailCirle).each(function(index){
        $(this).click(function(){
            if (count < index) {
                for (let i = count; i < index; i++) {
                    $(Swiper).animate({ left: -liWidth }, 100, () => {
                        $(Swiper).css("left", 0).find("li:first").appendTo(Swiper);
                    })
                }
            } else if (count > index) {
                for (let j = count; j > index; j--) {
                    $(Swiper).css("left", -liWidth).find("li:last").prependTo(Swiper);
                    $(Swiper).animate({ left: 0 }, 100);
                }
            }
            count = index;
            $(SmailCirle).eq(count).addClass("active").siblings().removeClass("active");
        })
    })
})