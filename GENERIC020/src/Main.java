import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Filter<T> {
    boolean test(T t);
}

class GenericFilter {
    public static <T> List<T> filter(List<T> input, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : input) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

class IntegerEventFilter implements Filter<Integer> {
    
    @Override
    public boolean test(Integer t) {
        return t % 2 == 0;
    }
}

class StringLengthFilter implements Filter<String> {
    private final int maxLength;
    public StringLengthFilter(int maxLength){
        this.maxLength = maxLength;
    }
    @Override
    public boolean test(String s) {
        return s.length() >= maxLength ;
    }
}

class FilterEmployeeSalary implements Filter<Employee> {
    private final double salary;
    public FilterEmployeeSalary(double salary){
        this.salary = salary;
    }
    @Override
    public boolean test(Employee t) {
        return t.getSalary() > salary ;
    }
}

class Employee {
    private String name;
    private Double salary;
    
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getSalary() {
        return salary;
    }
    
    public String toString(){
        return name + " " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer testCase = Integer.parseInt(sc.nextLine());
        
        while(true) {
            String line = sc.nextLine();
            if (line.equals("End")) break;
            String[] tokens = line.split("\\s+");
            switch (tokens[0]){
                case "FilterIntEven": {
                    int n = Integer.parseInt(tokens[1]);
                    List<Integer> list = new ArrayList<>();
                    
                    for (int i = 0; i < n; i++){
                        list.add(Integer.parseInt(tokens[2 + i]));
                    }
                    
                    List<Integer> result = GenericFilter.filter(list, new IntegerEventFilter());
                    printResult(result);
                    break;
                }
                case "FilterStringLength": {
                    int n = Integer.parseInt(tokens[2]);
                    int minLength = Integer.parseInt(tokens[1]);
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < n; i++){
                        list.add(tokens[3 + i]);
                    }
                    
                    List<String> result = GenericFilter.filter(list, new StringLengthFilter(minLength));
                    printResult(result);
                    break;
                }
                case "FilterEmployeeSalary": {
                    double minSalary = Double.parseDouble(tokens[1]);
                    int n = Integer.parseInt(tokens[2]);
                    List<Employee> list = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String name = tokens[3 + i*2];
                        double salary = Double.parseDouble(tokens[ 3 + i* 2 + 1]);
                        list.add(new Employee(name,salary));
                    }
                    List<Employee> result = GenericFilter.filter(list, new FilterEmployeeSalary(minSalary));
                    printResult(result);
                    break;
                }
            }
        }
        sc.close();
    }
    
    private static <T> void printResult(List<T> list){
        if (list.isEmpty()){
            System.out.println("None");
        }else {
            for(T item : list){
                System.out.println(item);
            }
        }
    }
}