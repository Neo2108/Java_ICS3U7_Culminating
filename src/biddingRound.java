import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class biddingRound extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	ImageIcon image;
	JTextField player1Bid;
	JLabel bidPrompt;
	JButton submitBid;
	JButton glossaryBackButton;
	JButton rulesBackButton;
	
	public biddingRound() throws IOException {
			
			frame.setLayout(null);
			
			rulesBackButton = new JButton("Rules");
			rulesBackButton.setBounds(1140, 20, 100, 40);
			rulesBackButton.addActionListener(this);
			rulesBackButton.setBackground(Color.LIGHT_GRAY);
			
			glossaryBackButton = new JButton("Glossary");
			glossaryBackButton.setBounds(1140, 70, 100, 40);
			glossaryBackButton.addActionListener(this);
			glossaryBackButton.setBackground(Color.LIGHT_GRAY);
			
			bidPrompt = new JLabel("Player 1 - Enter your Bid, you have 5 seconds: ");
			bidPrompt.setFont(new Font("Impact", Font.PLAIN, 30));
			bidPrompt.setBounds(380,153,800,90);
			
			player1Bid = new JTextField();
			player1Bid.setBounds(500, 225, 150, 45);
		
			
			frame.add(glossaryBackButton);
			frame.add(rulesBackButton);
			frame.add(player1Bid);
			frame.add(bidPrompt);
			
			
			frame.setSize(1275, 775);
			Color color2 = new Color (195, 195, 0);
			frame.getContentPane().setBackground(color2);
			frame.setVisible(true);
		    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		}

	public static void main(String[] args) throws IOException {
		new biddingRound();

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
		
	}

}
