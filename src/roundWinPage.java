import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


// Glossary class
public class roundWinPage extends JFrame implements ActionListener {
	
	JFrame frame;
	ImageIcon winnerPagePic;
	JLabel picLabel;
	JLabel winnerDisplay;
	JButton closeButton;
	int gameWinner = 0;
	String nameOfWinner = "";
	
	// Method for all GUI elements on page
	public roundWinPage() throws IOException {
		frame = new JFrame();
		frame.setLayout(null);
		winnerPagePic = new ImageIcon(this.getClass().getResource("ImagesFolder1/WinPageSimulation.JPG"));
		picLabel = new JLabel(winnerPagePic);
		picLabel.setBounds(-100, -40, 800, 800);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(610, 530, 100, 40);
		closeButton.addActionListener(this);
		closeButton.setBackground(Color.LIGHT_GRAY);
		
		frame.add(picLabel);
		frame.add(closeButton);
		
		
		frame.setSize(710, 730);
		Color color2 = new Color (195, 195, 0);
		frame.getContentPane().setBackground(color2);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call Glossary Page method
	public static void main(String[] args) throws IOException {
		new roundWinPage(); 
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == closeButton) {
			  
			  frame.dispose();
		  }
		
	}

}