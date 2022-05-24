package de.dhbw.tim21.helloworld.model;


public class Water {

    public String shortname = null;
    public String longname = null;

    public Water(String shortname, String longname) {
        this.shortname = shortname;
        this.longname = longname;
    }

    public Water() {
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }


}
