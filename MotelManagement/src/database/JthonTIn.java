package database;

import javax.swing.*;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Color;

public class JthonTIn extends JFrame {

	private JPanel contentPane;
	private JTextField txname;
	private JTextField txdiachi;
	private JTextField txsdt;
	private JTable table;
	private JTextField tfID;
	String filename=null;
	byte[] person_image=null;
	private JTextField tfFind;

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
					JthonTIn frame = new JthonTIn();
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
	public JthonTIn() {
		setTitle("Thông Tin Khách Hàng");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 685);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 128, 192));
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 22));
		lblNewLabel.setBounds(268, 10, 363, 46);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(28, 163, 75, 36);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("diachi");
		lblNewLabel_2.setForeground(new Color(255, 128, 192));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(28, 225, 75, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("gioitinh");
		lblNewLabel_3.setForeground(new Color(255, 128, 192));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(375, 107, 75, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("sdt");
		lblNewLabel_4.setForeground(new Color(255, 128, 192));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(375, 163, 75, 36);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbImage = new JLabel(new ImageIcon());
		lbImage.setBounds(693, 91, 135, 164);
		contentPane.add(lbImage);

		txname = new JTextField();
		txname.setFont(new Font("Tahoma", Font.BOLD, 18));
		txname.setBounds(125, 165, 178, 36);
		contentPane.add(txname);
		txname.setColumns(10);

		txdiachi = new JTextField();
		txdiachi.setFont(new Font("Tahoma", Font.BOLD, 18));
		txdiachi.setColumns(10);
		txdiachi.setBounds(125, 227, 178, 36);
		contentPane.add(txdiachi);

		txsdt = new JTextField();
		txsdt.setFont(new Font("Tahoma", Font.BOLD, 18));
		txsdt.setColumns(10);
		txsdt.setBounds(503, 163, 178, 36);
		contentPane.add(txsdt);

		JComboBox cbgioitinh = new JComboBox();
		cbgioitinh.setFont(new Font("Tahoma", Font.BOLD, 18));
		cbgioitinh.setModel(new DefaultComboBoxModel(new String[] { "Male ", "Female" }));
		cbgioitinh.setBounds(503, 103, 178, 36);
		contentPane.add(cbgioitinh);

		JButton btnNewButton = new JButton("save");
		btnNewButton.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/save.jpg")));
		btnNewButton.setBackground(new Color(255, 128, 192));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thongtin tt = new Thongtin();
				tt.setId(tfID.getText());
				tt.setName(txname.getText());
				tt.setDiachi(txdiachi.getText());
				String gt = cbgioitinh.getSelectedItem().toString().trim();
				if (gt.equalsIgnoreCase("Male")) {
					tt.setGioitinh(0);
				}
				else {
					tt.setGioitinh(1);
				}
				tt.setSdt(txsdt.getText());
				tt.setImage(person_image);
				JDBCutil.insert(tt);
				JOptionPane.showConfirmDialog(null, "Save success");
				showdata();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(16, 293, 142, 51);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("delete");
		btnDelete.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/1345874.png")));
		btnDelete.setBackground(new Color(255, 128, 192));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thongtin tt = new Thongtin();
				tt.setName(txname.getText());
				JDBCutil.delete(tt);
				showdata();

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(350, 293, 142, 51);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("update");
		btnUpdate.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/update.png")));
		btnUpdate.setBackground(new Color(255, 128, 192));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thongtin tt = new Thongtin();
			tt.setId(tfID.getText());
				tt.setName(txname.getText());
				tt.setDiachi(txdiachi.getText());
				tt.setGioitinh(cbgioitinh.getSelectedIndex());
				tt.setSdt(txsdt.getText());
				tt.setImage(person_image);
				JDBCutil.Update(tt);
				JOptionPane.showConfirmDialog(null, "Update success");
				showdata();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(181, 293, 142, 51);
		contentPane.add(btnUpdate);

		JButton btnRef = new JButton("refresh");
		btnRef.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/1200px-Ic_refresh_48px.svg.png")));
		btnRef.setBackground(new Color(255, 128, 192));
		btnRef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfID.setText("");
				txname.setText("");
				txdiachi.setText("");
				txsdt.setText("");
				lbImage.setIcon(null);
				
			}
		});
		btnRef.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRef.setBounds(522, 293, 142, 51);
		contentPane.add(btnRef);

		JButton btnFind = new JButton("find");
		btnFind.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/download.png")));
		btnFind.setBackground(new Color(255, 128, 192));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = tfFind.getText();
				find = "%" + find + "%";
				String [] arr = {"id","name","diachi","gioitinh","sdt","images"};
				DefaultTableModel model = new DefaultTableModel(arr, 0);
				String query = "SELECT * FROM thongtin\n"
						+ "WHERE NAME LIKE ?";
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
							vector.add(rs.getString(6));
							model.addRow(vector);
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
				table.setModel(model);
				//showdata();

			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFind.setBounds(693, 293, 142, 51);
		contentPane.add(btnFind);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 373, 834, 214);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String id = table.getValueAt(row, 0).toString();
				String name = table.getValueAt(row, 1).toString();
				String dc = table.getValueAt(row, 2).toString();
				String t = table.getValueAt(row, 3).toString().trim();
				String gt = null;
				if (t.substring(0, 1).equalsIgnoreCase("0")) {
					gt = "Male";
				}
				else {
					gt = "Female";
				}
				//System.out.print(gt);
				String sdt = table.getValueAt(row, 4).toString();
				tfID.setText(id);
				txname.setText(name);
				txdiachi.setText(dc);
				int i = 0;
				while (true) {
					String frCb = cbgioitinh.getItemAt(i).toString().trim();
					//System.out.println(frCb);
					if (frCb.equalsIgnoreCase(gt)) {
						cbgioitinh.setSelectedIndex(i);
						break;
					}
					i++;
					if (i > 1) break;
				}
				txsdt.setText(sdt);
				try {
					Connection con = JDBCutil.getConnection();
					String query = "select * from thongtin where id = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						person_image = rs.getBytes(6);
					}
					
				}
				catch (Exception ex) {
					ex.setStackTrace(null);
				}
				ImageIcon imageicon = new ImageIcon(new ImageIcon(person_image).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
				lbImage.setIcon(imageicon);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"images", "id", "name", "diachi", "gioitinh", "sdt"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(39);
		table.getColumnModel().getColumn(3).setMinWidth(35);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(127);
		scrollPane.setViewportView(table);
		
		JLabel lb = new JLabel("id");
		lb.setForeground(new Color(255, 128, 192));
		lb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb.setBounds(28, 103, 75, 36);
		contentPane.add(lb);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfID.setColumns(10);
		tfID.setBounds(125, 102, 178, 36);
		contentPane.add(tfID);
		
		   String imagePath = "image.jpg";
		
		JButton btnNewButton_1 = new JButton("Browser");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				filename = f.getAbsolutePath();
				ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH));
				lbImage.setIcon(imageicon);
				try {
					File image = new File(filename);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte[] buf = new byte[1024];
					for (int readNum; (readNum=fis.read(buf))!=-1;) {
						bos.write(buf, 0, readNum);
					}
					person_image=bos.toByteArray();
				}
				catch (Exception ex) {
				 
				}
			}
		});
		btnNewButton_1.setBounds(503, 52, 114, 51);
		contentPane.add(btnNewButton_1);
		
		tfFind = new JTextField();
		tfFind.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfFind.setBounds(503, 227, 178, 36);
		contentPane.add(tfFind);
		tfFind.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_4_1.setForeground(new Color(255, 128, 192));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(375, 225, 97, 36);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(JthonTIn.class.getResource("/images/close-removebg-preview.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancel.setBackground(new Color(255, 128, 192));
		btnCancel.setBounds(703, 591, 142, 51);
		contentPane.add(btnCancel);
		
//		JButton btnNewButton_2 = new JButton("TienTro");
//		btnNewButton_2.setBackground(Color.PINK);
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JTienTroo jr= new JTienTroo();
//				jr.setVisible(true);
//			}
//		});
//		btnNewButton_2.setBounds(685, 0, 85, 34);
//		contentPane.add(btnNewButton_2);
		
		
		showdata();
		this.setLocationRelativeTo(null);
	}

public void showdata() {
	try {
		String [] arr = {"id","name","diachi","gioitinh","sdt"};
		DefaultTableModel model = new DefaultTableModel(arr,0);
		Connection c=JDBCutil.getConnection();
		String query= "select *from thongtin";
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
		// TODO: handle exception
	}
  
}
}
