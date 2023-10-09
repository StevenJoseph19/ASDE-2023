package com.acme.domain;

import com.acme.connect.ConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class Employee implements Serializable {

    int empID;
    String empName;
    long empContact;
    String empDepartment;
    String empEmail;
    String empAddress;

    String SQL_SELECT;

    public Employee() {

    }

    public Employee(int empID, String empName, long empContact, String empDepartment, String empEmail,
                    String empAddress) {
        super();
        this.empID = empID;
        this.empName = empName;
        this.empContact = empContact;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpContact() {
        return empContact;
    }

    public void setEmpContact(long empContact) {
        this.empContact = empContact;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public List getAllUsers() throws SQLException {
        SQL_SELECT = "Select * from EMPLOYEE";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
             ResultSet resultSet = preparedStatement.executeQuery();) {


            List employees = new ArrayList();

            while (resultSet.next()) {
                Employee employee = extractUserFromResultSet(resultSet);
                employees.add(employee);
            }

            return employees;
        }
    }

    public  Employee extractUserFromResultSet(ResultSet resultSet) throws SQLException {


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

        return emp;
    }

    @Override
    public String toString() {
        return "Employee [empID=" + empID + ", empName=" + empName + ", empContact=" + empContact + ", empDepartment="
                + empDepartment + ", empEmail=" + empEmail + ", empAddress=" + empAddress + "]";
    }

}