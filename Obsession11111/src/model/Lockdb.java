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
	private JFrame L=new JFrame("你确定吗？");//一个面板罢了
	private JFrame J = new JFrame("锁");//锁屏界面的面板
	private JButton M=new JButton("解锁密码");//密码按钮
	private JButton W=new JButton("退出");
	private JLabel X=new JLabel("解锁");
	private JLabel N=new JLabel();//承载倒计时的Label
	private Toolkit A = Toolkit.getDefaultToolkit();//定义抽象类Toolkit用其子类
	private Robot robot = null;
	private final int width = (int) A.getScreenSize().getWidth();//获取屏幕的宽
	private final int height = (int) A.getScreenSize().getHeight();//获取屏幕的高
	private int intMark = 0;
	private String keyChar = null;
	private String[] lowerUnLockValue = null;
	//上面三个是关于解锁密码的东西
	private String type="";
	static Thread checkThread;
	public void init(){
		L.setLayout(null);
		L.setSize(300, 150);
		L.setResizable(false);//大小不可调
		L.setLocationRelativeTo(null);
		L.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		M.setBounds(75, 20, 150, 30);
		W.setBounds(75, 70, 150, 30);
		L.add(M);
		L.add(W);
		L.setVisible(true);
		J.setLayout(null);
		J.setSize(width, height);//大小不可调
		J.setUndecorated(true);//禁用任何装饰，无边框=去掉窗口的装饰
		J.getRootPane().setWindowDecorationStyle(JRootPane.NONE);// 采用指定的窗口装饰风格
		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用 System exit 方法退出应用程序。仅在应用程序中使用。 
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
			      this.N.setText("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
			try {
				Thread.sleep(1000);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!J.isMaximumSizeSet() || !J.isActive()){
				J.toFront();//最前面
				J.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化
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
	//鼠标事件选择按钮组件
	public void pswLock() throws AWTException{
		String message="";
		String remessage=""; 
		
		do{
			message = JOptionPane.showInputDialog(J, "请输入解锁码:", "设置解锁码",
					JOptionPane.INFORMATION_MESSAGE);
			if (message==null || message.equals("")) {
				return;
			}
			remessage = JOptionPane.showInputDialog(J, "请重复输入解锁码:", "设置解锁码",
					JOptionPane.INFORMATION_MESSAGE);
			if (remessage==null) {
				return;
			}
			if(!message.equals(remessage)){
				JOptionPane.showMessageDialog(J, "两次输入解锁码不一致,请重新输入!", "错误", JOptionPane.WARNING_MESSAGE);
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
	//输入锁屏密码部分代码（类似注册）


	
	//以下lock类为锁定功能
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
				J.toFront();//聚焦窗口
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

		});//解锁！解锁！
		J.addWindowFocusListener(new WindowFocusListener() {

			public void windowGainedFocus(WindowEvent e) {
				
			}

			public void windowLostFocus(WindowEvent e) {
				J.toFront();//聚焦窗口
			}

		});
		J.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				J.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}//这是一个关于窗口的代码

	

	class DrawPanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			setLayout(null);
				this.setBackground(Color.BLACK);
			
			
				g.setColor(Color.WHITE);
			g.setFont(new Font("幼圆", Font.BOLD, 200));
			g.drawString("禅", width/2-110, height/2+70);
			g.drawOval(width / 2 - 135, height / 2 - 135, 270, 270);
			g.setFont(new Font("幼圆", Font.PLAIN, 18));
			add(N);
			  N.setBounds(200,100,1000,100);
			  N.setFont(new   java.awt.Font("Dialog",   1,   17));
			  N.setForeground(Color.white);
			if(type.equals("u")){
				add(X);
				
			}
		}
	}
//这部分是锁屏界面

}
