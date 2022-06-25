import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Class for user to pick the gameMode they want to play, either multiplayer with a friend or single-player against computer

public class GameMode extends JFrame implements ActionListener {
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	JFrame frame;
	JButton button;
	JButton button2;
	JLabel heading;
	JLabel modeExplanation;
	JLabel rules;	
		
	public GameMode() throws IOException {
		
		// Between player data and main menu
		// Between itemDisplay and biddinground1
		
		Color mindara = new Color (223, 230, 103);
		Color astronautBlue = new Color (32, 82, 92);
		
		frame = new JFrame();
		frame.setLayout(null);
		heading = new JLabel("Mode Choice");
		heading.setFont(new Font("Impact", Font.PLAIN, 60));
		heading.setBounds(480,20,800,150);
		heading.setForeground(astronautBlue);
		
		modeExplanation = new JLabel("Please pick the game mode you want to play ");
		modeExplanation.setFont(new Font("Barlow", Font.PLAIN, 30));
		modeExplanation.setBounds(280,200,800,60);
		modeExplanation.setForeground(astronautBlue);
		
		button = new JButton("Single-Player Mode");
		button.setBounds(520, 340, 250, 60);
		button.addActionListener(this);
		Color color1 = new Color (0, 210, 0);
		button.setBackground(color1);
		
		button2 = new JButton("Multiplayer Mode");
		button2.setBounds(520, 490, 250, 60);
		button2.addActionListener(this);
		button2.setBackground(color1);
		
		// Add GUI Elements onto JFrame
		frame.add(heading);
		frame.add(button);
		frame.add(button2);
		frame.add(modeExplanation);
			
		// Basics and fundamentals of JFrame added on
		frame.setSize(1275, 775);
		frame.getContentPane().setBackground(mindara);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	 public void actionPerformed(ActionEvent e) {
		   
		  if (e.getSource() == button) {
			  
			  frame.dispose();
			  
			  userData1.setGameMode("Singleplayer");
			  
			  // After choosing gameMode, take user to SinglePlayerDataInput, if they choose singlePlayer mode
			  try {
				  SinglePlayerDataInput difficultyPick = new SinglePlayerDataInput();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  
		  else if (e.getSource() == button2) {
			  
			  frame.dispose();
			  
			  userData1.setGameMode("Multiplayer");
			  
			  // After choosing gameMode, take user to MultiPlayerDataInput1, if they choose multiPlayer mode
			  try {
				  MultiPlayerDataInput1 multiplayerModeSelect = new MultiPlayerDataInput1();
			  } 
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
	  }
	 
	 // Call Page
	 public static void main(String[] args) throws Exception {
		 new GameMode();
	 }
}
