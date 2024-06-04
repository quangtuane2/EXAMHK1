package database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
public class TrangTroGiup {
		public TrangTroGiup() {
	     JFrame frame = new JFrame("Error Login");
	        frame.setSize(500, 250);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(null); 
	        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/th (2).jpg"));
	        
			JButton ok = new JButton("ok");
			ok.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
			ok.setBounds(185, 175, 122, 28);
			ok.setBackground(Color.BLUE);
			ok.setForeground(Color.WHITE);
			frame.add(ok);
			
			JLabel lblNewLabel = new JLabel("Help !");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
			lblNewLabel.setBounds(21, 10, 228, 58);
			frame.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("If you have any questions, please contact via gmail vivalavida@gmail.com or phone number \r\n\r\n");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(21, 71, 444, 28);
			frame.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel(" 0976781028. Thank You!");
			lblNewLabel_2.setForeground(Color.BLACK);
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(21, 103, 408, 22);
			
			frame.add(lblNewLabel_2);
            
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}
			});
					 frame.setVisible(true);
					frame.setResizable(false);
	}
   
    	  
      }
    	  
      





