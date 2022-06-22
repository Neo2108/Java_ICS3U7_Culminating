import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;

public class BiddingRoundComputer extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	Timer timer = new Timer();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	int bid1 = maxBid1.getBidValue();
	JLabel computerBid;
	JLabel dollarSign;
	int secondsLeft = 20;
	JLabel maxBidDisplay;
	public int player1BidValue;
	JLabel countdownDisplay;
	JButton proceedButton;

	
	public BiddingRoundComputer() throws IOException {
			
			frame.setLayout(null);
			
			computerBid = new JLabel("Player 1 - Enter your Bid, you have 15 seconds: ");
			computerBid.setFont(new Font("Impact", Font.PLAIN, 30));
			computerBid.setBounds(380,145,800,90);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + bid1);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			
			dollarSign = new JLabel("$");
			dollarSign.setFont(new Font("Impact", Font.PLAIN, 32));
			dollarSign.setBounds(475,215,800,90);
			
		
			
			frame.add(computerBid);
			frame.add(dollarSign);
			frame.add(maxBidDisplay);
			frame.add(proceedButton);
			
			
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
		new BiddingRoundComputer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}		 
			  
			
		
}
