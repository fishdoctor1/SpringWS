package th.co.por.dao.hibernate.util;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import th.co.por.dao.domain.Emdd;
import th.co.por.dao.util.IEmployeeDao;

public class HibernateEmployeeDao extends HibernateGenericDao<Emdd> implements IEmployeeDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Emdd getEmployee(String empName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
