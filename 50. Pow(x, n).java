class Solution {
    
    public double myPow(double x, int n) {
            //edge case
            if(x == 1 || n == 0) return 1;
            if(x == 0) return 0;
            if(x == -1) return n % 2 == 0 ? 1 : -1;
            if(n == 1) return x;
            
            // use long as -Neg max change to Pos max will overflow
            long N = n;
            if(N < 0) {
                N = -N;
                x = 1/x;
            }
            return p(x, N); 
        }
		// for loop solution
		double p(double x, long n) {
			 double base = x;
			 double resisual = 1;
			 for(long i = n; i > 1; i /= 2) {
				 if(i%2 == 1) resisual *= base; 
				 base *= base;
			 }
			 return resisual*base;
		}
}
