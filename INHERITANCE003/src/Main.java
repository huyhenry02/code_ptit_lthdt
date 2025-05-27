import java.util.*;
class Main {
    public static void main(String[] args) {
        Student student = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles", "90028");
        System.out.println(student);
        System.out.println("Study credits " + student.credits());
        student.study();
        System.out.println("Study credits " + student.credits());
    }
}

class Person {
    private String name;
    private String address;
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName(String name){
        return name;
    }
    
    public String getAddress(String address){
        return address;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String name) {
        this.address = address;
    }
    
    public String toString(){
        return name + " - " + address;
    }
}

class Student extends Person {
    private int credits;
    private String studentID;
    
    public Student(String name, String address,String studentID) {
        super(name, address);
        this.studentID = studentID;
        this.credits= 0;
    }
    
    public void study() {
        credits++;
    }
    
    public int credits() {
        return credits;
    }
    
    public String getStudentID(String studentID) {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String toString() {
        return super.toString() + " " + studentID;
    }
}