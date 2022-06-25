// Import packages as needed
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Title page
public class TitlePage extends JFrame implements ActionListener {
   ImageIcon img, img2, img3;
   JLabel image, image2, image3, title;
   JFrame frame;
   JButton button;
   
   // This method contains all the GUI elements required to form up the JFrame
   public TitlePage() throws IOException {
	  
	  // Initializing all variables needed for this frame (Labels, buttons, colours, images), and declaring them as desired
	  frame = new JFrame();
	  frame.setLayout(null);
	  img = new ImageIcon(this.getClass().getResource("ImagesFolder1/3dDollarSign.png"));
	  img2 = new ImageIcon(this.getClass().getResource("ImagesFolder1/fatcapitalist.png"));
	  img3 = new ImageIcon(this.getClass().getResource("ImagesFolder1/3dDollarSign.png"));
	  image = new JLabel(img);
	  image2 = new JLabel(img2);
	  image3 = new JLabel(img3);
	  title = new JLabel("The Auctioneer!");
	  title.setFont(new Font("Impact", Font.PLAIN, 60));
	  title.setBounds(480,20,800,150);
	  image.setBounds(680,200,600,400);
	  image2.setBounds(20, 20, 550, 650);
	  image3.setBounds(810,80,600,400);
	  title.setForeground(Color.white);
	  button = new JButton("Proceed");
	  button.setBounds(530, 400, 250, 60);
	  button.addActionListener(this);
	  Color color1 = new Color (0, 210, 0);
	  button.setBackground(color1);
	  
	  // Add all elements to this frame
	  frame.add(title);
	  frame.add(image);
	  frame.add(image2);
	  frame.add(image3);
	  frame.add(button);
	  
	  // Basic and fundamental additions to get the appropriate JFrame Panel required
	  frame.setSize(1275, 775);
	  Color color2 = new Color (32, 82, 92);
	  frame.getContentPane().setBackground(color2);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   
   // If "Proceed" button is clicked... go to the next class
   public void actionPerformed(ActionEvent e) {
	   
	  if (e.getSource() == button) {
		  
		  frame.dispose();
		  
		  try {
			  GameMode newMenu = new GameMode();
		  } 
		  catch (IOException e1) {
			  e1.printStackTrace();
		  }
		  
	  }
   }
   
   // Call the titlePage method, with all the various GUI elements on it
   public static void main(String[] args) throws Exception {
      new TitlePage();
      
   }
}	
