import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExceptionPage extends JFrame implements ActionListener {
	
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JFrame frame;
	JButton button;
	
	public ExceptionPage() throws IOException  {
		
		frame = new JFrame();
		button = new JButton("Close Tab");
		button.addActionListener(this);
		button.setBounds(200, 500, 160, 100);
		
		label = new JLabel ("01 - Please enter an integer");
		label.setFont(new Font("Impact", Font.PLAIN, 30));
		label.setBounds(10,125,800,90);
		
		label2 = new JLabel ("02 - Please enter a bid greater than maxBid and the starting price!");
		label2.setFont(new Font("Impact", Font.PLAIN, 28));
		label2.setBounds(10,195,800,120);
		
		label3 = new JLabel ("03 - You cannot bid more than you have in your wallet!");
		label3.setFont(new Font("Impact", Font.PLAIN, 30));
		label3.setBounds(20,45,800,90);
		
		
		frame.add(button);
		frame.add(label);
		frame.add(label2);
		frame.add(label3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI!");
		frame.setSize(1275, 775);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new ExceptionPage();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			  
			  frame.dispose();
			  
		  }
		
	}

}
