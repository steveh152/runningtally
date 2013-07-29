package com.RCOS.runningtally;

/**
 * Created by steve on 6/30/13.
 */
public class Athlete {

    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return comment;
    }
}
