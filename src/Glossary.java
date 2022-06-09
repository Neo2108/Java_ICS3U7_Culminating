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
	JButton backButton;
	
	// Method for all GUI elements on page
	public Glossary() throws IOException {
		frame = new JFrame();
		frame.setLayout(null);
		Glossary = new ImageIcon(this.getClass().getResource("GlossaryPage.png"));
		Image image = Glossary.getImage();
        Image newImg = image.getScaledInstance(600, 700,  java.awt.Image.SCALE_SMOOTH);
        Glossary = new ImageIcon(newImg);
		glossaryImage1 = new JLabel(Glossary);
		glossaryImage1.setBounds(-100, -60, 800, 800);
		
		backButton = new JButton("Back");
		backButton.setBounds(610, 530, 100, 40);
		backButton.addActionListener(this);
		backButton.setBackground(Color.LIGHT_GRAY);
		
		frame.add(glossaryImage1);
		frame.add(backButton);
		
		
		frame.setSize(730, 750);
		Color color2 = new Color (195, 195, 0);
		frame.getContentPane().setBackground(color2);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Call Glossary Page method
	public static void main(String[] args) throws IOException {
		new Glossary(); 
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			  
			  frame.dispose();
			  
			  try {
				MainMenu newMenu = new MainMenu();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		
	}

}
