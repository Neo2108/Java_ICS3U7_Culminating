import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Main menu class, with the three options: One for rules, one for glossary of terms, and one for starting the game
public class MainMenu extends JFrame implements ActionListener {
	
	JFrame frame;
	JButton button;
	JButton button2;
	JButton button3;
	JLabel heading;
	JLabel startGame;
	JLabel rules;
	JLabel glossary;
	
	// Method with all the GUI elements on Main Menu	
	public MainMenu() throws IOException {
		
		frame = new JFrame();
		frame.setLayout(null);
		heading = new JLabel("Main Menu");
		heading.setFont(new Font("Impact", Font.PLAIN, 60));
		heading.setBounds(480,20,800,60);
		
		
		button = new JButton("How to Play?");
		button.setBounds(230, 200, 250, 60);
		button.addActionListener(this);
		Color color1 = new Color (0, 210, 0);
		button.setBackground(color1);
		
		button2 = new JButton("Play");
		button2.setBounds(230, 350, 250, 60);
		// button2.addActionListener(this);
		button2.setBackground(color1);
		
		button3 = new JButton("Glossary/Terms");
		button3.setBounds(230, 500, 250, 60);
		button3.addActionListener(this);
		button3.setBackground(color1);
		
		
		
		frame.add(heading);
		frame.add(button);
		frame.add(button2);
		frame.add(button3);
			
		
		
		
		 frame.setSize(1275, 775);
		 Color color2 = new Color (195, 195, 0);
		 frame.getContentPane().setBackground(color2);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// If one of the three buttons are clicked, divert the page to where the user wants to specifically go
	 public void actionPerformed(ActionEvent e) {
		   
		  if (e.getSource() == button) {
			  
			  frame.dispose();
			  
			  try {
				Rules displayRules = new Rules();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		  // This button leads to actually playing the game, and will be finished at the end of version 2
		  /*
		  else if (e.getSource() == button2) {
			  
			  frame.dispose();
			  
			  
		  }
		  */
		  
		  else if (e.getSource() == button3) {
			  
			  frame.dispose();
			  
			  try {
				Glossary displayGlossary = new Glossary();
			  } 
			  catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			  }
		  }
	  }
	 
	 // Call Main menu page
	 public static void main(String[] args) throws Exception {
		 new MainMenu();
	 }
}
