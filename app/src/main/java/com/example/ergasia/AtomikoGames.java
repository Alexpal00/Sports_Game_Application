package com.example.ergasia;

import java.util.ArrayList;
import java.util.List;

public class AtomikoGames {


    private String Date;


    private String City;
    private String Country;
    private String Eidos;
    private String Sport;
    private int id;
    List<String> name,score;

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getScore() {
        return score;
    }

    public void setScore(List<String> score) {
        this.score = score;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getEidos() {
        return Eidos;
    }

    public void setEidos(String eidos) {
        Eidos = eidos;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }


}
