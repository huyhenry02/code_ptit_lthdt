package OOP012;

import java.util.*;

public class OOP012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String line = sc.nextLine();
            if (line.equals("End")) break;
            if (line.equals("Book")) {
                String bookName = sc.nextLine();
                double price = Double.parseDouble(sc.nextLine());
                int qty = Integer.parseInt(sc.nextLine());
                
                sc.nextLine();
                
                String authorName = sc.nextLine();
                String authorEmail = sc.nextLine();
                char gender = sc.nextLine().charAt(0);
                
                Author author = new Author(authorName, authorEmail, gender);
                Book book = new Book(bookName, author, price, qty);
                System.out.println(book);
            }
        }
        
        sc.close();
    }
}

class Author{
    private String name;
    private String email;
    private char gender;
    
    public Author (String name, String email, char gender) {
        this.name = name;
        this.email = email;
        setGender(gender);
    }
    
    public String email() {
        return email;
    }
    
    public String name() {
        return name;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGender(char gender) {
        if (gender == 'f' || gender == 'm'){
            this.gender = gender;
        } else {
            this.gender = 'u';
        }
    }
    
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qty = 0;
    
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.author = author;
    }
    
    public String name() {
        return name;
    }
    
    public Author author() {
        return author;
    }
    
    public double price() {
        return price;
    }
    
    public int qty() {
        return qty;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public String toString() {
        return "Book[name=" + name + ", " + author + ", price=" + price + ", qty=" + qty + "]";
    }
}