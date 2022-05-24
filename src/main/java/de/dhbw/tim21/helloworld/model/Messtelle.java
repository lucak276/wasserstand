package de.dhbw.tim21.helloworld.model;



public class Messtelle {



    public String uuid = null;


    public String number = null;


    public String shortname = null;



    public String longname = null;


    public long km = 0;


    public String agency = null;


    public long longitude = 0;


    public long latitude = 0;

    // has to be an Object with shortname and longname keys

    public Water water = null;




    public Messtelle(String uuid, String number, String shortname, String longname, long km, String agency, long longitude, long latitude, Water water) {
        this.uuid = uuid;
        this.number = number;
        this.shortname = shortname;
        this.longname = longname;
        this.km = km;
        this.agency = agency;
        this.longitude = longitude;
        this.latitude = latitude;
        this.water = water;

    }

    public Messtelle() {
    }

    public String toString() {

        return "Student[gewaesser:" + this.shortname + ",longname:" + this.longname + ",km:" + this.km + "]";
    }


    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public long getKm() {
        return km;
    }

    public void setKm(long km) {
        this.km = km;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

}
