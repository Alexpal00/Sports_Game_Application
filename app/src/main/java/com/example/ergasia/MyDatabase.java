package com.example.ergasia;



import android.content.Context;


import androidx.room.Database;

import androidx.room.RoomDatabase;



@Database(entities = {AthletePin.class,TeamPin.class,SportPin.class}, version = 7)

public abstract class MyDatabase extends RoomDatabase {


    public abstract MyDao Daotemp();


}




