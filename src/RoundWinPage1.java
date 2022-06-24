import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


// Glossary class
public class RoundWinPage1 extends JFrame implements ActionListener {
	
	JFrame frame;
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	MaxBidCalculator maxBid = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	ImageIcon winnerPagePic;
	JLabel picLabel;
	JLabel winnerDisplay;
	JLabel purseValueDisplay;
	JLabel netWorthDisplay;
	JButton closeButton;
	JButton resultsButton;
	
	// Method for all GUI elements on page
	public RoundWinPage1() throws IOException {
		frame = new JFrame();
		frame.setLayout(null);
		winnerPagePic = new ImageIcon(this.getClass().getResource("ImagesFolder1/WinPageSimulation.JPG"));
		picLabel = new JLabel(winnerPagePic);
		picLabel.setBounds(20, 40, 800, 800);
		
		
		if (maxBid.getBidWinner().equals(userData1.getPlayerName())) {
			userData1.setPurseValue(userData1.getPurseValue() - maxBid.getBidValue());
			userData1.setNetWorth(userData1.getNetWorth() + (itemSelected.getPrice()*((itemSelected.getAppreciationRate()/100)+1) + itemSelected.getLiquidity()*100));
			userData2.setPurseValue(userData2.getPurseValue() - 50000);
			userData2.setNetWorth(userData2.getNetWorth() - 50000);
		}
		
		else if (maxBid.getBidWinner().equals(userData2.getPlayerName())) {
			userData2.setPurseValue(userData2.getPurseValue() - maxBid.getBidValue());
			userData2.setNetWorth(userData2.getNetWorth() + (itemSelected.getPrice()*((itemSelected.getAppreciationRate()/100)+1) + itemSelected.getLiquidity()*100));
			userData1.setPurseValue(userData1.getPurseValue() - 50000);
			userData1.setNetWorth(userData1.getNetWorth() - 50000);
		}
		
		winnerDisplay = new JLabel(maxBid.getBidWinner() + " wins the round!");
		winnerDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		winnerDisplay.setBounds(280,20,800,60);
		
		purseValueDisplay = new JLabel(userData1.getPlayerName() + ", You have $" + userData1.getPurseValue() + " left in your wallet! &\n " + userData2.getPlayerName() + ", You have $" + userData2.getPurseValue() + " left in your wallet! ");
		purseValueDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		purseValueDisplay.setBounds(280,60,800,60);
		
		netWorthDisplay = new JLabel(userData1.getPlayerName() + ", Your net worth is: $" + userData1.getNetWorth() + "\n  &  " + userData2.getPlayerName() + ", Your net worth is: $" + userData2.getNetWorth());
		netWorthDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		netWorthDisplay.setBounds(280,95,800,60);
		
		if (maxBid.getNumRounds() < 3) {
			closeButton = new JButton("Next Round!");
			closeButton.setBounds(610, 530, 150, 40);
			closeButton.addActionListener(this);
			closeButton.setBackground(Color.LIGHT_GRAY);
			
			frame.add(picLabel);
			frame.add(closeButton);
			frame.add(winnerDisplay);
			frame.add(purseValueDisplay);
			frame.add(netWorthDisplay);
		}
		
		else if (maxBid.getNumRounds() == 3) {
					
			resultsButton = new JButton("See Results!");
			resultsButton.setBounds(610, 530, 150, 40);
			resultsButton.addActionListener(this);
			resultsButton.setBackground(Color.LIGHT_GRAY);
			
			frame.add(picLabel);
			frame.add(winnerDisplay);
			frame.add(purseValueDisplay);
			frame.add(resultsButton);
			frame.add(netWorthDisplay);
			
		}
		
		
		
		
		
		frame.setSize(1275, 775);
		Color color2 = new Color (195, 195, 0);
		frame.getContentPane().setBackground(color2);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call Glossary Page method
	public static void main(String[] args) throws IOException {
		new RoundWinPage1(); 
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
					if (e.getSource() == closeButton) {
							  
							  frame.dispose();
							  
							  try {
								  
								  ItemDisplayPage newRound = new ItemDisplayPage();
							  } 
							  catch (IOException e1) {
								  e1.printStackTrace();
							  }
							  
				    }
					
					if (e.getSource() == resultsButton) {
						  
						  frame.dispose();
						  
						  try {
							  
							   EndScreen roundEnd = new EndScreen();
						  } 
						  catch (IOException e1) {
							  e1.printStackTrace();
						  }
						  
			  }
		
			  
		  }
		
	}


