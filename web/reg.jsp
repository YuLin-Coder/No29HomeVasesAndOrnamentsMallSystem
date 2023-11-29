<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/function.js"></script>
    <style type="text/css">
        .reg p .error{
            display: inline-block;
            border: 1px solid #ff855a;
            background-color: #ffe8e0;
            height: 25px;
            line-height: 25px;
            padding: 0px 20px;
            margin-left: 10px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return CheckFrom(this)"><h1><a href="index.jsp"><img src="img/temp/logo.png"></a></h1>
        <h1 style="padding:0px;magin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:45px;color:#FFFFFF">用户注册</h1>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="BlueItem(this)" placeholder="请输入用户id" required><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="BlueItem(this)" placeholder="请输入姓名" required><span></span></p>
        <p><input type="password" name="passWord" value="" onfocus="FocusItem(this)" onblur="BlueItem(this)" placeholder="请输入密码" required><span></span></p>
        <p><input type="password" name="rePassWord" value="" onfocus="FocusItem(this)" onblur="BlueItem(this)" placeholder="请输确认密码" required><span></span></p>
        <p>
            <input style="width:15px;height:15px" type="radio" name="sex" value="T" checked="checked">男
            <input style="width:15px;height:15px" type="radio" name="sex" value="F" >女
        </p>
        <p><input type="date" name="birthday" value=""  placeholder="请输出生日期"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号码"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入送货地址"><span></span></p>
        <p><input class="code" type="text" name="veryCode" value="" placeholder="验证码">
            <img height="25" alt="看不清，换一张"><span></span>
        </p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的
            <a href="#">
            <使用条款和隐私策略></a>
        </p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
