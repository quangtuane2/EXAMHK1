package database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database2.Jmenu;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
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

public class Jkhachthue extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JTextField tfID;
	private JTextField tfKhach;
	private JTextField tfPhong;
	private JTextField tfFind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jkhachthue frame = new Jkhachthue(null);
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
	public Jkhachthue(String id) {
		setTitle("Khách Thuê Phòng");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 830, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				tfID.setText(table.getValueAt(row, 0).toString());
				tfKhach.setText(table.getValueAt(row, 1).toString());
				tfPhong.setText(table.getValueAt(row, 2).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Thu\u00EA", "ID Kh\u00E1ch Thu\u00EA", "ID Ph\u00F2ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(69);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("QUẢN LÝ KHÁCH THUÊ PHÒNG");
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(265, 10, 345, 29);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ID Thuê:");
		lblNewLabel_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(70, 91, 151, 29);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ID Khách Thuê:");
		lblNewLabel_2.setForeground(new Color(255, 128, 192));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(70, 161, 151, 29);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ID Phòng:");
		lblNewLabel_3.setForeground(new Color(255, 128, 192));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(70, 232, 151, 29);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_6 = new JLabel("Tìm Kiếm:\r\n");
		lblNewLabel_6.setForeground(new Color(255, 128, 192));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(494, 232, 105, 29);
		contentPane.add(lblNewLabel_6);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfID.setBounds(247, 94, 158, 29);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfKhach = new JTextField();
		tfKhach.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfKhach.setColumns(10);
		tfKhach.setBounds(247, 164, 158, 29);
		contentPane.add(tfKhach);
		
		tfPhong = new JTextField();
		tfPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfPhong.setColumns(10);
		tfPhong.setBounds(247, 235, 158, 29);
		contentPane.add(tfPhong);
		
		tfFind = new JTextField();
		tfFind.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfFind.setColumns(10);
		tfFind.setBounds(609, 235, 158, 29);
		contentPane.add(tfFind);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setIcon(new ImageIcon(Jkhachthue.class.getResource("/images/close-removebg-preview.png")));
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				 SwingUtilities.invokeLater(new Runnable() {
//			            @Override
//			            public void run() {
//			                new Jmenu().setVisible(true);
//			            }
//			        });
				 dispose();
			}
		});
		btnNewButton.setBounds(678, 543, 151, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setIcon(new ImageIcon(Jkhachthue.class.getResource("/images/add.png")));
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					KhachThue kt= new KhachThue();
					kt.setIdthue(tfID.getText());
					kt.setIdkhach(tfKhach.getText());
					kt.setIdPhong(tfPhong.getText());
	                JDBCutil3.insert(kt);
	                JOptionPane.showConfirmDialog(null, "Save success");
	                
	                
	                try {
	                	String tt="Đã có";
	                	String id=tfPhong.getText();
	                    Connection con = JDBCutil2.getConnection();
	                    String sql = "UPDATE dsphongtro SET  trangThai = ?"
	                     		+ "WHERE iD = ?";
	                    PreparedStatement stmt = con.prepareStatement(sql);
	                    stmt.setString(1, tt);
	                    stmt.setString(2,id);
	                    stmt.executeUpdate();
	                   
	                   
	                } catch (Exception e1) {
	                    System.out.println(e1);
	                }
					Showdata();
				
			}
		});
		btnNewButton_1.setBounds(42, 289, 151, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Find");
		btnNewButton_2.setIcon(new ImageIcon(Jkhachthue.class.getResource("/images/download.png")));
		btnNewButton_2.setBackground(new Color(255, 128, 192));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = tfFind.getText();
				find = "%" + find + "%";
				String [] arr = {"ID thuê","ID Khách Hàng","ID Phòng","họ","Tên" };
				DefaultTableModel model = new DefaultTableModel(arr, 0);
				String query = "SELECT * FROM khachthue\n"
						+ "WHERE Tên LIKE ?";
				try {
					Connection c = JDBCutil.getConnection();
					PreparedStatement st = c.prepareStatement(query);
					st.setString(1, find);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
							Vector<String> vector=new Vector<String>();
							vector.add(rs.getString(1));
							vector.add(rs.getString(2));
							vector.add(rs.getString(3));
							vector.add(rs.getString(4));
							vector.add(rs.getString(5));
							model.addRow(vector);
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
				table.setModel(model);
				//showdata();

			}
		});
		btnNewButton_2.setBounds(637, 289, 151, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setIcon(new ImageIcon(Jkhachthue.class.getResource("/images/1345874.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection c=JDBCutil.getConnection();
					String query= "delete from khachthue where Num = ?";
					PreparedStatement ps=c.prepareStatement(query);
					ps.setString(1, tfID.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Xóa xong");
					
				}
				catch (Exception ex){
					ex.printStackTrace();
				}
				 
                try {
                	String tt="Trống";
                	String id=tfPhong.getText();
                    Connection con = JDBCutil2.getConnection();
                    String sql = "UPDATE dsphongtro SET  trangThai = ?"
                     		+ "WHERE iD = ?";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setString(1, tt);
                    stmt.setString(2,id);
                    stmt.executeUpdate();
                   
                   
                } catch (Exception e1) {
                    System.out.println(e1);
                }
				Showdata();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1_1.setBounds(237, 289, 151, 40);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Refresh");
		btnNewButton_1_2.setIcon(new ImageIcon(Jkhachthue.class.getResource("/images/1200px-Ic_refresh_48px.svg.png")));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfID.setText("");
				tfKhach.setText("");
				tfPhong.setText("");
				tfFind.setText("");
			}
		});
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_2.setBackground(new Color(255, 128, 192));
		btnNewButton_1_2.setBounds(437, 289, 151, 40);
		contentPane.add(btnNewButton_1_2);
		Showdata();
		this.setLocationRelativeTo(null);
	}
	public void Showdata() {
		try {
			String [] arr = {"ID Thuê","ID Khách Thuê","ID Phòng"};
			DefaultTableModel model = new DefaultTableModel(arr,0);
			Connection c=JDBCutil.getConnection();
			String query= "select *from khachthue";
			PreparedStatement ps=c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector<String> vector=new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				model.addRow(vector);
				
			}

			table.setModel(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}
}
