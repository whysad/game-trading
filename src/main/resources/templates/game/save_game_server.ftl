<div>
	 <form action="/api/game/server" id="save-server" method="post" >
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
	 		   <label for="category">游戏:</label>
	 		</td>
	 		<td>
	 		<input class="easyui-combobox" name="gameBase" required="true" data-options="url:'/api/game',
			 method:'get',
			 valueField:'id',
			 textField:'text'"></input>
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
	 			<input type="submit" value="确定"/>
	 		</td>
	 	</tr>
	 </table>
	</form>
</div>
<script>
	function saveServer(){
			$('#save-server').form('submit', {
	    			onSubmit: function(param){
			    	},
			    	success:function(data){
			    	var parseData = JSON.parse(data);
			    		if(parseData.code=="20000"){
			    			alert("添加成功");
			    			dlgAddServer.dialog('close');
			    		}else{
			    			alert(parseData.message);
			    		}
	        		}
			});
		}
</script>