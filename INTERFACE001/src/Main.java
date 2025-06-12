import java.util.*;
import java.io.*;

interface Packable {
    double weight();
}

class Book implements Packable {
    private String author;
    private String name;
    private double weight;
    
    public Book(String author, String name, double weight){
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return author + ": " + name;
    }
    
}

class CD implements Packable{
    private String artist;
    private String name;
    private int publicationYear;
    
    public CD(String artist, String name, int publicationYear){
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }
    
    public double weight(){
        return 0.1;
    }
    
    public String toString(){
        return artist + ": " + name + " (" + publicationYear + ")";
    }
}

class Main {
    public static void main(String[] args){
        Book b1 = new Book("Fyodor Dostoevsky", "Crime and Punishment", 2);
        Book b2 = new Book("Robert Martin", "Clean Code", 1);
        Book b3 = new Book("Kent Beck", "Test Driven Development", 0.5);
        
        CD c1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD c2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD c3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);
        
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
    }
}















