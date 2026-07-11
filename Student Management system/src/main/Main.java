package main;

import java.util.Scanner;

import model.Students;
import service.StudentService;
import exception.StudentNotFoundException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Gender: ");
                String gender = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                System.out.print("Enter Percentage: ");
                double percentage = sc.nextDouble();

                Students student = new Students(
                        id,
                        name,
                        age,
                        gender,
                        email,
                        phone,
                        course,
                        address,
                        percentage);

                service.addStudent(student);

                break;

            case 2:

                service.viewStudents();

                break;

            case 3:

                System.out.println("1. Search by ID");
                System.out.println("2. Search by Name");
                System.out.println("3. Search by Course");

                int searchChoice = sc.nextInt();
                sc.nextLine();

                switch (searchChoice) {

                case 1:

                	System.out.print("Enter ID: ");
                	int searchId = sc.nextInt();

                	try {

                	    Students s = service.searchById(searchId);

                	    System.out.println(s);

                	} catch (StudentNotFoundException e) {

                	    System.out.println(e.getMessage());

                	}

                    break;

                case 2:

                    System.out.print("Enter Name: ");
                    service.searchByName(sc.nextLine());

                    break;

                case 3:

                    System.out.print("Enter Course: ");
                    service.searchByCourse(sc.nextLine());

                    break;
                }

                break;

            case 4:

                System.out.print("Enter Student ID: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String newName = sc.nextLine();

                System.out.print("New Phone: ");
                String newPhone = sc.nextLine();

                System.out.print("New Address: ");
                String newAddress = sc.nextLine();

                System.out.print("New Course: ");
                String newCourse = sc.nextLine();

                System.out.print("New Percentage: ");
                double newPercentage = sc.nextDouble();

                if (service.updateStudent(updateId,
                        newName,
                        newPhone,
                        newAddress,
                        newCourse,
                        newPercentage))

                    System.out.println("Student Updated Successfully.");

                else

                    System.out.println("Student Not Found.");

                break;

            case 5:

                System.out.print("Enter Student ID: ");

                int deleteId = sc.nextInt();

                if (service.deleteStudent(deleteId))

                    System.out.println("Student Deleted Successfully.");

                else

                    System.out.println("Student Not Found.");

                break;

            case 6:

                System.out.println("1.Sort by ID");
                System.out.println("2.Sort by Name");
                System.out.println("3.Sort by Age");
                System.out.println("4.Sort by Percentage");

                int sortChoice = sc.nextInt();

                switch (sortChoice) {

                case 1:
                    service.sortById();
                    break;

                case 2:
                    service.sortByName();
                    break;

                case 3:
                    service.sortByAge();
                    break;

                case 4:
                    service.sortByPercentage();
                    break;

                default:
                    System.out.println("Invalid Choice");
                }

                service.viewStudents();

                break;

            case 7:

                System.out.println("Thank You!");

                sc.close();

                System.exit(0);

            default:

                System.out.println("Invalid Choice.");

            }

        }

    }

}