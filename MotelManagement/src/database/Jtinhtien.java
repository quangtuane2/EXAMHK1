package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database2.Jmenu;
import jfreechat.Bieudo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Jtinhtien extends JFrame {

	private JPanel contentPane;
	private JTextField tfPhong;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		  try {
	      		String str="javax.swing.plaf.nimbus.NimbusLookAndFeel";
	    		UIManager.setLookAndFeel(str);
			} catch (Exception e) {
				// TODO: handle exception
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jtinhtien frame = new Jtinhtien();
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
	public Jtinhtien() {
		setTitle("Tính Tiền");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÍNH TIỀN");
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(357, 6, 165, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TÊN PHÒNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1.setBounds(48, 78, 140, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HỌ VÀ TÊN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_1.setBounds(48, 138, 117, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("GIÁ PHÒNG");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_2.setBounds(48, 196, 140, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("THÀNH TIỀN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 128, 192));
		lblNewLabel_2.setBounds(48, 249, 140, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ĐIỆN(chữ)");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_3.setBounds(468, 78, 100, 31);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("NƯỚC(cm^3)");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_4.setBounds(468, 138, 134, 31);
		contentPane.add(lblNewLabel_1_4);
		
		tfPhong = new JTextField();
		tfPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfPhong.setBounds(231, 80, 146, 31);
		contentPane.add(tfPhong);
		tfPhong.setColumns(10);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfName.setColumns(10);
		tfName.setBounds(231, 140, 146, 31);
		contentPane.add(tfName);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfPrice.setColumns(10);
		tfPrice.setBounds(231, 198, 146, 31);
		contentPane.add(tfPrice);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(626, 80, 146, 31);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(626, 140, 146, 31);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(231, 251, 146, 31);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Thành Tiền");
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 double num1 = Double.parseDouble(textField_3.getText());
		            double num2 = Double.parseDouble(textField_4.getText());
		            double num3= Double.parseDouble(tfPrice.getText());
		            double result = num1*3000+ num2*6000+num3;
		            textField_5.setText(String.valueOf(result));
			}
		});
		btnNewButton.setBounds(409, 244, 146, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				 SwingUtilities.invokeLater(new Runnable() {
//			            public void run() {
//			                new Jmenu().setVisible(true);
//			            }
//			        });
				 dispose();
			}
		});
		btnNewButton_1.setBounds(740, 546, 100, 41);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 322, 830, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String name = table.getValueAt(row, 1).toString();
				String phong = table.getValueAt(row, 3).toString();
				String price = table.getValueAt(row, 4).toString();
				tfName.setText(name);
				tfPhong.setText(phong);
				tfPrice.setText(price);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 H\u0110", "T\u00EAn KH", "S\u0110T", "T\u00EAn ph\u00F2ng", "Gi\u00E1 ph\u00F2ng"
			}
		));
		scrollPane.setViewportView(table);
		
		showData();
		this.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("unchecked")
	public void showData() {
		try {
			table.removeAll();
			String[] arr = {"Số HĐ", "Tên KH", "SĐT", "Tên phòng", "Giá phòng"};
			DefaultTableModel model = new DefaultTableModel(arr, 0);
			Connection connection = JDBCutil.getConnection();
			String query = "SELECT khachthue.Num, thongtin.name, thongtin.sdt, dsphongtro.tenPhong, dsphongtro.giaPhong FROM khachthue\r\n"
					+ "JOIN thongtin ON thongtin.id = khachthue.idKH\r\n"
					+ "JOIN dsphongtro ON dsphongtro.iD = khachthue.idP";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector vector = new Vector();
				vector.add(rs.getString(1).trim());
				vector.add(rs.getString(2).trim());
				vector.add(rs.getString(3).trim());
				vector.add(rs.getString(4).trim());
				vector.add(rs.getString(5).trim());
				model.addRow(vector);
			}
			table.setModel(model);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
