import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

// Title page
public class EndScreen extends JFrame implements ActionListener {
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	PlayerDataProperties2 userData2 = PlayerDataProperties2.getInstance();
	SinglePlayerDataProperties playerData = SinglePlayerDataProperties.getInstance();
	ComputerDataProperties computerData = ComputerDataProperties.getInstance();
    ImageIcon img, img2, img3;
    JLabel image, title, name, age, occupation, cashValue, netWorth;
    JFrame frame;
    JButton button;
   
   // This method contains all the GUI elements required to form up the JFrame
   public EndScreen() throws IOException {
	  BufferedReader br = null;
	  
	  // main decorations
	  frame = new JFrame();
	  frame.setLayout(null);
	  img2 = new ImageIcon(this.getClass().getResource("ImagesFolder1/fatcapitalist.png"));
	  image = new JLabel(img2);
	  title = new JLabel("Thank you for playing the Auctioneer!");
	  title.setFont(new Font("Impact", Font.PLAIN, 45));
	  title.setBounds(280,20,800,150);
	  image.setBounds(-50, 20, 550, 650);
	  title.setForeground(Color.white);
	  button = new JButton("End Game!");
	  button.setBounds(530, 400, 250, 60);
	  button.addActionListener(this);
	  Color color1 = new Color (0, 210, 0);
	  button.setBackground(color1);
	  
	  // bas
	  String nameText = "[name]";
	  String occupationText = "[occupation]";
	  String ageText = "[age]";
	  
	  // if p1 wins
	  br = new BufferedReader(new FileReader("userData1.txt"));
	  int netWorth = 0;
	  if (userData1.getGameMode().equals("Multiplayer") && userData1.getNetWorth() > userData2.getNetWorth()) {
		   br = new BufferedReader(new FileReader("userData1.txt"));
		   netWorth = userData1.getNetWorth();
	  }
	  
	  // if p2 wins
	  else if (userData1.getGameMode().equals("Multiplayer") && userData1.getNetWorth() < userData2.getNetWorth()) {
		   br = new BufferedReader(new FileReader("userData2.txt"));
		   netWorth = userData2.getNetWorth();
	  }
	  
	  // if single player wins
	  else if (userData1.getGameMode().equals("Singleplayer") && playerData.getNetWorth() > computerData.getNetWorth()) {
		   br = new BufferedReader(new FileReader("userDataSingle.txt"));
		   netWorth = playerData.getNetWorth();
	  }
	  
	  // read everything with the buffered reader
	  nameText = br.readLine().replace("Name: ", "");
	  occupationText = br.readLine().replace("Occupation: ", "") + " with a net worth of $" + netWorth;
	  ageText = "(" + br.readLine().replace("Age: ", "") + " years old)";
	  
	  // capitalize first letter of the name
	  String s1 = nameText.substring(0, 1).toUpperCase();
	  nameText = s1 + nameText.substring(1);
	  nameText = nameText + " " + ageText+ " is the winner!";
	  
	  
	  // capitalize first letter of the occupation
	  String s2 = occupationText.substring(0, 1).toUpperCase();
	  occupationText = s2 + occupationText.substring(1);
	  br.close();
	  
	  // if computer wins
	  if (userData1.getGameMode().equals("Singleplayer") && playerData.getNetWorth() < computerData.getNetWorth()) {
		  netWorth = computerData.getNetWorth();
		  nameText = "Computer is the winner!";
		  occupationText = "Computer has a net worth of $" + netWorth + "!";
		  ageText = "";
	  }
	  
	  // write the occupation
	  occupation = new JLabel (occupationText);
	  occupation.setFont(new Font("Barlow", Font.PLAIN, 30));
	  occupation.setBounds(520,125+50,800,120);
	  occupation.setForeground(Color.white);
	 
	  // write the name
	  name = new JLabel (nameText);
	  name.setFont(new Font("Barlow", Font.PLAIN, 30));
	  name.setBounds(520,125,800,120);
	  name.setForeground(Color.white);

	  // add everything
	  frame.add(title);
	  frame.add(image);
	  frame.add(button);
	  frame.add(name);
	  frame.add(occupation);
	  
	  // setup backgrounds
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
