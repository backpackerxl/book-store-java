$(function(){
    $("#my-book td #close").click(function () {
        if (confirm('确定要删除？')) {
            $(this).parent().parent('#my-book').remove();
            // 展示总金额和总数量
            // showTotalMoney();
            }
    });
})
