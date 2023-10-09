import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageEmployee {

	static void display(List<Employee> result) {
		System.out.println("\n--------------Employee List---------------\n");
		System.out.println(String.format("%-10s%-15s%-20s%-30s%-35s%-20s", "ID", "Name", "Contact No.", "Department",
				"Email-Id", "Address"));
		for (Employee e : result) {
			System.out.println(String.format("%-5s%-20s%-20s%-30s%-35s%-20s", e.empID, e.empName, e.empContact,
					e.empDepartment, e.empEmail, e.empAddress));
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

		String SQL_SELECT;
		String SQL_INSERT;
		String SQL_UPDATE;
		String SQL_SELECT_BY_ID;
		String SQL_DELETE;

		do {
			System.out.println("\n*********Welcome to the Employee Management System**********\n");
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

				try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/employee_mgmt", "postgres",
						"password");) {

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
				try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/employee_mgmt", "postgres",
						"password");) {
					SQL_SELECT_BY_ID = "Select * from EMPLOYEE WHERE ID=?";
					PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID);
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

				try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/employee_mgmt", "postgres",
						"password");) {

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
				try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/employee_mgmt", "postgres",
						"password");) {
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
				try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/employee_mgmt", "postgres",
						"password");)

				// auto close connection and preparedStatement

				{
					SQL_SELECT = "Select * from EMPLOYEE";
					PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
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
//							result.forEach(x -> System.out.println(x));

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
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