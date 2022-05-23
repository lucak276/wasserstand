package de.dhbw.tim21.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "messstellen")
public class Messtelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "uuid")
    public String uuid = null;

    @Column(name = "number")
    public long number = 0;

    @Column(name = "shortname")
    public String shortname = null;

    @Column(name = "longname")
    public String longname = null;

    @Column(name = "km")
    public long km = 0;

    @Column(name = "agency")
    public String agency = null;

    @Column(name = "longitude")
    public long longitude = 0;

    @Column(name = "latitude")
    public long latitude = 0;

    // has to be an Object with shortname and longname keys
    @Column(name = "water")
    @ManyToOne
    public Water water = null;




    public Messtelle(String uuid, long number, String shortname, String longname, long km, String agency, long longitude, long latitude, Water water) {
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

        return "Student[gewässer:" + this.shortname + ",longname:" + this.longname + ",km:" + this.km + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }



}
