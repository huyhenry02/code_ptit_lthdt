import java.util.Scanner;

public  class Main {
    public static <T> int findFirstMatch(T[] array, T target) {
        for (int i = 0; i < array.length; i++){
            if (array[i].equals(target)){
                return i;
            }
        }
        
        return -1;
    
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
            
            String[] arrayPart = parts[0].trim().split("\\s+");
            String target = parts[1].trim();
            
            Integer result = findFirstMatch(arrayPart, target);
            System.out.println(result);
        }
        scanner.close();
    }
}