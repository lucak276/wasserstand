package de.dhbw.tim21.helloworld.model;



public class Pegel {


    private String timestamp = null;


    private long value;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
    public Pegel(String timestamp, long value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Pegel() {

    }
}
