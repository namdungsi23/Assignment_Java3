package dao;
import java.util.List;

import entity.News;


/**
 * Servlet implementation class TrangchuDao
 */
public interface TrangchuDao  {
	 List<News> findHomeNews();
	 
	 News findById(String id);
}
