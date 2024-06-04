package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JdanhSachPhong extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfID;
	private JTextField tfTt;
	private JTextField tfName;
	private JTextField tfPrice;

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
					JdanhSachPhong frame = new JdanhSachPhong();
					frame.setLocationRelativeTo(null);
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
	public JdanhSachPhong() {
		setTitle("Danh Sách Phòng Trọ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÍ DANH SÁCH PHÒNG TRỌ ");
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 25));
		lblNewLabel.setBounds(234, 6, 409, 32);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 330, 834, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				tfID.setText(table.getValueAt(row, 0).toString());
				tfName.setText(table.getValueAt(row, 1).toString());
				tfTt.setText(table.getValueAt(row, 2).toString());
				tfPrice.setText(table.getValueAt(row, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Trạng Thái", "Tên Phòng", "Giá Phòng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(129);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(108, 125, 35, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setIcon(new ImageIcon(JdanhSachPhong.class.getResource("/images/save.jpg")));
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dsphongtro ds= new Dsphongtro();
				ds.setiD(tfID.getText());
				ds.setTenPhong(tfName.getText());
				ds.setTrangthai(tfTt.getText());
				ds.setGiaPhong(tfPrice.getText());
				JDBCutil2.insert(ds);
				JOptionPane.showConfirmDialog(null,"Thêm thành công");
				Showdata();
			}
		});
		btnNewButton.setBounds(53, 267, 107, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setIcon(new ImageIcon(JdanhSachPhong.class.getResource("/images/update.png")));
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dsphongtro ds = new Dsphongtro();
				ds.setiD(tfID.getText());
				ds.setTenPhong(tfName.getText());
				ds.setTrangthai(tfTt.getText());
				ds.setGiaPhong(tfPrice.getText());
				JDBCutil2.Update(ds);
				JOptionPane.showConfirmDialog(null,"cập nhật thành công");
				Showdata();
			}
		});
		btnNewButton_1.setBounds(249, 267, 123, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setIcon(new ImageIcon(JdanhSachPhong.class.getResource("/images/1345874.png")));
		btnNewButton_2.setBackground(new Color(255, 128, 192));
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dsphongtro ds = new Dsphongtro();
				ds.setTenPhong(tfName.getText());
				JDBCutil2.Delete(ds);
				Showdata();
			}
		});
		btnNewButton_2.setBounds(457, 267, 119, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.setIcon(new ImageIcon(JdanhSachPhong.class.getResource("/images/1200px-Ic_refresh_48px.svg.png")));
		btnNewButton_3.setBackground(new Color(255, 128, 192));
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfPrice.setText("");
				tfID.setText("");
				tfName.setText("");
				tfTt.setText("");
			}
		});
		btnNewButton_3.setBounds(664, 267, 129, 40);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trạng Thái");
		lblNewLabel_1_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(53, 196, 109, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên Phòng");
		lblNewLabel_1_2.setForeground(new Color(255, 128, 192));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(469, 125, 118, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel txtGiaPhong = new JLabel("Giá Phòng");
		txtGiaPhong.setForeground(new Color(255, 128, 192));
		txtGiaPhong.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtGiaPhong.setBounds(469, 196, 107, 23);
		contentPane.add(txtGiaPhong);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfID.setBounds(174, 122, 147, 32);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfTt = new JTextField();
		tfTt.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfTt.setColumns(10);
		tfTt.setBounds(174, 187, 147, 32);
		contentPane.add(tfTt);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfName.setColumns(10);
		tfName.setBounds(599, 122, 147, 32);
		contentPane.add(tfName);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfPrice.setColumns(10);
		tfPrice.setBounds(599, 193, 147, 32);
		contentPane.add(tfPrice);
		
		JButton btnNewButton_3_1 = new JButton("Cancel");
		btnNewButton_3_1.setIcon(new ImageIcon(JdanhSachPhong.class.getResource("/images/close-removebg-preview.png")));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnNewButton_3_1.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton_3_1.setBackground(new Color(255, 128, 192));
		btnNewButton_3_1.setBounds(685, 547, 155, 40);
		contentPane.add(btnNewButton_3_1);
		Showdata();
		this.setLocationRelativeTo(null);
	}
	public void Showdata() {
		try {
			String [] arr = {"iD","tenPhong","trangThai","giaPhong"};
			DefaultTableModel model = new DefaultTableModel(arr,0);
			Connection c=JDBCutil.getConnection();
			String query= "select *from dsphongtro";
			PreparedStatement ps=c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<String> vector=new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				model.addRow(vector);
				
			}
			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}
}
