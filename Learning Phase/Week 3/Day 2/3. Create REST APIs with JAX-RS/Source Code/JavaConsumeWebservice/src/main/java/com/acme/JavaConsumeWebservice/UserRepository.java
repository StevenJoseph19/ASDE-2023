package com.acme.JavaConsumeWebservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    Connection con = null;
    PreparedStatement pstmt = null;

    public UserRepository() {
        String url = "jdbc:postgresql://localhost:5432/java_consume_webservice_db";
        String username = "postgres";
        String password = "password";

        try {

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<User> displayUser() {
        List<User> user = new ArrayList<>();

        try {
            pstmt = con.prepareStatement("SELECT * FROM tbl_user");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setOwner(rs.getString("owner"));

                user.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }

    public void createUser(User user) {
        try {
            System.out.println("here...");
            pstmt = con.prepareStatement("INSERT INTO tbl_user (id,username,owner) VALUES (?,?,?)");
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getOwner());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User getUserId(int id) {
        User user = new User();
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbl_user WHERE id=? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setOwner(rs.getString("owner"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }

    public void updateUser(User user) {
        try {
            pstmt = con.prepareStatement("UPDATE tbl_user SET username=?, owner=? WHERE id=?");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getOwner());
            pstmt.setInt(3, user.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser(int id) {
        try {
            pstmt = con.prepareStatement("DELETE FROM tbl_user WHERE id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
