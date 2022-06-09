import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


// This class is for displaying the rules page, when user clicks on it
public class Rules extends JFrame implements ActionListener {
	
	JFrame frame;
	ImageIcon Rules;
	JLabel rulesImage1;
	JButton backButton;
	
	// Method with all GUI elements on it
	// *Back-button* for user will be added in Version 2, for user to go back to the main menu if desired
	public Rules() throws IOException {
		frame = new JFrame();
		frame.setLayout(null);
		Rules = new ImageIcon(this.getClass().getResource("RulesPage.png"));
		Image image = Rules.getImage();
        Image newImg = image.getScaledInstance(600, 700,  java.awt.Image.SCALE_SMOOTH);
        Rules = new ImageIcon(newImg);
		rulesImage1 = new JLabel(Rules);
		rulesImage1.setBounds(-100, -60, 800, 800);
		
		backButton = new JButton("Glossary/Terms");
		backButton.setBounds(230, 500, 250, 60);
		backButton.addActionListener(this);
		backButton.setBackground(Color.LIGHT_GRAY);
		
		frame.add(rulesImage1);
		
		
		frame.setSize(730, 750);
		Color color2 = new Color (195, 195, 0);
		frame.getContentPane().setBackground(color2);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call method, that is the Rules page
	public static void main(String[] args) throws IOException {
		new Rules(); 
		

	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
