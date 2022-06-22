import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Main menu class, with the three options: One for rules, one for glossary of terms, and one for starting the game
public class Loading extends JFrame implements ActionListener {
	
	JFrame frame;
	ImageIcon img;
	JLabel image;
	
	// Method with all the GUI elements on Main Menu	
	public Loading() throws IOException {
		frame = new JFrame();
		frame.setLayout(null);
		
		
		img = new ImageIcon(this.getClass().getResource("ImagesFolder1/512x512.gif"));
		image = new JLabel(img);
		image.setBounds(350,170,600,400);
		
		frame.add(image);

	     long start = System.currentTimeMillis();

		
		 frame.setSize(1275, 775);
		 Color color2 = new Color (32, 82, 92);
		 frame.getContentPane().setBackground(color2);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	     Timer timer = new Timer(3000, new ActionListener(){
	    	    public void actionPerformed(ActionEvent evt) {
	    	        frame.dispose();
	    	    }
	    	});
	    	timer.setRepeats(false);
	    	timer.start();
	}

	// If one of the three buttons are clicked, divert the page to where the user wants to specifically go
	 public void actionPerformed(ActionEvent e) {
		   
		  
	  }
	 
	 // Call Main menu page
	 public static void main(String[] args) throws Exception {
		 new Loading();
	 }
}
