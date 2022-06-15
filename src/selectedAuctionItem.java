public class selectedAuctionItem {
	
	private static selectedAuctionItem itemSelectedSingleton = new selectedAuctionItem();
	
	private selectedAuctionItem() {}
	
	public static selectedAuctionItem getInstance() {
		return itemSelectedSingleton;
	}
	private String name;
	private int yearMade;
	private int appreciationRate;
	private int liquidity;
	private int price;
	
	public void setItemName(String itemName) {
		this.name = itemName;
	}
	
	public void setYearMade(int yearItemMade) {
		this.yearMade = yearItemMade;
	}
	
	public void setAppreciationRate(int itemAppRate) {
		this.appreciationRate = itemAppRate;
	}
	
	public void setPrice(int itemPrice) {
		this.price = itemPrice;
	}
	
	public void setLiquidity(int itemLiquidity) {
		this.liquidity = itemLiquidity;
	}
	
	public String getItemName() {
		return this.name;
	}
	
	public int getYearMade() {
		return this.yearMade;
	}
	
	public int getAppreciationRate() {
		return this.appreciationRate;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getLiquidity() {
		return this.liquidity;
	}

	

}