import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    
    public double getSalary() { return salary; }
    
    public void setName(String name) { this.name = name; }
    
    public void setSalary(double salary) { this.salary = salary; }
    
    public String getInfo() {
        return "Họ tên: " + name;
    }
    
    public double calculateSalary() {
        return salary;
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;
    
    public FullTimeEmployee(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        return salary + bonus;
    }
    
    @Override
    public String getInfo() {
        return "Loại: FullTime\n" +
                "Họ tên: " + name + "\n" +
                "Lương cơ bản: " + String.format("%.1f", salary) + "\n" +
                "Thưởng: " + String.format("%.1f", bonus) + "\n" +
                "=> Lương thực nhận: " + String.format("%.1f", calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public String getInfo() {
        return "Loại: PartTime\n" +
                "Họ tên: " + name + "\n" +
                "Số giờ làm việc: " + hoursWorked + " giờ\n" +
                "Tiền công mỗi giờ: " + String.format("%.1f", hourlyRate) + "\n" +
                "=> Lương thực nhận: " + String.format("%.1f", calculateSalary());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("--- Thông tin nhân viên ---");
        
        // Nhân viên 1
        String type1 = sc.nextLine();
        String name1 = sc.nextLine();
        
        if (type1.equals("FullTime")) {
            double salary = Double.parseDouble(sc.nextLine());
            double bonus = Double.parseDouble(sc.nextLine());
            FullTimeEmployee emp1 = new FullTimeEmployee(name1, salary, bonus);
            System.out.println(emp1.getInfo());
        } else {
            int hours = Integer.parseInt(sc.nextLine());
            double rate = Double.parseDouble(sc.nextLine());
            PartTimeEmployee emp1 = new PartTimeEmployee(name1, hours, rate);
            System.out.println(emp1.getInfo());
        }
        
        System.out.println();
        
        // Nhân viên 2
        String type2 = sc.nextLine();
        String name2 = sc.nextLine();
        
        if (type2.equals("FullTime")) {
            double salary = Double.parseDouble(sc.nextLine());
            double bonus = Double.parseDouble(sc.nextLine());
            FullTimeEmployee emp2 = new FullTimeEmployee(name2, salary, bonus);
            System.out.println(emp2.getInfo());
        } else {
            int hours = Integer.parseInt(sc.nextLine());
            double rate = Double.parseDouble(sc.nextLine());
            PartTimeEmployee emp2 = new PartTimeEmployee(name2, hours, rate);
            System.out.println(emp2.getInfo());
        }
        
        sc.close();
    }
}