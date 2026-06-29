package student;

import java.util.*;

public class Main {
	
	    public static void main(String[] args) {

	        ArrayList<Student> list = new ArrayList<>();

	        list.add(new Student(101, "Mouli", 95, "CSE"));
	        list.add(new Student(102, "Anu", 88, "ECE"));
	        list.add(new Student(103, "Kavin", 91, "CSE"));
	        list.add(new Student(104, "Divya", 95, "IT"));
	        list.add(new Student(105, "Bala", 76, "EEE"));
	        list.add(new Student(106, "Arun", 95, "CSE"));
	        list.add(new Student(107, "Hari", 82, "ECE"));
	        list.add(new Student(108, "Nila", 89, "IT"));

	        StudentService service = new StudentService();

	        service.sortStudents(list);
	        service.displayTop5(list);
	        service.departmentTopper(list);
	        service.countAbove80(list);
	    }
	}


