import java.util.Scanner;

public class Main {
    public static int getQuadrant(int x, int y) {
        if (x > 0 && y > 0) return 1;
        else if (x < 0 && y > 0) return 2;
        else if (x < 0 && y < 0) return 3;
        else if (x > 0 && y < 0) return 4;
        else return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(getQuadrant(x, y));
        }
        sc.close();
    }
}