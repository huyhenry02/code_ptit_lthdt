import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int birthYear;
    private double gpa;
    private int credit;
    
    public Student(String name, int birthYear, double gpa, int credit) {
        this.name = name;
        this.birthYear = birthYear;
        this.gpa = gpa;
        this.credit = credit;
    }
    
    public String getName() {
        return name;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public int getBirthYear() {
        return birthYear;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public String toString() {
        return name + " " + birthYear + " " + gpa + " " + credit;
    }
}

class ByGpaCreditName implements Comparator<Student> {
    
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGpa() != o2.getGpa()) {
            return Double.compare(o2.getGpa(), o1.getGpa());
        }
        if (o1.getCredit() != o2.getCredit()) {
            return Integer.compare(o2.getCredit(), o1.getCredit());
        }
        return o1.getName().compareTo(o2.getName());
    }
}

class ByBirthGpaName implements Comparator<Student> {
    
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getBirthYear() != o2.getBirthYear()) {
            return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
        }
        if (o1.getGpa() != o2.getGpa()) {
            return Double.compare(o2.getGpa(), o1.getGpa());
        }
        return o1.getName().compareTo(o2.getName());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCase = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();
        
        for (int i = 0; i < testCase; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            
            students.add(new Student(
                    parts[0],
                    Integer.parseInt(parts[1]),
                    Double.parseDouble(parts[2]),
                    Integer.parseInt(parts[3])
            ));
        }
        String sortBy = sc.nextLine();
        switch (sortBy) {
            case "BY_GPA_CREDIT_NAME": {
                students.sort(new ByGpaCreditName());
                break;
            }
            
            case "BY_BIRTH_GPA_NAME": {
                students.sort(new ByBirthGpaName());
                break;
            }
        }
        for (Student student: students) {
            System.out.println(student);
        }
        sc.close();
    }
}