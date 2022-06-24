import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


// Class for user to enter their data (name, age, occupation) and then export it to text file, for use later while outputting the final results
public class MultiPlayerDataInput1 extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame();
	PlayerDataProperties1 userData1 = PlayerDataProperties1.getInstance();
	JLabel heading;
	JLabel age;
	JLabel name;
	JLabel occupation;
	static String nameText;
	static String occupationText;
	static String ageText;
	JComboBox ageSelect;
	JTextField nameSelect;
	JTextField jobSelect;
	JButton submit;
	
	public MultiPlayerDataInput1() throws IOException {
		Color astronautBlue = new Color (32, 82, 92);
		Color mindara = new Color (223, 230, 103);
		frame.setLayout(null);
		
		heading = new JLabel("Please enter Player 1's Data: ");
		heading.setFont(new Font("Impact", Font.PLAIN, 60));
		heading.setBounds(300,20,800,150);
		heading.setForeground(astronautBlue);
		
		age = new JLabel("AGE: ");
		age.setFont(new Font("Barlow", Font.PLAIN, 20));
		age.setBounds(400,325,800,25);
		age.setForeground(astronautBlue);
		
		name = new JLabel("NAME: ");
		name.setFont(new Font("Barlow", Font.PLAIN, 20));
		name.setBounds(400,225,800,25);
		name.setForeground(astronautBlue);
		
		occupation = new JLabel("OCCUPATION: ");
		occupation.setFont(new Font("Barlow", Font.PLAIN, 20));
		occupation.setBounds(400,425,800,25);
		occupation.setForeground(astronautBlue);
		
		// textFields
		nameSelect = new JTextField();
		nameSelect.setBounds(550, 225, 150, 25);
		
		
		jobSelect = new JTextField();
		jobSelect.setBounds(550, 425, 150, 25);
		
		
		
		// age field -> combo-box
		String[] ages = new String [83];
		for (int i = 0; i <= 82; i++) {
			ages[i] = i+18 +"";
			
		}
		ageSelect = new JComboBox(ages);
		//JComboBox ageSelect = new JComboBox(ages);
		
		ageSelect.setEditable(true);
		ageSelect.setBounds(550, 325, 60, 23);
		ageSelect.addActionListener(this);
		
		
		submit = new JButton("Submit");
		submit.setBounds(470, 525, 100, 30);
		submit.addActionListener(this);
		submit.setBackground(Color.LIGHT_GRAY);

		frame.add(ageSelect);
		frame.add(nameSelect);
		frame.add(jobSelect);
		frame.add(heading);
		frame.add(age);
		frame.add(name);
		frame.add(occupation);
		frame.add(submit);
		
		
		frame.setSize(1275, 775);
		frame.getContentPane().setBackground(mindara);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
	
	// call the method with the GUI elements
	public static void main(String[] args) throws IOException {
		new MultiPlayerDataInput1();
		
		
	}



	// Once submit button is clicked, write data into a text file for use later on, while outputting result
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			  
			  
			  
			  nameText = nameSelect.getText();
			  userData1.setPlayerName(nameText);
			  occupationText = jobSelect.getText();
			  userData1.setPlayerOccupation(occupationText);
			  ageText =  (String) ageSelect.getSelectedItem();
			  userData1.setPlayerAge(Integer.parseInt(ageText));
			  
			  
			try {
				FileWriter dataWriter = new FileWriter("userData1.txt");
				BufferedWriter writer = new BufferedWriter(dataWriter);
				writer.write("Name: " + nameText + "\n");
				writer.write("Occupation: " + occupationText + "\n");
				writer.write("Age: " + ageText);
				writer.close();
				
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
			frame.dispose();
			  
			  		  
			  try {
				  MultiPlayerDataInput2 newData = new MultiPlayerDataInput2();
			  } 
			  catch (IOException e1) {
				e1.printStackTrace();
			  }
			  
		  }
		
	}

}
