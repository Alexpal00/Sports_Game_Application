package com.example.ergasia;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Team")

public class TeamPin {
    @ColumnInfo(name="id_team")
    @NonNull
    @PrimaryKey
    private int id;

    @ColumnInfo(name="name_team")
    @NonNull
    private String name;

    @ColumnInfo(name="name_stadium")@NonNull
    private String stadium_name;


    @ColumnInfo(name="city")@NonNull
    private String city;

    @ColumnInfo(name="country")@NonNull
    private String country_team;

    @ColumnInfo(name="sport_code")@NonNull
    private int sport_code;

    @ColumnInfo(name="birthday")@NonNull
    private int year_of_birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium_name() {
        return stadium_name;
    }

    public void setStadium_name(String stadium_name) {
        this.stadium_name = stadium_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_team() {
        return country_team;
    }

    public void setCountry_team(String country_team) {
        this.country_team = country_team;
    }

    public int getSport_code() {
        return sport_code;
    }

    public void setSport_code(int sport_code) {
        this.sport_code = sport_code;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
