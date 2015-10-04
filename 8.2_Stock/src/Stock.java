
public class Stock {

	/***Data Fields***/
	String symbol;
	String name;
	double previousClosingPrice = 0;
	double currentPrice = 0;
	
	public Stock(String s, String n) {
		
	}//end Stock
	
	//Work on finding percent
	public double getChangePercent() {
		
		double percent = ((currentPrice - previousClosingPrice)/previousClosingPrice) * 100;

		return percent;
		
	}//end GetChangePercent
	
}
