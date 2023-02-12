package com.example.ergasia;

import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.Map;

public class GamesPin  {
    private String Date;
    private String Team1;
    private String Team2;
    private String City;
    private String Country;
    private String Eidos;
    private String Sport;
    private int ScoreTeam1;
    private int ScoreTeam2;
    private int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public String getSport() {
        return Sport;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTeam1() {
        return Team1;
    }

    public void setTeam1(String team1) {
        Team1 = team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public void setTeam2(String team2) {
        Team2 = team2;
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

    public int getScoreTeam1() {
        return ScoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        ScoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return ScoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        ScoreTeam2 = scoreTeam2;
    }
}
