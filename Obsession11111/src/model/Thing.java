package model;

import java.io.Serializable;

public class Thing implements Serializable{
	private int tid;
	private int uid;
	private String thing;
	private String time;
	

	public Thing(int tid,int uid,String thing, String time) {
		this.tid=tid;
		this.uid=uid;
		this.thing = thing;
		this.time = time;
		
	}
	public int getTid(){
		return tid;
	}
	public void setTid(int tid){
		this.tid=tid;
	}
	public int getUid(){
		return uid;
	}
	public void setUid(int uid){
		this.uid=uid;
	}
	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
