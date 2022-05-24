package de.dhbw.tim21.helloworld.model;

import java.util.ArrayList;
import java.util.List;

public class MesstelleList {
    public List<Messtelle> getMesstellen() {
        return messtellen;
    }

    public MesstelleList(List<Messtelle> messtellen) {
        this.messtellen = messtellen;
    }

    public void setMesstellen(List<Messtelle> messtellen) {
        this.messtellen = messtellen;
    }

    private List<Messtelle> messtellen;

    public MesstelleList() {
        messtellen = new ArrayList<>();
    }
}
