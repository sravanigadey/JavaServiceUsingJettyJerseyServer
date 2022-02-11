package com.maven.restapi;

import javax.rmi.CORBA.Stub;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBOperations {

    public static class Student {
        Integer num;
        String name;
        String branch;
        String section;
        String course;

        public Integer getNum() {
            return num;
        }
        public void setNum(Integer num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getBranch() {
            return branch;
        }
        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getSection() {
            return section;
        }
        public void setSection(String section) {
            this.section = section;
        }

        public String getCourse() {
            return course;
        }
        public void setCourse(String course) {
            this.course = course;
        }
    }

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
    public static ArrayList<Student> display() throws SQLException {
        ArrayList<Student> students = new ArrayList<Student>();
        String displayQuery = "SELECT * FROM students";
        PreparedStatement psmt = con.prepareStatement(displayQuery);

        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            Student st = new Student();
            st.setNum(rs.getInt("num"));
            st.setName(rs.getString("name"));
            st.setBranch(rs.getString("branch"));
            st.setSection(rs.getString("section"));
            st.setCourse(rs.getString("course"));
            students.add(st);
//            Integer num = rs.getInt("num");
//            String name = rs.getString("name");
//            String branch = rs.getString("branch");
//            String section = rs.getString("section");
//            String course = rs.getString("course");
//            System.out.format("%d, %s, %s, %s, %s\n", num, name, branch, section, course);
        }
        return students;
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
