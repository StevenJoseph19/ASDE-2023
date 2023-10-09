package com.acme.domain;

import com.acme.connect.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private String loginId;
    private String password;

    private int employee_id;

    private char role;

    public Login() {

    }

    public Login(String loginId, String password, char role) {
        this.loginId = loginId;
        this.password = password;
        this.role = role;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }


    public Login getEmployeeLoginDetailsByUserNameAndPassword(String user, String pass) {
        String SQL_LOGIN = "SELECT *  FROM LOGIN WHERE username = ? AND password = ? ";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_LOGIN);
        ) {

            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Login login = new Login();
                login.setEmployee_id(rs.getInt("employee_id"));
                login.setRole(rs.getString("role").charAt(0));

                return login;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
