import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long L = scanner.nextLong();
            long R = scanner.nextLong();
            
            long count = countPerfectSquares(L, R);
            System.out.println(count);
        }
        scanner.close();
    }
    
    public static long countPerfectSquares(long L, long R) {
        long sqrtL = (long) Math.ceil(Math.sqrt(L));
        long sqrtR = (long) Math.floor(Math.sqrt(R));
        return Math.max(0, sqrtR - sqrtL + 1);
    }
}
