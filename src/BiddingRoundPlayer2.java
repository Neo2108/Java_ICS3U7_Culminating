/**
 * This class is for the user to decide whether to bid, not bid, or continue bidding in the round (Player 2 in multiplayer)
 * @author Nischae Tiwari
 */

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.event.*;

public class BiddingRoundPlayer2 extends JFrame implements ActionListener {
	
	// Initializing variables needed for displaying various GUI Elements
	JFrame frame = new JFrame();
	java.util.Timer timer2 = new java.util.Timer();
	MaxBidCalculator maxBid2 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	int actualMaxBid = maxBid2.getBidValue();
	JTextField player2Bid;
	JLabel playerName;
	JLabel bidPrompt;
	JLabel dollarSign;
	public static int secondsLeft = 15;
	int player2BidValue;
	JLabel maxBidDisplay;
	JLabel player1BidDisplay;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	JButton endBid;
	JLabel startingPrice;

	// Countdown display (VISUAL)
	JLabel counterLabel;
	Font font1 = new Font("Impact", Font.PLAIN, 70);
	javax.swing.Timer countdown;
	int second;
	String formattedSecond;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public BiddingRoundPlayer2() throws IOException {
		Color mindara = new Color (223, 230, 103);
		Color astronautBlue = new Color (32, 82, 92);
		
			frame.setLayout(null);
			
			rulesBackButton = new JButton("Rules");
			rulesBackButton.setBounds(1140, 20, 100, 40);
			rulesBackButton.addActionListener(this);
			rulesBackButton.setBackground(Color.LIGHT_GRAY);
			
			glossaryBackButton = new JButton("Glossary");
			glossaryBackButton.setBounds(1140, 70, 100, 40);
			glossaryBackButton.addActionListener(this);
			glossaryBackButton.setBackground(Color.LIGHT_GRAY);
			
			submitBid = new JButton("Submit Bid");
			submitBid.setBounds(500+100, 300, 100, 40);
			submitBid.addActionListener(this);
			submitBid.setBackground(Color.LIGHT_GRAY);
			
			endBid = new JButton("End Bid");
			endBid.setBounds(500, 300, 100, 40);
			endBid.addActionListener(this);
			endBid.setBackground(Color.LIGHT_GRAY);
			
			if (userData2.getPurseValue() == 0) {
				userData2.setPurseValue(1000000);
				userData2.setNetWorth(1000000);
			}
			
			if (userData1.getPurseValue() == 0) {
				userData1.setPurseValue(1000000);
				userData1.setNetWorth(1000000);
			}
			
			playerName = new JLabel(userData2.getPlayerName()+"");
			playerName.setFont(new Font("Impact", Font.PLAIN, 70));
			playerName.setBounds(0,20,1275,150);
			playerName.setHorizontalAlignment(JLabel.CENTER);
			playerName.setForeground(astronautBlue);

			bidPrompt = new JLabel("You have $" + userData2.getPurseValue());
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(0,145,1275,90);
			bidPrompt.setHorizontalAlignment(JLabel.CENTER);
			bidPrompt.setForeground(astronautBlue);

			maxBidDisplay = new JLabel("Max bid so far: $" + actualMaxBid);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(500,320+30,1275,90);
			maxBidDisplay.setForeground(astronautBlue);

			startingPrice = new JLabel("Starting Price of Item: $" + itemSelected.getPrice());
			startingPrice.setFont(new Font("Impact", Font.PLAIN, 30));
			startingPrice.setBounds(500,360+30,800,90);
			startingPrice.setForeground(astronautBlue);
			
			if (maxBid2.getNumRounds() == 0) {
				userData1.setPurseValue(1000000);
			}

			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 30));
			dollarSign.setBounds(475,217,800,90);
			dollarSign.setForeground(astronautBlue);

			player2Bid = new JTextField();
			player2Bid.setBounds(500, 240, 150, 45);
			
			counterLabel = new JLabel();
			counterLabel.setBounds(30, 30, 100, 100);
			counterLabel.setFont(font1);
			counterLabel.setForeground(astronautBlue);
			
			// Add all elements onto JFrame
			frame.add(submitBid);
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(player2Bid);
			frame.add(bidPrompt);
			frame.add(dollarSign);
			frame.add(maxBidDisplay);
			frame.add(endBid);
			frame.add(startingPrice);
			frame.add(counterLabel);
			frame.add(playerName);
			
			// Basics and fundamentals of JFrame added on 
			frame.setSize(1275, 775);
			frame.getContentPane().setBackground(mindara);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		    
			countdownTimer();
			countdown.start();	
			
			// Start IN-GAME Timer
		    timer2.schedule( 
			        new java.util.TimerTask() {
			           
			            public void run() {
			            	
			            	frame.dispose();
			  			    timer2.cancel();
			  			    maxBid2.setBidWinner(userData1.getPlayerName());
			  			    maxBid2.setBidValue(maxBid2.getBidValue()/2);
			            	userData1.setPurseValue(userData1.getPurseValue() - maxBid2.getBidValue());
			               
			                try {
			  				  RoundWinPage1 roundWinner2 = new RoundWinPage1();
			  			  	} 
			  			  	catch (IOException e1) {
			  			  		e1.printStackTrace();
			  			  	}
			                
			            }
			        }, 
			        15000 
			);
		    
		}
	
	 // Start VISUAL Display Timer
	 public void countdownTimer() {
		 counterLabel.setText("15");
		 second =15;
		 countdown = new Timer(1000, new ActionListener() {
		 @Override
		 public void actionPerformed(ActionEvent e) {
		 second--;
		 formattedSecond = dFormat.format(second);
		 counterLabel.setText(formattedSecond);
		 if(second==0) {
		 countdown.stop();
		 }
		 }
		 });
		 }
		  
	// Call Page 
	public static void main(String[] args) throws IOException {
		new BiddingRoundPlayer2();

	}

	// Open Rules BackButton, if user clicks on it
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rulesBackButton) {
			  
			  try {
				  Rules newRulesPage1 = new Rules();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		
		// Open Glossary BackButton, if user clicks on it
		  else if (e.getSource() == glossaryBackButton) {

			  try {
				  Glossary howToPlay1 = new Glossary();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		// Button to confirm bid, that user types in, in the textfield
		  else if (e.getSource() == submitBid) {
			  
			  timer2.cancel();
			  frame.dispose();


			  try {
				  player2BidValue = Integer.parseInt(player2Bid.getText()); 
				  }
				  catch (final NumberFormatException illegal) {
					  try {
						ExceptionPage errorOccurred = new ExceptionPage();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  }
			  
			// Makes sure user-entered bid is appropriate, if it is - > moves on to computer's turn
			  if (player2BidValue > actualMaxBid && player2BidValue > itemSelected.getPrice() && userData2.getPurseValue() > player2BidValue) {
				  
				  maxBid2.setBidValue(player2BidValue);
				  maxBid2.setBidWinner(userData2.getPlayerName());
				  
				  try {
					  BiddingRoundPlayer1 player1Turn = new BiddingRoundPlayer1();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
			  }
			  
			// If user-entered bid is inappropriate, display exception Page, and ask user to re-enter an appropriate bid
			  else if (player2BidValue < actualMaxBid || actualMaxBid < itemSelected.getPrice() || userData2.getPurseValue() <= player2BidValue) {
				  try {
					  BiddingRoundPlayer2 player1Turn = new BiddingRoundPlayer2();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
				  
				  try {
					  ExceptionPage errorOcurred = new ExceptionPage();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
				  
			  }
			  

		  }
		
		// If user decides not to bid anymore, they can simply end the bid, meaning the other plays wins
		  else if (e.getSource() == endBid) {
			  
			  frame.dispose();
			  timer2.cancel();
			  maxBid2.setBidWinner(userData1.getPlayerName());
			  maxBid2.setBidValue(maxBid2.getBidValue()/2);
          	  userData1.setPurseValue(userData1.getPurseValue() - maxBid2.getBidValue());
			  
			  try {
				  RoundWinPage1 winnerShow = new RoundWinPage1();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
