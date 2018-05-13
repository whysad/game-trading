package cn.hongtianren.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.hongtianren.entity.Order;

@Mapper
public interface OrderMapper {
	
	@Select("select * from `order`")
	List<Order> getList();
	
	@Select("SELECT * FROM `order` WHERE `user` = #{user}")
	List<Order> getListByUser(@Param("user") Long user);
}
