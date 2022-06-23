public class ComputerDataProperties {
	
	private static ComputerDataProperties itemSelectedSingleton = new ComputerDataProperties();
	
	private ComputerDataProperties() {}
	
	public static ComputerDataProperties getInstance() {
		return itemSelectedSingleton;
	}

	private int purseValue;
	private int gameWinner;
	private int winningBid;
	private int netWorth;
	
	
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