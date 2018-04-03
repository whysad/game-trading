package cn.hongtianren.entity.vo;

import cn.hongtianren.entity.GameArea;

public class GameAreaVo extends GameArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2434961318318821177L;
	
	private String gameName;
	
	private String serverName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
}
