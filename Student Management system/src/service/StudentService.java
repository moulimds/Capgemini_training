package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import exception.StudentNotFoundException;
import model.Students;
import util.FileUtility;

public class StudentService {

    private ArrayList<Students> students;

    public StudentService() {

        // Read students from students.txt
        students = FileUtility.readText();

    }

    // Add Student
    public void addStudent(Students student) {

        students.add(student);

        // Save to students.txt
        FileUtility.writeText(students);

        System.out.println("Student added successfully.");
    }

    // View Students
    public void viewStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        for (Students student : students) {
            System.out.println(student);
        }
    }

    // Search by Student ID
    public Students searchById(int id) throws StudentNotFoundException {

        for (Students student : students) {

            if (student.getId() == id) {
                return student;
            }

        }

        throw new StudentNotFoundException("Student ID " + id + " not found.");
    }

    // Search by Name
    public void searchByName(String name) {

        boolean found = false;

        for (Students student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println(student);
                found = true;

            }
        }

        if (!found) {

            System.out.println("Student not found.");

        }
    }

    // Search by Course
    public void searchByCourse(String course) {

        boolean found = false;

        for (Students student : students) {

            if (student.getCourse().equalsIgnoreCase(course)) {

                System.out.println(student);
                found = true;

            }
        }

        if (!found) {

            System.out.println("No students found.");

        }
    }

    // Update Student
    public boolean updateStudent(int id,
                                 String name,
                                 String phone,
                                 String address,
                                 String course,
                                 double percentage) {

        try {

            Students student = searchById(id);

            student.setName(name);
            student.setPhone(phone);
            student.setAddress(address);
            student.setCourse(course);
            student.setPercentage(percentage);

            FileUtility.writeText(students);

            return true;

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
            return false;

        }
    }

    // Delete Student
    public boolean deleteStudent(int id) {

        try {

            Students student = searchById(id);

            students.remove(student);

            FileUtility.writeText(students);

            return true;

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
            return false;

        }
    }

    // Sort by Student ID
    public void sortById() {

        Collections.sort(students, Comparator.comparingInt(Students::getId));

        FileUtility.writeText(students);

        System.out.println("Students sorted by ID.");
    }

    // Sort by Name
    public void sortByName() {

        Collections.sort(students, Comparator.comparing(Students::getName));

        FileUtility.writeText(students);

        System.out.println("Students sorted by Name.");
    }

    // Sort by Age
    public void sortByAge() {

        Collections.sort(students, Comparator.comparingInt(Students::getAge));

        FileUtility.writeText(students);

        System.out.println("Students sorted by Age.");
    }

    // Sort by Percentage
    public void sortByPercentage() {

        Collections.sort(students, Comparator.comparingDouble(Students::getPercentage));

        FileUtility.writeText(students);

        System.out.println("Students sorted by Percentage.");
    }

}