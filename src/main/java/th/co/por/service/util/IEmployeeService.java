package th.co.por.service.util;

import org.springframework.transaction.annotation.Transactional;

import th.co.por.dao.domain.Emdd;

@Transactional
public interface IEmployeeService {
	public Emdd getEmployee(String empName);
}
