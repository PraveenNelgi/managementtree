package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class purpose is get the Employee details from user and display 
 * the Employee Management Tree.
 * 
 * @author Praveen
 *
 */
public class EmployeeMangementTree {
	private static final int ZERO_CONSTANT = 0;
	private static final String ARROW_CONSTANT = "->";

	public static void main(String[] args) {
		try {
			List<Employee> emplist = getEmployeeListFromUserInputdata();
			System.out.println("Employee details entered are:");
			displayEmployeeDetailsEntered(emplist);
			System.out.println("\n");
			System.out.println("Employee Management Tree is:");
			displayManagementTree(emplist);
		} catch (Exception e) {
			System.out.println("Excpetion occured in main method. The exception messsage is " + e.getMessage());
		}
	}

	/**
	 * Method accepts the below inputs from user and 
	 * returns the list of employees.
	 * 
	 * <Code>empId</Code> - Employee Id. 
	 * <Code>empName</Code> - Employee Name.
	 * <Code>empManagerId</Code> - Employee Manager Id.
	 * 
	 * It makes a call to a method which validates only one 
	 * Root Manager exist.
	 * If more than one root Manager is entered then 
	 * user is asked to re-enter the employee Manager Id.
	 * 
	 * 
	 * @return
	 */
	private static List<Employee> getEmployeeListFromUserInputdata() {
		List<Employee> employeeList = null;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the number of employee details you wish to enter :");
			int numOfEmplyee = sc.nextInt();
			employeeList = new ArrayList<Employee>(numOfEmplyee);
			for (int i = 0; i < numOfEmplyee; i++) {
				System.out.println("Please enter the Employee " + (i + 1) + " Id :");
				int empId = sc.nextInt();
				System.out.println("Please enter the Employee " + (i + 1) + " Name :");
				String empName = sc.next();
				System.out.println("Please enter the Employee " + (i + 1) + " Manager Id :");
				int empManagerId = sc.nextInt();
				if (empManagerId == ZERO_CONSTANT && !isOnlyOneRootManagerExist(employeeList, empManagerId)) {
					System.out.println("Please note there can be only one root manager Id");
					System.out.println("Please re enter the Employee " + (i + 1) + " Manager Id :");
					empManagerId = sc.nextInt();
				}
				Employee emp = new Employee(empId, empName, empManagerId);
				employeeList.add(emp);
			}

		} catch (Exception e) {
			System.out.println("Excpetion occured while user input. The exception messsage is " + e.getMessage());
		}
		return employeeList;
	}

	/**
	 * Method accepts the employee List <Code>employeeList</Code> and 
	 * employee manager id <Code>empManagerId</Code>
	 * and  validates only one root Manager exist.
	 * 
	 * If only one root manager is present then returns <code>Boolean.TRUE</Code>
	 * If more than  one root manager is entered then returns <code>Boolean.FALSE</Code>
	 * 
	 * @param employeeList
	 * @param empManagerId
	 * @return
	 */
	private static boolean isOnlyOneRootManagerExist(List<Employee> employeeList, int empManagerId) {
		boolean isOnlyOneRootManagerExist = Boolean.TRUE;
		try {
			if (employeeList != null && !employeeList.isEmpty()) {
				for (Employee emp : employeeList) {
					if (emp.getEmpManagerId() == empManagerId) {
						isOnlyOneRootManagerExist = Boolean.FALSE;
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(
					"Excpetion occured While determining if only one root manager exist. The exception messsage is"
							+ e.getMessage());
		}
		return isOnlyOneRootManagerExist;
	}

	/**
	 * Method accepts employee list <Code>emplist</Code>.
	 * And displays  below employee details.
	 * 
	 * <Code>empId</Code> - Employee Id. 
	 * <Code>empName</Code> - Employee Name.
	 * <Code>empManagerId</Code> - Employee Manager Id.
	 * 
	 * @param emplist
	 */
	private static void displayEmployeeDetailsEntered(List<Employee> emplist) {
		try {
			if (emplist != null && !emplist.isEmpty()) {
				for (Employee emp : emplist) {
					System.out.println(emp);
				}
			}
		} catch (Exception e) {
			System.out.print(
					"Excpetion occured while displaying employee details. The exception messsage is " + e.getMessage());
		}
	}

	/**
	 * Method accepts Employee list <code>emplist</code> and displays Management Tree.
	 * 
	 * If Employee manager id is 0 then one -> Indentation character followed by
	 * employee name is displayed.
	 * If Employee manager id 1 then two -> Indentation character followed by 
	 * employee name is displayed. 
	 * 
	 * Based on number of Manager id the -> Indentation character are added 
	 * followed by Employee name.
	 * 
	 * @param emplist
	 */
	private static void displayManagementTree(List<Employee> emplist) {
		try {
			if (emplist != null && !emplist.isEmpty()) {
				for (Employee emp : emplist) {
					StringBuffer sb = new StringBuffer(emplist.size());
					for (int i = 0; i <= emp.getEmpManagerId(); i++) {
						sb = sb.append(ARROW_CONSTANT);
					}
					System.out.println(sb.append(emp.getEmpName()));
				}
			}
		} catch (Exception e) {
			System.out.print(
					"Excpetion occured while displaying management tree. The exception messsage is " + e.getMessage());
		}
	}
}
