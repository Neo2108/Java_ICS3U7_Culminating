import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class loading extends JFrame implements ActionListener {
	JFrame frame;
	ImageIcon img;
	JLabel image;
    
    public loading() throws IOException, InterruptedException{
    	frame = new JFrame();
		frame.setLayout(null);
		img = new ImageIcon(this.getClass().getResource("ImagesFolder1/512x512.gif"));
		image = new JLabel(img);
		image.setBounds(350,170,600,400);
		
		frame.add(image);
		frame.setSize(1275, 775);
		 Color color2 = new Color (195, 195, 0);
		 frame.getContentPane().setBackground(color2);
	     frame.setVisible(true);
	     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	     Thread.sleep(5000);
	     frame.dispose();
	     
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws Exception {
		 new loading();
	 }
    }

