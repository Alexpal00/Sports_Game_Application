package com.example.ergasia;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity (tableName = "Athlete",
        foreignKeys =
        @ForeignKey(entity = SportPin.class,
        parentColumns =  "id_sport",
        childColumns = "sport_code",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)

)

public class AthletePin {
    @ColumnInfo(name="id_athlete")
    @PrimaryKey
    private int id;

    @ColumnInfo(name="name_athlete")@NonNull
    private String name;

    @ColumnInfo(name="last_name_athlete")@NonNull
    private String last_name;


    @ColumnInfo(name="city")@NonNull
    private String city;

    @ColumnInfo(name="country")@NonNull
    private String country_athlete;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_athlete() {
        return country_athlete;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public void setCountry_athlete(String country_athlete) {
        this.country_athlete = country_athlete;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getSport_code() {
        return sport_code;
    }

    public void setSport_code(int sport_code) {
        this.sport_code = sport_code;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
