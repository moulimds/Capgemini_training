package model;

public class Students {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String course;
    private String address;
    private double percentage;

    public Students() {

    }

    public Students(int id, String name, int age, String gender,
                    String email, String phone,
                    String course, String address,
                    double percentage) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.address = address;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    // Converts object to one line for students.txt
    public String toFileString() {

        return id + "," +
               name + "," +
               age + "," +
               gender + "," +
               email + "," +
               phone + "," +
               course + "," +
               address + "," +
               percentage;
    }

    @Override
    public String toString() {

        return "Student ID : " + id +
                "\nName : " + name +
                "\nAge : " + age +
                "\nGender : " + gender +
                "\nEmail : " + email +
                "\nPhone : " + phone +
                "\nCourse : " + course +
                "\nAddress : " + address +
                "\nPercentage : " + percentage +
                "\n----------------------------";
    }

}