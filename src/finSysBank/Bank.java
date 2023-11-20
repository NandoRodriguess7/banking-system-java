package finSysBank;

import java.util.ArrayList;
import java.util.List;

import finSysAgency.Agency;
import finSysEmployee.Employee;

public class Bank {
	
	private String name;
	private List<Agency> agencys;
	
	public Bank(String name) {
		this.name = name;
		this.agencys = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Agency> getAgencys() {
		return new ArrayList<>(agencys); // Returns a copy to prevent external modifications
	}
	
	public void addAgency(Agency agency) {
		agencys.add(agency);
	}
	
	public void removeAgency(Agency agency) {
		agencys.remove(agency);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = new ArrayList<>();
		for (Agency agency : agencys) {
			allEmployees.addAll(agency.getEmployees());
		}
		return allEmployees;
	}
	
	public Agency findAgencyByNumber(int numberAgency) {
		for (Agency agency : agencys) {
			if (agency.getNumberAgency() == numberAgency) {
				return agency;
			}
		}
		return null; // Returns null if the agency was not found
	}
	
	public boolean existsEmployee(Employee employee) {
		for (Agency agency : agencys) {
			if (agency.getEmployees().contains(employee)) {
				return true;
			}
		}
		return false;
	}
	
	
}
