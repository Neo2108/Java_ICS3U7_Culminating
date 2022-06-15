
public class MaxBidCalculator {
	
	private static MaxBidCalculator maxBidSingleton = new MaxBidCalculator();
	
	private MaxBidCalculator() {}
	
	public static MaxBidCalculator getInstance() {
		return maxBidSingleton;
	}
	private int maxBid;
	
	public void setBidValue(int receivedValue) {
		this.maxBid = receivedValue;
	}
	
	public int getBidValue() {
		return this.maxBid;
	}

	

}
