

public class Random { 
	int n = 4;
	 public int nextInt(int n) {
		   if (n <= 0)
		     throw new IllegalArgumentException("n must be positive");

		   if ((n & -n) == n)  // i.e., n is a power of 2
		     return (int)((n * (long)nextInt(31)) >> 31);

		   int bits, val;
		   do {
		       bits = nextInt(31);
		       val = bits % n;
		   } while (bits - val + (n-1) < 0);
		   System.out.println(val);
		   return val;
		   
		   
		   
		   
		 }
}

