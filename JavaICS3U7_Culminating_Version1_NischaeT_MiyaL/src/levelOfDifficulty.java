import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Class for user to pick the levelOfDifficulty they want to play
public class levelOfDifficulty extends JFrame implements ActionListener {
	
	JFrame frame;
	JButton button;
	JButton button2;
	JButton button3;
	JLabel heading;
	JLabel modeExplanation;
	JLabel rules;
	// If difficultyChoice = 0, level selected is 'Beginner', if difficultyChoice = 1, level selected is 'Intermediate', and if difficultyChoice = 2, level selected is 'Advanced'
	int difficultyChoice = 0;
	
		
	public levelOfDifficulty() throws IOException {
		
		frame = new JFrame();
		frame.setLayout(null);
		heading = new JLabel("Level of Difficulty");
		heading.setFont(new Font("Impact", Font.PLAIN, 60));
		heading.setBounds(480,20,800,60);
		
		modeExplanation = new JLabel("Please choose the level of difficulty you want to play with: ");
		modeExplanation.setFont(new Font("Barlow", Font.PLAIN, 30));
		modeExplanation.setBounds(180,160,800,60);
		
		
		button = new JButton("Beginner");
		button.setBounds(730, 250, 250, 60);
		button.addActionListener(this);
		Color color1 = new Color (0, 210, 0);
		button.setBackground(color1);
		
		button2 = new JButton("Intermediate");
		button2.setBounds(730, 375, 250, 60);
		button2.addActionListener(this);
		button2.setBackground(color1);
		
		button3 = new JButton("Advanced");
		button3.setBounds(730, 500, 250, 60);
		button3.addActionListener(this);
		button3.setBackground(color1);
		
		
		
		frame.add(heading);
		frame.add(button);
		frame.add(button2);
		frame.add(button3);
		frame.add(modeExplanation);
			
		
		
		
		 frame.setSize(1275, 775);
		 Color color2 = new Color (195, 195, 0);
		 frame.getContentPane().setBackground(color2);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// If certain button clicked, save user's choice into a variable and continue with other program functionalities
	 public void actionPerformed(ActionEvent e) {
		   
		  if (e.getSource() == button) {
			  
			  frame.dispose();
			  
			  difficultyChoice = 0;
			  
			  try {
				SinglePlayerDataInput beginner = new SinglePlayerDataInput();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  
		  else if (e.getSource() == button2) {
			  
			  frame.dispose();
			  
			  difficultyChoice = 1;
			  
			  try {
				  SinglePlayerDataInput intermediate = new SinglePlayerDataInput();
			  } 
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
		  
		  else if (e.getSource() == button2) {
			  
			  frame.dispose();
			  
			  difficultyChoice = 2;
			  
			  try {
				  SinglePlayerDataInput advanced = new SinglePlayerDataInput();
			  } 
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
	  }
	 
	 // Call method with GUI elements to the screen
	 public static void main(String[] args) throws Exception {
		 new levelOfDifficulty();
	 }
}
