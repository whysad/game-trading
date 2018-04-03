package cn.hongtianren.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.hongtianren.entity.ComboboxModel;
import cn.hongtianren.entity.Game;
import cn.hongtianren.entity.GameArea;
import cn.hongtianren.entity.GameCurrency;
import cn.hongtianren.entity.GameServer;
import cn.hongtianren.entity.vo.GameAreaVo;

@Mapper
public interface GameMapper {

	/**
	 * 创建游戏
	 * 
	 * @param game
	 */
	void create(Game game);

	/**
	 * 根据条件获取游戏币
	 * 
	 * @param word
	 *            条件
	 * @param gameArea
	 * @param gameServer
	 * @param gameBase
	 * @return
	 */
	List<GameCurrency> getGameCurrency(@Param("word") String word, @Param("gameBase") Long gameBase,
			@Param("gameServer") Long gameServer, @Param("gameArea") Long gameArea);

	/**
	 * 添加游戏服务器
	 * 
	 * @param gameServer
	 *            服务器信息
	 */
	void saveServer(GameServer gameServer);

	/**
	 * 添加游戏区服
	 * 
	 * @param gameArea
	 *            区服信息
	 */
	void saveArea(GameArea gameArea);

	/**
	 * 获取游戏下拉框数据
	 * 
	 * @return
	 */
	@Select("select id,name AS text from game_base")
	List<ComboboxModel> getGame();

	/**
	 * 获取游戏服务器下拉框数据
	 * 
	 * @param game
	 *            游戏id
	 * @return
	 */
	@Select("select id ,name AS text from game_server where game_base = #{game}")
	List<ComboboxModel> getGameServer(@Param("game") Long game);

	/**
	 * 获取游戏分类下拉框数据
	 * 
	 * @return
	 */
	@Select("select id ,name AS text from game_category")
	List<ComboboxModel> getCategories();

	/**
	 * 添加分类信息
	 * 
	 * @param name
	 *            分类名
	 * @param create
	 *            创建时间
	 * @param update
	 *            修改时间
	 */
	@Insert("insert into game_category (name,create_time,update_time) values(#{name},#{create},#{update})")
	void saveCategory(@Param("name") String name, @Param("create") Date create, @Param("update") Date update);

	/**
	 * 根据id获取游戏区服相关信息
	 * 
	 * @param area
	 *            区服id
	 * @return
	 */
	GameAreaVo getAreaById(@Param("area") Long area);

	/**
	 * 添加游戏币
	 * 
	 * @param currency
	 *            游戏币信息
	 */
	void saveCurrency(GameCurrency currency);

	/**
	 * 获取游戏区服
	 * 
	 * @param server
	 * @return
	 */
	@Select("select id ,name AS text from game_area where game_server = #{server}")
	List<ComboboxModel> getGameArea(@Param("server") Long server);
}
