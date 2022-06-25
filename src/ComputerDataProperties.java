/**
 * This class is for showing the computer's various data properties and etc.
 * @author Nischae Tiwari
 */

// OOP Class
public class ComputerDataProperties {
	
	private static ComputerDataProperties itemSelectedSingleton = new ComputerDataProperties();
	
	private ComputerDataProperties() {}
	
	public static ComputerDataProperties getInstance() {
		return itemSelectedSingleton;
	}

	// Initializing variables needed for computerProperties
	private int purseValue;
	private int gameWinner;
	private int winningBid;
	private int netWorth;
	
	// SETTER Methods
	public void setPurseValue(int cashAmount) {
		this.purseValue = cashAmount;
	}
	
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}
	
	public void setGameWinner(int winner) {
		this.gameWinner = winner;
	}
	
	public void setWinningBid(int bid) {
		this.winningBid = bid;
	}
	
	// GETTER Methods
	public int getPurseValue() {
		return this.purseValue;
	}
	
	public int getNetWorth() {
		return this.netWorth;
	}
	
	public int getGameWinner() {
		return this.gameWinner;
	}
	
	public int getWinningBid() {
		return this.winningBid;
	}

	

}