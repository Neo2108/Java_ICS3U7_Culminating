import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Class for user to pick the gameMode they want to play, either multiplayer with a friend or single-player against computer
public class gameMode extends JFrame implements ActionListener {
	
	JFrame frame;
	JButton button;
	JButton button2;
	JLabel heading;
	JLabel modeExplanation;
	JLabel rules;
	// If modeChoice = 0, gameMode selected is 'Single-player', and if modeChoice = 1, gameMode is 'Multiplayer'
	public int modeChoice = 0;
	
		
	public gameMode() throws IOException {
		// between player data and main menu
		// between itemdisplay and biddinground1
		
		frame = new JFrame();
		frame.setLayout(null);
		heading = new JLabel("Mode Choice");
		heading.setFont(new Font("Impact", Font.PLAIN, 60));
		heading.setBounds(480,20,800,150);
		heading.setForeground(Color.white);
		
		modeExplanation = new JLabel("Please pick the game mode you want to play ");
		modeExplanation.setFont(new Font("Barlow", Font.PLAIN, 30));
		modeExplanation.setBounds(280,200,800,60);
		modeExplanation.setForeground(Color.white);
		
		
		button = new JButton("Single-Player Mode");
		button.setBounds(730, 300, 250, 60);
		button.addActionListener(this);
		Color color1 = new Color (0, 210, 0);
		button.setBackground(color1);
		
		button2 = new JButton("Multiplayer Mode");
		button2.setBounds(730, 450, 250, 60);
		button2.addActionListener(this);
		button2.setBackground(color1);
		
		
		
		frame.add(heading);
		frame.add(button);
		frame.add(button2);
		frame.add(modeExplanation);
			
		
		
		
		 frame.setSize(1275, 775);
		 Color color2 = new Color (32, 82, 92);
		 frame.getContentPane().setBackground(color2);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	 public void actionPerformed(ActionEvent e) {
		   
		  if (e.getSource() == button) {
			  
			  frame.dispose();
			  
			  modeChoice = 0;
			  
			  try {
				  SinglePlayerDataInput difficultyPick = new SinglePlayerDataInput();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  
		  else if (e.getSource() == button2) {
			  
			  frame.dispose();
			  
			  modeChoice = 1;
			  
			  try {
				  MultiPlayerDataInput1 multiplayerModeSelect = new MultiPlayerDataInput1();
			  } 
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
	  }
	 
	 public static void main(String[] args) throws Exception {
		 new gameMode();
	 }
}
