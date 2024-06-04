package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database2.Jmenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class login extends JFrame {
	
	private JPanel contentPane;
	public JTextField txtuser;
	public JPasswordField txtpass;
	public JButton btnlogin, btncancel;
	public JCheckBox chkRememberMe;
	private JButton btnSignUp;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_4;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		      		String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
		    		UIManager.setLookAndFeel(str);		
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public login() {
		setAutoRequestFocus(false);
		setFont(new Font("Arial", Font.BOLD, 30));
		setTitle("Motel Management");
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 518);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Motel Management");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(282, 10, 301, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(121, 104, 129, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(121, 202, 110, 31);
		contentPane.add(lblNewLabel_2);
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtuser.setBounds(282, 107, 317, 31);
		contentPane.add(txtuser);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpass.setBounds(282, 204, 317, 31);
		contentPane.add(txtpass);
		

		
		btnlogin = new JButton("Login");
		btnlogin.setForeground(new Color(255, 255, 255));
		btnlogin.setBackground(new Color(0, 0, 255));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						String username = new String(txtuser.getText());
						String password = new String (txtpass.getPassword());
						
						String username1 = "root";
						String password1 = "";
						String databaseName = "student";
						String url = "jdbc:mysql://localhost/" + databaseName;
						ResultSet rs ;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, username1, password1); 
						String sql = "SELECT * FROM taikhoan WHERE username = ? and password = ? ";// cau truy van den sql
						PreparedStatement ps = con.prepareStatement(sql);//cho phep chi dinh tham so dau vao khi chay
						ps.setString(1, txtuser.getText());//nhan vao mot tham so txtuser khi nguoi dung nhap vao
						ps.setString(2, password);
						rs = ps.executeQuery(); // executeQuery tra ve mot doi tuong resultset khi thuc hien cau lenh select
						
						StringBuilder sb = new StringBuilder();
						
						if (username .equals("")) {
							sb.append("username is empty \n");
							txtuser.setBackground(Color.YELLOW);
							txtuser.requestFocus();
						}
						if (password .equals("")) {
							sb.append("Password is empty\n");
							txtpass.setBackground(Color.YELLOW);
							txtpass.requestFocus();
						}
						
						
						if(username .equals("") || password .equals("")) {
							if (sb.length() > 0) {
							JOptionPane.showMessageDialog(login.this, sb.toString(), "Invalidation",
									JOptionPane.ERROR_MESSAGE);
							return;
							}
						}
						
						//else if(username.equals("admin") && password.equals("123456")) {
						else if(rs.next()) {
							JOptionPane.showMessageDialog(login.this, "Login successfully");
							if(chkRememberMe.isSelected()) {
								JOptionPane.showMessageDialog(login.this, "Login information is remember");
							}	
							try {
					      		String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
					    		UIManager.setLookAndFeel(str);
					    		Jmenu thongTinView = new Jmenu();
					    		thongTinView.setVisible(true);
							} catch (Exception e2) {
								// TODO: handle exception
							}
											
						}else {
							JOptionPane.showMessageDialog(login.this, "Invalid username or password", "Failure",
									JOptionPane.ERROR_MESSAGE);
						}
					
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
		
		
				}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setBounds(282, 361, 100, 37);
		contentPane.add(btnlogin);
		
		btncancel = new JButton("Cancel");
		btncancel.setForeground(new Color(255, 255, 255));
		btncancel.setBackground(new Color(0, 0, 255));
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtuser.setText("");
				txtpass.setText("");	
				chkRememberMe.setSelected(true);
			}
		});
		btncancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btncancel.setBounds(499, 361, 100, 37);
		contentPane.add(btncancel);
		
		chkRememberMe = new JCheckBox("Remember me?");
		chkRememberMe.setForeground(new Color(255, 128, 192));
		chkRememberMe.setBackground(new Color(255, 255, 255));
		chkRememberMe.setFont(new Font("Tahoma", Font.BOLD, 15));
		chkRememberMe.setBounds(282, 292, 145, 31);
		contentPane.add(chkRememberMe);
		
		btnSignUp = new JButton("Sign Up?");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpForm();
			}
		});
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignUp.setBackground(new Color(0, 255, 128));
		btnSignUp.setBounds(660, 421, 127, 37);
		contentPane.add(btnSignUp);
		
		separator = new JSeparator();
		separator.setBounds(10, 81, 777, 13);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 265, 777, 2);
		contentPane.add(separator_1);
		
		JCheckBox chckbxViewPassword = new JCheckBox("View Password");
		chckbxViewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxViewPassword.isSelected()) {
					txtpass.setEchoChar((char)0);
				}else {
					txtpass.setEchoChar('*');
				}
				
			}
		});
		chckbxViewPassword.setForeground(new Color(255, 128, 192));
		chckbxViewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxViewPassword.setBackground(Color.WHITE);
		chckbxViewPassword.setBounds(454, 292, 145, 31);
		contentPane.add(chckbxViewPassword);
		
		JButton btnHelp = new JButton("Help?");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TrangTroGiup();
				
			}
		});
		btnHelp.setForeground(new Color(255, 255, 255));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHelp.setBackground(new Color(0, 255, 128));
		btnHelp.setBounds(10, 421, 100, 37);
		contentPane.add(btnHelp);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/images/pngtree-vector-house-icon-png-image_889944.jpg")));
		lblNewLabel_3.setBounds(184, 0, 87, 80);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(login.class.getResource("/images/anhnen.png")));
		lblNewLabel_4.setBounds(0, 0, 797, 493);
		contentPane.add(lblNewLabel_4);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}