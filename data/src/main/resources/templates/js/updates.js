$("document").ready(function() {
    $("#i3").click(function () {
        let stuid = $("#stuid").val();
        if (stuid.length != 0) {
            $.ajax({
                url:"/userinfo/update",
                contentType:"application/x-www-form-urlencoded",
                type:"post",
                data:{
                    stuid:stuid
                },
                success:function(res){
                    if (res['sta'] == "T") {
                        return $.growl.notice({title:"重置成功", message:"学号为" + stuid + "密码重置成功"});
                    } else {
                        return $.growl.warning({title:"重置失败", message:"学号对应用户不存在"});
                    }
                }
            });
        } else {
            return $.growl.error({title:"重置失败", message:"学号不能为空"});
        }
    });
});