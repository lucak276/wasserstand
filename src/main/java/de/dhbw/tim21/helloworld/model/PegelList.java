package de.dhbw.tim21.helloworld.model;

import java.util.ArrayList;
import java.util.List;

public class PegelList {
    public PegelList(List<Pegel> pegels) {
        this.pegels = pegels;
    }

    public List<Pegel> getPegels() {
        return pegels;
    }

    public void setPegels(List<Pegel> pegels) {
        this.pegels = pegels;
    }

    private List<Pegel> pegels;

    public PegelList() {
        pegels = new ArrayList<>();
    }
}
