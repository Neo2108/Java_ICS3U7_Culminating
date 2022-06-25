import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExceptionPage extends JFrame implements ActionListener {
	
	// Initializing variables for use in GUI
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JFrame frame;
	JButton button;
	
	public ExceptionPage() throws IOException  {
		
		Color astronautBlue = new Color (32, 82, 92);

		frame = new JFrame();
		button = new JButton("Close Tab");
		button.addActionListener(this);
		button.setBounds(550, 125+100*4, 250, 60);
		
		label = new JLabel ("01 - Please enter an integer");
		label.setFont(new Font("Barlow", Font.PLAIN, 30));
		label.setBounds(30,125,800,120);
		label.setForeground(Color.white);
		
		label2 = new JLabel ("02 - Please enter a bid greater than maxBid and the starting price!");
		label2.setFont(new Font("Barlow", Font.PLAIN, 30));
		label2.setBounds(30,125+100,1200,120);
		label2.setForeground(Color.white);
		
		label3 = new JLabel ("03 - You cannot bid more than you have in your wallet!");
		label3.setFont(new Font("Barlow", Font.PLAIN, 30));
		label3.setBounds(30,125+100*2,1200,120);
		label3.setForeground(Color.white);
		
		label4 = new JLabel ("");
		label4.setBounds(0,0,0,0);
		label4.setForeground(Color.white);
		
		// Add GUI Elements onto JFrame
		frame.add(button);
		frame.add(label);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(astronautBlue);
		frame.setTitle("Our GUI!");
		frame.setSize(1275, 775);
		frame.setVisible(true);
	}

	// Call Page
	public static void main(String[] args) throws IOException {
		new ExceptionPage();
	}

	// Close page, if user clicks on closeButton
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			  
			  frame.dispose();
			  
		  }
	}

}
