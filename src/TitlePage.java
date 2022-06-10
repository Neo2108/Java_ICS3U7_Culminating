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
	  title.setBounds(480,20,800,60);
	  image.setBounds(680,200,600,400);
	  image2.setBounds(20, 20, 600, 600);
	  image3.setBounds(810,80,600,400);
	  button = new JButton("Proceed");
	  button.setBounds(530, 400, 250, 60);
	  button.addActionListener(this);
	  Color color1 = new Color (0, 210, 0);
	  button.setBackground(color1);
	  

	  frame.add(title);
	  frame.add(image);
	  frame.add(image2);
	  frame.add(image3);
	  frame.add(button);
	  
	  frame.setSize(1275, 775);
	  Color color2 = new Color (195, 195, 0);
	  frame.getContentPane().setBackground(color2);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   // If button clicked... go to the next class
   public void actionPerformed(ActionEvent e) {
	   
	  if (e.getSource() == button) {
		  
		  frame.dispose();
		  
		  try {
			  gameMode newMenu = new gameMode();
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