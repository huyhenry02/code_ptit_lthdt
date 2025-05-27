import java.util.*;

interface Callable {
    String call();
}

interface Browsable {
    String browse();
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<String> numbers = Arrays.asList(sc.nextLine().split(" "));
        List<String> urls = Arrays.asList(sc.nextLine().split(" "));
        
        Smartphone smartphone = new Smartphone(numbers, urls);
        
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}

class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;
    
    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }
    
    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                sb.append("Invalid number!").append("\n");
            } else {
                sb.append("Calling... ").append(number).append("\n");
            }
        }
        return sb.toString();
    }
    
    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (url.matches(".*\\d.*")) {
                sb.append("Invalid URL!").append("\n");
            } else {
                sb.append("Browsing: ").append(url).append("!").append("\n");
            }
        }
        return sb.toString();
    }
}
