$(function () {
    /**
     * 计算总价的函数
     */
    function total_price() {
        let total_money = 0.00;
        $("#my-book #total_price").each(function () {
            //通过兄弟节点下的子节点获取购物车中checkbox的选中状态，
            //若选中状态为真，则将单个商品的总金额统计到总的订单金额中去
            const blog = $(this).prev().prev().prev().prev().children("#select-book").is(':checked');
            if (blog) {
                const money = parseFloat($(this).html().slice(1));
                total_money += money;
            }
        });
        $("#my_total_money").html(`￥${total_money.toFixed(2)}`);
    }
    /**
     * 页面加载成功后默认选中第一项
     */
    $("#my-book #book-info #select-book").each(function(index){
        if(index === 0){
            //为第一个商品添加默认选中状态
            $(this).attr("checked","checked")
            total_price()
        }
    })
    /**
     * 删除订单
     */
    $("#my-book td #close").click(function () {
        if (confirm('确定要删除？')) {
            $(this).parent().parent('#my-book').remove();
            // 展示总金额和总数量
            total_price();
        }
    });
    /**
     * 点击checkbox后重新计算总价
     */
    $("#my-book #book-info #select-book").click(function(){
        total_price()
    })
    /**
     * 提交订单
     */
    $("#submit").click(function(){
        if(parseInt($(this).prev().html().slice(1)) > 0){
            //提交
            alert(`正在提交订单，您的订单金额是${parseFloat($(this).prev().html().slice(1))}元`)
        }else if($("#shop-car #my-book").length === 0){
            alert("亲，购物车空空空如也呢，让我们去看看商品吧！")
            $(window).attr('location', 'http://127.0.0.1:5500/book-shop.html')
        }else{
            alert("亲，您还没选商品呢 ❓")
        }
    })
    /**
     * 全选订单
     */
    $("#select-all").click(function(){
        if ($(this).is(':checked')){
            $("#my-book #book-info #select-book").each(function(){
                $(this).attr("checked","checked")
            })
        }else{
            $("#my-book #book-info #select-book").each(function(){
                $(this).removeAttr("checked");
            })
        }
        total_price()
    })
    /**
     * 绑定订单数量，若订单数量变化后应重新计算相应的值
     */
    $("#my-book #count-number #number").bind("change", function () {
        if (parseInt($(this).val()) > 1){
            //通过兄弟节点获取商品单价，和数量进行单个商品的总价计算
            const total = (parseInt($(this).val()) * parseFloat($(this).parent().prev().html().slice(1))).toFixed(2)
            $(this).parent().next().html(`￥${total}`);
            total_price();
        }else{
            $(this).val(1)
            alert("😭，不能再少了！")
        }
    })
    /**
     * 增加数量的点击事件
     */
    $("#my-book #count-number #add").click(function () {
        //通过点击对输入框中的值进行加1
        $(this).prev().val(parseInt($(this).prev().val()) + 1);
        //通过兄弟节点获取商品单价，和数量进行单个商品的总价计算
        const total = (parseInt($(this).prev().val()) * parseFloat($(this).parent().prev().html().slice(1))).toFixed(2)
        $(this).parent().next().html(`￥${total}`);
        total_price();
    })
   /**
    * 减少数量的点击事件
    */
    $("#my-book #count-number #incle").click(function () {
        if (parseInt($(this).next().val()) > 1) {
            //通过点击对输入框中的值进行减1
            $(this).next().val(parseInt($(this).next().val()) - 1);
            //通过兄弟节点获取商品单价，和数量进行单个商品的总价计算
            const total = (parseInt($(this).next().val()) * parseFloat($(this).parent().prev().html().slice(1))).toFixed(2)
            $(this).parent().next().html(`￥${total}`);
            total_price();
        } else {
            alert("😭，不能再少了！")
        }
    })
})
