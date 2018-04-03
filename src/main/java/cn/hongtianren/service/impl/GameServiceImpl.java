package cn.hongtianren.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hongtianren.entity.ComboboxModel;
import cn.hongtianren.entity.Game;
import cn.hongtianren.entity.GameArea;
import cn.hongtianren.entity.GameCurrency;
import cn.hongtianren.entity.GameServer;
import cn.hongtianren.entity.type.CurrencyUnit;
import cn.hongtianren.entity.vo.GameAreaVo;
import cn.hongtianren.mapper.GameMapper;
import cn.hongtianren.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameMapper gameMapper;

	@Override
	public boolean create(Game game) {
		Date date = new Date();
		game.setCreateTime(date);
		game.setUpdateTime(date);
		try{
			gameMapper.create(game);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public PageInfo<GameCurrency> getGameCurrency(int page, int rows, String word,Long gameBase, Long gameServer,
			Long gameArea) {
		PageHelper.startPage(page, rows);
		return new PageInfo<>(gameMapper.getGameCurrency(word,gameBase,gameServer,gameArea));
	}

	@Override
	public boolean saveServer(GameServer gameServer) {
		Date date = new Date();
		gameServer.setCreateTime(date);
		gameServer.setUpdateTime(date);
		try{
			gameMapper.saveServer(gameServer);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public boolean saveArea(GameArea gameArea) {
		Date date = new Date();
		gameArea.setCreateTime(date);
		gameArea.setUpdateTime(date);
		try{
			gameMapper.saveArea(gameArea);
			GameAreaVo areaVo = gameMapper.getAreaById(gameArea.getId());
			GameCurrency currency = new GameCurrency();
			currency.setCreateTime(date);
			currency.setUpdateTime(date);
			currency.setGameArea(areaVo.getId());
			currency.setGameAreaName(areaVo.getName());
			currency.setGameCurrencyStock(0L);
			currency.setGameCurrencyTotalPrice(BigDecimal.ZERO);
			currency.setGameCurrencyUnit(CurrencyUnit.piece.ordinal());
			currency.setGameCurrencyUnitPrice(BigDecimal.ZERO);
			currency.setGameName(areaVo.getGameName());
			currency.setGameServerName(areaVo.getServerName());
			gameMapper.saveCurrency(currency);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<ComboboxModel> getGame() {
		List<ComboboxModel> gameList = new ArrayList<>();
		ComboboxModel comboboxModel = new ComboboxModel();
		comboboxModel.setId(0L);
		comboboxModel.setText("请选择");
		gameList.add(comboboxModel);
		gameList.addAll(gameMapper.getGame());
		return gameList;
	}

	@Override
	public List<ComboboxModel> getGameServer(Long game) {
		return gameMapper.getGameServer(game);
	}

	@Override
	public List<ComboboxModel> getGameCategory() {
		return gameMapper.getCategories();
	}

	@Override
	public boolean saveCategory(String name) {
		Date date = new Date();
		try{
			gameMapper.saveCategory(name,date,date);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public List<ComboboxModel> getGameArea(Long server) {
		return gameMapper.getGameArea(server);
	}

}
