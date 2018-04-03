package cn.hongtianren.entity;

public class Game extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5026814788551891208L;
	
	 private String name;

    private Long gameCategory;

    private String imageUrl;

    private String description;

    private String supplier;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(Long gameCategory) {
		this.gameCategory = gameCategory;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
}
