import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exceptionPage extends JFrame implements ActionListener {
	
	private JLabel label;
	private JLabel label2;
	private JFrame frame;
	JButton button;
	
	public exceptionPage() throws IOException  {
		frame = new JFrame();
		JButton button = new JButton("Close Tab");
		button.addActionListener(this);
		
		label = new JLabel ("01 - Please enter an integer");
		label2 = new JLabel ("02 - Please enter a bid greater than maxBid!");
		
		
		frame.add(button);
		frame.add(label);
		frame.add(label2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI!");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new exceptionPage();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			  
			  frame.dispose();
			  
			  try {
				  Rules newRulesPage1 = new Rules();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		
	}

}
