package th.co.por.dao.hibernate.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface IGenericDao<T, ID extends Serializable> {

//	public List<T> getByHQLCriteria(String hql) throws DataAccessException;
//
	public T getByStringPrimaryKey(String rowId) throws DataAccessException;
//
	public T getByLongPrimaryKey(Long rowId) throws DataAccessException;
//
	public List<T> getBySQLCriteria(String sql) throws DataAccessException;
//
//	public List<T> getBySQLCriteria(String sql, int page, int maxResults) throws DataAccessException;

	public void insert(T entity) throws DataAccessException;
	
	public void insertList(List<T> entityList) throws DataAccessException;
//	
	public void insertOrUpdate(T entity) throws DataAccessException;
//
	public void update(T entity) throws DataAccessException;
//	
	public void updateList(List<T> entityList) throws DataAccessException;
	
	public void saveOrUpdate(T entity) throws DataAccessException;
//
	public void delete(T entity) throws DataAccessException;
//	
	public void deleteList(List<T> entityList) throws DataAccessException;
//
//	public List<T> getAll();
	
	public void insertOrUpdateList(List<T> entity) throws DataAccessException;

}
