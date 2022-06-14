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
        Image newImg = image.getScaledInstance(600, 700,  java.awt.Image.SCALE_SMOOTH);
        Glossary = new ImageIcon(newImg);
		glossaryImage1 = new JLabel(Glossary);
		glossaryImage1.setBounds(-100, -40, 800, 800);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(610, 530, 100, 40);
		closeButton.addActionListener(this);
		closeButton.setBackground(Color.LIGHT_GRAY);
		
		frame.add(glossaryImage1);
		frame.add(closeButton);
		
		
		frame.setSize(710, 730);
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
		if (e.getSource() == closeButton) {
			  
			  frame.dispose();
		  }
		
	}

}
