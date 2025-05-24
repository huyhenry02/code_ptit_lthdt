import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            StringBuilder initials = new StringBuilder();
            
            for (char c : line.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    initials.append(c);
                }
            }
            
            System.out.println("My initials are: " + initials);
        }
        
        sc.close();
    }
}
