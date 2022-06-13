
public class biddingRound {

	public static void main(String[] args) {
		
		int itemNumber = ((int) (Math.random()*12));
		
		String currentRoundItem = itemName(itemNumber);
		String currentRoundImage = itemImage(itemNumber);
		int currentRoundYearItemMade = yearItemMade(itemNumber);
		int currentRoundItemPrice = itemPrices(itemNumber);
		int currentRoundItemAppreciationRate = itemAppreciationRate(itemNumber);
		int currentRoundItemLiquidity = itemLiquidity(itemNumber);
		
		System.out.println(currentRoundItem);
		System.out.println(currentRoundImage);
		System.out.println(currentRoundYearItemMade);
		System.out.println(currentRoundItemPrice);
		System.out.println(currentRoundItemAppreciationRate);
		System.out.println(currentRoundItemLiquidity);
		
	}

	
	public static String itemName(int itemNumber) {
		
		String[] itemNames = {"Anglo-Austrian Urn", "Silver Japanese Dining Goblet", "British Ballroom Gramophone", "Napoleon-era Parisian Mirror", "Al Capone's Bedside Telephone", "Gilded Porcelain Carousel", "Vintage Portuguese Lamp", "Thousand-year old Roman Clock", "Persian Astronomy Globe", "19th Century Chrysanthemum Oil Painting", "WW1-era British Vintage Car"};
		return itemNames[itemNumber];
	}
	
	public static String itemImage(int itemNumber) {
		
		String[] itemImages = {"ImagesFolder1/Item1.png", "ImagesFolder1/Item2.png", "ImagesFolder1/Item3.png", "ImagesFolder1/Item4.png", "ImagesFolder1/Item5.png", "ImagesFolder1/Item6.png", "ImagesFolder1/Item7.png", "ImagesFolder1/Item8.png", "ImagesFolder1/Item9.png", "ImagesFolder1/Item10.png", "ImagesFolder1/Item11.png"};
		return itemImages[itemNumber];
	}
	
	public static int yearItemMade(int itemNumber) {
		
		int[] yearMade = {1880, 1630, 1925, 1795, 1915, 1952, 1875, 1120, 1350, 1973, 1941};
		return yearMade[itemNumber];
	}
	
	public static int itemPrices(int itemNumber) {
		
		// Prices are in USD
		int [] startingPrices = {75000, 60000, 50000, 150000, 100000, 40000, 80000, 300000, 75000, 175000, 400000};
		return startingPrices[itemNumber];
	}
	
	public static int itemAppreciationRate(int itemNumber) {
		
		// Integers are displayed in percent (FOR EXAMPLE: 7 -> 7%)
		int [] appreciationRate = {7, 9, 4, 9, 10, 5, 7, 14, 12, 18, 2};
		return appreciationRate[itemNumber];
	}
	
	public static int itemLiquidity(int itemNumber) {
		
		// Liquidity is shown on a scale from 1 - 10 (1 being the worst, and 10 being the best)
		int [] liquidity = {3, 2, 4, 3, 7, 6, 8, 2, 5, 2, 8};
		return liquidity[itemNumber];
	}
	
	
	
	
	
	
	
	
	
	

}
