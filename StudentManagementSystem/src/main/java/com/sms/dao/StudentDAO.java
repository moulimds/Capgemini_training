package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sms.model.Student;
import com.sms.util.DBConnection;

public class StudentDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // Add Student
    public boolean addStudent(Student s) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query = "INSERT INTO student(name,email,phone,course,address,date_of_birth) VALUES(?,?,?,?,?,?)";

            pst = con.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getPhone());
            pst.setString(4, s.getCourse());
            pst.setString(5, s.getAddress());
            pst.setString(6, s.getDateOfBirth());

            int row = pst.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    // View Students
    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            String query = "SELECT * FROM student";

            pst = con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setDateOfBirth(rs.getString("date_of_birth"));

                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Delete Student
    public boolean deleteStudent(int id) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query = "DELETE FROM student WHERE student_id=?";

            pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int row = pst.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    // Search Student
    public Student searchStudent(int id) {

        Student s = null;

        try {

            con = DBConnection.getConnection();

            String query = "SELECT * FROM student WHERE student_id=?";

            pst = con.prepareStatement(query);

            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setDateOfBirth(rs.getString("date_of_birth"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    // Update Student
    public boolean updateStudent(Student s) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query = "UPDATE student SET name=?,email=?,phone=?,course=?,address=?,date_of_birth=? WHERE student_id=?";

            pst = con.prepareStatement(query);

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getPhone());
            pst.setString(4, s.getCourse());
            pst.setString(5, s.getAddress());
            pst.setString(6, s.getDateOfBirth());
            pst.setInt(7, s.getStudentId());

            int row = pst.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

}