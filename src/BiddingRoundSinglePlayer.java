import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.event.*;

public class BiddingRoundSinglePlayer extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	java.util.Timer timer = new java.util.Timer();
	MaxBidCalculator maxBid = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	SinglePlayerDataProperties playerData = SinglePlayerDataProperties.getInstance();
	ComputerDataProperties computerData = ComputerDataProperties.getInstance();
	int actualMaxBid = maxBid.getBidValue();
	JTextField singlePlayerBid;
	JLabel playerName;
	JLabel bidPrompt;
	JLabel dollarSign;
	public static int secondsLeft = 15;
	JLabel maxBidDisplay;
	public int singlePlayerBidValue;
	JLabel countdownDisplay;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	JButton endBid;
	JLabel startingPrice;
	
	// countdown
	JLabel counterLabel;
	Font font1 = new Font("Impact", Font.PLAIN, 70);	
	javax.swing.Timer countdown;	
	int second;
	String formattedSecond;	
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public BiddingRoundSinglePlayer() throws IOException {
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
			
			playerName = new JLabel(playerData.getPlayerName()+"");
			playerName.setFont(new Font("Impact", Font.PLAIN, 70));
			playerName.setBounds(0,20,1275,150);
			playerName.setHorizontalAlignment(JLabel.CENTER);
			playerName.setForeground(astronautBlue);
			
			bidPrompt = new JLabel("You have 15 seconds to enter your bid");
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
			
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 30));
			dollarSign.setBounds(475,217,800,90);
			dollarSign.setForeground(astronautBlue);
			
			singlePlayerBid = new JTextField();
			singlePlayerBid.setBounds(500, 240, 150, 45);
			
			if (playerData.getPurseValue() == 0) {
				playerData.setPurseValue(1000000);
				playerData.setNetWorth(1000000);
			}
			if (computerData.getPurseValue() == 0) {
				computerData.setPurseValue(1000000);
				computerData.setNetWorth(1000000);
			}
			
			counterLabel = new JLabel();
			counterLabel.setBounds(30, 30, 100, 100);
			counterLabel.setFont(font1);
			counterLabel.setForeground(astronautBlue);
			
			frame.add(submitBid);
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(singlePlayerBid);
			frame.add(bidPrompt);
			frame.add(dollarSign);
			frame.add(maxBidDisplay);
			frame.add(endBid);
			frame.add(startingPrice);
			frame.add(counterLabel);
			frame.add(playerName);
			
			
			frame.setSize(1275, 775);
			frame.getContentPane().setBackground(mindara);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    countdownTimer();
			countdown.start();	
		    
		    timer.schedule(new TimerTask() 
		    			{
			            @Override
			            public void run() {
			            	if (maxBid.getNumRounds() == 0) {
			            		maxBid.setBidWinner("Computer");
			            		maxBid.setBidValue(itemSelected.getPrice()/2);
			            		frame.dispose();
			            		computerData.setPurseValue(computerData.getPurseValue() - (maxBid.getBidValue()));
			            	}
			            	
			            	else {
			            		maxBid.setBidWinner("Computer");
			            		maxBid.setBidValue(maxBid.getBidValue());
			            		frame.dispose();
			            		computerData.setPurseValue(computerData.getPurseValue() - (maxBid.getBidValue()));
			            	}
			            	
			                try {
			  				  RoundWinPage2 roundWinner = new RoundWinPage2();
			  			  	} 
			  			  	catch (IOException e1) {
			  			  		e1.printStackTrace();
			  			  	}
			                
			            }
			        }, 
			        15000
			);
		    
		}

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
	
	public static void main(String[] args) throws IOException {
		new BiddingRoundSinglePlayer();

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rulesBackButton) {
			  
			  //frame.dispose();
			  
			  try {
				  Rules newRulesPage1 = new Rules();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  
		  else if (e.getSource() == glossaryBackButton) {
			  
			  //frame.dispose();
			  
			  try {
				  Glossary howToPlay1 = new Glossary();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
		  else if (e.getSource() == submitBid) {
			  
			  frame.dispose();
			  timer.cancel();
			  
			  singlePlayerBidValue = Integer.parseInt(singlePlayerBid.getText()); 
			  
			  
			  if (singlePlayerBidValue > actualMaxBid && singlePlayerBidValue > itemSelected.getPrice() && playerData.getPurseValue() > singlePlayerBidValue) {
				  
				  maxBid.setBidValue(singlePlayerBidValue);
				  maxBid.setBidWinner(playerData.getPlayerName());
				  
				  try {
					  BiddingRoundComputer computerTurn = new BiddingRoundComputer();
					  
				  } 
				  catch (IOException e1) {
					  e1.printStackTrace();
				  }
			  }
			  
			  else if (singlePlayerBidValue < actualMaxBid || actualMaxBid < itemSelected.getPrice() || playerData.getPurseValue() <= singlePlayerBidValue) {
				  try {
					  BiddingRoundSinglePlayer repeat = new BiddingRoundSinglePlayer();
					  
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
		
		  else if (e.getSource() == endBid) {
			  
			  frame.dispose();
			  timer.cancel();
			  maxBid.setBidWinner("Computer");
			  maxBid.setBidWinner("Computer");
          	  //maxBid.setBidValue(itemSelected.getPrice()/2);
          	  computerData.setPurseValue(computerData.getPurseValue() - (maxBid.getBidValue()));

			  
			  try {
				  RoundWinPage2 winnerShow = new RoundWinPage2();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
