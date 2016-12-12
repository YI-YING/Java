class CFraction {
	int num;
	int den;
 
	public CFraction(int num, int den)
	{
  		this.num = num;
  		this.den = den;
 	}
 	
 	private int gcd(int m, int n)
 	{
 		if(m % n == 0)
 			return n;
 		else
 			return gcd(n, m%n);
 	}
 
 	public CFraction add(CFraction b)
 	{
 		int newnum = this.num*b.den+b.num*this.den;
 		int newden = this.den*b.den;
 		int g = gcd(Math.abs(newnum), Math.abs(newden));
  		return new CFraction(newnum/g, newden/g);
 	}

 	public CFraction sub(CFraction b)
 	{
		int newnum = this.num*b.den-b.num*this.den;
 		int newden = this.den*b.den;
 		int g = gcd(Math.abs(newnum), Math.abs(newden));
  		return new CFraction(newnum/g, newden/g);
 	}
 
 	public CFraction mul(CFraction b)
 	{
 		int newnum = this.num*b.num;
 		int newden = this.den*b.den;
 		int g = gcd(Math.abs(newnum), Math.abs(newden));
  		return new CFraction(newnum/g, newden/g);
 	}
 
 	public CFraction div(CFraction b)
 	{
 		int newnum = this.num*b.den;
 		int newden = this.den*b.num;
 		int g = gcd(Math.abs(newnum), Math.abs(newden));
  		return new CFraction(newnum/g, newden/g);
 	}
 	
 	public String toString()
 	{
  		return num + " / " + den + " = " + (double)num/den;
 	}
    
}
