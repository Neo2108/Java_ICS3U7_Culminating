import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;

public class BiddingRoundPlayer1 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	Timer timer = new Timer();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	int bid1 = maxBid1.getBidValue();
	JTextField player1Bid;
	JLabel bidPrompt;
	JLabel dollarSign;
	int secondsLeft = 20;
	JLabel maxBidDisplay;
	public int player1BidValue;
	JLabel countdownDisplay;
	JButton submitBid;
	int gameWinner = 1;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	JButton endBid;
	
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
			
			bidPrompt = new JLabel("Player 1 - Enter your Bid, you have 15 seconds: ");
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(380,145,800,90);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + bid1);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 32));
			dollarSign.setBounds(475,215,800,90);
			
			player1Bid = new JTextField();
			player1Bid.setBounds(500, 240, 150, 45);
			
			
		
			
			frame.add(submitBid);
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(player1Bid);
			frame.add(bidPrompt);
			frame.add(dollarSign);
			frame.add(maxBidDisplay);
			frame.add(endBid);
			
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    
		    
		    timer.schedule(new TimerTask() 
		    			{
			            @Override
			            public void run() {
			            	
			            	frame.dispose();
			            	
			            	
			                try {
			  				  RoundWinPage roundWinner = new RoundWinPage();
			  			  	} 
			  			  	catch (IOException e1) {
			  			  		e1.printStackTrace();
			  			  	}
			                
			            }
			        }, 
			        15000
			);
		    
		}

	public static void main(String[] args) throws IOException {
		new BiddingRoundPlayer1();

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
			  
			  
			  if (player1BidValue > bid1 && player1BidValue > itemSelected.getPrice()) {
				  
				  maxBid1.setBidValue(player1BidValue);
				  
				  try {
					  BiddingRoundPlayer2 player2Turn = new BiddingRoundPlayer2();
					  
				  } 
				  catch (IOException e1) {
					  e1.printStackTrace();
				  }
			  }
			  
			  else if (player1BidValue < bid1 || bid1 < itemSelected.getPrice()) {
				  try {
					  BiddingRoundPlayer2 player2Turn = new BiddingRoundPlayer2();
					  
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
			  gameWinner = 0;
			  userData1.setGameWinner(gameWinner);
			  
			  try {
				  RoundWinPage winnerShow = new RoundWinPage();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
