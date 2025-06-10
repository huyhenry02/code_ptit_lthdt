import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
    public abstract double calculateCost(int quantity);
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
    }
}

class Book extends Product {
    private String author;
    
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    
    @Override
    public double calculateCost(int quantity) {
        return this.getPrice() * quantity;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + this.getName());
        System.out.println("Price: $" + this.getPrice());
        System.out.println("Available Quantity: " + this.getQuantity());
        System.out.println("Author: " + author);
    }
}

class Electronics extends Product {
    private String brand;
    
    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }
    
    @Override
    public double calculateCost(int quantity) {
        return this.getPrice() * quantity * 1.1;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + this.getName());
        System.out.println("Price: $" + this.getPrice());
        System.out.println("Available Quantity: " + this.getQuantity());
        System.out.println("Brand: " + brand);
    }
}

class User {
    private String username;
    private double totalSpent;
    
    public User(String username) {
        this.username = username;
        this.totalSpent = 0;
    }
    
    public double getTotalSpent() {
        return totalSpent;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void buyProduct(Product product, int quality) {
        if (quality < product.getQuantity()) {
            System.out.println("User: "
                    + username
                    + " bought "
                    + quality
                    + " "
                    + product.getName()
                    + " for $"
                    + String.format("%.1f", product.calculateCost(quality))
            );
            product.reduceQuantity(quality);
            totalSpent += product.calculateCost(quality);
        } else {
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());
        Electronics electronics = new Electronics("laptop", 20, 10, "Dell");
        Book book = new Book("Harry Potter", 10, 12, "camnh");
        User u1 = new User("Alice");
        User u2 = new User("Bob");
        User u3 = new User("Charlie");
     
        u1.buyProduct(electronics, 3);
        u1.buyProduct(book, 10);
        u2.buyProduct(electronics, 1);
        u3.buyProduct(book, 5);
        
        System.out.println("====");
        System.out.println("Users with Highest Total Spent:");
        User[] users = {u1, u2, u3};
        for (int i = 0; i < (users.length -1); i++){
            for (int j = i + 1; j < users.length; j++){
                if (users[i].getTotalSpent() < users[j].getTotalSpent()){
                    User temp = users[i];
                    users[i] = users[j];
                    users[i] = temp;
                    
                }
            }
        }
        
        for (int i = 0; i < users.length; i++){
            System.out.println(i+1 + ". " + users[i].getUsername() + ": $" + String.format("%.1f", users[i].getTotalSpent()));
        }
        System.out.println("====");
        electronics.displayDetails();
        
        System.out.println("---");
        book.displayDetails();
        
        sc.close();
    }
}