package layeredarchitecture.dao;
import java.io.*;
import layeredarchitecture.model.Employee;

public class StorageFileImpl implements StorageIntf{
	private String filename;
	
	public StorageFileImpl(String filename) {
        this.filename = filename;
    }


	@Override
	public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
		// TODO Auto-generated method stub
		try (FileReader fileReader=new FileReader("src/emp.txt");
				BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int empNo = Integer.parseInt(parts[0].trim());
                if (empNo == e.getEmpno()) {
                    throw new EmployeeAlreadyExistsException("Employee with ID " + e.getEmpno() + " already exists.");
                }
            }
        } catch (IOException ex) {
        	ex.printStackTrace();
        }
		
		 try (FileWriter fileWriter = new FileWriter("src/emp.txt", true);
				 BufferedWriter writer = new BufferedWriter(fileWriter)) {
	            writer.write(e.getEmpno() + "," + e.getFirstName() + "," + e.getCity() + "," + e.getSalary());
	            writer.newLine();
	        } catch (IOException ex) {
	            System.out.println("Error while adding employee: " + ex.getMessage());
	        }
	}

	@Override
	public Employee getEmployee(int empno) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		 try (FileReader fileReader=new FileReader("src/emp.txt");
				 BufferedReader reader = new BufferedReader(fileReader)) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                int storedEmpNo = Integer.parseInt(parts[0].trim());
	                if (storedEmpNo == empno) {
	                    String firstName = parts[1].trim();
	                    String city = parts[2].trim();
	                    double salary = Double.parseDouble(parts[3].trim());
	                    return new Employee(empno, firstName, city, salary);
	                }
	            }
	        } catch (IOException ex) {
	            System.out.println("Error while retrieving employee: " + ex.getMessage());
	        }
	        throw new EmployeeNotFoundException("Employee with ID " + empno + " not found.");
	    
	}
}
