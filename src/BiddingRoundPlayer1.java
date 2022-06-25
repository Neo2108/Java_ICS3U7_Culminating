/**
 * This class is for the user to decide whether to bid, not bid, or continue bidding in the round (Player 1 in multiplayer)
 * @author Nischae Tiwari
 */

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.event.*;

public class BiddingRoundPlayer1 extends JFrame implements ActionListener {
	
	// Initializing variables needed for displaying various GUI Elements
	JFrame frame = new JFrame();
	java.util.Timer timer = new java.util.Timer();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	int actualMaxBid = maxBid1.getBidValue();
	JTextField player1Bid;
	JLabel playerName;
	JLabel bidPrompt;
	JLabel dollarSign;
	public static int secondsLeft = 15;
	JLabel maxBidDisplay;
	public int player1BidValue;
	JLabel countdownDisplay;
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
	
	public BiddingRoundPlayer1() throws IOException {
		
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
			
			if (userData1.getPurseValue() == 0) {
				userData1.setPurseValue(1000000);
				userData1.setNetWorth(1000000);
			}
			
			if (userData2.getPurseValue() == 0) {
				userData2.setPurseValue(1000000);
				userData2.setNetWorth(1000000);
			}
			
			playerName = new JLabel(userData1.getPlayerName()+"");
			playerName.setFont(new Font("Impact", Font.PLAIN, 70));
			playerName.setBounds(0,20,1275,150);
			playerName.setHorizontalAlignment(JLabel.CENTER);
			playerName.setForeground(astronautBlue);
			
			bidPrompt = new JLabel("You have $" + userData1.getPurseValue());
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(0,145,1275,90);
			bidPrompt.setHorizontalAlignment(JLabel.CENTER);
			bidPrompt.setForeground(astronautBlue);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + actualMaxBid);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(500,320+30,1275,90);
			maxBidDisplay.setForeground(astronautBlue);

			if (maxBid1.getNumRounds() == 0) {
				userData1.setPurseValue(1000000);
			}

			startingPrice = new JLabel("Starting Price of Item: $" + itemSelected.getPrice());
			startingPrice.setFont(new Font("Impact", Font.PLAIN, 30));
			startingPrice.setBounds(500,360+30,800,90);
			startingPrice.setForeground(astronautBlue);
		
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 30));
			dollarSign.setBounds(475,217,800,90);
			dollarSign.setForeground(astronautBlue);
			
			player1Bid = new JTextField();
			player1Bid.setBounds(500, 240, 150, 45);			
			
			counterLabel = new JLabel();
			counterLabel.setBounds(30, 30, 100, 100);
			counterLabel.setFont(font1);
			counterLabel.setForeground(astronautBlue);
			
			// Add all elements onto JFrame
			frame.add(submitBid);
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(player1Bid);
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
		    timer.schedule(new TimerTask() 
		    			{
			            @Override
			            public void run() {
			            	
			            	frame.dispose();
			            	timer.cancel();
			            	maxBid1.setBidWinner(userData2.getPlayerName());
			            	maxBid1.setBidValue(maxBid1.getBidValue()/2);			            	
			            	userData2.setPurseValue(userData2.getPurseValue() - maxBid1.getBidValue());
			            	
			                try {
			  				  RoundWinPage1 roundWinner = new RoundWinPage1();
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
		second = 15;
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
		new BiddingRoundPlayer1();
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
			  
			  frame.dispose();
			  timer.cancel();
			  
			  try {
				  player1BidValue = Integer.parseInt(player1Bid.getText()); 
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
			  if (player1BidValue > actualMaxBid && player1BidValue > itemSelected.getPrice() && userData1.getPurseValue() > player1BidValue) {
				  
				  maxBid1.setBidValue(player1BidValue);
				  maxBid1.setBidWinner(userData1.getPlayerName());
				  
				  try {
					  BiddingRoundPlayer2 player2Turn = new BiddingRoundPlayer2();
					  
				  } 
				  catch (IOException e1) {
					  e1.printStackTrace();
				  }
			  }
			// If user-entered bid is inappropriate, display exception Page, and ask user to re-enter an appropriate bid
			  else if (player1BidValue < actualMaxBid || actualMaxBid < itemSelected.getPrice() || userData1.getPurseValue() <= player1BidValue) {
				  try {
					  BiddingRoundPlayer1 player2Turn = new BiddingRoundPlayer1();
					  
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
			  timer.cancel();
			  maxBid1.setBidWinner(userData2.getPlayerName());
          	  maxBid1.setBidValue(maxBid1.getBidValue()/2);
          	  userData2.setPurseValue(userData2.getPurseValue() - maxBid1.getBidValue());
			  
			  
			  try {
				  RoundWinPage1 winnerShow = new RoundWinPage1();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
