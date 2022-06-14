import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class itemDisplayPage extends JFrame {
	
	JFrame frame = new JFrame();
	ImageIcon itemDisplay;
	JLabel Img1;
	JLabel itemAgeProperty;
	JLabel itemNameProperty;
	JLabel itemAppreciationRateProperty;
	JLabel itemLiquidityProperty;
	JLabel itemPriceProperty;
	
	public itemDisplayPage() throws IOException {
		
		// Picks random item from the number of items available
		int itemNumber = ((int) (Math.random()*10) + 1);
		
		// Assign item properties to variables for convenience in using
		String currentRoundItemName = itemName(itemNumber);
		String currentRoundImage = itemImage(itemNumber);
		int currentRoundYearItemMade = yearItemMade(itemNumber);
		int currentRoundItemPrice = itemPrices(itemNumber);
		int currentRoundItemAppreciationRate = itemAppreciationRate(itemNumber);
		int currentRoundItemLiquidity = itemLiquidity(itemNumber);

		frame.setLayout(null);
		
		itemDisplay = new ImageIcon(this.getClass().getResource(currentRoundImage));
		Image image = itemDisplay.getImage();
        Image newImg = image.getScaledInstance(450, 350,  java.awt.Image.SCALE_SMOOTH);
        itemDisplay = new ImageIcon(newImg);
		Img1 = new JLabel(itemDisplay);
		Img1.setBounds(200, -240, 800, 800);
		
		itemNameProperty = new JLabel("Item Name: " + currentRoundItemName);
		itemNameProperty.setFont(new Font("Impact", Font.PLAIN, 35));
		itemNameProperty.setBounds(400,350,800,40);
		
		itemPriceProperty = new JLabel("Starting Price: " + currentRoundItemPrice);
		itemPriceProperty.setFont(new Font("Impact", Font.PLAIN, 35));
		itemPriceProperty.setBounds(400,410,800,40);
		
		itemAgeProperty = new JLabel("Year Made: " + currentRoundYearItemMade);
		itemAgeProperty.setFont(new Font("Impact", Font.PLAIN, 35));
		itemAgeProperty.setBounds(400,470,800,40);
		
		itemAppreciationRateProperty = new JLabel("Appreciation Rate (Per Round): " + currentRoundItemAppreciationRate);
		itemAppreciationRateProperty.setFont(new Font("Impact", Font.PLAIN, 35));
		itemAppreciationRateProperty.setBounds(400,530,800,40);
		
		itemLiquidityProperty = new JLabel("Liquidity Rate (Scale from 1 (Worst) - 10 (Best): " + currentRoundItemLiquidity);
		itemLiquidityProperty.setFont(new Font("Impact", Font.PLAIN, 35));
		itemLiquidityProperty.setBounds(400,590,800,50);
		
		
		
		frame.add(itemNameProperty);
		frame.add(itemAgeProperty);
		frame.add(itemPriceProperty);
		frame.add(itemAppreciationRateProperty);
		frame.add(itemLiquidityProperty);
		frame.add(Img1);
		
		
		
		frame.setSize(1275, 775);
		Color color2 = new Color (195, 195, 0);
		frame.getContentPane().setBackground(color2);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}

	public static void main(String[] args) throws IOException {
		
		new itemDisplayPage();
		
		
		
		
		
		
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
