import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.*;

public class BiddingRoundComputer extends JFrame{
	
	JFrame frame = new JFrame();
	Timer timer = new Timer();
	MaxBidCalculator maxBid1 = MaxBidCalculator.getInstance();
	ComputerDataProperties computerData = ComputerDataProperties.getInstance();
	SinglePlayerDataProperties playerData = SinglePlayerDataProperties.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	int bid1 = maxBid1.getBidValue();
	JLabel computerBid;
	int computerBidValue;
	JLabel maxBidDisplay;
	JLabel description;
	public int player1BidValue;
	JLabel countdownDisplay;

	
	public BiddingRoundComputer() throws IOException {
			
			frame.setLayout(null);
			
			if (itemSelected.getPrice()* ((itemSelected.getAppreciationRate()/100) + 1) >= maxBid1.getBidValue() && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + 5000;
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else if (itemSelected.getPrice()* ((itemSelected.getAppreciationRate()/100) + 1) <= maxBid1.getBidValue() && itemSelected.getPrice()* (((itemSelected.getAppreciationRate()/100) + 1)*3) >= maxBid1.getBidValue() && itemSelected.getLiquidity() >= 8 && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + ((int)Math.random()*1000 + 800);
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else if (itemSelected.getPrice()* ((itemSelected.getAppreciationRate()/100) + 1) <= maxBid1.getBidValue() && itemSelected.getPrice()* (((itemSelected.getAppreciationRate()/100) + 1)*2.6) >= maxBid1.getBidValue() && itemSelected.getLiquidity() >= 7 && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + ((int)Math.random()*1000 + 400);
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else if (itemSelected.getPrice()* ((itemSelected.getAppreciationRate()/100) + 1) <= maxBid1.getBidValue() && itemSelected.getPrice()* (((itemSelected.getAppreciationRate()/100) + 1)*2.3) >= maxBid1.getBidValue() && itemSelected.getLiquidity() >= 5 && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + ((int)Math.random()*1000 + 200);
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else if (itemSelected.getPrice()* ((itemSelected.getAppreciationRate()/100) + 1) <= maxBid1.getBidValue() && itemSelected.getPrice()* (((itemSelected.getAppreciationRate()/100) + 1)*2.2) >= maxBid1.getBidValue() && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + 1000;
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else if (itemSelected.getPrice() >= 200000 && itemSelected.getPrice()* (((itemSelected.getAppreciationRate()/100) + 1)*2) >= maxBid1.getBidValue() && itemSelected.getLiquidity() >= 8 && computerData.getPurseValue() > maxBid1.getBidValue()) {
				computerBidValue = maxBid1.getBidValue() + ((int)Math.random()*1000 + 100);
				maxBid1.setBidValue(computerBidValue);
				maxBid1.setBidWinner("Computer");
				
				timer.schedule(new TimerTask() 
    			{
	            @Override
	            public void run() {
	            	
	            	frame.dispose();
	            	
	            	
	                try {
	  				  BiddingRoundSinglePlayer singlePlayerTurn = new BiddingRoundSinglePlayer();
	  			  	} 
	  			  	catch (IOException e1) {
	  			  		e1.printStackTrace();
	  			  	}
	                
	            }
	        }, 
	        8000
	);
			}
			
			else {
				
				maxBid1.setBidWinner(playerData.getPlayerName());
				frame.dispose();
			    
			try {
						timer.schedule(new TimerTask() 
		    			{
			            @Override
			            public void run() {
			            	
			            	frame.dispose();
			            	
			            	
			                try {
			                	RoundWinPage2 winnerShow = new RoundWinPage2();
			  			  	} 
			  			  	catch (IOException e1) {
			  			  		e1.printStackTrace();
			  			  	}
			                
			            }
			        }, 
			        8000);
					
				}
				
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			

			description = new JLabel("You have 5 seconds to look at the computer's bid! Get ready for your turn!");
			description.setFont(new Font("Barlow", Font.PLAIN, 20));
			description.setBounds(180,145,800,90);
			
			if(computerBidValue == 0) {
				computerBid = new JLabel("Computer gives up and does not want to bid further");
			}else {
				computerBid = new JLabel("Computer bids: $" + computerBidValue);
			}
			
			computerBid.setFont(new Font("Barlow", Font.PLAIN, 25));
			computerBid.setBounds(380,226,800,90);
			
			maxBidDisplay = new JLabel("Max bid so far: $" + bid1);
			maxBidDisplay.setFont(new Font("Impact", Font.PLAIN, 30));
			maxBidDisplay.setBounds(440,320,800,90);
			
			if (computerData.getPurseValue() == 0) {
				computerData.setPurseValue(1000000);
				computerData.setNetWorth(1000000);
			}
			
			frame.add(computerBid);
			frame.add(maxBidDisplay);
			frame.add(description);
			
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    
		    
		    
		    
		}

	public static void main(String[] args) throws IOException {
		new BiddingRoundComputer();

	}		 
			  
			
		
}
