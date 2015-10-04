
public class Main {

	public static void main(String[] args) {
		
		Stock s1 = new Stock("ORCL", "Oracle Corporation");
		
		s1.previousClosingPrice = 34.5;
		s1.currentPrice = 34.35;
		
		System.out.printf("Percentage change: %4.2f", s1.getChangePercent());
		
	}//end main
	
}//end class
