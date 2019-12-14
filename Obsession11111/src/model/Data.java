package model;

public class Data {
private int tid;
private String thing;
private int time;
public Data(int id, String thing,  int time) {
	super();
	this.tid = tid;
	this.thing = thing;
	this.time = time;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getThing() {
	return thing;
}
public void setThing(String thing) {
	this.thing = thing;
}

public int getTime() {
	return time;
}
public void setTime(int Time) {
	this.time = Time;
}

}
