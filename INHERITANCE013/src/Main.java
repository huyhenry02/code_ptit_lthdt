import java.util.Scanner;

class Teacher {
    protected String name;
    protected double baseSalary;
    
    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public String getName() { return name; }
    
    public double getBaseSalary() { return baseSalary; }
    
    public void setName(String name) { this.name = name; }
    
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    
    public String getInfo() {
        return "Họ tên: " + name;
    }
    
    public double calculateSalary() {
        return baseSalary;
    }
}

class PermanentLecturer extends Teacher {
    private double researchAllowance;
    
    public PermanentLecturer(String name, double baseSalary, double researchAllowance) {
        super(name, baseSalary);
        this.researchAllowance = researchAllowance;
    }
    
    @Override
    public double calculateSalary() {
        return baseSalary + researchAllowance;
    }
    
    @Override
    public String getInfo() {
        return "Loại giảng viên: Permanent\n" +
                "Họ tên: " + name + "\n" +
                "Lương thực nhận: " + calculateSalary();
    }
}

class VisitingLecturer extends Teacher {
    private int teachingHours;
    private double paymentPerHour;
    
    public VisitingLecturer(String name, int teachingHours, double paymentPerHour) {
        super(name, 0);
        this.teachingHours = teachingHours;
        this.paymentPerHour = paymentPerHour;
    }
    
    @Override
    public double calculateSalary() {
        return teachingHours * paymentPerHour;
    }
    
    @Override
    public String getInfo() {
        return "Loại giảng viên: Visiting\n" +
                "Họ tên: " + name + "\n" +
                "Lương thực nhận: " + calculateSalary();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Thông tin giảng viên ---");
        
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        String line3 = sc.nextLine();
        String line4 = sc.nextLine();
        
        Teacher t1;
        if (type1.equals("PermanentLecturer")) {
            double base = Double.parseDouble(line3);
            double allowance = Double.parseDouble(line4);
            t1 = new PermanentLecturer(name1, base, allowance);
        } else {
            int hours = Integer.parseInt(line3);
            double pay = Double.parseDouble(line4);
            t1 = new VisitingLecturer(name1, hours, pay);
        }
        
        System.out.println(t1.getInfo());
        
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        String line6 = sc.nextLine();
        String line7 = sc.nextLine();
        
        Teacher t2;
        if (type2.equals("PermanentLecturer")) {
            double base = Double.parseDouble(line6);
            double allowance = Double.parseDouble(line7);
            t2 = new PermanentLecturer(name2, base, allowance);
        } else {
            int hours = Integer.parseInt(line6);
            double pay = Double.parseDouble(line7);
            t2 = new VisitingLecturer(name2, hours, pay);
        }
        
        System.out.println(t2.getInfo());
        sc.close();
    }
}