class Main {
    public static void main(String[] args) {
        Money a = new Money(10, 8);
        Money b = new Money(5, 5);
        Money c = a.plus(b);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        Money u = new Money(10, 0);
        Money y = new Money(3, 0);
        Money w = new Money(5, 0);
        
        System.out.println(u.lessThan(y));
        System.out.println(y.lessThan(w));
        
        Money m = new Money(10, 0);
        Money n = new Money(3, 50);
        Money o = m.minus(n);
        
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        
        o = o.minus(m);
        System.out.println(o);
    }
}


class Money {
    private int euros;
    private int cents;
    
    public Money(int euros, int cents) {
        if (cents >= 100) {
            this.euros = euros + cents / 100;
            this.cents = cents % 100;
        } else {
            this.euros = euros;
            this.cents = cents;
        }
    }
    
    public Money plus(Money added) {
        int totalCents = this.cents + added.cents;
        int totalEuros = this.euros + added.euros;
        
        return new Money(totalEuros, totalCents);
    }
    
    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) return true;
        if (this.euros == compared.euros && this.cents < compared.cents) return true;
        return false;
    }
    
    public Money minus(Money minus) {
        int total1 = this.euros * 100 + this.cents;
        int total2 = minus.euros * 100 + minus.cents;
        int result = total1 - total2;
        
        if (result < 0) result = 0;
        
        int newEuros = result / 100;
        int newCents = result % 100;
        
        return new Money(newEuros, newCents);
    }
    
    public String toString() {
        return String.format("%d.%02de", euros, cents);
    }
}
