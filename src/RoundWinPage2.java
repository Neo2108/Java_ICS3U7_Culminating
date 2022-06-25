/**
 * This class is for displaying the roundWinPage for the single-player game mode
 * @author Nischae Tiwari
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Round-win Page2 class
public class RoundWinPage2 extends JFrame implements ActionListener {
	
	JFrame frame;
	SinglePlayerDataProperties playerData = SinglePlayerDataProperties.getInstance();
	ComputerDataProperties computerData = ComputerDataProperties.getInstance();
	MaxBidCalculator maxBid = MaxBidCalculator.getInstance();
	SelectedAuctionItem itemSelected = SelectedAuctionItem.getInstance();
	ImageIcon winnerPagePic;
	JLabel picLabel;
	JLabel winnerDisplay;
	JLabel purseValueDisplay;
	JLabel netWorthDisplay;
	JButton nextButton;
	JButton resultsButton;
	
	// Method for all GUI elements on page
	public RoundWinPage2() throws IOException {
		
		frame = new JFrame();
		frame.setLayout(null);
		winnerPagePic = new ImageIcon(this.getClass().getResource("ImagesFolder1/WinPageSimulation.png"));
		picLabel = new JLabel(winnerPagePic);
		picLabel.setBounds(20, 40, 800, 800);
		
		Color astronautBlue = new Color (32, 82, 92);
		
		// Modify cash Values, and net Worths of players based on who wins the round
		if (maxBid.getBidWinner().equals(playerData.getPlayerName())) {
			playerData.setPurseValue(playerData.getPurseValue() - maxBid.getBidValue());
			playerData.setNetWorth(playerData.getNetWorth() + (itemSelected.getPrice()*((itemSelected.getAppreciationRate()/100)+1) + itemSelected.getLiquidity()*100));
			computerData.setPurseValue(computerData.getPurseValue() - 50000);
			computerData.setNetWorth(computerData.getNetWorth() - 50000);
		}
		
		else if (maxBid.getBidWinner().equals("Computer")) {
			computerData.setPurseValue(computerData.getPurseValue() - maxBid.getBidValue());
			computerData.setNetWorth(computerData.getNetWorth() + (itemSelected.getPrice()*((itemSelected.getAppreciationRate()/100)+1) + itemSelected.getLiquidity()*100));
			playerData.setPurseValue(playerData.getPurseValue() - 50000);
			playerData.setNetWorth(playerData.getNetWorth() - 50000);
		}
		
		// JLabels
		winnerDisplay = new JLabel(maxBid.getBidWinner() + " wins the round!");
		winnerDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		winnerDisplay.setBounds(280,20,800,60);
		winnerDisplay.setForeground(Color.white);
		
		purseValueDisplay = new JLabel(playerData.getPlayerName() + ", You have $" + playerData.getPurseValue() + " left in your wallet! \n &  Computer has $" + computerData.getPurseValue() + " left in its wallet! ");
		purseValueDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		purseValueDisplay.setBounds(280,60,800,60);
		purseValueDisplay.setForeground(Color.white);
		
		netWorthDisplay = new JLabel(playerData.getPlayerName() + ", Your net worth is: $" + playerData.getNetWorth() + "\n &  Computer's net worth is: $" + computerData.getNetWorth());
		netWorthDisplay.setFont(new Font("Impact", Font.PLAIN, 20));
		netWorthDisplay.setBounds(280,95,800,60);
		netWorthDisplay.setForeground(Color.white);
		
		// Run rounds up to only 3 times, and then display the RESULTS page
		if (maxBid.getNumRounds() < 3) {
			nextButton = new JButton("Next Round!");
			nextButton.setBounds(610, 530, 150, 40);
			nextButton.addActionListener(this);
			nextButton.setBackground(Color.LIGHT_GRAY);
			
			frame.add(picLabel);
			frame.add(nextButton);
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
		
		// Basic and fundamentals of GUI JFrame
		frame.setSize(1275, 775);
		frame.getContentPane().setBackground(astronautBlue);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call Page
	public static void main(String[] args) throws IOException {
		new RoundWinPage2(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		// If nextButton is clicked go into next round
			if (e.getSource() == nextButton) {
					  
					  frame.dispose();
					  
					  try {
						  
						  ItemDisplayPage newRound = new ItemDisplayPage();
					  } 
					  catch (IOException e1) {
						  e1.printStackTrace();
					  }
					  
		    }
			
			// If resultsButton is clicked display results
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
