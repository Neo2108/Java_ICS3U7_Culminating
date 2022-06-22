public class SinglePlayerDataProperties {
	
	private static SinglePlayerDataProperties itemSelectedSingleton = new SinglePlayerDataProperties();
	
	private SinglePlayerDataProperties() {}
	
	public static SinglePlayerDataProperties getInstance() {
		return itemSelectedSingleton;
	}
	private String name;
	private int age;
	private int purseValue;
	private String occupation;
	private int gameWinner;
	private int winningBid;
	
	public void setPlayerName(String playerName) {
		this.name = playerName;
	}
	
	public void setPlayerAge(int playerAge) {
		this.age = playerAge;
	}
	
	public void setPurseValue(int cashAmount) {
		this.purseValue = cashAmount;
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
	
	
	public int getPurseValue() {
		return this.purseValue;
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