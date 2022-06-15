import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class biddingRoundPlayer1 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	int bid1 = maxBid1.getBidValue();
	JTextField player1Bid;
	JLabel bidPrompt;
	JLabel dollarSign;
	int secondsLeft = 20;
	JLabel maxBidDisplay;
	public int player1BidValue;
	JLabel countdownDisplay;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	
	public biddingRoundPlayer1() throws IOException {
			
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
			
			bidPrompt = new JLabel("Player 1 - Enter your Bid, you have 10 seconds: ");
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
			
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                frame.dispose();
			                secondsLeft--;
			                
			                try {
			  				  biddingRoundPlayer2 player2Turn = new biddingRoundPlayer2();
			  			  	} 
			  			  	catch (IOException e1) {
			  			  		e1.printStackTrace();
			  			  	}
			                
			            }
			        }, 
			        20000 
			);
		    
		}

	public static void main(String[] args) throws IOException {
		new biddingRoundPlayer1();

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
			  // MaxBidCalculator maxBid1 = new MaxBidCalculator();
			  
			  player1BidValue = Integer.parseInt(player1Bid.getText());
			  
			  if (player1BidValue > bid1) {
				  maxBid1.setBidValue(player1BidValue);
				  
				  try {
					  biddingRoundPlayer2 player2Turn = new biddingRoundPlayer2();
					  
				  } 
				  catch (IOException e1) {
					  e1.printStackTrace();
				  }
			  }
			  
			  else if (player1BidValue <= bid1) {
				  try {
					  biddingRoundPlayer2 player2Turn = new biddingRoundPlayer2();
					  
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
		
	}

}
