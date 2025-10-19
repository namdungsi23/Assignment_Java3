package dao;

import java.util.List;
import entity.News;

/**
 * Interface for TrangchuDao
 */
public interface TrangchuDao {
    List<News> findHomeNews();
    News findById(String id);
    List<News> findNewsByCategory(String categoryId);
    List<News> findLatestNews(); 
    News findFirst();           
    News[] findPrevNext(String id); 
    void updateViewCount(String id); 
}
