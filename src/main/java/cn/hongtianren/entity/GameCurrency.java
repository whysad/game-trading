package cn.hongtianren.entity;

import java.math.BigDecimal;

public class GameCurrency extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6615696276571048213L;

	private Long gameArea;

	private Long gameCurrencyStock;

	private BigDecimal gameCurrencyTotalPrice;

	private BigDecimal gameCurrencyUnitPrice;

	private int gameCurrencyUnit;

	private String gameName;

	private String gameServerName;

	private String gameAreaName;

	public Long getGameArea() {
		return gameArea;
	}

	public void setGameArea(Long gameArea) {
		this.gameArea = gameArea;
	}

	public Long getGameCurrencyStock() {
		return gameCurrencyStock;
	}

	public void setGameCurrencyStock(Long gameCurrencyStock) {
		this.gameCurrencyStock = gameCurrencyStock;
	}

	public BigDecimal getGameCurrencyTotalPrice() {
		return gameCurrencyTotalPrice;
	}

	public void setGameCurrencyTotalPrice(BigDecimal gameCurrencyTotalPrice) {
		this.gameCurrencyTotalPrice = gameCurrencyTotalPrice;
	}

	public BigDecimal getGameCurrencyUnitPrice() {
		return gameCurrencyUnitPrice;
	}

	public void setGameCurrencyUnitPrice(BigDecimal gameCurrencyUnitPrice) {
		this.gameCurrencyUnitPrice = gameCurrencyUnitPrice;
	}

	public int getGameCurrencyUnit() {
		return gameCurrencyUnit;
	}

	public void setGameCurrencyUnit(int gameCurrencyUnit) {
		this.gameCurrencyUnit = gameCurrencyUnit;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameServerName() {
		return gameServerName;
	}

	public void setGameServerName(String gameServerName) {
		this.gameServerName = gameServerName;
	}

	public String getGameAreaName() {
		return gameAreaName;
	}

	public void setGameAreaName(String gameAreaName) {
		this.gameAreaName = gameAreaName;
	}

}
