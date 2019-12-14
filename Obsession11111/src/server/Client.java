package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Data;
import model.DataConnect;
import model.Thing;
import model.User;

public class Client implements Protocol {
	private static Socket s;
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;

	private static void init() throws IOException {
		s = new Socket("127.0.0.1",1027);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}
	public static User login(int uid,String upw) throws IOException, ClassNotFoundException {
		init();
		oos.writeInt(U_LOGIN);
		oos.flush();
		oos.writeInt(uid);
		oos.flush();
		oos.writeUTF(upw);
		oos.flush();
		User u =(User) ois.readObject();
		return u;
	}//登录

	public static void register(int uid, String uname, String p1, String p2) throws IOException  {
		init();
		oos.writeInt(REGISTER);
		oos.flush();
		oos.writeInt(uid);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();
		oos.writeUTF(p1);
		oos.flush();
		oos.writeUTF(p2);
		oos.flush();
	}//注册

	public static ArrayList<Thing> viewAllThing(String id) throws IOException, ClassNotFoundException  {
		init();
		oos.writeInt(VIEWALLTHING);
		oos.flush();
		oos.writeUTF(id);
		oos.flush();
		System.out.print("ALlthing");
		ArrayList<Thing> thing = (ArrayList<Thing>) ois.readObject();
		return thing;
	}//待办(根据用户id，登陆时就查询关键字
	public static void add(int uid,String thing,String time ) throws IOException{
		init();
		oos.writeInt(U_ADD);
		oos.flush();
		System.out.print("CAdd1");
		oos.writeInt(uid);
		oos.flush();
		System.out.print("CAdd2");
		oos.writeUTF(thing);
		oos.flush();
		System.out.print("CAdd3");
		oos.writeUTF(time);
		oos.flush();
		System.out.print("CAdd4");
        
	}//待办增加
	public static void delete(int tid) throws IOException{
        init();
        oos.writeInt(DELETE);
        oos.flush();
        oos.writeInt(tid);
        oos.flush();
 
	}//待办删除

	public static void revise(String thing,String time) throws IOException {
		init();
		oos.writeInt(REVISE);
		oos.flush();
		oos.writeUTF(thing);
		oos.flush();
		oos.writeUTF(time);
		oos.flush();
	}//待办修改


	public static Thing viewthing(int tid) throws IOException, ClassNotFoundException {
		init();
		oos.writeInt(VIEWTHING);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		Thing thing = (Thing) ois.readObject();
		return thing;
	}//查待办

	public ArrayList<Data> AllStu() throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(ALLSTU);
		oos.flush();		
		ArrayList<Data> st = (ArrayList<Data>) ois.readObject();
		return st;
	}
	public static void statistics(String thing,String time) throws IOException  { 
		init();
		oos.writeInt(STATISTICS);
		oos.flush();
		oos.writeUTF(thing);
		oos.flush();
		oos.writeUTF(time);
		oos.flush();
	}

}