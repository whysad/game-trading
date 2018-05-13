<table id="dg-order-my" class="easyui-datagrid" style="height:590px"
    data-options="url:'/api/order',method:'GET',rownumbers:true,pagination:true,fitColumns:true,singleSelect:true">
    <thead>
		<tr>
			<th data-options="field:'sn',width:100">订单流水号</th>
			<th data-options="field:'createTime',width:100,formatter:date">创建时间</th>
			<th data-options="field:'type',width:50,formatter:parseOrderType">订单类型</th>
			<th data-options="field:'gameName',width:100">游戏名</th>
			<th data-options="field:'quantity',width:50">数量</th>
			<th data-options="field:'price',width:50">单价</th>
			<th data-options="field:'totalPrice',width:100">总价</th>
			<th data-options="field:'unit',width:50,formatter:parseUnit">单位</th>
			<th data-options="field:'status',width:100,formatter:parseOrderStatus">状态</th>
		</tr>
    </thead>
</table>