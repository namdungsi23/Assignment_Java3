package entity;

public class News {

	    private int id;
	    private String title;
	    private String content;
	    private String image;
	    private java.sql.Date publishedDate;
	    private int viewCount;
	    private int favoriteCount;
	    private boolean isActive;
	    private int categoryId;
	    private int userId;

	    public News() {}

	    public News(int id, String title, String content, String image, java.sql.Date publishedDate,
	                int viewCount, int favoriteCount, boolean isActive, int categoryId, int userId) {
	        this.id = id;
	        this.title = title;
	        this.content = content;
	        this.image = image;
	        this.publishedDate = publishedDate;
	        this.viewCount = viewCount;
	        this.favoriteCount = favoriteCount;
	        this.isActive = isActive;
	        this.categoryId = categoryId;
	        this.userId = userId;
	    }

	    // Getter và Setter
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public String getImage() {
	        return image;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }

	    public java.sql.Date getPublishedDate() {
	        return publishedDate;
	    }

	    public void setPublishedDate(java.sql.Date publishedDate) {
	        this.publishedDate = publishedDate;
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

	    public int getCategoryId() {
	        return categoryId;
	    }

	    public void setCategoryId(int categoryId) {
	        this.categoryId = categoryId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }
	}


