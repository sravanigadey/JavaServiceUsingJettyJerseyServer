package com.maven.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBOperations {

    //establishing connection to database
    static Connection con = null;
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root@mysql");
        return con;
    }

    //inserting record into database
    public static void insert(Integer num, String name, String branch, String section, String course) throws SQLException {
        String insertQuery = "INSERT INTO students values (?, ?, ?, ?, ?)";
        PreparedStatement psmt = con.prepareStatement(insertQuery);
        psmt.setInt(1, num);
        psmt.setString(2, name);
        psmt.setString(3, branch);
        psmt.setString(4, section);
        psmt.setString(5, course);
        psmt.executeUpdate();
    }

    //displaying all the records
    public static void display() throws SQLException {
        String displayQuery = "SELECT * FROM students";
        PreparedStatement psmt = con.prepareStatement(displayQuery);

        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            Integer num = rs.getInt("num");
            String name = rs.getString("name");
            String branch = rs.getString("branch");
            String section = rs.getString("section");
            String course = rs.getString("course");
            System.out.format("%d, %s, %s, %s, %s\n", num, name, branch, section, course);
        }
    }

    //updating a particular record
    public static void update(String val, Integer val1) throws SQLException {
        String updateQuery = "UPDATE students SET course = ? where num = ?";
        PreparedStatement psmt = con.prepareStatement(updateQuery);
        psmt.setString(1,val);
        psmt.setInt(2,val1);
        psmt.executeUpdate();
    }

    //deleting a particular record
    public static void delete(Integer val) throws SQLException {
        String deleteQuery = "DELETE from students where num = ?";
        PreparedStatement psmt = con.prepareStatement(deleteQuery);
        psmt.setInt(1,val);
        psmt.executeUpdate();
    }
}
