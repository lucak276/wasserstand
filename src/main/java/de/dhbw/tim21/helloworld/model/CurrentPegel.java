package de.dhbw.tim21.helloworld.model;


import java.util.Date;

public class CurrentPegel {
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getTrend() {
        return trend;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public String getStateMnwMhw() {
        return stateMnwMhw;
    }

    public void setStateMnwMhw(String stateMnwMhw) {
        this.stateMnwMhw = stateMnwMhw;
    }

    public String getStateNswHsw() {
        return stateNswHsw;
    }

    public void setStateNswHsw(String stateNswHsw) {
        this.stateNswHsw = stateNswHsw;
    }

    private String timestamp;

    private long value;

    private int trend;

    private String stateMnwMhw;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String stateNswHsw;



    public CurrentPegel(String timestamp, long value, int trend, String stateMnwMhw, String stateNswHsw) {
        this.timestamp = timestamp;
        this.value = value;
        this.trend = trend;
        this.stateMnwMhw = stateMnwMhw;
        this.stateNswHsw = stateNswHsw;

    }

    public CurrentPegel() {

    }
}
