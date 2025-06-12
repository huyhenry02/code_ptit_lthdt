import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;
    
    public Book (String title, String author,double price, int quantity){
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
    
    public double calculateValue(){
        return this.price * this.quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String toString() {
        return title + ";" + author + ";" + price + ";" + quantity;
    }
}

class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null){
                try {
                    String[] parts = line.split(";");
                    if(parts.length != 4) {
                        throw new RuntimeException("Invalid line format: " + line);
                    }
                    
                    String title = parts[0];
                    String author = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    
                    books.add(new Book(title, author, price, quantity));
                }catch (Exception e) {
                    System.err.println("Error parsing line " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error in line " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error read txt: " + e.getMessage());
        }
        
        Book highestValueBook = null;
        double maxValue = -1;
        for (Book b: books){
            double value = b.calculateValue();
            if (value > maxValue){
                maxValue = value;
                highestValueBook = b;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("highest_value_book.txt"))) {
            if (highestValueBook != null) {
                bw.write(highestValueBook.toString());
            } else {
                bw.write("No valid book found.");
            }
        } catch (IOException e) {
            System.err.println("Error writing highest_value_book.txt: " + e.getMessage());
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("available_books.txt"))){
            for (Book b: books){
                if (b.getQuantity() > 0){
                    bw.write(b.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing available_books.txt: " + e.getMessage());
        }
        
        System.out.println("done.");
    }
}