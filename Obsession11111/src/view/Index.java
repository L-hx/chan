/*
 * Index.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.MyBarPanel;
import model.User;

/**
 *
 * @author  __USER__
 */
public class Index extends javax.swing.JFrame {
	private static User u;

	/** Creates new form Index */
	public Index() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("logo.png").getImage());
		JLabel jlb = new JLabel();
		jlb.setBounds(0, 0, this.getWidth(), this.getHeight());
		jlb.setIcon(new ImageIcon("6.jpg"));
		this.add(jlb);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9996\u9875");

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jButton1.setForeground(new java.awt.Color(0, 153, 204));
		jButton1.setText("\u5f85 \u529e");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
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
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jButton2.setForeground(new java.awt.Color(0, 153, 204));
		jButton2.setText("\u9501 \u673a");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jButton3.setForeground(new java.awt.Color(0, 153, 204));
		jButton3.setText("\u6570\u636e\u5206\u6790");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton3ActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 844,
				Short.MAX_VALUE).addGroup(
				layout.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						layout.createSequentialGroup().addGap(81, 81, 81)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										195,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(49, 49, 49).addComponent(jButton2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										195,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(48, 48, 48).addComponent(jButton3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										195,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(81, Short.MAX_VALUE))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 563, Short.MAX_VALUE)
						.addGroup(
								layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												layout
														.createSequentialGroup()
														.addGap(114, 114, 114)
														.addGroup(
																layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				334,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jButton2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				334,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				334,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addContainerGap(115,
																Short.MAX_VALUE))));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
			throws ClassNotFoundException, SQLException, IOException {

		JFrame frame = new JFrame("数据统计");
		frame.add(new MyBarPanel().getChartPanel()); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new Lock().setVisible(true);
		this.dispose();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException, ClassNotFoundException, IOException {
		// TODO add your handling code here:
		String id = Login.getjTextField1().getText();

		this.dispose();
		view.Menu.update(id);
	}

	/**
	 * @param args the command line arguments
	 */

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	// End of variables declaration//GEN-END:variables

}