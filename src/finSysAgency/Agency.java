package finSysAgency;

import java.util.ArrayList;
import java.util.List;

import finSysEmployee.Employee;

public class Agency {
	
	private int numberAgency;
	private List<Employee> employees;
	
	public Agency(int numberAgency) {
		super();
		this.numberAgency = numberAgency;
		this.employees = new ArrayList<>();
	}

	public int getNumberAgency() {
		return numberAgency;
	}

	public List<Employee> getEmployees() {
		return new ArrayList<>(employees); // Returns a copy to prevent external modifications
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void remove(Employee employee) {
		employees.remove(employee);
	}
	
	public Employee findEmployee(int numberIdentification) {
		for (Employee employee : employees) {
			if (employee.getNumberIdentification() == numberIdentification) {
				return employee;
			}
		}
		return null;
	}
	
	public double calculatePayroll() {
		double payRoll = 0.0;
		for (Employee employee : employees) {
			payRoll += employee.calculateSalary();
		}
		return payRoll;
	}
	
}
