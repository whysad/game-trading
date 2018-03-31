<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>币易</title>
  <link rel="stylesheet" href="/css/login.css">
  <link rel="stylesheet" href="/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="logo_box">
  <h1>币易注册</h1>
  <form action="register" method="post">
    <div class="input_outer">
      <i class="fa fa-user-o u_user"></i>
      <input required="required" name="username" class="text" placeholder="输入账号" type="text">
    </div>
    <div class="input_outer">
      <i class="fa fa-eye u_user"></i>
      <input id="pwd" required="required" placeholder="请输入密码" name="password" class="text" type="password">
    </div>
    <div class="input_outer">
      <i class="fa fa-eye u_user"></i>
      <input required="required" placeholder="请确认密码" name="validPassword" class="text " type="password">
    </div>
    <div class="input_outer">
      <i class="fa fa-mobile u_user" aria-hidden="true"></i> 
      <input required="required" placeholder="请输入手机号" name="phone" class="text" type="text">
    </div>
    <div class="input_outer">
      <i class="fa fa-envelope-o u_user" aria-hidden="true"></i> 
      <input required="required" placeholder="请输入邮箱" name="email" class="text"  type="email">
    </div>
    <div class="mb2">
      <button class="act-but submit" style="color: #FFFFFF">注册</button>
    </div>
    <#if registerMessage??>
    <div style="text-align:center;padding: 10px;">${registerMessage}</div>
  	</#if>
  </form>
</div>
</body>
</html>