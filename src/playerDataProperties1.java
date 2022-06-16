public class playerDataProperties1 {
	
	private static playerDataProperties1 itemSelectedSingleton = new playerDataProperties1();
	
	private playerDataProperties1() {}
	
	public static playerDataProperties1 getInstance() {
		return itemSelectedSingleton;
	}
	private String name;
	private int age;
	private String occupation;
	private int gameWinner;
	
	public void setPlayerName(String playerName) {
		this.name = playerName;
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
	
	public String getPlayerName() {
		return this.name;
	}
	
	public int getPlayerAge() {
		return this.age;
	}
	
	public String getPlayerOccupation() {
		return this.occupation;
	}
	
	public int getGameWinner() {
		return this.gameWinner;
	}

	

}