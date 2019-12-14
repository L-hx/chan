package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Data;
import model.DataConnect;
import model.Thing;
import model.User;

public class Server implements Protocol{
	private Socket s;
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	public Server() throws Exception{
		ServerSocket ss = new ServerSocket(1027);
		System.out.println("ok");
		while (true){
			s = ss.accept();
			ois = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			int command = ois.readInt();
			if(command ==U_LOGIN ){
				this.U_login();	
			}
			if(command ==REGISTER  ){
				this.register();	
			}
			if(command ==VIEWALLTHING ){
				this.viewAllThing();	
			}
			if(command ==U_ADD ){
				this.add();	
			}
			if(command ==DELETE ){
				this.delete();	
			}
			if(command ==REVISE ){
				this.revise();	
			}
			if(command ==VIEWTHING ){
				this.viewthing();	
			}
			if(command ==ALLSTU ){
				this.AllStu();	
			}
			if(command ==STATISTICS ){
				this.statistics();	
			}
		}
	}
	public static void U_login() throws IOException, SQLException, ClassNotFoundException {
		User u =null;
		int uid=ois.readInt();
		String upw=ois.readUTF();
		String sql = "select * from user where uid='"+uid+"' and upw = '"+upw+"'";
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		if(rs.next()){
			u= new User(uid,rs.getString("uname"),upw);
		}
		oos.writeObject(u);
		oos.flush();
	}//��¼

	public void register() throws Exception  {
		User u =null;
		int uid=ois.readInt();
		String uname=ois.readUTF();
		String p1=ois.readUTF();
		String p2=ois.readUTF();
		String sql = "insert into user(uid,uname,upw) values ('"+uid+"','"+uname+"','"+p1+"')";
		int rs= DataConnect.getStat().executeUpdate(sql);
		if (!p1.equals(p2)){
			throw new Exception("�������벻һ��");
		}
		oos.writeObject(u);
		oos.flush();
	}//ע��

	public  void viewAllThing() throws IOException, ClassNotFoundException, SQLException  {
		//		User u= (User) ois.readObject();
		String id =ois.readUTF();
		ArrayList<Thing> thing = new ArrayList<Thing>();
		String sql = "select * from thing where uid = '"+id+"'";
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		while (rs.next()) {
			thing.add(new Thing(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
		}
		oos.writeObject(thing);
		oos.flush();
	}//����(�����û�id����½ʱ�Ͳ�ѯ�ؼ���
	public void add() throws IOException, ClassNotFoundException, SQLException{
//		User u =(User) ois.readObject();
		System.out.print("SAdd1");
		int uid=ois.readInt();
		String thing=ois.readUTF();
		String time=ois.readUTF();
		System.out.print("SAdd2");
		String sql ="insert into thing (uid,thing,time) values ('"+uid+"','"+thing+"','"+time+"')";
		System.out.print("SAdd3");
		DataConnect.getStat().executeUpdate(sql);

	}//��������
	public void delete() throws IOException, ClassNotFoundException, SQLException {
		//      User u=(User) ois.readObject();
		int tid=ois.readInt();
		String sql ="delete from thing where tid ="+tid;
		DataConnect.getStat().executeUpdate(sql);
	}//����ɾ��

	public void revise() throws IOException, ClassNotFoundException, SQLException{
		//		User u=(User) ois.readObject();
		Thing thing=(Thing) ois.readObject();
		String sql ="insert into thing (thing,time) values ('"+thing.getThing()+"','"+thing.getTime()+"')";
		DataConnect.getStat().executeUpdate(sql);
	}//�����޸�


	public void viewthing() throws IOException, ClassNotFoundException, SQLException {
		Thing thing = null;
		//		User u=(User) ois.readObject();
		int tid=ois.readInt();
		String sql = "select * from thing where tid=" + tid;
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		if (rs.next()) {
			thing = new Thing(rs.getInt(1), rs.getInt(2), rs.getString(3), rs
					.getString(4));
		}
		oos.writeObject(thing);
		oos.flush();
	}//�����
	public void AllStu() throws SQLException,ClassNotFoundException, IOException {
		ArrayList<Data> st = new ArrayList<Data>();
		String sql = "select tid,thing,time from data";
		ResultSet rs = DataConnect.getStat().executeQuery(sql);
		while (rs.next()) {
			st.add(new Data(rs.getInt(1),rs.getString(2),rs.getInt(3)));
		}
		oos.writeObject(st);
		oos.flush();
	}
	public void statistics() throws IOException, SQLException, ClassNotFoundException { 
		String thing =ois.readUTF();
		String time = ois.readUTF();
		String sql ="insert into data (thing,time) values ('"+thing+"','"+time+"')";
		DataConnect.getStat().executeUpdate(sql);
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
