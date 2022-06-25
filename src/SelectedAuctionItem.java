/**
 * This class is for getting the properties of the items up for auction
 * @author Nischae Tiwari
 */

// OOP Class
public class SelectedAuctionItem {
	
	private static SelectedAuctionItem itemSelectedSingleton = new SelectedAuctionItem();
	
	private SelectedAuctionItem() {}
	
	public static SelectedAuctionItem getInstance() {
		return itemSelectedSingleton;
	}
	
	// Initialize variables needed for itemProperties
	private String name;
	private int yearMade;
	private int appreciationRate;
	private int liquidity;
	private int price;
	
	// SETTER Methods
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
	
	// GETTER Methods
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
