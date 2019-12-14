package model;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

import server.Protocol;


public class User implements Serializable{



	private int uid;
	private String uname;
	private String upw;
	private static boolean login;


	public User(int uid, String uname, String upw) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upw = upw;
		login = true;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public User() {
		super();
		login = false;
	}

	public boolean isLogin() {
		return login;
	}
	 public ArrayList<Data> AllStu() throws SQLException,ClassNotFoundException {
	        ArrayList<Data> st = new ArrayList<Data>();
	        String sql = "select tid,thing,time from data";
	        ResultSet rs = DataConnect.getStat().executeQuery(sql);
	        while (rs.next()) {
	    	st.add(new Data(rs.getInt(1),rs.getString(2),rs.getInt(3)));
	    }
	    return st;
	    }
	    public void statistics(String thing,String time) throws Exception {    
	        String sql ="insert into data (thing,time) values ('"+thing+"','"+time+"')";
	     DataConnect.getStat().executeUpdate(sql);
	    }


//	public static User login(int uid,String upw) throws Exception{
//		User u =null;
//		if(login)
//			throw new Exception("你已经登陆了");
//		String sql = "select * from user where uid='"+uid+"' and " +"upw = '"+upw+"'";
//		ResultSet rs = DataConnect.getStat().executeQuery(sql);
//		if(rs.next())
//			return new User(uid,rs.getString("uname"),upw);
//		else
//			return u;
//	}//登录
//
//	public void register(String uname, String p1, String p2) throws Exception {
//		if (!p1.equals(p2))
//			throw new Exception("密码输入不一致");
//		String sql = "insert into user(uname,upw) values ('"+uname+"','"+p1+"')";
//
//		DataConnect.getStat().executeUpdate(sql);
//	}//注册
//
//	public ArrayList<Thing> viewAllThing(String id) throws SQLException,ClassNotFoundException {
//		ArrayList<Thing> thing = new ArrayList<Thing>();
//		String sql = "select * from thing where uid = '"+id+"'";
//		ResultSet rs = DataConnect.getStat().executeQuery(sql);
//		while (rs.next()) {
//			thing.add(new Thing(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
//		}
//		return thing;
//	}//待办(根据用户id，登陆时就查询关键字
//	public static User add(int uid,String thing,String time )throws Exception{
//		User u =null;
//		String sql ="insert into thing (uid,thing,time) values ('"+uid+"','"+thing+"','"+time+"')";
//		DataConnect.getStat().executeUpdate(sql);
//		return u;
//
//	}//待办增加
//	public void delete(int tid) throws SQLException, ClassNotFoundException{
//
//		Thing thing = null;
//		String sql ="delete from thing where tid ="+tid;
//
//
//		DataConnect.getStat().executeUpdate(sql);
//
//
//	}//待办删除
//
//	public void revise(String thing,String time) throws SQLException, ClassNotFoundException{
//		String sql ="insert into thing (thing,time) values ('"+thing+"','"+time+"')";
//		DataConnect.getStat().executeUpdate(sql);
//	}//待办修改
//
//
//	public Thing viewthing(int tid) throws SQLException, ClassNotFoundException {
//		Thing thing = null;
//		String sql = "select * from thing where tid=" + tid;
//		ResultSet rs = DataConnect.getStat().executeQuery(sql);
//		if (rs.next()) {
//			thing = new Thing(rs.getInt(1), rs.getInt(2), rs.getString(3), rs
//					.getString(4));
//		}
//		return thing;
//	}//查待办
//
//
//	public void statistics(){
//
//
//	}//统计
//	public void list(){
//
//
//	}//白名单
//	public void picture(){
//
//
//	}//图片
//	public void start(){
//
//
//	}//时间开始
//	public void stop(){
//
//
//	}//时间停止
//	public void end(){
//
//
//	}//时间结束
//	public void time(){
//
//
//	}//计时

}
