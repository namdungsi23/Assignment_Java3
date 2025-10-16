package entity;

public class News {

	    private String id;
	    private String title;
	    private String content;
	    private String image;
	    private java.sql.Date publishedDate;
	    private int viewCount;
	    private int favoriteCount;
	    private boolean isActive;
	    private String categoryId;
	    private String userId;
	    

	    public News() {}

	    public News(String id, String title, String content, String image, java.sql.Date publishedDate,
	                int viewCount, int favoriteCount, boolean isActive, String categoryId, String userId) {
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
	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
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

	    public String getCategoryId() {
	        return categoryId;
	    }

	    public void setCategoryId(String categoryId) {
	        this.categoryId = categoryId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }
	}


