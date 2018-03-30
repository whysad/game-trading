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
    <span class="item" id="public_change_info"><i class="fa fa-user"></i>${name!'<a href="/login">请登录</a>'}</span>
    <a class="item" href="/logout"><i class="fa fa-sign-out"></i> 注销</a>
  </div>
  <h1>币易</h1>
</div>
<div title="菜单" data-options="region:'west',iconCls:'fa fa-list',collapsible:false" style="width: 200px">
  <div class="easyui-accordion" data-options="multiple:true">
		<div title="Language" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<p>A programming language is a formal language designed to communicate instructions to a machine, particularly a computer. Programming languages can be used to create programs that control the behavior of a machine and/or to express algorithms precisely.</p>
		</div>
		<div title="Java" style="padding:10px;">
			<p>Java (Indonesian: Jawa) is an island of Indonesia. With a population of 135 million (excluding the 3.6 million on the island of Madura which is administered as part of the provinces of Java), Java is the world's most populous island, and one of the most densely populated places in the world.</p>
		</div>
		<div title="C#" style="padding:10px;">
			<p>C# is a multi-paradigm programming language encompassing strong typing, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.</p>
		</div>
		<div title="Ruby" style="padding:10px;">
			<p>A dynamic, reflective, general-purpose object-oriented programming language.</p>
		</div>
		<div title="Fortran" style="padding:10px;">
			<p>Fortran (previously FORTRAN) is a general-purpose, imperative programming language that is especially suited to numeric computation and scientific computing.</p>
		</div>
  </div>
</div>
<div id="myTabs" class="easyui-tabs" data-options="region:'center'">
	<div title="主页" data-options="href:'/desktop',closable:true" style="padding:20px;display:none;">
		
    </div>
</div>
<script>
  function openTabs(title,href){
  		var tab = $('#myTabs').tabs('getTab',title);
  		if(!tab){
	  		$('#myTabs').tabs('add',{
				title: title,
				href:href,
				iconCls:'icon-reload',
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