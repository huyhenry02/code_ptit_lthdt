
import java.util.Scanner;

interface Packable{
    double weight();
}

class Book implements Packable {
    private String author;
    private String name;
    private double weight;

    public Book (String author, String name, double weight){
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
    
    public double weight(){
        return 0;
    }
}

class CD implements Packable{
    private String artist;
    private String name;
    private int weigpublicationYearht;

    public CD (String artist, String name, int weigpublicationYearht){
        this.artist = artist;
        this.name = name;
        this.weigpublicationYearht = weigpublicationYearht;
    }

    public double weight(){
        return 0;
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    } 
}