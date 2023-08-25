package layeredarchitecture.model;

public class Employee {
	
	private int empno;
	private String firstName;
	private String city;
	private double salary;
	
	public Employee(int empno,String firstName,String city,double salary)
	  {
		  this.empno =empno;
		  this.firstName = firstName;
		  this.city=city;
		  this.salary =salary;
	  }
	
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	} 

	
	
}

