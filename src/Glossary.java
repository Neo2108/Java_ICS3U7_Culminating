/**
 * This class is for displaying the glossary page, if the user wishes to see it
 * @author Nischae Tiwari
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


// Glossary class
public class Glossary extends JFrame implements ActionListener {
	
	JFrame frame;
	ImageIcon Glossary;
	JLabel glossaryImage1;
	JButton closeButton;
	
	// Method for all GUI elements on page
	public Glossary() throws IOException {
		
		frame = new JFrame();
		frame.setLayout(null);
		Glossary = new ImageIcon(this.getClass().getResource("ImagesFolder1/GlossaryPage.png"));
		Image image = Glossary.getImage();
        Image newImg = image.getScaledInstance(image.getWidth(null)*730/image.getHeight(null), 730,  java.awt.Image.SCALE_SMOOTH);
        Glossary = new ImageIcon(newImg);
		glossaryImage1 = new JLabel(Glossary);
		int imgWidth = newImg.getWidth(null);
		int imgHeight = newImg.getHeight(null);
		glossaryImage1.setBounds(0, 0, imgWidth, imgHeight);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(610, 530, 100, 40);
		closeButton.addActionListener(this);
		closeButton.setBackground(Color.LIGHT_GRAY);
		
		// Add GUI Elements onto JFrame
		frame.add(glossaryImage1);
		frame.add(closeButton);
		
		// Basic and fundamentals of GUI JFrame
		frame.setSize(750, 730);
		Color mindara = new Color (223, 230, 103);
		frame.getContentPane().setBackground(mindara);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call Glossary Page method
	public static void main(String[] args) throws IOException {
		new Glossary(); 
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == closeButton) {
			  
			  frame.dispose();
		  }
		
	}

}
