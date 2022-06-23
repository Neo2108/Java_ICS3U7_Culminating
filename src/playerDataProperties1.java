public class PlayerDataProperties1 {
	
	private static PlayerDataProperties1 itemSelectedSingleton = new PlayerDataProperties1();
	
	private PlayerDataProperties1() {}
	
	public static PlayerDataProperties1 getInstance() {
		return itemSelectedSingleton;
	}
	private String name;
	private int age;
	private int purseValue;
	private String occupation;
	private int gameWinner;
	private int winningBid;
	private String gameMode;
	private int netWorth;
	
	public void setPlayerName(String playerName) {
		this.name = playerName;
	}
	
	public void setGameMode(String mode) {
		this.gameMode = mode;
	}
	
	public void setPlayerAge(int playerAge) {
		this.age = playerAge;
	}
	
	public void setPurseValue(int cashAmount) {
		this.purseValue = cashAmount;
	}
	
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
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
	
	public String getPlayerName() {
		return this.name;
	}
	
	public int getPlayerAge() {
		return this.age;
	}
	
	public String getGameMode() {
		return this.gameMode;
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