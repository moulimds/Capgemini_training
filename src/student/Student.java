package student;

public class Student implements Comparable<Student>{
	int roll;
	String name;
	int mark;
	String dept;
	
	public Student(int roll, String name, int mark, String dept) {
		this.roll = roll;
		this.name= name;
		this.mark= mark;
		this.dept=dept;
	}
	@Override
    public int compareTo(Student s) {

        if (this.mark != s.mark)
            return s.mark - this.mark;

        if (!this.name.equals(s.name))
            return this.name.compareTo(s.name);

        return this.roll - s.roll;
    }

    @Override
    public String toString() {
        return roll + " " + name + " " + mark + " " + dept;
    }
}

