import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Timer;

public class BiddingRoundPlayer2 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	Timer timer2 = new Timer();
	MaxBidCalculator maxBid2 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	int actualMaxBid = maxBid2.getBidValue();
	JTextField player2Bid;
	JLabel bidPrompt;
	JLabel dollarSign;
	public static int secondsLeft = 15;
	int player2BidValue;
	JLabel maxBidDisplay;
	JLabel countdownDisplay;
	JLabel player1BidDisplay;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	JButton endBid;
	
	
	public BiddingRoundPlayer2() throws IOException {
			
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
			
			if (userData2.getPurseValue() == 0) {
				userData2.setPurseValue(1000000);
				userData2.setNetWorth(1000000);
			}
			
			bidPrompt = new JLabel(userData2.getPlayerName() + " You have $" + userData2.getPurseValue() + ", Enter your Bid, you have 15 seconds: ");
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(380,145,800,90);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + actualMaxBid);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 32));
			dollarSign.setBounds(475,215,800,90);
			
			player2Bid = new JTextField();
			player2Bid.setBounds(500, 240, 150, 45);
			
			countdownDisplay = new JLabel("Time Left: " + secondsLeft + " seconds");
			countdownDisplay.setFont(new Font("Barlow", Font.BOLD, 32));
			countdownDisplay.setBounds(455,365,800,90);
			
		
			
			frame.add(submitBid);
			//frame.add(countdownDisplay);
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(player2Bid);
			frame.add(bidPrompt);
			frame.add(dollarSign);
			frame.add(maxBidDisplay);
			frame.add(endBid);
			
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    
		    timer2.schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	if (secondsLeft == 0) {
			            		countdownDisplay.setText("    Time left: " + secondsLeft + " seconds"); //update JLabel
			            		timer2.cancel();
			            		frame.dispose();
			            	}
			            	
			            	maxBid2.setBidWinner(userData1.getPlayerName());
			            	secondsLeft--; //decrement timeLeft
							countdownDisplay.setText("    Time left: " + secondsLeft + " seconds"); //update JLabel
			                
			               
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

	public static void main(String[] args) throws IOException {
		new BiddingRoundPlayer2();

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
			  
			  timer2.cancel();
			  frame.dispose();
			  // MaxBidCalculator maxBid1 = new MaxBidCalculator();
			  
			  player2BidValue = Integer.parseInt(player2Bid.getText());
			  
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
		
		  else if (e.getSource() == endBid) {
			  
			  frame.dispose();
			  timer2.cancel();
			  maxBid2.setBidWinner(userData1.getPlayerName());
			  
			  try {
				  RoundWinPage1 winnerShow = new RoundWinPage1();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
