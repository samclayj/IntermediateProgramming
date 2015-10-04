/*Project 8
  Samuel Jentsch
  CSC_202*/

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("Samuel Jentsch");
		
		 /***Run for 50 numbers***/
		 for(int i = 1; i <= 45; i++) {
			 
			 /***Call fibonacci recursively***/
			 long sTime = System.nanoTime();
			 System.out.printf("Index: %d Fib Recursive: %d Time: %d\n", i, fibR(i), (System.nanoTime() - sTime));

			 /***Call fibonacci iteratively***/
//		 	 sTime = System.nanoTime();
	//		 System.out.printf("Index: %d Fib Iterative: %d Time: %d\n", i, fibI(i), (System.nanoTime() - sTime));
			 
			 /***Call fibonacci closed form***/
		//	 sTime = System.nanoTime();
			// System.out.printf("Index: %d Fib Closed: %d Time: %d\n", i, fibC(i), (System.nanoTime() - sTime));
			 
			 System.out.println();
		 }//end for
	
	}//end main
	
	public static long fibR(long n) {
		//Recursive form uses recursive method.
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibR(n-1) + fibR(n-2);
	}//end fibR (recursively)
	
	public static long fibI(long n) {
		//Iterative form uses loop
		if(n == 1)
			return 1;
		
		long fibNum = 0;
		
		long n1 = 0;
		long n2 = 1;
		for(int i = 1; i < n; i++) {
			fibNum = n1 + n2; //Previous + Previous
			n1 = n2; //Move n1 up
			n2 = fibNum; //Move n2 up
		}
		
		return fibNum;
	}//end fibI (iteratively)
	
	public static long fibC(long n) {
		if(n == 1)
			return 1;
		
		//Closed form using equation
		double x = ((1 + Math.pow(5, 0.5)) / 2);
		double y = ((1 - Math.pow(5, 0.5)) / 2);
		double answer = ((Math.pow(Math.abs(x), n) - Math.pow(Math.abs(y), n)) / Math.pow(5, 0.5));
		return (long)Math.round(answer);
	}
		
}
