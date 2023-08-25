package layeredarchitecture.dao;

import layeredarchitecture.model.Employee;

public class StorageImpl implements StorageIntf{

	private Employee[] arr;
	private int lastIndex;
	
	public StorageImpl(int size) {
		this.arr=new Employee[size];
		this.lastIndex=0;
	}
	
	@Override
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		// TODO Auto-generated method stub
		for (Employee emp : arr) {
            if (emp != null && emp.getEmpno() == e.getEmpno()) {
                throw new EmployeeAlreadyExistsException("Employee with ID " + e.getEmpno() + " already exists.");
            }
        }
		if(lastIndex<arr.length) {
			arr[lastIndex]=e;
			lastIndex++;
		}
		else {
			 System.out.println("Storage is full. Cannot add more employees.");
		}
		
	}

	@Override
	public Employee getEmployee(int empno) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		for(Employee emp: arr) {
			if(emp!=null && emp.getEmpno()==empno) {
				return emp;
			}
		}
		throw new EmployeeNotFoundException("Employee with ID " + empno + " not found.");
	}

}
