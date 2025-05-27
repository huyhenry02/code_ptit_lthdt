import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        Map<String, List<Employee>> departments = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.trim().split("\\s+");
            
            String name = parts[0];
            double salary = Double.parseDouble(parts[1]);
            String department = parts[2];
            
            Employee emp;
            
            if (parts.length == 3) {
                emp = new Employee(name, salary, department);
            } else if (parts.length == 4) {
                if (parts[3].contains("@")) {
                    emp = new Employee(name, salary, department, parts[3]);
                } else {
                    int age = Integer.parseInt(parts[3]);
                    emp = new Employee(name, salary, department, age);
                }
            } else if (parts.length == 5) {
                String email = parts[3];
                int age = Integer.parseInt(parts[4]);
                emp = new Employee(name, salary, department, email, age);
            } else {
                continue;
            }
            
            departments.putIfAbsent(department, new ArrayList<>());
            departments.get(department).add(emp);
        }
        
        String bestDepartment = "";
        double bestAvg = 0.0;
        
        for (String dept : departments.keySet()) {
            List<Employee> emps = departments.get(dept);
            double total = 0.0;
            for (Employee e : emps) {
                total += e.getSalary();
            }
            double avg = total / emps.size();
            if (avg > bestAvg) {
                bestAvg = avg;
                bestDepartment = dept;
            }
        }
        
        System.out.println("Highest Average Salary: " + bestDepartment);
        
        departments.get(bestDepartment)
                .stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private double salary;
    private String department;
    private String email;
    private int age;
    
    public Employee(String name, double salary, String department) {
        this(name, salary, department, "n/a", -1);
    }
    
    public Employee(String name, double salary, String department, String email) {
        this(name, salary, department, email, -1);
    }
    
    public Employee(String name, double salary, String department, int age) {
        this(name, salary, department, "n/a", age);
    }
    
    public Employee(String name, double salary, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.email = email;
        this.age = age;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
