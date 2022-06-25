// OOP Class
public class PlayerDataProperties2 {
	
	private static PlayerDataProperties2 itemSelectedSingleton = new PlayerDataProperties2();
	
	private PlayerDataProperties2() {}
	
	public static PlayerDataProperties2 getInstance() {
		return itemSelectedSingleton;
	}
	
	// Initializing variables needed for playerData2Properties
	private String name;
	private int purseValue;
	private int age;
	private String occupation;
	private int gameWinner;
	private int winningBid;
	private int netWorth;
	
	// SETTER Methods
	public void setPlayerName(String playerName) {
		this.name = playerName;
	}
	
	public void setPurseValue(int cashAmount) {
		this.purseValue = cashAmount;
	}
	
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}
	
	public void setPlayerAge(int playerAge) {
		this.age = playerAge;
	}
	
	public void setPlayerOccupation(String playerOccupation) {
		this.occupation = playerOccupation;
	}
	
	public void setGameWinner(int winner) {
		this.gameWinner = winner;
	}
	
	public void setWinningBid(int bid) {
		this.winningBid = bid;
	}
	
	// GETTER Methods
	public String getPlayerName() {
		return this.name;
	}
	
	public int getPlayerAge() {
		return this.age;
	}
	
	public int getPurseValue() {
		return this.purseValue;
	}
	
	public int getNetWorth() {
		return this.netWorth;
	}
	
	public String getPlayerOccupation() {
		return this.occupation;
	}
	
	public int getGameWinner() {
		return this.gameWinner;
	}
	
	public int getWinningBid() {
		return this.winningBid;
	}

	

}