<table id="dg-game-show" class="easyui-datagrid" style="height:550px"
    data-options="url:'/api/game/currency',method:'GET',toolbar: '#dg-game-tool',rownumbers:true,pagination:true,fitColumns:true,singleSelect:true">
    <thead>
		<tr>
			<th data-options="field:'gameName',width:100">游戏名称</th>
			<th data-options="field:'gameServerName',width:50">游戏服务器</th>
			<th data-options="field:'gameAreaName',width:50">游戏区</th>
			<th data-options="field:'gameCurrencyStock',width:50">库存</th>
			<th data-options="field:'gameCurrencyUnitPrice',width:50">单价</th>
			<th data-options="field:'gameCurrencyUnit',width:50,formatter:parseUnit">单位</th>
		</tr>
    </thead>
    <script>
    	function parseUnit(value){
				if(value == 0){
					return '个';
				}else if(value == 1){
					return '万个';
				}else{
					return '百万个'
				}
			}
    </script>
</table>
<div id="dg-game-tool">
	<label for="index-gameBase">游戏：</label><input id="index-gameBase" class="easyui-combobox" name="gameBase" required="true" data-options="url:'/api/game',
			 method:'get',
			 valueField:'id',
			 textField:'text',
			 onSelect:function(record){$('#index-gameServer').combobox('reload','/api/game/server?game='+record.id);
			 $('#index-gameServer').combobox('clear');
			 $('#index-gameArea').combobox('loadData','');
			 $('#index-gameArea').combobox('clear');
			 }"></input>
			<label for="index-gameServer">服务器:</label>
			<input id="index-gameServer" class="easyui-combobox"  data-options="method:'get',url:'api/game/server',valueField:'id',
			 textField:'text',onSelect:function(record){$('#index-gameArea').combobox('reload','/api/game/area?server='+record.id);
			  $('#index-gameArea').combobox('clear');
			 }" > 
			 <label for="index-gameArea">区服:</label>
			<input id="index-gameArea" class="easyui-combobox"  data-options="method:'get',url:'api/game/area',valueField:'id',
			 textField:'text'"> 
			 
			 <div style="text-align:center;float:right">
		<input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:reloadData,prompt:'游戏/服务器/区'"></input>
	</div>
</div>
<script>
		function reloadData(value){
			var gameBase = $("#index-gameBase").combobox("getValue");
			var gameServer = $("#index-gameServer").combobox("getValue");
			var gameArea = $("#index-gameArea").combobox("getValue");
			$("#dg-game-show").datagrid('load',{
				gameBase:gameBase,
				gameServer:gameServer,
				gameArea:gameArea,
				word:value
			})
		}
</script>
