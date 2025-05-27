import java.util.*;

class Main {
    public static void main(String[] args) {
        Product laptop = new Electronics("laptop", 20, 10, "Dell");
        Product book = new Book("Harry Potter", 10, 12, "camnh");
        User user_1 = new User("Alice", 0.0);
        User user_2 = new User("Bob", 0.0);
        User user_3 = new User("Charlie", 0.0);
        
        user_1.buyProduct(laptop, 3);
        user_1.buyProduct(book, 10);
        user_2.buyProduct(laptop, 1);
        user_3.buyProduct(book, 5);
        
        System.out.println("====");
        
        System.out.println("Users with Highest Total Spent:");
        User[] users = {user_1, user_2, user_3};
        for (int i = 0; i < users.length - 1; i++){
            for (int j = i + 1; j < users.length; j++) {
                if (users[i].getTotalSpent() < users[j].getTotalSpent()) {
                    User temp = users[i];
                    users[i] = users[j];
                    users[j] = temp;
                }
            }
        }
        for (int i = 0; i < users.length; i++) {
            System.out.printf("%d. %s: $%.1f%n", i + 1, users[i].getUsername(), users[i].getTotalSpent());
        }
        
        System.out.println("====");
        
        laptop.displayDetails();
        System.out.println("---");
        book.displayDetails();
    }
}

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public abstract double calculateCost(int quantity);
    
    public abstract void displayDetails();
    
    public String getName() {
        return name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}

class Book extends Product {
    
    private String author;
    
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public double calculateCost(int quantity) {
        return this.price * quantity;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Author: " + author);
    }
}

class Electronics extends Product {
    private String brand;
    
    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    @Override
    public double calculateCost(int quantity) {
        return this.price * quantity * 1.1;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Brand: " + brand);
    }
}

class User {
    private String username;
    private double totalSpent;
    
    public User(String username, double totalSpent) {
        this.username = username;
        this.totalSpent = 0.0;
    }
    public String getUsername() {
        return username;
    }
    
    public double getTotalSpent() {
        return totalSpent;
    }
    
    public void buyProduct(Product product, int quantity) {
        double totalPrice = product.calculateCost(quantity);
        if (quantity > product.getQuantity()) {
            System.out.println("Insufficient quantity of " + product.getName() + " available.");
            return;
        }
        System.out.println("User: "
                + this.username
                + " bought "
                + quantity
                + " "
                + product.getName()
                + " for $"
                + totalPrice);
        totalSpent += totalPrice;
        product.reduceQuantity(quantity);
    }
}