package model;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import view.Revise;


public class Lockdb implements Runnable{
	private JFrame L=new JFrame("��ȷ����");//һ��������
	private JFrame J = new JFrame("��");//������������
	private JButton M=new JButton("��������");//���밴ť
	private JButton W=new JButton("�˳�");
	private JLabel X=new JLabel("����");
	private JLabel N=new JLabel();//���ص���ʱ��Label
	private Toolkit A = Toolkit.getDefaultToolkit();//���������Toolkit��������
	private Robot robot = null;
	private final int width = (int) A.getScreenSize().getWidth();//��ȡ��Ļ�Ŀ�
	private final int height = (int) A.getScreenSize().getHeight();//��ȡ��Ļ�ĸ�
	private int intMark = 0;
	private String keyChar = null;
	private String[] lowerUnLockValue = null;
	//���������ǹ��ڽ�������Ķ���
	private String type="";
	static Thread checkThread;
	public void init(){
		L.setLayout(null);
		L.setSize(300, 150);
		L.setResizable(false);//��С���ɵ�
		L.setLocationRelativeTo(null);
		L.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		M.setBounds(75, 20, 150, 30);
		W.setBounds(75, 70, 150, 30);
		L.add(M);
		L.add(W);
		L.setVisible(true);
		J.setLayout(null);
		J.setSize(width, height);//��С���ɵ�
		J.setUndecorated(true);//�����κ�װ�Σ��ޱ߿�=ȥ�����ڵ�װ��
		J.getRootPane().setWindowDecorationStyle(JRootPane.NONE);// ����ָ���Ĵ���װ�η��
		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ʹ�� System exit �����˳�Ӧ�ó��򡣽���Ӧ�ó�����ʹ�á� 
		checkThread=new Thread(this);
		chooseListener();
	}
	
	public void run() {
		String num = Revise.jTextField2.getText();
		int time = Integer.parseInt(num);
		while(time>0){
			time--;
			int hh = time / 60 / 60 % 60;
			   int mm = time / 60 % 60;
			      int ss = time % 60;
			      this.N.setText("��ʣ" + hh + "Сʱ" + mm + "����" + ss + "��");
			try {
				Thread.sleep(1000);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!J.isMaximumSizeSet() || !J.isActive()){
				J.toFront();//��ǰ��
				J.setExtendedState(JFrame.MAXIMIZED_BOTH);//�������
			}
			if(time==0){
				
				J.dispose();
				  }
		}
	}
	
	public void chooseListener(){
		M.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){
					L.setVisible(false);
					try {
						type="psw";
						pswLock();
						checkThread.start();
					} catch (AWTException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		W.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1){
					L.setVisible(false);
				
				}
			}
		});
	}
	//����¼�ѡ��ť���
	public void pswLock() throws AWTException{
		String message="";
		String remessage=""; 
		
		do{
			message = JOptionPane.showInputDialog(J, "�����������:", "���ý�����",
					JOptionPane.INFORMATION_MESSAGE);
			if (message==null || message.equals("")) {
				return;
			}
			remessage = JOptionPane.showInputDialog(J, "���ظ����������:", "���ý�����",
					JOptionPane.INFORMATION_MESSAGE);
			if (remessage==null) {
				return;
			}
			if(!message.equals(remessage)){
				JOptionPane.showMessageDialog(J, "������������벻һ��,����������!", "����", JOptionPane.WARNING_MESSAGE);
			}else {
				lowerUnLockValue = new String[message.length()];
				for (int i = 0; i < message.length(); i++) {
					lowerUnLockValue[i] = String.valueOf(message
							.toLowerCase().charAt(i));
				}
			}
		}while(!message.equals(remessage));
		lock();
	}
	//�����������벿�ִ��루����ע�ᣩ


	
	//����lock��Ϊ��������
	public void lock(){
		J.setContentPane(new DrawPanel());
		J.setVisible(true);
		
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		J.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 524) {
					robot.keyRelease(e.getKeyCode());
					robot.keyPress(e.getKeyCode());
					robot.keyRelease(e.getKeyCode());
					robot.keyPress(27);
					robot.keyRelease(27);
				} else if (e.getKeyCode() == 18) {
					robot.keyRelease(e.getKeyCode());
					robot.keyPress(524);
					robot.keyRelease(524);
					robot.keyPress(17);
				} else {
					robot.keyRelease(e.getKeyCode());
				}
				J.toFront();//�۽�����
			}

			public void keyReleased(KeyEvent e) {
				robot.keyRelease(17);
			}

			public void keyTyped(KeyEvent e) {
				if(type.equals("psw")){
					keyChar = String.valueOf(e.getKeyChar()).toLowerCase();
					if (keyChar.equals(lowerUnLockValue[intMark])) {
						intMark++;
					} else {
						intMark = 0;
					}
					if (intMark == (lowerUnLockValue.length)) {
						J.dispose();
					}
				}
			}

		});//������������
		J.addWindowFocusListener(new WindowFocusListener() {

			public void windowGainedFocus(WindowEvent e) {
				
			}

			public void windowLostFocus(WindowEvent e) {
				J.toFront();//�۽�����
			}

		});
		J.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				J.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}//����һ�����ڴ��ڵĴ���

	

	class DrawPanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			setLayout(null);
				this.setBackground(Color.BLACK);
			
			
				g.setColor(Color.WHITE);
			g.setFont(new Font("��Բ", Font.BOLD, 200));
			g.drawString("��", width/2-110, height/2+70);
			g.drawOval(width / 2 - 135, height / 2 - 135, 270, 270);
			g.setFont(new Font("��Բ", Font.PLAIN, 18));
			add(N);
			  N.setBounds(200,100,1000,100);
			  N.setFont(new   java.awt.Font("Dialog",   1,   17));
			  N.setForeground(Color.white);
			if(type.equals("u")){
				add(X);
				
			}
		}
	}
//�ⲿ������������

}
