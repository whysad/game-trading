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
  <h1>币易</h1>
  <form action="login" method="post" autocomplete="off">
    <div class="input_outer">
      <i class="fa fa-user-o u_user"></i>
      <input required="required" name="username" class="text" placeholder="输入账号/邮箱/手机号" type="text">
    </div>
    <div class="input_outer">
      <i class="fa fa-eye u_user"></i>
      <input required="required" placeholder="请输入密码" name="password" class="text" type="password">
    </div>
    <div class="mb2">
      <button class="act-but submit" style="color: #FFFFFF">登录</button>
    </div>
  </form>
     <div class="mb2" style="margin-top:20px">
      <button class="act-but" style="color: #FFFFFF" onClick="register()">注册</button>
    </div>
  <#if message??>
    <div style="text-align:center;padding: 10px;">${message}</div>
  </#if>
</div>
</body>
<script>
	function register(){
		window.open("register");
	}
</script>
</html>