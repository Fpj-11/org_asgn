package layeredarchitecture.dao;

import layeredarchitecture.model.Employee;

public interface StorageIntf {
	
	void addEmployee(Employee e) throws EmployeeAlreadyExistsException;;
	Employee getEmployee(int empno) throws EmployeeNotFoundException;
	//Employee[] retrieveAll();

}
