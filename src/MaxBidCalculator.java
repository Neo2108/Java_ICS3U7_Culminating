// OOP Class
public class MaxBidCalculator {
	
	private static MaxBidCalculator maxBidSingleton = new MaxBidCalculator();
	
	private MaxBidCalculator() {}
	
	public static MaxBidCalculator getInstance() {
		return maxBidSingleton;
	}
	
	// Initializing variables needed for determining maxBids, number of rounds left in each game, and bidWinner
	private int maxBid;
	private int numRounds;
	private String bidWinner;
	
	// SETTER Methods
	public void setBidWinner(String playerName) {
		this.bidWinner = playerName;
	}
	
	public void setNumRounds(int num) {
		this.numRounds = num;
	}
	
	public void setBidValue(int receivedValue) {
		this.maxBid = receivedValue;
	}
	
	// GETTER Methods
	public int getNumRounds() {
		return this.numRounds;
	}
	
	public int getBidValue() {
		return this.maxBid;
	}
	
	public String getBidWinner() {
		return this.bidWinner;
	}

	

}
