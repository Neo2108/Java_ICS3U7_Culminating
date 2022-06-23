import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Title page
public class EndScreen extends JFrame implements ActionListener {
   ImageIcon img, img2, img3;
   JLabel image, image2, image3, title, name, age, occupation, cashValue, netWorth, overallWinner;
   JFrame frame;
   JButton button;
   
   // This method contains all the GUI elements required to form up the JFrame
   public EndScreen() throws IOException {
	   
	  BufferedReader br1 = new BufferedReader(new FileReader("userData1.txt"));
	  BufferedReader br2 = new BufferedReader(new FileReader("userData2.txt"));
	  BufferedReader br3 = new BufferedReader(new FileReader("userDataSingle.txt"));
	  
	  String st1;
	  String st2;
	  String st3;
      // Condition holds true till
      // there is character in a string
      while ((st1 = br1.readLine()) != null) {

          // Print the string
    	  System.out.println(st1);
      }
      
      while ((st2 = br2.readLine()) != null) {

          // Print the string
          System.out.println(st2);
      }
      
      while ((st3 = br3.readLine()) != null) {

          // Print the string
          System.out.println(st3);
      }
	   
	  frame = new JFrame();
	  frame.setLayout(null);
	  img2 = new ImageIcon(this.getClass().getResource("ImagesFolder1/fatcapitalist.png"));
	  image2 = new JLabel(img2);
	  title = new JLabel("Thank you for playing the Auctioneer!");
	  title.setFont(new Font("Impact", Font.PLAIN, 60));
	  title.setBounds(280,20,800,150);
	  image2.setBounds(0, 20, 550, 650);
	  title.setForeground(Color.white);
	  button = new JButton("End Game!");
	  button.setBounds(530, 400, 250, 60);
	  button.addActionListener(this);
	  Color color1 = new Color (0, 210, 0);
	  button.setBackground(color1);
	  

	  frame.add(title);
	  frame.add(image2);
	  frame.add(button);
	  
	  frame.setSize(1275, 775);
	  Color color2 = new Color (32, 82, 92);
	  frame.getContentPane().setBackground(color2);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   
   // If button clicked... go to the next class
   public void actionPerformed(ActionEvent e) {
	   
	  if (e.getSource() == button) {
		  
		  frame.dispose();
		  
	  }
   }
   
   // Call the titlePage method, with all the various GUI elements on it
   public static void main(String[] args) throws Exception {
      new EndScreen();
      
   }
}	
