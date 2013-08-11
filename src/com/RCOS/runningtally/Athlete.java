package com.RCOS.runningtally;

/**
 * Created by steve on 6/30/13.
 */
public class Athlete {

    private int id;
    private String name;
    private long time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getTime() {
    	return time;
    }
    
    public void setTime(long time) {
    	this.time = time;
    }
    @Override
    public String toString() {
        return name;
    }
}
