<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>币易</title>
  <!-- 导入主题样式文件 -->
  <link rel="stylesheet" href="/easyui/themes/gray/easyui.css">
  <!-- 图标 -->
  <link rel="stylesheet" href="/easyui/themes/icon.css">
  <link rel="stylesheet" href="/font-awesome/css/font-awesome.min.css">
  <!-- 项目公共样式 -->
  <link rel="stylesheet" href="/css/app.css">
  <!-- 第一脚本：jquery，必须是在第一位 -->
  <script src="/easyui/jquery.min.js" charset="utf-8"></script>
  <!-- easyui的核心 -->
  <script src="/easyui/jquery.easyui.min.js" charset="utf-8"></script>
  <!-- Easyui的扩展 -->
  <script src="/easyui/jquery.edatagrid.js" charset="utf-8"></script>
  <!-- Easyui的国际化 -->
  <script src="/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
  <!-- Easyui的bug修复包 -->
  <script src="/easyui/fixed.js" charset="utf-8"></script>
  <script src="/js/lib/xss.js" charset="utf-8"></script>
  <style type="text/css">
    	div{
    		opacity:0.95;
			filter:alpha(opacity=95);
    	}
   </style>
</head>
<body class="easyui-layout" style="background: url(../images/index.png) no-repeat; background-size: cover;   
-webkit-background-size: cover;   
-moz-background-size: cover;   
-o-background-size: cover;">
<div data-options="region:'north'" style="height: 70px;overflow: hidden;padding: 0 10px;">
  <div class="user-info">
    <span class="item" id="public_change_info"><i class="fa fa-user"></i><@shiro.user><@shiro.principal property="username"/>&nbsp;余额：	￥<@shiro.principal property="balance"/></span>
    <a class="item" href="/logout"><i class="fa fa-sign-out"></i> 注销</a></@shiro.user>
    <@shiro.guest><a href="/login">登录</a></span><a class="item" href="/register"><i class="fa fa-registered"></i> 注册</a></@shiro.guest>
  </div>
  <h1>币易</h1>
</div>
<div title="菜单" data-options="region:'west',iconCls:'fa fa-list',collapsible:false" style="width: 200px">
  <div class="easyui-accordion" data-options="multiple:true">
  		<@shiro.hasPermission name="page:mall">
			<div title="商城管理" data-options="iconCls:'icon-tip'" style="overflow:auto;padding:10px;">
				<ul class="crm-menu">
				<@shiro.hasPermission name="action:mall:buy">
					<li onClick="">我要买</li>
				</@shiro.hasPermission>
				<@shiro.hasPermission name="action:mall:sell">
					<li onClick="">我要卖</li>
				</@shiro.hasPermission>
				</ul>
			</div>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="page:user">
			<div title="用户管理" style="padding:10px;" data-options="iconCls:'icon-man'">
				<ul class="crm-menu">
					<@shiro.hasPermission name="action:user:basic">
						<li onClick="">修改信息</li>
					</@shiro.hasPermission>
					<@shiro.hasPermission name="action:user:password">
						<li onClick="">修改密码</li>
					</@shiro.hasPermission>
					<@shiro.hasPermission name="action:user:show">
						<li onClick="">查看用户</li>
					</@shiro.hasPermission>
				</ul>
			</div>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="page:order">
			<div title="订单管理" style="padding:10px;" data-options="iconCls:'icon-sum'">
				<ul class="crm-menu">
					<@shiro.hasPermission name="action:order:show">
						<li onClick="openTabs('我的订单','/page/order/order_my')">我的订单</li>
					</@shiro.hasPermission>
					<@shiro.hasPermission name="action:order:track">
						<li onClick="openTabs('订单跟踪','/page/order/order_track')">订单跟踪</li>
					</@shiro.hasPermission>
				</ul>
			</div>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="page:recharge">
			<div title="充值管理" style="padding:10px;" data-options="iconCls:'icon-more'">
				<ul class="crm-menu">
					<@shiro.hasPermission name="action:recharge:record">
						<li onClick="">充值记录</li>
					</@shiro.hasPermission>
					<@shiro.hasPermission name="action:recharge:member">
						<li onClick="">会员充值</li>
					</@shiro.hasPermission>
				</ul>
			</div>
		</@shiro.hasPermission>
		<@shiro.hasPermission name="page:game">
			<div title="游戏管理" style="padding:10px;" data-options="iconCls:'icon-filter'">
				<ul class="crm-menu">
					<@shiro.hasPermission name="action:game:area">
						<li onClick="openTabs('区服添加','/page/game/save_game_area')">区服添加</li>
					</@shiro.hasPermission>
				</ul>
			</div>
		</@shiro.hasPermission>
		<div title="帮助" style="padding:10px;" data-options="iconCls:'icon-help'">
			<ul class="crm-menu">
				<li onClick="openTabs('币易是什么','/page/help/help_what')">币易是什么</li>
				<li onClick="openTabs('币易能做什么','/page/help/help_how')">币易能做什么</li>
			</ul>
		</div>
  </div>
</div>
<div id="myTabs" class="easyui-tabs" data-options="region:'center'">
	<div title="主页" data-options="href:'/desktop',closable:false" style="padding:20px;display:none;">
		
    </div>
</div>
<script>
  function openTabs(title,href){
  		var tab = $('#myTabs').tabs('getTab',title);
  		if(!tab){
	  		$('#myTabs').tabs('add',{
				title: title,
				href:href,
				closable:true
			});
		}else{
			$('#myTabs').tabs('select',title);
			tab.panel('refresh', href);
		}
  	}
  	function date(value) {
  			if(value==null){
  				return "-";
  			}
            var date = new Date(value);//long转换成date
            var year = date.getFullYear().toString();
            var month = (date.getMonth() + 1);
            var day = date.getDate().toString();
            if (month < 10) {
                month = "0" + month;
            }
            if (day < 10) {
                day = "0" + day;
            }
            return year + "-" + month + "-" + day;
        }
    function formatNull(value){
    	if(!value){
    		return "-";
    	}else{
    		return value;
    	}
    }
 </script>
</body>
</html>