package com.example.ergasia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MyDao {

    @Insert
    public  void insertTeam (TeamPin teamPin);

    @Delete
    public  void deleteTeam (TeamPin teamPin);

    @Update
    public  void updateTeam (TeamPin teamPin);


    @Insert
    public  void insertSport (SportPin sportPin);

    @Delete
    public  void deleteSport (SportPin sportPin);

    @Update
    public  void updateSport (SportPin sportPin);

    @Insert
    public void insertAthlete (AthletePin athletepin);

    @Delete
    public void deleteAthlete (AthletePin athletePin);

    @Update
    public  void updateAthlete( AthletePin athletePin);

    @Query("select * from Athlete")
    public List<AthletePin> getAthlete();

    @Query("select * from Sport")
    public List<SportPin> getSport();


    @Query("select * from Team")
    public List<TeamPin> getTeam();

}


