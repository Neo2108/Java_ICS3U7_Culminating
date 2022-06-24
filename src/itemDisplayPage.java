import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ItemDisplayPage extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	MaxBidCalculator maxBid = MaxBidCalculator.getInstance();
	ImageIcon itemDisplay;
	JLabel Img1;
	JLabel itemAgeProperty;
	JLabel itemNameProperty;
	JLabel itemAppreciationRateProperty;
	JLabel itemLiquidityProperty;
	JLabel itemPriceProperty;
	JButton rulesBackButton;
	JButton glossaryBackButton;
	JButton continueButton;
	JLabel continueButtonMessage1;
	JLabel continueButtonMessage2;
	public String currentRoundItemName;
	public String currentRoundImage;
	public int currentRoundYearItemMade;
	public int currentRoundItemPrice;
	public int currentRoundItemAppreciationRate;
	public int currentRoundItemLiquidity;
	
	
	public ItemDisplayPage() throws IOException {
		
		// Picks random item from the number of items available
		
		int itemNumber = ((int) (Math.random()*10) + 1);
		int[] itemNumberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		
		
		// Assign item properties to variables for convenience in using
		currentRoundItemName = itemName(itemNumber);
		itemSelected.setItemName(currentRoundItemName);
		currentRoundImage = itemImage(itemNumber);
		currentRoundYearItemMade = yearItemMade(itemNumber);
		itemSelected.setYearMade(currentRoundYearItemMade);
		currentRoundItemPrice = itemPrices(itemNumber);
		itemSelected.setPrice(currentRoundItemPrice);
		currentRoundItemAppreciationRate = itemAppreciationRate(itemNumber);
		itemSelected.setAppreciationRate(currentRoundItemAppreciationRate);
		currentRoundItemLiquidity = itemLiquidity(itemNumber);
		itemSelected.setLiquidity(currentRoundItemLiquidity);

		frame.setLayout(null);
		
		rulesBackButton = new JButton("Rules");
		rulesBackButton.setBounds(1140, 20, 100, 40);
		rulesBackButton.addActionListener(this);
		rulesBackButton.setBackground(Color.LIGHT_GRAY);
		
		glossaryBackButton = new JButton("Glossary");
		glossaryBackButton.setBounds(1140, 70, 100, 40);
		glossaryBackButton.addActionListener(this);
		glossaryBackButton.setBackground(Color.LIGHT_GRAY);
		
		continueButton = new JButton("Proceed");
		continueButton.setBounds(120, 200, 150, 60);
		continueButton.addActionListener(this);
		continueButton.setBackground(Color.LIGHT_GRAY);
		
		continueButtonMessage1 = new JLabel("Player 1 will have 10 seconds to place their bid");
		continueButtonMessage1.setFont(new Font("Barlow", Font.PLAIN, 20));
		continueButtonMessage1.setBounds(20,250+1*20,8000,30);
		continueButtonMessage1.setForeground(Color.white);
		
		continueButtonMessage2 = new JLabel("Press only when fully prepared to play");
		continueButtonMessage2.setFont(new Font("Barlow", Font.PLAIN, 20));
		continueButtonMessage2.setBounds(20,250+2*20,8000,30);
		continueButtonMessage2.setForeground(Color.white);
		
		itemDisplay = new ImageIcon(this.getClass().getResource(currentRoundImage));
		Image image = itemDisplay.getImage(); // 450, 350
        Image newImg = image.getScaledInstance(image.getWidth(null)*350/image.getHeight(null), 350,  java.awt.Image.SCALE_SMOOTH);
        itemDisplay = new ImageIcon(newImg);
		Img1 = new JLabel(itemDisplay);
		int imgWidth = newImg.getWidth(null);
		int imgHeight = newImg.getHeight(null);
		Img1.setBounds((1275-imgWidth)/2, 30, imgWidth, imgHeight);
		
		itemNameProperty = new JLabel("Item Name: " + currentRoundItemName);
		itemNameProperty.setFont(new Font("Barlow", Font.PLAIN, 25));
		itemNameProperty.setBounds(400,450+1*30,800,40);
		itemNameProperty.setForeground(Color.white);
		
		itemPriceProperty = new JLabel("Starting Price: " + currentRoundItemPrice);
		itemPriceProperty.setFont(new Font("Barlow", Font.PLAIN, 25));
		itemPriceProperty.setBounds(400,450+2*30,800,30);
		itemPriceProperty.setForeground(Color.white);
		
		itemAgeProperty = new JLabel("Year Made: " + currentRoundYearItemMade);
		itemAgeProperty.setFont(new Font("Barlow", Font.PLAIN, 25));
		itemAgeProperty.setBounds(400,450+3*30,800,30);
		itemAgeProperty.setForeground(Color.white);
		
		itemAppreciationRateProperty = new JLabel("Appreciation Rate (Per Round): " + currentRoundItemAppreciationRate + "%");
		itemAppreciationRateProperty.setFont(new Font("Barlow", Font.PLAIN, 25));
		itemAppreciationRateProperty.setBounds(400,450+4*30,800,30);
		itemAppreciationRateProperty.setForeground(Color.white);
		
		itemLiquidityProperty = new JLabel("Liquidity Rate (1 being worst and 10 being best): " + currentRoundItemLiquidity);
		itemLiquidityProperty.setFont(new Font("Barlow", Font.PLAIN, 25));
		itemLiquidityProperty.setBounds(400,450+5*30,800,30);
		itemLiquidityProperty.setForeground(Color.white);
		

		frame.add(itemNameProperty);
		frame.add(itemAgeProperty);
		frame.add(itemPriceProperty);
		frame.add(itemAppreciationRateProperty);
		frame.add(itemLiquidityProperty);
		frame.add(Img1);
		frame.add(glossaryBackButton);
		frame.add(continueButton);
		frame.add(continueButtonMessage1);
		frame.add(continueButtonMessage2);
		frame.add(rulesBackButton);
		
		
		frame.setSize(1275, 775);
		Color color2 = new Color (32, 82, 92);
		frame.getContentPane().setBackground(color2);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}

	public static void main(String[] args) throws IOException {
		
		new ItemDisplayPage();
		
	}

	public static String itemName(int itemNumber) {
		
		String[] itemNames = {"Anglo-Austrian Urn", "Silver Japanese Dining Goblet", "British Ballroom Gramophone", "Napoleon-era Parisian Mirror", "Al Capone's Bedside Telephone", "Gilded Porcelain Carousel", "Vintage Portuguese Lamp", "Thousand-year old Roman Clock", "Persian Astronomy Globe", "19th Century Chrysanthemum Oil Painting", "WW2-era British Vintage Car"};
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rulesBackButton) {
			  
			  //frame.dispose();
			  
			  try {
				  Rules newRulesPage = new Rules();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  
		  else if (e.getSource() == glossaryBackButton) {
			  
			  //frame.dispose();
			  
			  try {
				  Glossary howToPlay = new Glossary();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
		  else if (e.getSource() == continueButton) {
			  
			  frame.dispose();
			  
			  try {
				  if (userData1.getGameMode().equals("Singleplayer")) {
					  maxBid.setNumRounds(maxBid.getNumRounds()+1);
					  maxBid.setBidValue(0);
					  maxBid.setBidWinner(null);
					  BiddingRoundSinglePlayer askFirstBid = new BiddingRoundSinglePlayer();
				  }
				  
				  else if (userData1.getGameMode().equals("Multiplayer")) {
					  maxBid.setNumRounds(maxBid.getNumRounds()+1);
					  maxBid.setBidValue(0);
					  maxBid.setBidWinner(null);
					  BiddingRoundPlayer1 askFirstBid = new BiddingRoundPlayer1();
				  }
				  
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}
	
}
