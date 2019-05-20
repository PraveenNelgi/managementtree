package main;

/**
 * This class purpose is to hold below Employee Details.
 * 
 * <Code>empId</Code> - Employee Id. 
 * <Code>empName</Code> - Employee Name.
 * <Code>empManagerId</Code> - Employee Manager Id.
 * 
 * @author Praveen
 *
 */
public class Employee {
	
	/**
	 * Variable Holds Employee Id.
	 */
	private int empId;
	/**
	 * Variable Holds Employee Name.
	 */
	private String empName;
	/**
	 * Variable Holds Employee Manager Id.
	 */
	private int empManagerId;

	/**
	 * Constructor of Employee class.
	 * @param empId
	 * @param empName
	 * @param empManagerId
	 */
	public Employee(int empId, String empName, int empManagerId) {
		this.empId = empId;
		this.empName = empName;
		this.empManagerId = empManagerId;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName
	 *            the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empManagerId
	 */
	public int getEmpManagerId() {
		return empManagerId;
	}

	/**
	 * @param empManagerId
	 *            the empManagerId to set
	 */
	public void setEmpManagerId(int empManagerId) {
		this.empManagerId = empManagerId;
	}

	@Override
	public String toString() {
		return "Employee Id: " + this.getEmpId() + " Emplyee Name: " + this.getEmpName() + " Employee Manager Id: "
				+ this.getEmpManagerId();
	}
}
