import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.event.*;

public class BiddingRoundPlayer1 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	java.util.Timer timer = new java.util.Timer();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	int actualMaxBid = maxBid1.getBidValue();
	JTextField player1Bid;
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
	
	// countdown
	JLabel counterLabel;
	Font font1 = new Font("Impact", Font.PLAIN, 70);	
	javax.swing.Timer countdown;	
	int second;
	String formattedSecond;	
	DecimalFormat dFormat = new DecimalFormat("00");
	
	public BiddingRoundPlayer1() throws IOException {
			
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
			submitBid.setBounds(522, 300, 100, 40);
			submitBid.addActionListener(this);
			submitBid.setBackground(Color.LIGHT_GRAY);
			
			endBid = new JButton("End Bid");
			endBid.setBounds(322, 300, 100, 40);
			endBid.addActionListener(this);
			endBid.setBackground(Color.LIGHT_GRAY);
			if (userData1.getPurseValue() == 0) {
				userData1.setPurseValue(1000000);
				userData1.setNetWorth(1000000);
			}
			bidPrompt = new JLabel(userData1.getPlayerName() + " You have $" + userData1.getPurseValue() + ", Enter your Bid, you have 15 seconds: ");
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(380,145,800,90);
			
			
			maxBidDisplay = new JLabel("Max bid so far: $" + actualMaxBid);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			

			startingPrice = new JLabel("Starting Price of Item: $" + itemSelected.getPrice());
			startingPrice.setFont(new Font("Impact", Font.PLAIN, 25));
			startingPrice.setBounds(440,360,800,90);
			frame.add(startingPrice);
		
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 32));
			dollarSign.setBounds(475,215,800,90);
			
			player1Bid = new JTextField();
			player1Bid.setBounds(500, 240, 150, 45);
			
			counterLabel = new JLabel();
			counterLabel.setBounds(300, 230, 200, 100);
			counterLabel.setHorizontalAlignment(JLabel.CENTER);
			counterLabel.setFont(font1);
			
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
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
			countdownTimer();
			countdown.start();	
		    
		    
		    
		
	
	timer.schedule(new TimerTask() 
	{
    @Override
    public void run() {
    	maxBid1.setBidWinner(userData2.getPlayerName());
    	frame.dispose();
    	
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
		new BiddingRoundPlayer1();
//		new CountDownTimer();

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
			  
			  player1BidValue = Integer.parseInt(player1Bid.getText()); 
			  
			  
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
		
		  else if (e.getSource() == endBid) {
			  
			  frame.dispose();
			  timer.cancel();
			  maxBid1.setBidWinner(userData2.getPlayerName());
			  
			  
			  try {
				  RoundWinPage1 winnerShow = new RoundWinPage1();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
