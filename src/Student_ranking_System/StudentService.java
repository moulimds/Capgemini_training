package student;

import java.util.*;

public class StudentService {
	
	    public void sortStudents(ArrayList<Student> list) {
	        Collections.sort(list);

	        System.out.println("\nSorted Students");
	        for (Student s : list)
	            System.out.println(s);
	    }

	    public void displayTop5(ArrayList<Student> list) {

	        System.out.println("\nTop 5 Students");

	        for (int i = 0; i < 5 && i < list.size(); i++)
	            System.out.println(list.get(i));
	    }

	    public void departmentTopper(ArrayList<Student> list) {

	        System.out.println("\nDepartment Wise Topper");

	        HashMap<String, Student> map = new HashMap<>();

	        for (Student s : list) {

	            if (!map.containsKey(s.dept) ||
	                    s.mark > map.get(s.dept).mark) {

	                map.put(s.dept, s);
	            }
	        }

	        for (String dept : map.keySet()) {
	            System.out.println(dept + " -> " + map.get(dept));
	        }
	    }

	    public void countAbove80(ArrayList<Student> list) {

	        int count = 0;

	        for (Student s : list) {

	            if (s.mark > 80)
	                count++;
	        }

	        System.out.println("\nStudents Above 80 : " + count);
	    }
	}

