package finSysEmployee;

public class Employee {
	
	private String name;
	private String jobTitle;
	private int numberIdentification;
	private double baseSalary;
	
	public Employee(String name, String jobTitle, int numberIdentification, double baseSalary) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.numberIdentification = numberIdentification;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public int getNumberIdentification() {
		return numberIdentification;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}

	public double calculateSalary() {
		// Calculates salary based on job title.
		switch(jobTitle.toLowerCase()) {
		case "manager":
			return baseSalary * 1.2;
		case "attendant":
			return baseSalary * 1.1;
		default:
			return baseSalary;
		}
	}
	
	public void conductTraining(String subject) {
		System.out.println("Employee " + name + " is participating in training on: " + subject);
	}
	
	public void performTask(String task) {
		System.out.println("Employee " + name + " is performing the task: " + task);
	}
	
}
