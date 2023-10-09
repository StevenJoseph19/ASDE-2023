import com.acme.connect.ConnectionManager;
import com.acme.domain.Employee;
import com.acme.domain.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ManageEmployee {

	static void display(List<Employee> result) {
		System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-10s%-15s%-20s%-30s%-35s%-20s", "ID", "Name", "Contact No.", "Department",
				"Email-Id", "Address"));
		for (Employee e : result) {
			System.out.println(String.format("%-5s%-20s%-20s%-30s%-35s%-20s", e.getEmpID(), e.getEmpName(), e.getEmpContact(),
					e.getEmpDepartment(), e.getEmpEmail(), e.getEmpAddress()));
		}
	}

	public static void main(String[] args) {
		int empID;
		String empName;
		long empContact;
		String empDepartment;
		String empEmail;
		String empAddress;
		Scanner sc = new Scanner(System.in);
		List<Employee> result = new ArrayList<>();

//		String SQL_SELECT;
		String SQL_INSERT;
		String SQL_UPDATE;
		String SQL_SELECT_BY_ID;
		String SQL_DELETE;

		Employee employee = new Employee();
		do {


			System.out.println("\n*********Welcome to the Employee Management System**********\n");
			System.out.println("\n*********Please enter your login id and password*********\n");

			// Write the code to accept the user's input for the login id password.
			System.out.println("Enter Login Id :");
			String loginId = sc.nextLine();
			System.out.println("Enter Password :");
			String password  = sc.nextLine();

			Login login = new Login();
			int empId = login.getEmployeeLoginDetailsByUserNameAndPassword(loginId,password).getEmployee_id();
			char role = login.getEmployeeLoginDetailsByUserNameAndPassword(loginId,password).getRole();

			System.out.println("Employee Id.." + empId);
			System.out.println("Employee Role.." + role);

// Retrieve the password from the db for the given login id using jdbc.
			// If (! loginId  || password doesn't match)
			// redisplay login screen with an error message

//			else if(Valid credentials){
//			check role of user - either 'A' or 'E'
//			If (A)
//				display admin menu
//			else
//			display regular employee menu
					// Below displays representative admin menu
			// Create another menu for regular employees

			System.out.println("1). Add Employee to the DataBase\n" + "2). Search for Employee\n"
					+ "3). Edit Employee details\n" + "4). Delete Employee Details\n"
					+ "5). Display all Employees working in this company\n" + "6). EXIT\n");
			System.out.println("Enter your choice : ");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("\nEnter the following details to ADD an employee:\n");

				System.out.println("Enter Name :");
				sc.nextLine();
				empName = sc.nextLine();
				System.out.println("Enter Contact No :");
				empContact = sc.nextLong();
				System.out.println("Enter Department :");
				empDepartment = sc.next();
				System.out.println("Enter Email-ID :");
				empEmail = sc.next();
				System.out.println("Enter Address :");
				empAddress = sc.next();

				try (Connection conn = ConnectionManager.getConnection();) {


					SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, CONTACT, DEPARTMENT,EMAIL,ADDRESS) VALUES (?,?,?,?,?)";
					PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);
					preparedStatement.setString(1, empName);
					preparedStatement.setLong(2, empContact);
					preparedStatement.setString(3, empDepartment);
					preparedStatement.setString(4, empEmail);
					preparedStatement.setString(5, empAddress);

					int row = preparedStatement.executeUpdate();

					// rows affected
					System.out.print(row); // 1
					System.out.println(" employee record added to the database.");

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("Enter the Employee ID to search :");
				empID = sc.nextInt();
				SQL_SELECT_BY_ID = "Select * from EMPLOYEE WHERE ID=?";
				try (Connection conn = ConnectionManager.getConnection();
					 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID);) {
//					SQL_SELECT_BY_ID = "Select * from EMPLOYEE WHERE ID=?";
//					PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID);
					preparedStatement.setInt(1, empID);

					ResultSet resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {

						int id = resultSet.getInt("ID");
						String name = resultSet.getString("NAME");
						long contact = resultSet.getLong("CONTACT");
						String department = resultSet.getString("DEPARTMENT");
						String email = resultSet.getString("EMAIL");
						String address = resultSet.getString("ADDRESS");

						Employee emp = new Employee();
						emp.setEmpID(id);
						emp.setEmpName(name);
						emp.setEmpContact(contact);
						emp.setEmpDepartment(department);
						emp.setEmpEmail(email);
						emp.setEmpAddress(address);

						result.add(emp);

					}

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}

				display(result);
				break;

			case 3:
				System.out.println("\nEnter the following details to UPDATE an employee:\n");

				System.out.println("\nEnter Employee ID to UPDATE :");
				empID = sc.nextInt();
				System.out.println("Enter Name :");
				sc.nextLine();
				empName = sc.nextLine();
				System.out.println("Enter Contact No :");
				empContact = sc.nextLong();
				System.out.println("Enter Department :");
				empDepartment = sc.next();
				System.out.println("Enter Email-ID :");
				empEmail = sc.next();
				System.out.println("Enter Address :");
				empAddress = sc.next();

				try (Connection conn = ConnectionManager.getConnection()) {

					SQL_UPDATE = "UPDATE EMPLOYEE SET NAME = ?, CONTACT =?, DEPARTMENT =?,EMAIL =?, ADDRESS =? WHERE ID=?";
					PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE);
					preparedStatement.setString(1, empName);
					preparedStatement.setLong(2, empContact);
					preparedStatement.setString(3, empDepartment);
					preparedStatement.setString(4, empEmail);
					preparedStatement.setString(5, empAddress);
					preparedStatement.setInt(6, empID);

					int row = preparedStatement.executeUpdate();

					// rows affected
					System.out.print(row); // 1
					if (row > 0) {
						System.out.println(" existing employee record was updated successfully!");
					}
					System.out.println("  Done.");

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 4:
				System.out.println("\nEnter Employee ID to DELETE from the Databse :");
				empID = sc.nextInt();
				try (Connection conn = ConnectionManager.getConnection()) {
					SQL_DELETE = "DELETE FROM EMPLOYEE WHERE ID=?";
					PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
					preparedStatement.setInt(1, empID);

					int row = preparedStatement.executeUpdate();
					// rows affected
					System.out.print(row); // 1
					System.out.println(" employee record deleted from the database.");
				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 5:
				try (Connection conn = ConnectionManager.getConnection();) {

					result = employee.getAllUsers();

				} catch (Exception e) {
					e.printStackTrace();
				}

				display(result);
				break;

			case 6:
				System.out.println("\nYou have chosen EXIT !!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("\nEnter a correct choice from the List :");
				break;
			}
		} while (true);

	}

}