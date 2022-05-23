package de.dhbw.tim21.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "pegelstaende")
public class Pegel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "time")
    private String time;

    @Column(name = "value")
    private long value;

    public Pegel(String time, long value) {
        this.time = time;
        this.value = value;
    }

    public Pegel() {

    }
}
