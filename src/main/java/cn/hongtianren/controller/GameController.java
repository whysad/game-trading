package cn.hongtianren.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.hongtianren.entity.ApiResponse;
import cn.hongtianren.entity.ComboboxModel;
import cn.hongtianren.entity.Game;
import cn.hongtianren.entity.GameArea;
import cn.hongtianren.entity.GameCurrency;
import cn.hongtianren.entity.GameServer;
import cn.hongtianren.service.GameService;
import cn.hongtianren.util.Constant;
import net.sourceforge.web.easyui.EasyuiGridModel;

@RestController
@RequestMapping("/api/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/create_game")
	public Object create(Game game) {
		if (game.getName() == null) {
			return ApiResponse.PARAMETER;
		}
		if (gameService.create(game)) {
			return ApiResponse.SUCCESS;
		}
		return ApiResponse.result(Constant.PARAMETER_CODE, "分类不存在");
	}

	@PostMapping("/server")
	public Object saveServer(GameServer gameServer) {
		if (gameServer.getGameBase() == null || gameServer.getName() == null) {
			return ApiResponse.PARAMETER;
		}
		if (gameService.saveServer(gameServer)) {
			return ApiResponse.SUCCESS;
		} else {
			return ApiResponse.result(Constant.PARAMETER_CODE, "游戏不存在");
		}
	}

	@PostMapping("/area")
	public Object saveArea(GameArea gameArea) {
		if (gameArea.getGameServer() == null || gameArea.getName() == null) {
			return ApiResponse.PARAMETER;
		}
		if (gameService.saveArea(gameArea)) {
			return ApiResponse.SUCCESS;
		} else {
			return ApiResponse.result(Constant.PARAMETER_CODE, "服务器不存在");
		}
	}

	@GetMapping("/currency")
	public EasyuiGridModel<GameCurrency> getGameCurrency(int page, int rows, Long gameBase, Long gameServer,
			Long gameArea, String word) {
		if (gameBase != null && gameBase == 0) {
			gameBase = null;
		}
		PageInfo<GameCurrency> pageInfo = gameService.getGameCurrency(page, rows, word, gameBase, gameServer, gameArea);
		EasyuiGridModel<GameCurrency> easyuiGridModel = new EasyuiGridModel<>();
		easyuiGridModel.setRows(pageInfo.getList());
		easyuiGridModel.setTotal((int) pageInfo.getTotal());
		return easyuiGridModel;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ComboboxModel> getGame() {
		return gameService.getGame();
	}

	@GetMapping("/server")
	public List<ComboboxModel> getGameServer(Long game) {
		if (game == null || game == 0) {
			return null;
		}
		return gameService.getGameServer(game);
	}
	
	@GetMapping("/area")
	public List<ComboboxModel> getGameArea(Long server) {
		if (server == null) {
			return null;
		}
		return gameService.getGameArea(server);
	}

	@GetMapping("/categories")
	public List<ComboboxModel> getGameCategory() {
		return gameService.getGameCategory();
	}

	@PostMapping("/category")
	public Object saveCategory(String name) {
		if (name == null || name.trim() == null) {
			return ApiResponse.PARAMETER;
		}
		if (gameService.saveCategory(name)) {
			return ApiResponse.SUCCESS;
		} else {
			return ApiResponse.result(Constant.PARAMETER_CODE, "添加分类失败");
		}
	}

}
