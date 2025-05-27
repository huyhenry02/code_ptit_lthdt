import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < t; i++) {
            String[] line1 = sc.nextLine().split(" ");
            String currency1 = line1[0];
            int amount1 = Integer.parseInt(line1[1]);
            
            String[] line2 = sc.nextLine().split(" ");
            String currency2 = line2[0];
            int amount2 = Integer.parseInt(line2[1]);
            
            Amount a1 = new Amount(currency1, amount1);
            Amount a2 = new Amount(currency2, amount2);
            
            try {
                Amount result = a1.add(a2);
                System.out.println(result.getAmount());
            } catch (CurrencyMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
class CurrencyMismatchException extends Exception {
    public CurrencyMismatchException(String message) {
        super(message);
    }
}

class Amount {
    private String currency;
    private int amount;
    
    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public Amount add(Amount other) throws CurrencyMismatchException {
        if (!this.currency.equals(other.currency)) {
            throw new CurrencyMismatchException("Currency doesn't match");
        }
        return new Amount(this.currency, this.amount + other.amount);
    }
}
