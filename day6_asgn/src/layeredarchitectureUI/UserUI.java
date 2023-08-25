package layeredarchitectureUI;
import layeredarchitecture.model.*;
import layeredarchitecture.dao.*;
import java.util.Scanner;
public class UserUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StorageIntf storage = StorageFactory.getStorage(); // Create an instance of Storage
		
		//Add Employees
		 acceptEmpDetailsAndStore(storage);
		
        
		 // Retrieve and display employee details
		 retrive(storage);
	    
	}
	
	public static void acceptEmpDetailsAndStore(StorageIntf storage) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the number of employees: ");
		    int n = sc.nextInt();
		    sc.nextLine();
		    
		    for(int i=0;i<n;i++) {
		    	System.out.print("Enter Employee Number: ");
		        int empNo = sc.nextInt();
		        sc.nextLine(); // Consume newline

		        System.out.print("Enter First Name: ");
		        String firstName = sc.nextLine();

		        System.out.print("Enter City: ");
		        String city = sc.nextLine();

		        System.out.print("Enter Salary: ");
		        double salary = sc.nextDouble();

		        Employee newEmployee = new Employee(empNo, firstName, city, salary);
		        try {
		        	storage.addEmployee(newEmployee);
		        	System.out.println("Employee Added Successfully");
		        } catch(EmployeeAlreadyExistsException e) {
		            System.out.println("Error: " + e.getMessage());
		            System.out.println("Re-enter details:");
		            i--;
		         
		        }

		        System.out.println("Employee details added successfully.");

		    }
	}
	
	public static void retrive(StorageIntf storage){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Employee Number to find details: ");
	    int empno = sc.nextInt();
        
		try {
			Employee retrievedEmp= storage.getEmployee(empno);
			System.out.println("Retrieved Employee: " +"\nName:" +retrievedEmp.getFirstName() + ", City: " + retrievedEmp.getCity() + ", Salary: " + retrievedEmp.getSalary());
			  
		
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: "+e.getMessage());
		}
	}

}
