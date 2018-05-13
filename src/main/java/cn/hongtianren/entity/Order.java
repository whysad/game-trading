package cn.hongtianren.entity;

public class Order extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957467874967663210L;

	private Long user;

	private Long gameCurrencyStock;

	private Byte type;

	private Byte status;

	private Long quantity;

	private Long totalPrice;

	private Long price;

	private Byte unit;

	private String sn;

	private String gameName;

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getGameCurrencyStock() {
		return gameCurrencyStock;
	}

	public void setGameCurrencyStock(Long gameCurrencyStock) {
		this.gameCurrencyStock = gameCurrencyStock;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Byte getUnit() {
		return unit;
	}

	public void setUnit(Byte unit) {
		this.unit = unit;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

}
