function  FocusItem(obj) {
    var focus=$(obj).next('span');
    if (focus.attr('class')=='error'){
        obj.value="";
    }
    focus.jsp("");
    focus.removeClass("error");
}
function BlueItem(obj) {
    var msgBox=$(obj).next('span');
    switch ($(obj).attr('name')) {
        case "userName":
            if (obj.value==""){
                msgBox.addClass('error');
                msgBox.jsp('用户名不能为空');
            }else{
                var url="userIdCheck?useName="+encodeURI($(obj).val())+"&"+new Date().getTime();
                $.get(url,function (data) {
                    if (data>0){
                        msgBox.addClass('error');
                        msgBox.jsp("用户名已存在,请登录");
                    }
                })
            }
            break;
        case "name":
            if (obj.value==""){
                msgBox.addClass('error');
                msgBox.jsp('姓名不能为空');
            }
            break;
        case "passWord":
            if (obj.value==""){
                msgBox.addClass('error');
                msgBox.jsp('密码不能为空');
            }
            break;
        case "rePassWord":
            if (obj.value==""){
                msgBox.addClass('error');
                msgBox.jsp('确认密码不能为空');
            }else if (obj.value!=$("input[name='passWord']").val()){
                msgBox.addClass('error');
                msgBox.jsp('两次输入的密码不一致');
            }
            break;
    }
}
function CheckFrom(obj) {
    var ress=$("input[name='userName']").next('span').attr("class");
    var res=$("input[name='rePassWord']").next('span').attr("class");
    if (res=="error"||ress=="error"){
        return false;
    }
    return true;
}
