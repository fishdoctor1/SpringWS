package th.co.por.dao.hibernate.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;



public class HibernateGenericDao<T>  implements IGenericDao<T, Long>{
	private Class<T> persistentClass;

	protected SessionFactory sessionFactory;

	public HibernateGenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	@SuppressWarnings("unchecked")
	public T getByStringPrimaryKey(String rowId) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();

		T entity = (T) session.get(getPersistentClass(), rowId);


		return entity;
	}

	@SuppressWarnings("unchecked")
	public T getByLongPrimaryKey(Long rowId) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();

		T entity = (T) session.get(getPersistentClass(), rowId);

//		session.clear();
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getBySQLCriteria(String sql) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		List<T> entityList = session.createSQLQuery(sql).addEntity(
				getPersistentClass()).list();
		return entityList;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getBySQLCriteria(String sql,int page,int maxResults) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		List<T> entityList = session.createSQLQuery(sql).addEntity(
				getPersistentClass()).setFirstResult(page*maxResults).setMaxResults(maxResults).list();
		return entityList;
	}

	public void insert(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();

		session.save(entity);

		session.flush();
	}


	public void insertList(List<T> entityList) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		
			//session.beginTransaction();
			for (T entity : entityList) {
				session.save(entity);
			}
			
		session.flush();
	}
	
	public void insertOrUpdate(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
		session.flush();
	}
	
	public void update(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		

		session.update(entity);

		session.flush();
		
	}
	
	public void updateList(List<T> entityList) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		
			for (T entity : entityList) {
				session.update(entity);
			}
			
		session.flush();
	}
	
	public void saveOrUpdate(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.clear();

		session.saveOrUpdate(entity);
//		session.update(entity);

		session.flush();
		
	}

	public void delete(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
		
		session.flush();
	}
	
	public void deleteList(List<T> entityList) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		
			for (T entity : entityList) {
				session.delete(entity);
			}
			
		session.flush();
	}
	
	public void insertOrUpdateList(List<T> entityList) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		
		for (T entity : entityList) {
			session.saveOrUpdate(entity);
		}

		session.flush();
		
	}
	
}

