package cn.hongtianren.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.hongtianren.entity.ComboboxModel;
import cn.hongtianren.entity.Game;
import cn.hongtianren.entity.GameArea;
import cn.hongtianren.entity.GameCurrency;
import cn.hongtianren.entity.GameServer;

public interface GameService {
	
	/**
	 * 游戏创建
	 * @param game
	 * @return 是否创建成功
	 */
	boolean create(Game game);
	
	/**
	 * 分页返回游戏币信息
	 * @param page 页数
	 * @param rows 每页行数
	 * @param word 关键字
	 * @return
	 */
	PageInfo<GameCurrency> getGameCurrency(int page, int rows, String word, Long gameBase, Long gameServer,
			Long gameArea);
	
	/**
	 * 添加游戏服务器
	 * @param gameServer 服务器信息
	 * @return 是否添加成功
	 */
	boolean saveServer(GameServer gameServer);
	
	/**
	 * 添加游戏区服
	 * @param gameArea 游戏区服信息
	 * @return
	 */
	boolean saveArea(GameArea gameArea);
	
	/**
	 * 获取游戏下拉框数据
	 * @return 下拉框数据
	 */
	List<ComboboxModel> getGame();
	
	/**
	 * 获取服务器下拉框数据
	 * @param game 游戏id
	 * @return
	 */
	List<ComboboxModel> getGameServer(Long game);
	
	/**
	 * 获取游戏分类数据
	 * @return
	 */
	List<ComboboxModel> getGameCategory();
	
	/**
	 * 添加游戏分类
	 * @param name 分类名
	 * @return
	 */
	boolean saveCategory(String name);
	
	/**
	 * 获取游戏区服
	 * @param server 服务器
	 * @return 
	 */
	List<ComboboxModel> getGameArea(Long server);

}
