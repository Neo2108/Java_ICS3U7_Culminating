import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Timer;

public class biddingRoundPlayer2 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	Timer timer2 = new Timer();
	MaxBidCalculator maxBid2 = MaxBidCalculator.getInstance();
	selectedAuctionItem itemSelected = selectedAuctionItem.getInstance();
	playerDataProperties1 userData2 = playerDataProperties1.getInstance();
	int bid2 = maxBid2.getBidValue();
	JTextField player2Bid;
	JLabel bidPrompt;
	JLabel dollarSign;
	int gameWinner = 1;
	int secondsPassed = 0;
	int player2BidValue;
	JLabel maxBidDisplay;
	JLabel countdownDisplay;
	JLabel player1BidDisplay;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	JButton endBid;
	
	
	public biddingRoundPlayer2() throws IOException {
			
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
			
			bidPrompt = new JLabel("Player 2 - Enter your Bid, you have 15 seconds: ");
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(380,145,800,90);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + bid2);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 32));
			dollarSign.setBounds(475,215,800,90);
			
			player2Bid = new JTextField();
			player2Bid.setBounds(500, 240, 150, 45);
			
			
		
			
			frame.add(submitBid);
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
			                frame.dispose();
			                
			                
			            	
			                try {
			  				  roundWinPage roundWinner2 = new roundWinPage();
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
		new biddingRoundPlayer2();

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
			  
			  if (player2BidValue > bid2 || bid2 > itemSelected.getPrice()) {
				  maxBid2.setBidValue(player2BidValue);
				  
				  try {
					  biddingRoundPlayer1 player1Turn = new biddingRoundPlayer1();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
			  }
			  
			  else if (player2BidValue > bid2 && player2BidValue > itemSelected.getPrice()) {
				  try {
					  biddingRoundPlayer1 player1Turn = new biddingRoundPlayer1();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
				  
				  try {
					  exceptionPage errorOcurred = new exceptionPage();
					  
				  } 
				  catch (IOException e1) {
					e1.printStackTrace();
				  }
				  
			  }
			  

		  }
		
		  else if (e.getSource() == endBid) {
			  
			  frame.dispose();
			  gameWinner = 0;
			  userData2.setGameWinner(gameWinner);
			  
			  try {
				  roundWinPage winnerShow = new roundWinPage();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
		  }
		
	}

}
