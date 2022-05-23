package de.dhbw.tim21.helloworld.model;

import javax.persistence.*;

@Entity
public class Water {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shortname")
    public String shortname = null;

    @Column(name = "longname")
    public String longname = null;
}
