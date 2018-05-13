<div>
	 <form action="/api/game/area" id="save-area" method="post" >
	 <table>
	 	<tr>
	 		<td>
	 		 <label for="name">名称：</label>
	 		</td>
	 		<td>
	 		<input class="easyui-validatebox" type="text" id="name" name="name" required="true"></input>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 		 <label for="name">游戏：</label>
	 		</td>
	 		<td>
	 		<input id="gameBase" class="easyui-combobox" name="gameBase" required="true" data-options="url:'/api/game',
			 method:'get',
			 valueField:'id',
			 textField:'text',
			 onSelect:function(record){$('#server').combobox('reload','/api/game/server?game='+record.id)}"></input>
	 			<a class="item" onClick="addGame()"><i class="fa fa-pencil-square-o" ></i></a>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 		 <label for="server">服务器:</label>
	 		</td>
	 		<td>
	 		<input id="server" class="easyui-combobox" required="true" data-options="method:'get',url:'api/game/server',valueField:'id',
			 textField:'text'" name="gameServer">
			 <a class="item" onClick="addServer()"><i class="fa fa-pencil-square-o" ></i></a>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 		介绍:
	 		</td>
	 		<td>
	 		<input class="easyui-textbox" name="description" data-options="multiline:true" style="width:300px;height:100px">
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 		</td>
	 		<td>
	 			<input type="button" onClick="saveArea()" value="确定"/>
	 		</td>
	 	</tr>
	 </table>
	</form>
	<script>
		var dlgAddGame;
		var dlgAddServer;
	function addGame(){
		dlgAddGame = $("<div></div>");
		dlgAddGame.dialog({
		    title: '添加游戏',
		    width: 400,
		    height: 300,
		    closed: false,
		    cache: false,
		    href: '/page/game/save_game',
		    modal: true,
		    buttons:[{
				text:'添加',
				handler:function(){
					saveGame();
				}
			},{
				text:'关闭',
				handler:function(){
					dlgAddGame.dialog('close');
				}
			}]
		});
	}
	function addServer(){
		dlgAddServer = $("<div></div>");
		dlgAddServer.dialog({
		    title: '添加服务器',
		    width: 400,
		    height: 300,
		    closed: false,
		    cache: false,
		    href: '/page/game/save_game_server',
		    modal: true,
		    buttons:[{
				text:'添加',
				handler:function(){
					saveServer();
					$("#server").combobox('reload');
				}
			},{
				text:'关闭',
				handler:function(){
					dlgAddServer.dialog('close');
				}
			}]
		});
	}
	function saveArea(){
		$('#save-area').form('submit', {
	    			onSubmit: function(param){
			    	},
			    	success:function(data){
			    	var parseData = JSON.parse(data);
			    		if(parseData.code=="20000"){
			    			alert("添加成功");
			    		}else{
			    			alert(parseData.message);
			    		}
	        		}
			});
	}
	</script>
</div>