package entity;

public class Categories {
	private String id;
    private String name;
    private String alias;
    private int viewCount;
    private int favoriteCount;
    private boolean isActive;

    public Categories() {}

    public Categories(String id, String name, String alias, int viewCount, int favoriteCount, boolean isActive) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.viewCount = viewCount;
        this.favoriteCount = favoriteCount;
        this.isActive = isActive;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}
