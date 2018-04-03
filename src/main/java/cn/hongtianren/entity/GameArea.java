package cn.hongtianren.entity;



public class GameArea extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1363181592535610690L;

	private String name;

    private Long gameServer;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getGameServer() {
        return gameServer;
    }

    public void setGameServer(Long gameServer) {
        this.gameServer = gameServer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}