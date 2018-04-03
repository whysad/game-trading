package cn.hongtianren.entity;



public class GameServer extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1363181592535610690L;

	private String name;

    private Long gameBase;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getGameBase() {
        return gameBase;
    }

    public void setGameBase(Long gameBase) {
        this.gameBase = gameBase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}