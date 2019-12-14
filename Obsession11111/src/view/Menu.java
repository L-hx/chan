/*
 * Menu.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.io.IOException;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import server.Client;

import model.Thing;
import model.User;

/**
 *
 * @author  __USER__
 */
public class Menu extends javax.swing.JFrame {
	private static User u;
	private static Thing thing;
	private String tid;
	private Object Thing;

	/** Creates new form Menu */
	public Menu(User u) {
		this.u = u;
		initComponents();
		this.setLocationRelativeTo(null);
		try {
			update(String.valueOf(u.getUid()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setIconImage(new ImageIcon("logo.png").getImage());
		JLabel jlb = new JLabel();
		jlb.setBounds(0, 0, this.getWidth(), this.getHeight());
		jlb.setIcon(new ImageIcon("7.png"));
		this.add(jlb);
	}

	public static void update(String id) throws SQLException,
			ClassNotFoundException, IOException {

		//		User u = new User();
		System.out.print("Menu1");
		ArrayList<model.Thing> thing = Client.viewAllThing(id);
		Object title[] = { "ID", "待办事项", "时间" };
		Object detail[][] = new Object[thing.size()][3];
		for (int i = 0; i < thing.size(); i++) {
			detail[i][0] = thing.get(i).getTid();
			detail[i][1] = thing.get(i).getThing();
			detail[i][2] = thing.get(i).getTime();
		}
		Menu.jTable2.setModel(new DefaultTableModel(detail, title));
		TableColumn idColumn = jTable2.getColumnModel().getColumn(0);
		idColumn.setWidth(0);
		idColumn.setMaxWidth(0);
		idColumn.setMinWidth(0);
		jTable2.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0); //设置表的标题的宽度也为0,这个很重要
		jTable2.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton5 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u5f85\u529e");

		jButton5.setText("\u67e5\u770b\u4e8b\u9879");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton5ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jButton3.setText("\u5220 \u9664");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(jTable2);

		jButton1.setText("\u589e\u6dfb\u4e8b\u9879");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u8fd4\u56de\u9996\u9875");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(642, 642, 642)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																123,
																Short.MAX_VALUE)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																123,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																123,
																Short.MAX_VALUE)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																123,
																Short.MAX_VALUE))
										.addGap(82, 82, 82))
						.addGroup(
								layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												layout
														.createSequentialGroup()
														.addGap(80, 80, 80)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																467,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap(300,
																Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(82, 82, 82).addComponent(
						jButton5).addGap(83, 83, 83).addComponent(jButton1)
						.addGap(78, 78, 78).addComponent(jButton3).addGap(62,
								62, 62).addComponent(jButton2).addContainerGap(
								142, Short.MAX_VALUE)).addGroup(
				layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						layout.createSequentialGroup().addGap(69, 69, 69)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										424,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(70, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException {
		if (jTable2.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要查询的数据行");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定要查询");
		try {
			if (result == JOptionPane.OK_OPTION) {
				int tid = Integer.valueOf(jTable2.getValueAt(
						jTable2.getSelectedRow(), 0).toString());
				Thing thing = null;
				try {
					thing = Client.viewthing(tid);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				loadData();
				new Revise(thing).setVisible(true);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "待办id不存在");
		}

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException, ClassNotFoundException {
		if (jTable2.getSelectedRowCount() <= 0) {
			JOptionPane.showMessageDialog(null, "请选择要删除的数据行");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "是否确定要删除");

		if (result == JOptionPane.OK_OPTION) {
			int tid = Integer.valueOf(jTable2.getValueAt(
					jTable2.getSelectedRow(), 0).toString());
			try {
				Client.delete(tid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadData();
			int viewIndex = jTable2.getSelectedRow();
			if (viewIndex != -1) {
				int modelIndex = jTable2.convertRowIndexToModel(viewIndex);
				DefaultTableModel model = (DefaultTableModel) jTable2
						.getModel();
				model.removeRow(modelIndex);
			}
		}

	}

	private void loadData() {
		// TODO Auto-generated method stub

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new Add().setVisible(true);

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new Index().setVisible(true);

	}

	/**
	 * @param args the command line arguments
	 */

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton5;
	private javax.swing.JScrollPane jScrollPane2;
	private static javax.swing.JTable jTable2;
	// End of variables declaration//GEN-END:variables

}