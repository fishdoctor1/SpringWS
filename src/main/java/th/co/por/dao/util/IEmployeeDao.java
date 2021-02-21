package th.co.por.dao.util;

import org.springframework.dao.DataAccessException;

import th.co.por.dao.domain.Emdd;

public interface IEmployeeDao {
	public abstract Emdd getEmployee(String empName) throws DataAccessException;
}
