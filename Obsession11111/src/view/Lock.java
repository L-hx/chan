/*
 * Lock.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.AWTException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Lock10;
import model.Lock30;
import model.Lock5;
import model.Lockzdy;
import model.User;

/**
 *
 * @author  __USER__
 */
public class Lock extends javax.swing.JFrame implements Runnable {
	private static User u;
	private Object User;
	public String LockFrame;

	/** Creates new form Lock */
	public Lock() {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("logo.png").getImage());
		JLabel jlb = new JLabel();
		jlb.setBounds(0, 0, this.getWidth(), this.getHeight());
		jlb.setIcon(new ImageIcon("8.png"));
		this.add(jlb);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("\u9501\u673a");

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("\u7acb\u5373\u9501\u673a");

		jButton3.setText("\u81ea\u5b9a\u4e49\u65f6\u957f");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("30\u5206\u949f");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("10\u5206\u949f");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("5\u5206\u949f");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton6ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jButton7.setText("\u8fd4\u56de\u9996\u9875");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
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
								layout.createSequentialGroup().addGap(47, 47,
										47).addComponent(jLabel1)
										.addContainerGap(711, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				222,
																				222,
																				222)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE)
																		.addGap(
																				45,
																				45,
																				45)
																		.addComponent(
																				jButton4,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE)
																		.addGap(
																				49,
																				49,
																				49)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton6,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE)
																		.addGap(
																				644,
																				644,
																				644)))
										.addGap(31, 31, 31)).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										719, Short.MAX_VALUE).addComponent(
										jButton7).addGap(42, 42, 42)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(42, 42, 42)
										.addComponent(jLabel1)
										.addGap(43, 43, 43)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																274,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																274,
																Short.MAX_VALUE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																274,
																Short.MAX_VALUE)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																274,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(58, 58, 58).addComponent(
												jButton7).addGap(70, 70, 70)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		Lockzdy j = new Lockzdy();
		j.init();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		Lock30 m = new Lock30();
		m.init();
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		Lock10 j = new Lock10();
		j.init();

	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)
			throws Exception {
		Lock5 l = new Lock5();

		l.init();

	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		new Index().setVisible(true);
		this.dispose();
	}

	// TODO add your handling code here:

	/**
	 * @param args the command line arguments
	 */

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;

	// End of variables declaration//GEN-END:variables
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}