package database2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.JdanhSachPhong;
import database.Jkhachthue;
import database.JthonTIn;
import database.Jtinhtien;
import jfreechat.Bieudo;
import jfreechat.GrowthChartExample;
import jfreechat.HJJ;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSlider;
import javax.swing.JMenuItem;

public class Jmenu extends JFrame {

		private JPanel contentPane;

		public static void main(String[] args) {
			try {
	      		String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	    		UIManager.setLookAndFeel(str);
			} catch (Exception e) {
				
			}
			EventQueue.invokeLater(new Runnable() {
				
				public void run() {
					try {
						Jmenu frame = new Jmenu();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
			});
		}


		public Jmenu() {
			setFont(new Font("Dialog", Font.BOLD, 12));
			setTitle("Motel Management");
			//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 781, 570);
			contentPane = new JPanel();
			contentPane.setForeground(new Color(255, 128, 192));
			contentPane.setBackground(new Color(0, 64, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(new Color(255, 255, 255));
			menuBar.setBackground(new Color(255, 128, 192));
			menuBar.setBounds(0, 0, 767, 39);
			contentPane.add(menuBar);
			
			JMenu mnNewMenu = new JMenu("QUẢN LÍ NHÀ TRỌ ");
			mnNewMenu.setBackground(new Color(255, 255, 255));
			mnNewMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
			mnNewMenu.setForeground(new Color(255, 128, 192));
			menuBar.add(mnNewMenu);
			
			JButton btnNewButton = new JButton("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");
			btnNewButton.setBackground(new Color(255, 128, 192));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JthonTIn jt= new JthonTIn();
					jt.setVisible(true);
				}
			});
			mnNewMenu.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("QUẢN LÍ DANH SÁCH PHÒNG TRỌ  ");
			btnNewButton_1.setBackground(new Color(255, 128, 192));
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JdanhSachPhong jd = new JdanhSachPhong();
					jd.setVisible(true);
				}
			});
			mnNewMenu.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("QUẢN LÍ KHÁCH ĐÃ THUÊ PHÒNG  ");
			btnNewButton_2.setBackground(new Color(255, 128, 192));
			btnNewButton_2.setForeground(new Color(255, 255, 255));
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				      Jkhachthue jk = new Jkhachthue(null);
				      jk.setVisible(true);
				}
			});
			mnNewMenu.add(btnNewButton_2);
			
			JMenu mnNewMenu_1 = new JMenu("TÁC VỤ");
			mnNewMenu_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			mnNewMenu_1.setForeground(new Color(255, 128, 192));
			menuBar.add(mnNewMenu_1);
			
			JButton btnNewButton_3 = new JButton("TÍNH TIỀN TRỌ     ");
			btnNewButton_3.setBackground(new Color(255, 128, 192));
			btnNewButton_3.setForeground(new Color(255, 255, 255));
			btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jtinhtien jtt= new Jtinhtien();
					jtt.setVisible(true);
				}
			});
			mnNewMenu_1.add(btnNewButton_3);
			
			JButton btnNewButton_3_1 = new JButton("BIỀU ĐỒ TIỀN TRỌ");
			btnNewButton_3_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bieudo bd = new Bieudo("Biều Đồ Tiền Điện");
					bd.setVisible(true);
				}
			});
			btnNewButton_3_1.setForeground(Color.WHITE);
			btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_3_1.setBackground(new Color(255, 128, 192));
			mnNewMenu_1.add(btnNewButton_3_1);
			
			JLabel lblNewLabel_1 = new JLabel("Motel Management quản lý như một chuyên gia.");
			lblNewLabel_1.setForeground(new Color(255, 128, 192));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_1.setBounds(203, 443, 374, 59);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Jmenu.class.getResource("/images/snapedit_1705977499529.png")));
			lblNewLabel.setBounds(223, 201, 257, 255);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("VIVA LA VIDA!!!");
			lblNewLabel_2.setForeground(new Color(255, 128, 192));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_2.setBounds(457, 214, 136, 39);
			contentPane.add(lblNewLabel_2);
			
			JButton btnNewButton_4 = new JButton("EXIT");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 dispose();
				}
			});
			btnNewButton_4.setBackground(new Color(255, 128, 192));
			btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton_4.setForeground(new Color(255, 255, 255));
			btnNewButton_4.setBounds(679, 488, 88, 39);
			contentPane.add(btnNewButton_4);
			
			JLabel lblNewLabel_1_1 = new JLabel("WELCOME TO MOTEL MANAGEMENT");
			lblNewLabel_1_1.setForeground(new Color(255, 128, 192));
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_1_1.setBounds(197, 51, 380, 66);
			contentPane.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Jmenu.class.getResource("/images/snapedit_1705999817192.png")));
			lblNewLabel_3.setBounds(-38, 52, 805, 379);
			contentPane.add(lblNewLabel_3);
			this.setLocationRelativeTo(null);
		}
	}
