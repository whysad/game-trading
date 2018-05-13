<div>
	 <form id="save-game" method="post" >
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
	 		  <label for="category">分类:</label>
	 		</td>
	 		<td>
	 		<input class="easyui-combobox" name="gameCategory" required="true" data-options="url:'/api/game/categories',
			 method:'get',
			 valueField:'id',
			 textField:'text'"></input>
	 		<a class="item" onClick="saveCategory()"><i class="fa fa-pencil-square-o" ></i></a>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 		介绍:
	 		</td>
	 		<td>
	 		<input class="easyui-textbox" name="description" data-options="multiline:true" style="width:300px;height:100px"/>
	 		</td>
	 	</tr>
	 </table>
	</form>
</div>
<script>
		function saveGame(){
			$('#save-game').form('submit', {
					url:'/api/game/create_game',
					method:'post',
	    			onSubmit: function(param){
			    	},
			    	success:function(data){
			    	var parseData = JSON.parse(data);
			    		if(parseData.code=="20000"){
			    			alert("添加成功");
			    			$("#gameBase").combobox('reload','/api/game');
			    			dlgAddGame.dialog('close');
			    		}else{
			    			alert(parseData.message);
			    		}
	        		}
			});
		}
		function saveCategory(){
			$.messager.prompt('添加分类', '请输入分类名:', function(r){
				if (r){
					$.ajax({
						url:'/api/game/category',
						method:'post',
						cache: false,
						async: false,
						data: {name:r},
						success: function(data){
				    		if(data.code=="20000"){
				    			alert("添加成功");
				    		}else{
				    			alert(data.message);
				    		}
						} 
					});
				}
			});
		}
	</script>