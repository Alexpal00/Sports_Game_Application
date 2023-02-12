package com.example.ergasia;

import java.io.Serializable;

public class Cricketer implements Serializable {

    public String name;
    public String score;

    public Cricketer(){

    }


    public Cricketer(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
