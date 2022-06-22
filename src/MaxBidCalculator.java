
public class MaxBidCalculator {
	
	private static MaxBidCalculator maxBidSingleton = new MaxBidCalculator();
	
	private MaxBidCalculator() {}
	
	public static MaxBidCalculator getInstance() {
		return maxBidSingleton;
	}
	private int maxBid;
	private int numRounds;
	private String bidWinner;
	
	public void setBidWinner(String playerName) {
		this.bidWinner = playerName;
	}
	
	public void setNumRounds(int num) {
		this.numRounds = num;
	}
	
	public String getBidWinner() {
		return this.bidWinner;
	}
	
	public void setBidValue(int receivedValue) {
		this.maxBid = receivedValue;
	}
	
	public int getNumRounds() {
		return this.numRounds;
	}
	
	public int getBidValue() {
		return this.maxBid;
	}

	

}
