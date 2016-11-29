class CFraction {
    int num;
    int den;
	
    public CFraction() {
        this(0, 1);
    }
	
    public CFraction(int num, int den) {
        this.num = num;
	this.den = den;
    }
	
    private int gcd(int m, int n) {
	if(m %n == 0)
            return Math.abs(n);
	else
            return gcd(n, m%n);
    }
	
    public CFraction add(CFraction b) {
        int newnum = num * b.den + den * b.num;
        int newden = den * b.den;
        int g = gcd(newnum, newden);
			
        return new CFraction(newnum/g, newden/g);
    }
	
    public CFraction sub(CFraction b) {
        int newnum = num * b.den - den * b.num;
        int newden = den * b.den;
        int g = gcd(newnum, newden);
        
        return new CFraction(newnum/g, newden/g);
    }
	
    public CFraction mul(CFraction b) {
        int newnum = num * b.num;
        int newden = den * b.den;
        int g = gcd(newnum, newden);
        
        return new CFraction(newnum/g, newden/g);
    }
	
    public CFraction div(CFraction b) {
        int newnum = num * b.den;
        int newden = den * b.num;
        
        if (newden < 0) {
            newnum = -newnum;
            newden = -newden;
        }
        int g = gcd(newnum, newden);
        
        return new CFraction(newnum/g, newden/g);
    }
	
    public String toString() {
	return num + " / " + den + " = " + (double)num / den;
    }
}

public class HW10_05366016 {
    public static void main(String[] args) {
    	CFraction fra1 = new CFraction(-3, 2);
   	CFraction fra2 = new CFraction(-5, 6);
   		
    	System.out.println(fra1);
    	System.out.println(fra2);
    	
    	CFraction fra3;
    	fra3 = fra1.add(fra2); 	
    	System.out.println(fra3);
    	
    	fra3 = fra1.sub(fra2); 	
    	System.out.println(fra3);
    	
    	fra3 = fra1.mul(fra2); 	
    	System.out.println(fra3);
    	
    	fra3 = fra1.div(fra2); 	
    	System.out.println(fra3);
    }
    
}
