package database;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import database.JDBCutil;

public class SignUpForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SignUpForm frame = new SignUpForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpForm() {
		setFont(new Font("Arial", Font.BOLD, 30));
		setTitle("Sign Up");
//		String username = "root";
//		String password = "";
//		String databaseName = "student";
//		String url = "jdbc:mysql://localhost/" + databaseName;
//		Statement st ;
//		ResultSet rs ;
		setAutoRequestFocus(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up ");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(212, 10, 113, 28);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 484, 22);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 96, 113, 34);
		contentPane.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtUsername.setBounds(201, 96, 267, 30);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPassword.setBounds(201, 159, 267, 30);
		contentPane.add(txtPassword);
		
		txtConfirmpassword = new JPasswordField();
		txtConfirmpassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtConfirmpassword.setBounds(201, 220, 267, 30);
		contentPane.add(txtConfirmpassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 281, 484, 8);
		contentPane.add(separator_1);
		
		JButton btnsignup = new JButton("Sign Up");
		btnsignup.setBackground(new Color(0, 0, 255));
		btnsignup.setForeground(new Color(255, 255, 255));
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int dk = JOptionPane.showConfirmDialog(null, "Are you Sign Up?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(dk != JOptionPane.YES_NO_OPTION) {
					return;
				}		
				String password = new String(txtPassword.getPassword());
				String confirm = new String(txtConfirmpassword.getPassword());
				StringBuilder sb = new StringBuilder();
				
				if(txtUsername.getText().equals("")) {
					sb.append("Username is required! \n");
					txtUsername.setBackground(Color.YELLOW);
					txtUsername.requestFocus();
				}else {
					txtUsername.setBackground(Color.WHITE);
				}
				
				//String password = new String(txtPassword.getPassword());
				if(password.equals("")) {
					sb.append("Password is required! \n");
					txtPassword.setBackground(Color.YELLOW);
					txtPassword.requestFocus();
				}else {
					txtPassword.setBackground(Color.WHITE);
				}
				//String confirm = new String(txtConfirmpassword.getPassword());
				if(txtUsername.getText().equals("") && password.equals("") && confirm.equals("") ||  confirm.equals("")){
					sb.append("Confirm Password is required! \n");
					txtConfirmpassword.setBackground(Color.YELLOW);
				}
						
				else if(!password.equals(confirm)) {
					sb.append("Password and Confirm Password must be the same \n");
					txtPassword.setBackground(Color.YELLOW);
					txtConfirmpassword.setBackground(Color.YELLOW);		
					
				}else {
					txtPassword.setBackground(Color.WHITE);
					txtConfirmpassword.setBackground(Color.WHITE);
					String username = "root";
					String password1 = "";
					String databaseName = "student";
					String url = "jdbc:mysql://localhost/" + databaseName;
					Statement st ;
					ResultSet rs ;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password1); 
					String sql = "insert into taikhoan values(?,?,?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, txtUsername.getText());
					ps.setString(2, password);
					ps.setString(3, confirm);
					
					int n = ps.executeUpdate();
					if(n != 0) {
					JOptionPane.showMessageDialog(contentPane, "Information is valid");
					JOptionPane.showMessageDialog(contentPane, "Sign Up successfully");
					}

				}
				if(sb.length() > 0) {
					JOptionPane.showMessageDialog(contentPane, sb.toString(), "Invalidation",
							JOptionPane.ERROR_MESSAGE);
					JOptionPane.showMessageDialog(contentPane, "Sign Up unsuccessfully","Failure",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
								
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnsignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsignup.setBounds(117, 332, 113, 30);
		contentPane.add(btnsignup);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.setBackground(new Color(0, 0, 255));
		btncancel.setForeground(new Color(255, 255, 255));
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(261, 332, 104, 30);
		contentPane.add(btncancel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 159, 113, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(20, 220, 174, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JCheckBox chckbxViewPassword = new JCheckBox("View Password");
		chckbxViewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxViewPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
					txtConfirmpassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('*');
					txtConfirmpassword.setEchoChar('*');
				}
			}
		});
		chckbxViewPassword.setForeground(new Color(255, 128, 192));
		chckbxViewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxViewPassword.setBackground(Color.WHITE);
		chckbxViewPassword.setBounds(323, 295, 145, 31);
		contentPane.add(chckbxViewPassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignUpForm.class.getResource("/images/99_20.jpg")));
		lblNewLabel_2.setBounds(0, 0, 504, 372);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
